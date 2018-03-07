package fr.training.spring.shop.aop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import fr.training.spring.shop.domain.Order;
import fr.training.spring.shop.dto.OrderDTO;

@Aspect
public class CachingAspect {

	private Map<Long, List<Order>> cache = new HashMap<Long, List<Order>>();

	@Pointcut("execution(* fr.training.spring.shop.service.OrderService.getOrdersForCustomer(..)) ")
	private void getOrdersForCustomer() {
	}

	@Pointcut("execution(* fr.training.spring.shop.service.OrderService.addOrder(..)) ")
	private void addOrder() {
	}

	@Around("getOrdersForCustomer()")
	@SuppressWarnings("unchecked")
	public Object cache(ProceedingJoinPoint pjp) throws Throwable {
		Long customerID = (Long) pjp.getArgs()[0];
		List<Order> cachedResult = cache.get(customerID);
		if (cachedResult != null) {
			return cachedResult;
		}

		List<Order> result = (List<Order>) pjp.proceed();
		cache.put(customerID, result);
		return result;
	}

	@Before("addOrder()")
	public void cache(JoinPoint jp) throws Throwable {
		OrderDTO order = (OrderDTO) jp.getArgs()[0];
		cache.remove(order.getCustomerID());
	}
}
