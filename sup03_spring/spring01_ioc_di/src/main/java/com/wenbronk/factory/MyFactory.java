package com.wenbronk.factory;

import com.google.common.collect.Maps;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Map;
import java.util.Properties;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
public class MyFactory {

    public static Map<String, Object> container = Maps.newConcurrentMap();

    static {
        try {
            Resource resource = new ClassPathResource("bean.xml");
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            properties.forEach((key, value) -> {
                try {
                    container.put(key.toString(), Class.forName(value.toString()).getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public Object getServiceImpl() {
//        return container.get("accountService");
//    }

    public static Object getServiceImpl() {
        return container.get("accountService");
    }

}
