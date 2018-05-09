import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IO {

    private final PrintStream out;
    private final Scanner scanner;

    public IO(InputStream in, PrintStream out) {
        this.out = out;
        this.scanner = new Scanner(in);
    }

    public void greetUser() {
    }
}
