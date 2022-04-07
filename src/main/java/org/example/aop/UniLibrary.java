package org.example.aop;

import org.example.aop.aspects.AbstractLibrary;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary");
    }

    @Override
    public void returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary");
    }
    public void getMagazine() {
        System.out.println("Мы берем журнал из UniLibrary");
    }
    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в UniLibrary");
    }
}
