package self.model.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//혼자바 14-1 입출력 스트림 p.592
//파일 복사하는 .. 코드 자체를 class로 만들어서 다른 class에서 재사용하면 된다는..그런 의미신 듯
public class FileUtil {
	public static void copy(String src, String des) {
		//파일복사
		try {
		FileInputStream fis = new FileInputStream(src);	//경로이름
		FileOutputStream fos = new FileOutputStream(des);
		
		byte[] b = new byte[100];	//속도 빠르게(100바이트씩 읽어들인다)
		
		while(true) {
			int cnt = fis.read(b);
			if(cnt == -1) break;	//더이상 읽어들일 것이 없을 때 -1을 반환하기 때문에 -1일 때 break
			fos.write(b);
		}
		fis.close();
		fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
