package Project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class. Contains a static MorseCodeTree object and constructs the MorseCodeTree
 * @author CCPaulHipolito
 */

public class MorseCodeConverter {
	
    static MorseCodeTree morseCodeTree = new MorseCodeTree();
    
    /**
     * Converts a file of Morse code into English
     * @param codeFile
     * @return the English translation of the morse code located in the txt file
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        if(codeFile == null)
        	throw new FileNotFoundException("File not found");
        
		Scanner scanner = new Scanner(codeFile);
        String english = "";
        while(scanner.hasNext())
        	english += scanner.nextLine();
        scanner.close();
        return convertToEnglish(english);
    }

    /**
     * Converts Morse code into English
     * @param code
     * @return the English translation of the morse code
     */
    public static String convertToEnglish(String code) {
    	String english = "";
        String[] mCode = code.split("/");
        
        for(int i = 0; i < mCode.length; i++) {
        	mCode[i] = mCode[i].trim();
        	String[] letter = mCode[i].split(" ");
        	
        	for(int j = 0; j < letter.length; j++)
        		english += morseCodeTree.fetch(letter[j]);
        	english += " ";
        }
        return english.trim();
    }

    /**
     * Uses the toArrayList method in MorseCodeTree 
     * @return the data in the tree in LNR order separated by a space
     */
    public static String printTree() {
    	ArrayList<String> arrList = morseCodeTree.toArrayList();
        String treeString = "";
        for(String s : arrList)
        	treeString += s + " ";
        return treeString;
    }
}
