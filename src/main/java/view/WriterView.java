package view;

import java.io.PrintStream;
import java.util.Scanner;

public class WriterView {
    private final PrintStream printStream;
    private final Scanner scanner;

    public WriterView() {
        this.printStream = System.out;
        this.scanner = new Scanner(System.in);
    }

    public void selectCommand() {

    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void defaultText() {
        printStream.println("Введите команду!" +
                "\nПример команды: Добавить пост/Добавить автора/Показать всех авторов/Показать все теги" +
                "\nДля подробного описания команд введите !помощь");
    }

    public void errorText(String line) {
        printStream.printf("Вы допустили ошибку в команде: \n%s\n", line);
    }

}
