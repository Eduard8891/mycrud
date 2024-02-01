package view;

import controller.LabelController;

import java.io.PrintStream;
import java.util.Scanner;

public class LabelView {
    private final PrintStream printStream;
    private final Scanner scanner;
    private final LabelController labelController;


    public LabelView() {
        this.printStream = System.out;
        this.scanner = new Scanner(System.in);
        this.labelController = new LabelController();
    }

    public void selectCommand() {
        defaultText();
        while (true) {
            String line = readLine();
            if (!line.isEmpty() && line.split(" ").length == 2) {
                String command = line.split(" ")[0];
                String body = line.split(" ")[1];
                switch (command) {
                    case "Создать": {
                        boolean success = labelController.createLabel(body);
                        if (success) success();
                        return;
                    }
                    case "Удалить": {
                        boolean success = labelController.deleteLabel(Integer.valueOf(body));
                        if (success) success();
                        return;
                    }
                    case "Показать все":
                        labelController.getAll().forEach(printStream::println);
                        return;
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
        printStream.println("Вы выбрали 'Метка'! \nТеперь укажите команду: \nСоздать 'имя_тега'\nУдалить 'ИД_тега'\nПоказать все");
    }

    public void success() {
        printStream.println("Успех!");
    }

    public void errorText(String line) {
        printStream.printf("Вы допустили ошибку в команде для 'метка': \n%s\n", line);
    }

}
