import java.io.IOException;


public class HanUtil {
	public static String uni2ksc(String uniCodeStr) throws IOException {
		try {
			if(uniCodeStr != null) {
				return new String(uniCodeStr.getBytes("8859_1"), "KSC5601");
			} else {
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String ksc2uni(String kscStr) throws IOException {
		try {
			if(kscStr != null) {
				return new String(kscStr.getBytes("KSC5601"), "8859_1");
			} else {
				return null;
			}
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
