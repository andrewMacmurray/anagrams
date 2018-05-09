import org.junit.Test;

import static org.junit.Assert.*;

public class CliTest {

    @Test
    public void greetUser() {
        IOHelper ioHelper = new IOHelper("");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        cli.greetUser();
        assertEquals("Welcome to the anagram solver!\n", ioHelper.output());
    }

    @Test
    public void requestInput() {
        IOHelper ioHelper = new IOHelper("tar");
        Cli cli = new Cli(ioHelper.in, ioHelper.print);

        String word = cli.askForWord();
        assertEquals("tar", word);
    }
}


