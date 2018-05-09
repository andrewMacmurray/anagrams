import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;

public class IOTest {

    @Test
    public void greetUser() {

        IOHelper ioHelper = new IOHelper("");

        IO io = new IO(ioHelper.in, ioHelper.print);

        io.greetUser();

        assertEquals("Welcome to the anagram solver!", ioHelper.output());
    }

}


