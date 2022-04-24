package Project5;

/**
 * @author CCPaulHipolito
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverter_TestSTUDENT {
	File inputFile;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToEnglishStringSTUDENT() {
		String converterStudent = MorseCodeConverter.convertToEnglish(".-. --- -..- .- -. -. . / -.-- --- ..- / -.. --- / -. --- - / .... .- ...- . / - --- / .--. ..- - / --- -. / - .... . / .-. . -.. / .-.. .. --. .... -");
		assertEquals("roxanne you do not have to put on the red light",converterStudent);
	}
	
	@Test
	public void testConvertToEnglishFileSTUDENT() throws FileNotFoundException {
		String testStudent = "a frog in a well cannot conceive of the ocean";		
		getFile("studentTest.txt");
		String converterStudent = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(testStudent,converterStudent);
	}
	
	//Taken from MorseCodeConverter_GFA_2_Test class
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
