package controller;

import view.LabelView;
import view.MainView;
import view.PostView;
import view.WriterView;

import java.io.PrintStream;
import java.util.Scanner;

public class MainController {
    private final LabelController labelController;
    private final PostController postController;
    private final WriterController writerController;
    private final PrintStream printStream;
    private final Scanner scanner;
    private final MainView view;

    public MainController() {
        this.scanner = new Scanner(System.in);
        this.printStream = System.out;
        this.writerController = new WriterController(new WriterView(scanner, printStream));
        this.labelController = new LabelController(new LabelView(scanner, printStream));
        this.postController = new PostController(new PostView(scanner, printStream));
        this.view = new MainView(scanner, printStream);
    }

    public void start() {
        while (true) {
            view.defaultText();
            String line = view.readLine();
            if (line.equals("!Стоп")) {
                return;
            }
            if (!line.isEmpty()) {
                switch (line) {
                    case "Пост":
                        postController.selectCommand(line);
                    case "Метка":
                        labelController.selectCommand(line);
                    case "Автор":
                        writerController.selectCommand(line);
                    default:
                        view.errorText(line);
                }
            }
        }
    }
}
