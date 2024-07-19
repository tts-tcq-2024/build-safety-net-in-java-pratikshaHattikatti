package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import CodeTestCoverJava.Soundex;

public class SoundexTest {
    Soundex soundexMock = Mockito.mock(Soundex.class);

    @Test
    public void testEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    public void testString1() {
        assertEquals("B200", Soundex.generateSoundex("BOSCH"));
    }
     @Test
    public void testString2() {
         assertEquals("S552", Soundex.generateSoundex("Siemens"));
    }
    
    @Test
    public void testNullString() {
        assertEquals("", Soundex.generateSoundex(null));
    }
}
