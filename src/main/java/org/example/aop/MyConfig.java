package org.example.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.aop")
@EnableAspectJAutoProxy //позволит использовать AOP
public class MyConfig {
}
