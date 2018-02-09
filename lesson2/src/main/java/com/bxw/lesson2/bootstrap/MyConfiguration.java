package com.bxw.lesson2.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * Bootstrap 配置bean
 * Created by wxb on 2018/2/9.
 */
@Configuration
public class MyConfiguration implements ApplicationContextInitializer{

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        //从ConfigurationApplicationContext获取ConfigurationEnvironment实例
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        //获取PropertySources
        MutablePropertySources propertySources = environment.getPropertySources();
        //定义一个新的PropertySource,放置首位
        propertySources.addFirst(createPropertySource());
    }

    private PropertySource createPropertySource(){
        Map<String, Object> source = new HashMap<>();
        source.put("name", "bxw");
        PropertySource propertySource = new MapPropertySource("my-property-source", source);
        return propertySource;
    }




}
