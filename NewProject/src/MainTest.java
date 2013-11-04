import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainTest {

	@Test
	public void testHoge3() {
		OutputStream os = System.out;
		Main.hoge3(os, "text.txt");
		assert("text".equals(os.toString()));
	}
	
	@Test
	public void testHoge1() {
		OutputStream os = System.out;
		long time = System.currentTimeMillis();
		Main.hoge1(os, time);
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
