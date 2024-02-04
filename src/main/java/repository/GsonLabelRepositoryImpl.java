package repository;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GsonLabelRepositoryImpl implements LabelRepository {
    private final String PATH = Paths.get("src/main/resources/labels.json").toAbsolutePath().toString();

    private final Gson gson = new Gson();

    @Override
    public Label get(Integer id) {
        return null;
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
        Type listOfMyClassObject = new TypeToken<ArrayList<Label>>() {
        }.getType();
        try (Reader reader = new FileReader(PATH)) {
            return gson.fromJson(reader, listOfMyClassObject);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Label update(Label label) {
        return null;
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
