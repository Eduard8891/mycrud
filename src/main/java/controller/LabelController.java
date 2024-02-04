package controller;

import model.Label;
import repository.GsonLabelRepositoryImpl;
import repository.LabelRepository;

import java.util.List;

public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController() {
        this.labelRepository = new GsonLabelRepositoryImpl();
    }

    public List<Label> getAll() {
        return labelRepository.getAll();
    }

    public boolean createLabel(String name) {
        if (name.split(" ").length == 1) {
            List<Label> labels = getAll();
            Label current = labels.stream().filter(it -> it.getName().equals(name)).findFirst().orElse(null);
            if (current == null) {
                Label label = new Label();
                label.setName(name);
                labelRepository.create(label);
                return true;
            }
        }
        return false;
    }

    public boolean deleteLabel(Integer id) {
        labelRepository.delete(id);
        return true;
    }
}
