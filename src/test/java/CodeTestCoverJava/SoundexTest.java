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

    	@Test
	public void testGenerateSoundexEmptyString() {
		assertEquals("", Soundex.generateSoundex(""));
	}

	@Test
	public void testGenerateSoundexSingleCharacter() {
		assertEquals("M000", Soundex.generateSoundex("M"));
	}
	
	@Test
	public void testGenerateSoundexNullString() {
		assertEquals("", Soundex.generateSoundex(null));
	}
	
	@Test
	public void testGenerateSoundexMultiCharacter() {
		assertEquals("M253", Soundex.generateSoundex("Manikandan"));
		assertEquals("B200", Soundex.generateSoundex("Bosch"));
		assertEquals("C452", Soundex.generateSoundex("CleanCode"));
	}
	
	@Test
	public void testBuildSoundexSingleCharacter() {
		assertEquals("M", Soundex.buildSoundex("M").toString());
	}
	
	@Test
	public void testBuildSoundexMultiCharacter() {
		assertEquals("M253", Soundex.buildSoundex("Manikandan").toString());
		assertEquals("B2", Soundex.buildSoundex("Bosch").toString());
		assertEquals("C452", Soundex.buildSoundex("CleanCode").toString());
	}
	
	@Test
	public void testCheckLengthIndexLessSoundexLengthLess() {
		assertTrue(Soundex.checkLength(1, 2, 3));
	}
	
	@Test
	public void testCheckLengthIndexLessSoundexLengthEqual() {
		assertFalse(Soundex.checkLength(1, 2, 4));
	}
	
	@Test
	public void testCheckLengthIndexLessSoundexLengthGreater() {
		assertFalse(Soundex.checkLength(1, 2, 5));
	}
	
	@Test
	public void testCheckLengthIndexEqualSoundexLengthLess() {
		assertFalse(Soundex.checkLength(1, 1, 3));
	}
	
	@Test
	public void testCheckLengthIndexEqualSoundexLengthEqual() {
		assertFalse(Soundex.checkLength(1, 1, 4));
	}
	
	@Test
	public void testCheckLengthIndexEqualSoundexLengthGreater() {
		assertFalse(Soundex.checkLength(1, 1, 5));
	}
	
	@Test
	public void testCheckLengthIndexGreaterSoundexLengthLess() {
		assertFalse(Soundex.checkLength(2, 1, 3));
	}
	
	@Test
	public void testCheckLengthIndexGreaterSoundexLengthEqual() {
		assertFalse(Soundex.checkLength(2, 1, 4));
	}
	
	@Test
	public void testCheckLengthIndexGreaterSoundexLengthGreater() {
		assertFalse(Soundex.checkLength(2, 1, 5));
	}
	
	@Test
	public void testCodeNotZeroNotPrevCode() {
		assertTrue(Soundex.doAppend('3','2'));
	}
	
	@Test
	public void testCodeZeroNotPrevCode() {
		assertFalse(Soundex.doAppend('0','2'));
	}
	
	@Test
	public void testCodeNotZeroPrevCode() {
		assertFalse(Soundex.doAppend('3','3'));
	}
	
	@Test
	public void testCodeZeroPrevCode() {
		assertFalse(Soundex.doAppend('0','0'));
	}
	
	@Test
	public void testGetSoundexCodeValid() {
		assertEquals('1', Soundex.getSoundexCode('B'));
		assertEquals('2', Soundex.getSoundexCode('C'));
		assertEquals('3', Soundex.getSoundexCode('D'));
		assertEquals('4', Soundex.getSoundexCode('L'));
		assertEquals('5', Soundex.getSoundexCode('M'));
		assertEquals('6', Soundex.getSoundexCode('R'));
	}
	
	@Test
	public void testGetSoundexCodeInValid() {
		assertEquals('0', Soundex.getSoundexCode('A'));

	

	
	@Test
	public void testIsEmptyStringEmpty() {
		assertTrue(Soundex.isEmptyString(""));
	}
	
	@Test
	public void testIsEmptyStringNull() {
		assertTrue(Soundex.isEmptyString(null));
	}
	
	@Test
	public void testIsEmptyStringValid() {
		assertFalse(Soundex.isEmptyString("Manikandan"));
	}
	
	@Test
	public void testIsEmptyListValid() {
		List<Character> testList = Arrays.asList('C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Z');
		assertTrue(Soundex.isEmptyList(testList));
	}
	
	@Test
	public void testIsEmptyListEmpty() {
		List<Character> testList = Arrays.asList();
		assertFalse(Soundex.isEmptyList(testList));
	}
	
	@Test
	public void testIsEmptyListNull() {
		List<Character> testList = null;
		assertFalse(Soundex.isEmptyList(testList));
	}
}
