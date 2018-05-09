import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramGeneratorTest {

    @Test
    public void testNo() {
        assertEquals("onno", AnagramGenerator.generate("no"));
    }

  @Test
    public void testArt() {
        assertEquals("RatTar", AnagramGenerator.generate("Art"));
    }
}
