package com.wzp.LearnSpring.TestFactoryBean;

public class FactoryBeanServiceImpl implements FactoryBeanService{
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
