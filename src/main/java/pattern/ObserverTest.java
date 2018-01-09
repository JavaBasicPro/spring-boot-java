package pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinpanpan on 2017/11/15.
 */
public class ObserverTest {

    public static void main(String[] agrs) {
        final ConcreteSubject sb = new ConcreteSubject();

        final Observer o = new ConcreteObserver(sb);

        final Observer observer = new ConcreteObserver(sb);

        sb.setTemperature((float) 22.0);

        sb.removeObserver(o);

        SwingExample swingExample=new SwingExample();
        swingExample.go();


    }

}

/**
 * 观察者模式：
 * 微信公众号（可观察者）和订阅者（观察者）
 * 优点：可实现松耦合：让观察者和主题之间松耦合，不需要知道彼此的实现细节
 * jdk源码中的观察者：java.util.Observable和Observer、JButton
 * 设计原则：
 * 找出程序中变化的部分，然后将其与不变的部分相分离
 * 该模式中：变化的是主题的状态、观察者的数目和类型;主题是不变的
 * 优点：
 * 1、针对接口编程，而不针对实现（观察者用主题的接口向主题注册观察者；
 *  主题利用观察者的接口通知观察者）
 *  2、多用组合、少用继承：使用组合将观察者组合进主题，对象间的关系不是通过继承产生，而是在运行时利用组合产生的
 */
//观察者接口
interface Observer {
    public void update(float temprature);
}

//具体的观察者
class ConcreteObserver implements Observer {

    private float temperature;
    //保存一个可观察者的引用，可以方便注册或者取消关注
    private Subject subject;

    //使用构造器，注册观察者
    public ConcreteObserver(final Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public void update(float temprature) {
        System.out.println("可观察者通知到的内容为:" + temprature);
        this.temperature = temprature;
    }
}

//可观察者
interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();   //通知所有的观察者
}

//可观察者的实现
class ConcreteSubject implements Subject {

    /**
     * 多用组合，少用继承
     */
    private final List<Observer> observerList;

    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(final float temperature) {
        this.temperature = temperature;
        this.tempChanged();
    }

    public ConcreteSubject() {
        this.observerList = new ArrayList<>();
        ;
    }

    private void tempChanged() {
        System.out.println("有更新则通知所有的观察者");
        this.notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        System.out.println("添加观察者");
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        System.out.println("删除观察者");
        if (observerList.indexOf(observer) >= 0) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observerList) {
            System.out.println("循环更新所有的观察者");
            observer.update(temperature);
        }
    }
}

/*
基于jdk的JButton实现观察者和可观察者
 */
class SwingExample {

    JFrame frame;

    public void go() {
        frame = new JFrame();
        //给可观察者 中添加两个观察者
        JButton button = new JButton("should I do it ");

        button.addActionListener(new AngleListinser());
        button.addActionListener(new DevilListinser());
        button.updateUI();
        frame.getContentPane().add(BorderLayout.CENTER,button);
    }
}

class AngleListinser implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("天使监听并执行");
    }
}

class DevilListinser implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("恶魔监听并执行");
    }
}