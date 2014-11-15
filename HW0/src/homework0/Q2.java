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
			if (inComment && line.indexOf("\\*/") == -1) {
				//in middle of multi-line comment
				System.out.println(line);	
			} else if (inComment && line.indexOf("\\*/") != -1) {
				//last line in multi-line comment
				result = line.split("\\*/");
				System.out.println(result[0]);
				inComment = false;
				while (result[1] != "") {
					if (line.indexOf("//") < line.indexOf("/\\*") || 
							line.indexOf("/\\*") == -1) {
						// comment //... before /*...
						tempResult = result[1].split("//");
						if (tempResult.length > 1) { 
							System.out.println(tempResult[1]);			
						}
					} else {
						
					}
				}
			}
			
			
			if ((line.indexOf("//") < line.indexOf("/\\*") || line.indexOf("/\\*") == -1) &&
					(inComment == false)) {
				result = line.split("//");
				if (result.length > 1) {
					// the line includes comment from this type: // ...  
					System.out.println(result[1]);			
				}
			} else { 
				result = line.split("/\\*");
				while (result.length > 1) {
					if (result[1].contains("*/")) {
						// the line includes comment from this type: /* ...  */
						tempResult = result[1].split("\\*/");
						System.out.println(tempResult[0]);
						if (tempResult.length > 1) {
							result = tempResult[1].split("/\\*");
						} else {
							break;
						}
					} else {
						// first line of the comment from this type: /* ...
						System.out.println(result[1]);
						inComment = true;
						break;
					}
				}
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
		reader.close();
	}
	
	//print all the comments in line that include /*
	public void printComment2(String line) {
		String[] result, tempResult;
		result = line.split("/\\*");
		if (result.length > 1) {
			tempResult =  
		}
		while (result[1] != "") {
			
		}
	}
}
