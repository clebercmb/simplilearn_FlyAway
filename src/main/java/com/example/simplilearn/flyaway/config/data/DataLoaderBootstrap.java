package com.example.simplilearn.flyaway.config.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Component
public class DataLoaderBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    private DataLoader dataLoader;
    private final ApplicationContext applicationContext;

    @Autowired
    public DataLoaderBootstrap(ApplicationContext applicationContext, DataLoader dataLoader){
        this.applicationContext = applicationContext;
        this.dataLoader = dataLoader;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        dataLoader.loadData();
    }
}