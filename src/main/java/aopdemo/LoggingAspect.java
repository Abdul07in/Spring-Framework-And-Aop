package aopdemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

    @Before("execution(* aopdemo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        System.out.println(jp.getSignature());

        String args = jp.getArgs()[0].toString();

        System.out.println("Before Loggers" + args);
    }

    @After("execution( * *.*.checkout(..) )")
    public void afterLogger() {
        System.out.println("After Logger");
    }

    @Pointcut("execution(* aopdemo.ShoppingCart.getQuantity(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning(pointcut = "afterReturningPointCut()" , returning = "value")
    public void afterReturing(String value) {
        System.out.println("After Returning value = " + value);
    }
}
