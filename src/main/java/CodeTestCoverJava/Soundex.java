package CodeTestCoverJava;

public class Soundex {
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soundex {

	 private static final Map<Character , Character> soundexMapping = initSoundexMapping();

	    private static Map<Character , Character> initSoundexMapping() {
	        Map<List<Character> , Character> soundexMap = new HashMap<>();
		    soundexMap.put('A','0');
		    soundexMap.put('E','0');
		    soundexMap.put('I','0');
		    soundexMap.put('O','0');
		    soundexMap.put('U','0');
		    soundexMap.put('Y','0');
		    soundexMap.put('H','0');
		    soundexMap.put('W','0');
		    soundexMap.put('B','1');
		    soundexMap.put('F','1');
		    soundexMap.put('P','1');
		    soundexMap.put('V','1');
		    soundexMap.put('C','2');
		    soundexMap.put('G','2');
		    soundexMap.put('J','2');
		    soundexMap.put('Q','2');
		    soundexMap.put('K','2');
		    soundexMap.put('S','2');
		    soundexMap.put('X','2');
		    soundexMap.put('Z','2');
		    soundexMap.put('D','3');
		    soundexMap.put('T','3');
		    soundexMap.put('L','4');
		    soundexMap.put('M','5');
		    soundexMap.put('N','5');
		    soundexMap.put('R','6');
	           return soundexMap;
	    };

	    public static String generateSoundex(String name) {
	        if (name == null || name.isEmpty()) {
	            return "";
	        }

	        StringBuilder soundex = new StringBuilder();
	        soundex.append(Character.toUpperCase(name.charAt(0)));
	        char prevCode = getSoundexCode(name.charAt(0));

	        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
	            char code = getSoundexCode(name.charAt(i));
	            if (code != '0' && code != prevCode) {
	                soundex.append(code);
	                prevCode = code;
	            }
	        }

	        while (soundex.length() < 4) {
	            soundex.append('0');
	        }

	        return soundex.toString();
	    }

	    private static char getSoundexCode(char c) {
	        c = Character.toUpperCase(c);
	        return soundexMapping.getOrDefault(c, '0');
	    }
	}
