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
		String[] result;
		boolean inComment = false;
		while ((line = reader.readLine()) != null) {
			result = line.split("//");
			if (result.length > 1) {
				// the line includes comment from this type: // ...  
				System.out.println(result[1]);			
			} 
			else {
				result = line.split("/*");
				if (result.length > 1) {
					// the line includes comment from this type: /* ...   
					System.out.println(result[1]);
					inComment = true;
				}
				else {
					result = line.split("*/");
					if (result.length > 1) {
						// last line of ... */ comment 
						System.out.println(result[0]);
						inComment = false;
					}
				}	
			}
			if (inComment) {
				System.out.println(line);
			}
		
		}
		reader.close();
	}
}
