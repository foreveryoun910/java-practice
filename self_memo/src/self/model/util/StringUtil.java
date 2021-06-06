package self.model.util;

public class StringUtil {
	//파일명 추출
	public static String getFileName(String path) {
		
		String s = null;
		if (path == null) return null;
		s = path.substring(path.lastIndexOf("/")+1);
		return s;
	}
	
	
	
	//확장자 추출(jpg)
	public static String getExtention(String path) {
		
		String s = null;
		if (path == null) return null;
		s = path.substring(path.lastIndexOf(".")+1);
		return s;
	}
	
	
	
	
	//경로 추출(파일명 제외하고 ~image까지)
	public static String getPath(String path) {
		
		String s = null;
		if (path == null) return null;
		s = path.substring(0, 13);
		return s;
	}
}
