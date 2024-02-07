package tw.com.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;



public class ImageTools {
	private static String imagePath;

	public static String getImagePath() {
		return imagePath;
	}

	public static void setImagePath(String imagePath) {
		ImageTools.imagePath = imagePath;
	}
	
	public static void uploadFile(InputStream input,String fileName) throws IOException {
		Path paths = Paths.get(getImagePath(),fileName);
		File file =  paths.toFile();
		try(BufferedInputStream bfIn = new BufferedInputStream(input);
			FileOutputStream fOut = new FileOutputStream(file)){
			byte[] buffer = new byte[1024];
			int index = -1;
			while((index = bfIn.read(buffer)) != -1) {
				
				fOut.write(buffer,0,index);
			}
			
		}
	}
	
	public static List<String> getImageList() throws IOException {
		Path filePath = Paths.get(getImagePath());
		 List<String> fileNameList = 
				 Files.list(filePath).
				 map(p->p.getFileName().toString()).collect(Collectors.toList());
		return fileNameList;
		
	}
	
	public static void main(String[] args) throws IOException {
		ImageTools.setImagePath("c:\\upload_images");
//		FileInputStream fin = new 
//				FileInputStream("C:\\Users\\xvpow\\OneDrive\\Desktop\\upload\\fox1.png");
//		ImageTools.uploadFile(fin, "fox1.png");
		System.out.println(getImageList());
	
	}
	
}
