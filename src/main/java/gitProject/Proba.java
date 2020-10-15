package gitProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Proba {

	public static void main(String[] args) throws Exception {
	

		Writer writer = null;
		File fajl = new File("NovaKlasa.java");

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fajl), "utf-8"));
			StringBuilder  str = new StringBuilder();
			str.append("public class NovaKlasa {");
			str.append("}");
			writer.write(str.toString());
			
			
			
		} catch (IOException ex) {			
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		System.out.println(fajl.getAbsolutePath());
		File myObj = new File("filename.java");
		if (myObj.createNewFile()) {
			
			System.out.println("File created: " + myObj.getName());
		} else {
			System.out.println("File already exists.");
		}

		System.out.println(myObj.getAbsolutePath());
	
		 
		

	}
}