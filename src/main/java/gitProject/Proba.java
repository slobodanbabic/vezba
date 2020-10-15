package gitProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.TextProgressMonitor;

public class Proba {

	public static void main(String[] args) throws Exception {
		// Monitor to get git command progress printed on java System.out console
		TextProgressMonitor consoleProgressMonitor = new TextProgressMonitor(new PrintWriter(System.out));
		Writer writer = null;
		File fajl = new File("NovaKlasa.java");

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fajl), "utf-8"));
			StringBuilder str = new StringBuilder();
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
		Repository repo = GitHelper.openRepository();
		
        // This code would allow to access an existing repository
        Git git = Git.open(new File(System.getProperty("user.dir")));
        
        git.add().addFilepattern(".").call();

		git.commit().setMessage("Initial commit").call();
		System.out.println("Committed file " + fajl + " to repository at " + git.getRepository().getDirectory());
		System.out.println("\n>>> Printing status of local repository\n");
		Status status = git.status().setProgressMonitor(consoleProgressMonitor).call();
		System.out.println("Modified file = " + status.getModified());

	}
}