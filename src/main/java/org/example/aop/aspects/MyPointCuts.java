package org.example.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {
      @Pointcut("execution(* stop*(..))")//шаблон для поинтката, чтобы иметь ссылку
    public void allAddMethods() {
    }
}
