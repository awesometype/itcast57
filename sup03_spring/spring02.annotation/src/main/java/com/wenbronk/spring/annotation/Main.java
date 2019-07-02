package com.wenbronk.spring.annotation;

import com.wenbronk.spring.annotation.config.ConfigMain;
import com.wenbronk.spring.annotation.domain.User;
import com.wenbronk.spring.annotation.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-26
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigMain.class);
        AccountService service = context.getBean(AccountService.class);
        List<User> users = null;
        try {
            users = service.find();
        }catch (Exception e) {
            e.printStackTrace();
        }
        users.forEach(System.out::println);
    }

//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        AccountService service = context.getBean(AccountServiceImpl.class);
//        AccountDao dao = context.getBean(AccountDaoImpl.class);
//
//        String s = service.find();
//        System.out.println(s);
//    }

}
