package repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;
import model.Label;
import model.Post;
import model.PostStatus;
import model.Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String PATH = Paths.get("src/main/resources/writers.json").toAbsolutePath().toString();
    private final Gson gson = new Gson();

    @Override
    public Writer get(Integer id) {
        return getAllInternal().stream().filter(it -> it.getId().equals(id)).findFirst().get();
    }

    @Override
    public void delete(Integer id) {
        List<Writer> writers = getAll();
        writers.forEach(it -> {
            if (it.getId().equals(id)) {
                it.setStatus(PostStatus.DELETED);
            }
        });
        saveWriters(writers);
    }

    @Override
    public List<Writer> getAll() {
        return getAllInternal();
    }


    private List<Writer> getAllInternal() {
        List<Writer> writers = null;
        Type listOfMyClassObject = new TypeToken<ArrayList<Writer>>() {
        }.getType();
        try (Reader reader = new FileReader(PATH)) {
            writers = gson.fromJson(reader, listOfMyClassObject);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return writers;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writers = getAllInternal();
        writers.forEach(it -> {
            if (writer.getId().equals(it.getId())) {
                it.setPosts(writer.getPosts());
                it.setLastName(writer.getLastName());
                it.setFirstName(writer.getFirstName());
                it.setStatus(PostStatus.UNDER_REVIEW);
            }
        });
        saveWriters(writers);
        return writer;
    }

    @Override
    public Writer create(Writer writer) {
        List<Writer> writers = getAll();
        Integer id = writers.stream().map(Writer::getId).max(Integer::compareTo).orElse(0);
        writer.setId(id + 1);
        writer.setStatus(PostStatus.ACTIVE);
        writers.add(writer);
        saveWriters(writers);
        return writer;
    }

    private void saveWriters(List<Writer> writers) {
        try (java.io.Writer writer = new FileWriter(PATH)) {
            gson.toJson(writers, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
