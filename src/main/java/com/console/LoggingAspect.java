package com.console;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private static boolean loggingEnabled = true;

    @Before("execution(void ConsoleTransformer.getStringPlayer())")
    public void logInputString(JoinPoint joinPoint) {
        if (isLoggingEnabled()) {
            String input = (String) joinPoint.getArgs()[0];
            System.out.println("Input string: " + input);
        }
    }

    @Before("execution(Object ConsoleTransformer.validationAnswerPlayer(..))")
    public Object logTransformedString(ProceedingJoinPoint joinPoint) throws Throwable {
        if (isLoggingEnabled()) {
            StringBuilder transformedString = (StringBuilder) joinPoint.proceed();
            System.out.println("Transformed string: " + transformedString);
            return transformedString;
        }

        return joinPoint.proceed();
    }

    public static boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public static void setLoggingEnabled(boolean enabled) {
        loggingEnabled = enabled;
    }
}
