package employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NioFileApiTest {
public static String  Home =System.getProperty("user.home");
public static String Temp="temphear";
@Test
public void checkConformation() throws IOException {
	//checking file exists
	Path homePath=Paths.get(Home);
	Assert.assertTrue(Files.exists(homePath));
	//delete the file and check files not exits
	Path path2 =Paths.get(Home+"/"+Temp);
	if(Files.exists(path2))
		FileOperations.deleteFiles(path2.toFile());
	
	Assert.assertTrue(Files.notExists(path2));
//creating directory
	Files.createDirectories(path2);
	Assert.assertTrue(Files.exists(path2));
	//creating files
	IntStream.range(1,10).forEach(range-> {
		Path tempFile =Paths.get(path2+"/"+range);
		Assert.assertTrue(Files.notExists(tempFile));
		try {
			Files.createFile(tempFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(Files.exists(tempFile));
	});
	Files.list(path2).filter(Files::isRegularFile).forEach(System.out::println);
	Files.newDirectoryStream(path2).forEach(System.out::println);
	Files.newDirectoryStream(path2,tempPath->tempPath.toFile().isFile()&&tempPath
			.toString().startsWith("temp")).forEach(System.out::println);
}
}
