package com.wzp.LearnSpring.TestFactoryBean;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//自定义bean加载的过程。
@Component
public class FactoryBeanLearn implements FactoryBean<FactoryBeanService> {
    @Override
    public FactoryBeanService getObject() throws Exception {
        return new FactoryBeanServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanService.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Test
    public void test(){
        ClassPathXmlApplicationContext apac = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        apac.start();
        apac.getBean(FactoryBeanService.class);
    }
}


