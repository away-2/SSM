package aop;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class UserServiceLogger {
	private static final Logger log = Logger.getLogger(UserServiceLogger.class);

	public void before(JoinPoint jp) {
	    log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
	            + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
	}
	
	public void afterReturning(JoinPoint jp, Object result) {
	    log.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName()
	            + " 方法。方法返回值：" + result);
	}

}