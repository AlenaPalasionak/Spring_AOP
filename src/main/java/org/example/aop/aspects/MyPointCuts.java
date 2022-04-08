package org.example.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {
      @Pointcut("execution(* get*())")//шаблон для поинтката, чтобы иметь ссылку
    public void allGetMethods() {
    }
}
