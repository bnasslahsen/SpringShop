package fr.training.spring.shop.interceptor;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.chainsaw.Main;
import org.slf4j.Logger;

/**
 * @author par Gauthier Peel
 */
public class TraceInterceptor implements MethodInterceptor, Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(MethodInvocation)
	 */
	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Main.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();
		LOG.info("ENTERING " + methodName + "()");
		long startTime = System.nanoTime();
		Object rval = invocation.proceed();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		LOG.info("EXITING " + methodName + "()" + " in :" + duration / 1000000 + " ms");
		return rval;
	}
}