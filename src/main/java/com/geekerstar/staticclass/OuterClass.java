package com.geekerstar.staticclass;

/**
 * @author geekerstar
 * date: 2019/3/10 19:31
 * description:
 */
public class OuterClass {
    private static String msg = "geek";

    /**
     * 静态内部类
     */
    public static class NestedStaticClass{
        /**
         * 静态内部类只能访问外部类的静态成员和静态方法
         */
        public void printMessage(){
            //试着将Msg改成非静态的，这将导致编译错误
            System.out.println("Message from nested static class:" + msg);

        }
    }

    /**
     * 非静态内部类
     */
    public class InnerClass{
        /**
         * 不管是静态方法还是非静态方法都可以在非静态内部类中访问
         */
        public void dispaly(){
            System.out.println("Message from non-static nested class"+msg);

        }
    }


}
