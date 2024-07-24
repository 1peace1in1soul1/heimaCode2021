package com.itheima.test4;

public class Test4Ploymophic {
    public static void main(String[] args) {
        //向上转型：父类指向子类对象
        Fu f = new Zi();
        f.show();
        //多态的弊端：不能调用子类特有的
        //f.method();

        //A：直接创建子类的对象
        //B：向下转型

        //2、向下转型：从父类类型转换为子类类型
        Zi z = (Zi) f;
        z.method();
    }
}

class Fu{
    public void show(){
        System.out.println("Fu ... show...");
    }
}
class Zi extends Fu{
    @Override
    public void show() {
        System.out.println("Zi...show");
    }

    public void method() {
        System.out.println("我是特有的方法...method");
    }
}