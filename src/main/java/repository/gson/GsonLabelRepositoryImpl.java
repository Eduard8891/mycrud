package repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;
import model.Label;
import model.PostStatus;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String PATH = Paths.get("src/main/resources/labels.json").toAbsolutePath().toString();

    private final Gson gson = new Gson();

    @Override
    public Label get(Integer id) {
       return getAllInternal().stream().filter(it -> it.getId().equals(id)).findFirst().get();
    }

    @Override
    public void delete(Integer id) {
        List<Label> labels = getAll();
        labels.forEach(it -> {
            if (it.getId().equals(id)) {
                it.setStatus(PostStatus.DELETED);
            }
        });
        saveLabels(labels);
    }

    @Override
    public List<Label> getAll() {
        return getAllInternal().stream().filter(it -> it.getStatus().equals(PostStatus.ACTIVE)).collect(Collectors.toList());
    }


    private List<Label> getAllInternal() {
        List <Label> labels = new ArrayList<>();
        Type listOfMyClassObject = new TypeToken<ArrayList<Label>>() {
        }.getType();
        try (Reader reader = new FileReader(PATH)) {
            labels = gson.fromJson(reader, listOfMyClassObject);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return labels;
    }

    @Override
    public Label update(Label label) {
        List <Label> labels = getAllInternal();
        labels.forEach(it -> {
            if (it.getId().equals(label.getId())) {
                it.setStatus(PostStatus.UNDER_REVIEW);
                it.setName(label.getName());
            }
        });
        saveLabels(labels);
        return label;
    }

    @Override
    public Label create(Label label) {
        List<Label> labels = getAll();
        Integer id = labels.stream().map(Label::getId).max(Integer::compareTo).orElse(0);
        label.setId(id + 1);
        label.setStatus(PostStatus.ACTIVE);
        labels.add(label);
        saveLabels(labels);
        return label;
    }

    private void saveLabels(List<Label> labels) {
        try (Writer writer = new FileWriter(PATH)) {
            gson.toJson(labels, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
