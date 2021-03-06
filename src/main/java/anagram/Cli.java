package anagram;

import anagram.AnagramGenerator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Cli {

    private final PrintStream out;
    private final Scanner scanner;
    private final AnagramGenerator anagramGenerator;
    private String userInput = "";

    public Cli(InputStream in, PrintStream out, AnagramGenerator anagramGenerator) {
        this.out = out;
        this.scanner = new Scanner(in);
        this.anagramGenerator = anagramGenerator;
    }

    public void greetUser() {
        out.println("Welcome to the anagram solver!");
        out.println("Please enter a word - maybe your name!");
    }

    public void takeInput() {
        String input = scanner.next();
        this.userInput = input;
    }

    public void showResults() {
        anagramGenerator.generate(userInput)
            .stream()
            .forEach(out::println);
    }
}
