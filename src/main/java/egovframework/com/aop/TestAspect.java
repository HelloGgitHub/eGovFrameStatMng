package egovframework.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspect {
	Logger logger = LoggerFactory.getLogger(TestAspect.class);

/*    @Before("execution(* egovframework.com.stat.service.*.*(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {

        log.info("=============== onBeforeThing");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("=============== className : "+ className +"=============== methodName : "+ methodName);
    }*/


    @After("execution(* egovframework.com.stat..*Dao.select*(..))")
    public void onAfterHandler(JoinPoint joinPoint) {
    	
    	

//        log.info("=============== onAfterHandler");

       String className = joinPoint.getSignature().getDeclaringTypeName();
       String methodName = joinPoint.getSignature().getName();
       String hostName = System.getenv("HOSTNAME");
       logger.debug("=============== className : "+ className +"=============== methodName : "+ methodName +"===============hostName:"+hostName);

    }

    @AfterReturning(pointcut = "execution(* egovframework.com.stat..*Dao.update*(..)))",
            returning = "str")
    public void onAfterReturningHandler(JoinPoint joinPoint, Object str) throws Throwable {
    	logger.debug("@AfterReturning : " + str);
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		String hostName = System.getenv("HOSTNAME");
		logger.debug("=============== className : "+ className +"=============== methodName : "+ methodName +"===============hostName:"+hostName);
    	
       // log.info("=============== onAfterReturningHandler");
    }

/*    @Pointcut("execution(* egovframework.com.stat.service.*Service.select*(..))")
    public void onPointcut(JoinPoint joinPoint) {
        log.info("=============== onPointcut");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("=============== className : "+ className +"=============== methodName : "+ methodName);
    }*/
}