package org.example.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCuts {
      @Pointcut("execution(* add*(..))")//шаблон для поинтката, чтобы иметь ссылку
    public void allAddMethods() {
    }
}
