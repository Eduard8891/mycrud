package controller;

import model.Label;
import view.LabelView;

import java.util.List;

public class LabelController {
    private final LabelView view;

    public LabelController(LabelView view) {
        this.view = view;
    }

    public void selectCommand(String line) {
        while (true) {
            view.defaultText();
            String command = view.readLine();
            switch (command) {
                case "Создать":
                    createLabel(line);
                case "Удалить":
                    deleteLabel(line);
                case "Обновить":
                    updateLabel(line);
                case "Показать":
                    showLabel(line);
                default:
                    view.errorText(line);
            }
        }
    }


    public List<Label> getAll(String line) {
        return null;
    }

    public void createLabel(String line) {
    }

    public void updateLabel(String line) {
    }

    public Label showLabel(String line) {
        return new Label();
    }

    public void deleteLabel(String line) {
    }
}
