import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


public class Test {

	static Logger log = Logger.getLogger("desc1");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("Start of main()");
		log.info("test info log");
		log.warn("test warn log");
		log.error("test error log");
		log.fatal("test fata log");
		
		log.log(Priority.DEBUG, "Calling init()");
		new Test().init();
	}
	
	public void init() {
		java.util.Properties prop = System.getProperties();
		java.util.Enumeration enu = prop.propertyNames();
		
		log.info("----system environment as seen by java-----");
		log.debug("---format : property = value----");
		
		String key = "";
		while(enu.hasMoreElements()) {
			key = (String) enu.nextElement();
			log.info(key + " = " + System.getProperty(key));
		}
	}

}
