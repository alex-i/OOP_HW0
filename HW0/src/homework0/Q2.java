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
		String[] result, tempResult;
		boolean inComment = false;
		while ((line = reader.readLine()) != null) {
			result = line.split("//");
			if (result.length > 1) {
				// the line includes comment from this type: // ...  
				System.out.println(result[1]);			
			} else {
				result = line.split("/\\*");
				if (result.length > 1) {
					if (result[1].contains("*/")) {
						// the line includes comment from this type: /* ...  */
						tempResult = result[1].split("\\*/");
						System.out.println(tempResult[0]);					
					} else {
						// first line of the comment from this type: /* ...
						System.out.println(result[1]);
						inComment = true;
					}
				} else {
					if (inComment) {
						if (line.contains("*/")) {
							// last line of the comment from this type: ... */  
							result = line.split("\\*/");
							System.out.println(result[0]);
							inComment = false;
						} else {
							// in the middle of the comment from this type /* ... */
							System.out.println(line);
						}
					}
				}	
			}
		
		}
		reader.close();
	}
}
