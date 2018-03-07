package fr.training.spring.shop.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@Pointcut("execution(* fr.training.spring.shop.service.impl.OrderServiceImpl.*(..)) ")
	private void profile() {
	}

	@Before("profile()")
	public void log(JoinPoint jp) {
		StringBuilder toLog = new StringBuilder("logging ").append(jp.getSignature().toLongString())
				.append(" with args: [");
		Object[] args = jp.getArgs();
		for (Object arg : args) {
			toLog.append(arg).append(", ");
		}
		toLog.append("]");
		LOGGER.info(toLog.toString());
	}

	@Around("profile()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		LOGGER.info("Method execution time: " + elapsedTime + " milliseconds.");
		return output;
	}

}
