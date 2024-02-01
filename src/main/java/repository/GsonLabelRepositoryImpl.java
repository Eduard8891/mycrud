package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Label;
import model.PostStatus;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String PATH = Paths.get("labels.json").toAbsolutePath().toString();

    private final Gson gson = new Gson();

    @Override
    public Label get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        List<Label> labels = getAll();
        labels.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst().ifPresent(label -> label.setStatus(PostStatus.DELETED));
    }

    @Override
    public List<Label> getAll() {
        Type listOfMyClassObject = new TypeToken<ArrayList<Label>>() {
        }.getType();
        return gson.fromJson(PATH, listOfMyClassObject);
    }

    @Override
    public Label update(Label label) {
        return null;
    }

    @Override
    public Label create(Label label) {
        List<Label> labels = getAll();
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
