package view;

import java.io.PrintStream;
import java.util.Scanner;

public class WriterView {
    private final PrintStream printStream;
    private final Scanner scanner;


    public WriterView(Scanner scanner, PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = scanner;
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
