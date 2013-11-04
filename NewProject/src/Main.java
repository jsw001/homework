import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {
	static final String DATE_FORMAT = "yyyy-MM-dd";
	static final String FILE_NAME = "text.txt";
	static final OutputStream SYSTEM_OUTPUT = System.out;
	static ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
	
	public static void main(String[] args) {
		// TODO readText
		PrintStream p = new PrintStream(baos);
		System.setOut(p);
		hoge3(SYSTEM_OUTPUT, FILE_NAME);
		hoge1(SYSTEM_OUTPUT, System.currentTimeMillis());
		hoge("Jacob Wilson");
		try {
			SYSTEM_OUTPUT.write(baos.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// TODO out name
	public static void hoge(String name) {
		System.out.println(name);

	}
	// TODO
	public static void hoge1(OutputStream outputStream, long time) {
		Date date = new Date(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		String output = simpleDateFormat.format(date);
		try {
			outputStream.write(output.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// TODO date
	public static void hoge2(OutputStream ouputStream) {

	}
	//TODO readText
	public static void hoge3(OutputStream outputStream, String filename) {

		String output = null;
		try {
			output = new Scanner(new File(filename)).useDelimiter("\\z").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			outputStream.write(output.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
