package com.geekerstar.Java8.defaultmethod;

/**
 * @author geekerstar
 * date: 2019/3/10 20:10
 * description:
 */
public abstract class Imp implements Formula {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        formula.calculate(100);
        formula.sqrt(16);

    }

}
