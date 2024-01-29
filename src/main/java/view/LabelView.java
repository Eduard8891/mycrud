package view;

import java.io.PrintStream;
import java.util.Scanner;

public class LabelView {
    private final PrintStream printStream;
    private final Scanner scanner;


    public LabelView(Scanner scanner, PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void defaultText() {
        printStream.println("Вы выбрали 'Метка'! \nТеперь укажите команду: \nСоздать\nУдалить\nОбновить\nПоказать\nПоказать все");
    }

    public void errorText(String line) {
        printStream.printf("Вы допустили ошибку в команде для 'пост': \n%s\n", line);
    }

}
