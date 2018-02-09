package com.bxw.lesson2.bootstrap;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 {@link org.springframework.boot.env.PropertySourceLoader} 实现
 * Created by wxb on 2018/2/9.
 */
public class MyPropertySourceLocator implements PropertySourceLocator{
    @Override
    public PropertySource<?> locate(Environment environment) {
        if(environment instanceof ConfigurableEnvironment){
            ConfigurableEnvironment configurableEnvironment = ConfigurableEnvironment.class.cast(environment);
            //获取PropertySources
            MutablePropertySources propertySources = configurableEnvironment.getPropertySources();
            //定义新的propertySource ,放置首位
            propertySources.addFirst(createPropertySource());
        }

        return null;
    }


    private PropertySource createPropertySource(){
        Map<String, Object> source = new HashMap<>();
        source.put("spring.application.name", "bxw spring_cloud");
        //设置名称和来源
        PropertySource propertySource = new MapPropertySource("over-bootstrap-property-source", source);
        return propertySource;
    }


}
