package view;

import java.io.PrintStream;
import java.util.Scanner;

public class MainView {
    private final PrintStream printStream;
    private final Scanner scanner;


    public MainView(Scanner scanner, PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void defaultText() {
        printStream.println("Выберите сущность:\nПост\nМетка\nАвтор");
    }

    public void errorText(String line) {
        printStream.printf("Вы допустили ошибку в команде: \n%s\n", line);
    }

}
