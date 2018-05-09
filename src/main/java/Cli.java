import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Cli {

    private final PrintStream out;
    private final Scanner scanner;

    public Cli(InputStream in, PrintStream out) {
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public void greetUser() {
        out.println("Welcome to the anagram solver!");
    }

    public String askForWord() {
        out.println("Please enter a word - maybe your name!");
        return scanner.next();
    }
}
