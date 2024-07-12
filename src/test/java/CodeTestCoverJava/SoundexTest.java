package CodeTestCoverJava;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
       //  assertTrue(Soundex.generateSoundex("")=="");
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    public void testMultipleCharacters() {
        assertEquals("A123", Soundex.generateSoundex("AbCdEfG"));
    }

    @Test
    public void testLowerCase() {
        assertEquals("A123", Soundex.generateSoundex("abcdefg"));
    }

    @Test
    public void testNonAlphabetic() {
        assertEquals("A000", Soundex.generateSoundex("1234$%"));
    }
}
