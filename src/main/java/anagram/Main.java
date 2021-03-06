package anagram;

import anagram.AnagramGenerator;
import anagram.Cli;
import anagram.Dictionary;

public class Main {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("src/main/resources/words.txt");
        AnagramGenerator anagramGenerator = new AnagramGenerator(dictionary.getWords());

        Cli cli = new Cli(System.in, System.out, anagramGenerator);
        cli.greetUser();
        cli.takeInput();
        cli.showResults();
    }

}
