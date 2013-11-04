import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainTest {
	final static String NAME_TEST = "nothing";
	final static long CURRENT_TIME = System.currentTimeMillis();
	static final String FILE_NAME = "testfile.txt";
	static final String FILE_CONTENTS = "testing";
	static ByteArrayOutputStream baos = new ByteArrayOutputStream();
	static PrintStream printStream = new PrintStream(baos);
	
	@Before
	public void setUp() {
		System.setOut(printStream);
	}
	
	public boolean assertOutput(String testInput){
		testInput = testInput.trim();
		String outputString = baos.toString().trim();
		boolean result = testInput.equals(outputString);
		baos.reset();
		return result;
	}
	
	@Test
	public void testPrintName() {
		
		Main.printName(NAME_TEST);
		assertTrue(assertOutput(NAME_TEST));
	}
	
	@Test
	public void testPrintDate() {
		
		Main.printTime(CURRENT_TIME);
		assertEquals(baos.toString().trim(), Main.millisToStringDate(CURRENT_TIME).trim());
		baos.reset();
	}
	
	@Test
	public void testMillisToStringDate() {
		Date date = new Date(CURRENT_TIME);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Main.DATE_FORMAT);
		String dateString = simpleDateFormat.format(date);
		assertEquals(dateString, Main.millisToStringDate(CURRENT_TIME));
	}
	
	@Test
	public void testPrintFile() {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(FILE_NAME);
			printWriter.write(FILE_CONTENTS);
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.printFile(FILE_NAME);
		assertEquals(baos.toString().trim(), FILE_CONTENTS.trim());
		baos.reset();
	}
}
