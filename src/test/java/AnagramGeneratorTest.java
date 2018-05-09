import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramGeneratorTest {

    @Test
    public void testNo() {
        assertEquals("onno", AnagramGenerator.generate("no"));
    }

    @Test
    public void testOn() {
        assertEquals("onno", AnagramGenerator.generate("on"));
    }

    @Test
    public void testArt() {
        assertEquals("rattarart", AnagramGenerator.generate("art"));
    }
}
