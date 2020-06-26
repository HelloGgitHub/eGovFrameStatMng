package egovframework.com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspect {


/*    @Before("execution(* egovframework.com.stat.service.*.*(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {

        log.info("=============== onBeforeThing");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("=============== className : "+ className +"=============== methodName : "+ methodName);
    }*/


    @After("execution(* egovframework.com.stat..*Service.select*(..))")
    public void onAfterHandler(JoinPoint joinPoint) {

//        log.info("=============== onAfterHandler");

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String hostName = System.getenv("HOSTNAME");
//        log.info("=============== className : "+ className +"=============== methodName : "+ methodName +"===============hostName:"+hostName);

    }

/*    @AfterReturning(pointcut = "execution(* egovframework.com.stat.dao.*.*(..)))",
            returning = "str")
    public void onAfterReturningHandler(ProceedingJoinPoint joinPoint, Object str) {
        log.info("@AfterReturning : " + str);
        log.info("=============== onAfterReturningHandler");
    }*/

/*    @Pointcut("execution(* egovframework.com.stat.service.*Service.select*(..))")
    public void onPointcut(JoinPoint joinPoint) {
        log.info("=============== onPointcut");
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("=============== className : "+ className +"=============== methodName : "+ methodName);
    }*/
}