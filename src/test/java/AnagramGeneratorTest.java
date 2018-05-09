import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramGeneratorTest {

    @Test
    public void testNo() {
        assertEquals("on", AnagramGenerator.generate("no"));
    }
}
