package com.itheima.test6;

public class TestSwimming {
    public static void main(String[] args) {
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("贴纸，我们去游泳吧");
            }
        });
    }
    /**
     * 使用接口中的方法
     */
    public static void goSwimming(Swimming swimming) {
        /**
         *          如果一个方法的参数是一个接口的话，就可以使用匿名内部类作为参数传递进去
         *          Swimming swim = goSwimming(new Swimming() {
         *             @Override
         *             public void swim() {
         *                 System.out.println("贴纸，我们去游泳吧");
         *             }
         *         }
         */
        swimming.swim();
    }
}

/**
 * 游泳接口
 */
interface Swimming{
    void swim();
}

