package log.exam;

import java.io.IOException;

import org.apache.log4j.Logger;

public class log4jExample {
	// Filed(instance, static변수)
	private static Logger logger = Logger.getLogger("Log4jExample.class");

	public void a() {
		logger.info("info레벨의 로그임돠");
		//logger.info("info 레벨의 로그입니다.");
		b();
	}

	public void b() {
		logger.warn("warn 레벨의 로그입니다.");
		c();
	}

	public void c() {
		IOException e = new IOException("입출력 오류");
		logger.error("error 레벨의 로그 입니다.",e);
	}

	public static void main(String[] args) {
		log4jExample ex = new log4jExample();
		if(logger.isDebugEnabled()){//로그 레벨이 debug이면 true
			logger.debug("디버그 로그 입니다.");	
		}
			ex.a();

	}
}
