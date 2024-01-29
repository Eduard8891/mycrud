package controller;

import model.Writer;
import view.WriterView;

import java.util.List;

public class WriterController {
    private final WriterView view;

    public WriterController(WriterView view) {
        this.view = view;
    }

    public void selectCommand(String line) {
        String command = line.split(" ")[0];
        switch (command) {
            case "Создать":
                createWriter(line);
            case "Удалить":
                deleteWriter(line);
            case "Обновить":
                updateWriter(line);
            case "Показать":
                showWriter(line);
            default:
                view.errorText(line);
        }
    }

    public List<Writer> getAll(String line) {
        return null;
    }

    public void createWriter(String line) {
    }

    public void updateWriter(String line) {
    }

    public Writer showWriter(String line) {
        return new Writer();
    }

    public void deleteWriter(String line) {
    }
}
