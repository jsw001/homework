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
	
	@Before
	public void setUp(){
		System.setOut(Main.printStream);
	}
	
	@Test
	public void testPrintName() {
		String nameTest = "nothing";
		Main.printName(nameTest);
		assertEquals(Main.baos.toString().trim(), nameTest.trim());
		Main.baos.reset();
	}
	
	@Test
	public void testPrintDate() {
		long time = System.currentTimeMillis();
		Main.printTime(time);
		assertEquals(Main.baos.toString().trim(), Main.millisToStringDate(time).trim());
		Main.baos.reset();
	}
	
	@Test
	public void testMillisToStringDate() {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Main.DATE_FORMAT);
		String dateString = simpleDateFormat.format(date);
		assertEquals(dateString, Main.millisToStringDate(time));
	}
	
	@Test
	public void testPrintFile(){
		String fileName = "testfile.txt";
		String fileContents = "testing";
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(fileName);
			printWriter.write(fileContents);
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.printFile(fileName);
		assertEquals(Main.baos.toString().trim(), fileContents.trim());
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
