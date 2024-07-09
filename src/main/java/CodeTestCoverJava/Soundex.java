package CodeTestCoverJava;

public class Soundex {
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soundex {

	 private static final Map<List<Character> , Character> soundexMapping = initSoundexMapping();

	    private static Map<List<Character> , Character> initSoundexMapping() {
	        Map<List<Character> , Character> soundexMap = new HashMap<>();
	           soundexMap.put(Arrays.asList('A','E','I','O','U','Y','H','W'), '0');
	           soundexMap.put(Arrays.asList('B','F','P','V'), '1');
	           soundexMap.put(Arrays.asList('C','G','J','Q','K','S','X','Z'),'2');
	           soundexMap.put(Arrays.asList('D','T'), '3');
	           soundexMap.put(Arrays.asList('L'), '4');
	           soundexMap.put(Arrays.asList('M','N'), '5');
	           soundexMap.put(Arrays.asList('R'), '6');
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
