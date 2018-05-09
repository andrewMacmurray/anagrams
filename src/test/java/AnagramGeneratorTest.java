import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AnagramGeneratorTest {

    @Test
    public void testNo() {
        assertEquals(new ArrayList<String>(Arrays.asList("on", "no")), AnagramGenerator.generate("no"));
    }

    @Test
    public void testOn() {
        assertEquals(new ArrayList<String>(Arrays.asList("on", "no")), AnagramGenerator.generate("on"));
    }

    @Test
    public void testArt() {
        assertEquals(new ArrayList<String>(Arrays.asList("rat","tar","art")), AnagramGenerator.generate("art"));
    }
}
