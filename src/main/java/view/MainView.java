package view;

import java.io.PrintStream;
import java.util.Scanner;

public class MainView {
    private final PrintStream printStream;
    private final Scanner scanner;
    private final LabelView labelView;
    private final PostView postView;
    private final WriterView writerView;

    public MainView() {
        this.printStream = System.out;
        this.scanner = new Scanner(System.in);
        this.labelView = new LabelView();
        this.postView = new PostView();
        this.writerView = new WriterView();

    }

    public void start() {
        while (true) {
            defaultText();
            String line = readLine();
            if (line.equals("!Стоп")) {
                return;
            }
            if (!line.isEmpty()) {
                switch (line) {
                    case "Пост":
                        postView.selectCommand();
                        continue;
                    case "Метка":
                        labelView.selectCommand();
                        continue;
                    case "Автор":
                        writerView.selectCommand();
                        continue;
                    default:
                        errorText(line);
                }
            }
        }
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void defaultText() {
        printStream.println("Вы в главном меню.Выберите сущность:\nПост\nМетка\nАвтор");
    }

    public void errorText(String line) {
        printStream.printf("Вы допустили ошибку в команде: \n%s\n", line);
    }

}
