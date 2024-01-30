package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Label;
import model.PostStatus;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {

    private final Gson gson = new Gson();

    @Override
    public Label get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        List<Label> labels = new ArrayList<>();
        Type type = new TypeToken<List<Label>>() {
        }.getType();
        try (Reader reader = new FileReader("resources/labels.json")) {
            labels = gson.fromJson(reader, type);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        labels.stream().filter(it -> it.getId().equals(id)).findFirst().ifPresent(label -> label.setStatus(PostStatus.DELETED));

    }

    @Override
    public List<Label> getAll() {
        return null;
    }

    @Override
    public Label update(Label label) {
        return null;
    }

    @Override
    public Label create(Label label) {
        try (Writer writer = new FileWriter("resources/labels.json")) {
            gson.toJson(label, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return label;
    }
}
