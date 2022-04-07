package org.example.aop;

import org.example.aop.aspects.SchoolLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.returnBook();
        uniLibrary.getMagazine();
        uniLibrary.returnMagazine();

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.returnBook();

        context.close();

    }
}
