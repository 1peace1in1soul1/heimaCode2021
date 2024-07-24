package com.itheima.test3;

public class Test3Ploymophic {

    public static void main(String[] args) {
        useAnimal(new Dog());
        useAnimal(new Cat());

    }

/*    public static void useDog(Dog dog){
        dog.eat();
    }

    public static void useCat(Cat cat){
        cat.eat();
    }*/
public static void useAnimal(Animal a){
    a.eat();

    if(a instanceof Dog){
        Dog d = (Dog)a;
        d.watchHome();  //ClassCastException 类型转换异常
    }

}

}

abstract class Animal{
    public  abstract void eat();
}

class Dog extends Animal{
    public void eat() {
        System.out.println("狗吃肉");
    }

    public void watchHome() {
        System.out.println("狗看家");
    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
