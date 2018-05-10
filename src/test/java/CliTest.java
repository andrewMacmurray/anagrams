import anagram.AnagramGenerator;
import anagram.Cli;
import org.junit.Test;

import static org.junit.Assert.*;

public class CliTest {

    private AnagramGenerator mockAnagramGenerator() {
        return new AnagramGenerator(new String[]{"rat","tar","art"});
    }

    @Test
    public void greetUser() {
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print, mockAnagramGenerator());

        cli.greetUser();
        assertEquals("Welcome to the anagram solver!\nPlease enter a word - maybe your name!\n", ioHelper.output());
    }

    @Test
    public void showResults() {
        IOHelper ioHelper = new IOHelper("tar");
        Cli cli =  new Cli(ioHelper.in, ioHelper.print, mockAnagramGenerator());

        cli.takeInput();
        cli.showResults();
        assertEquals("rat\ntar\nart\n", ioHelper.output());
    }

}


