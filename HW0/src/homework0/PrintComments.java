package homework0;

import java.io.*;

public class PrintComments {

	public static boolean inComment = false;
	
	//print all the comments in line that include /*
	public static void printCommentLine(String line) {
		String[] result, tempResult;
		if (line == "") {
			return;
		}
		if ((line.indexOf("/*") < line.indexOf("//") || line.indexOf("//") == -1) &&
				line.indexOf("/*") != -1) {
			result = line.split("/\\*", 2);
			if (result[1].contains("*/")) {
				// the line includes comment from this type: /* ...  */
				tempResult = result[1].split("\\*/", 2);
				System.out.print(tempResult[0]);
				if (tempResult.length > 1) {
					printCommentLine(tempResult[1]);
				}
				System.out.print("\n");
			} else {
				// first line of the comment from this type: /* ...
				System.out.println(result[1]);
				inComment = true;
			}
		} else if ((line.indexOf("//") < line.indexOf("/*") || line.indexOf("/*") == -1) &&
				line.indexOf("//") != -1) {
			//there is comment //... after /*...*/ comment
			result = line.split("//");
			System.out.println(result[1]);
			
		}
	}
	
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
		
		while ((line = reader.readLine()) != null) {
			if (inComment == false) {
				if ((line.indexOf("//") < line.indexOf("/*") || line.indexOf("/*") == -1) &&
						line.indexOf("//") != -1) {
					// the line includes comment from this type: // ...  
					result = line.split("//");
					System.out.println(result[1]);	
				} else  {
					printCommentLine(line);
				}
			} else {
				//in comment /*...*/
				if (line.contains("*/")) {
					// last line of the comment from this type: ... */  
					printCommentLine(line);
					inComment = false;
				} else {
					// in the middle of the comment from this type /* ... */
					System.out.println(line);
				}
			}
				
		}
		
		
		reader.close();
	}
	

}
