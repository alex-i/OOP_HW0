package homework0;

import java.io.*;

public class Q2 {
	public static void main(String[] args) throws IOException {
		if (args.length != 1)
		{
			System.out.println("Invalid arguments");
			return;
		}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
		} catch (Exception e) {
			System.out.println("File doesn't exists");
			return;
		}
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		
	}
}
