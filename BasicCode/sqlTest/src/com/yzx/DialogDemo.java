package com.yzx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame {
    public DialogDemo()  {
        this.setVisible(true);
        this.setSize(700,500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//关闭窗口
        //JFrame 放东西，容器
        Container container = this.getContentPane();//将JFrame 放在这个容器里
        //绝对布局
        container.setLayout(null);

        //按钮
        JButton button = new JButton("点击弹出一个对话框");//创建
        button.setBounds(30,30,200,50);//设置按钮大小
        //点击一个按钮的时候，弹出一个弹窗
        button.addActionListener(new ActionListener() {//监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                new MyDialogDemo();//实例化，就行调用
            }
        });
        container.add(button);//将这个按钮放在这个容器里
    }

    public static void main(String[] args) {
        new DialogDemo();//实例化，调用

    }

}
//弹窗的窗口，
class MyDialogDemo extends JDialog{//一个弹窗的类  继承软件的弹窗的类 也是一个窗口
    public MyDialogDemo() {//构造器 实例化 这个类
        this.setVisible(true);
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null);
        container.add(new Label("我带你学习"));
        JButton button = new JButton("你是害人的");//第二个弹窗的按钮
        button.setBounds(30,30,200,50);//大小
        this.setVisible(true);//可见
container.add(button);//放在容器里

    }
}
