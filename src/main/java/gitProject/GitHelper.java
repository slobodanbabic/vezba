package gitProject;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class GitHelper {

    public static Repository openRepository() throws IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
       
        Repository repository = builder.setGitDir(new File(System.getProperty("user.dir")))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .build();
        return repository;
    }

    public static Repository createNewRepository() throws IOException {
        // prepare a new folder
        File localPath = File.createTempFile(System.getProperty("user.dir"), "");
        localPath.delete();

        // create the directory
        Repository repository = FileRepositoryBuilder.create(new File(System.getProperty("user.dir"), ".git"));
        repository.create();

        return repository;
    }
}