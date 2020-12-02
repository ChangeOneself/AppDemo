package app.manager.apple;

import app.manager.apple.bean.Apple;
import app.manager.apple.bean.Number;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        System.out.println(Number.ONE);
        List<Apple> appleList = new ArrayList<>();
        for(int ii = 10; ii>0;ii--){
            Apple apple = new Apple();
            apple.setSize("aaa"+ii);
            appleList.add(apple);

        }
        appleList.sort((Apple a1, Apple a2) -> a1.getSize().compareTo(a2.getSize()));
        for (Apple apple:
        appleList) {
            System.out.println(apple.getSize());
        }
    }



}
