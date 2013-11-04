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
	
	@Before
	public void setUp() {
		System.setOut(Main.printStream);
	}
	
	@Test
	public void testPrintName() {
		
		Main.printName(NAME_TEST);
		assertEquals(Main.baos.toString().trim(), NAME_TEST.trim());
		Main.baos.reset();
	}
	
	@Test
	public void testPrintDate() {
		
		Main.printTime(CURRENT_TIME);
		assertEquals(Main.baos.toString().trim(), Main.millisToStringDate(CURRENT_TIME).trim());
		Main.baos.reset();
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
		assertEquals(Main.baos.toString().trim(), FILE_CONTENTS.trim());
		Main.baos.reset();
	}
	

	public void testHoge1() {
		OutputStream os = System.out;
		long time = System.currentTimeMillis();
		//Main.hoge1(os, time);
		String a = "assmonster";
		try {
			os.write(a.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		sb.append(os);
		//assertEquals(os., );
	}
	
	

	public void testHoge2() {
		Method hoge3;
		try {
			 hoge3 = Main.class.getMethod("hoge3");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
