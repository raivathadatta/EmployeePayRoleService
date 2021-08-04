package employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
	public boolean checkFileExists(String filelocation) {
		File file = new File(filelocation);
		if (file.exists())
			return true;
		return false;
	}

	public boolean deleatFile(String filelocation) {
		File file = new File(filelocation);
		if (file.delete())
			return true;
		return false;
	}
	public void createDirectory(String location) throws IOException {
		Path path =Paths.get(location);
		Files.createDirectory(path);
		
	}
	public void removeDirectory(String location) throws IOException {
		Path path =Paths.get(location);
		Files.delete(path);
	}

	public static boolean deleteFiles(File path2) {
		File[]allContents =path2.listFiles();
		if(allContents!=null) {
			for (File file : allContents) {
				deleteFiles(file);
			}
		}
		return path2.delete();
	}

	
}
