package com.wenbronk.spring.ioc;

import com.wenbronk.spring.ioc.dao.AccountDao;
import com.wenbronk.spring.ioc.dao.impl.AccountDaoImpl;
import com.wenbronk.spring.ioc.service.AccountService;
import com.wenbronk.spring.ioc.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
public class Main {

    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("bean.xml");
//        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = context.getBean(AccountServiceImpl.class);
        AccountDao dao = context.getBean(AccountDaoImpl.class);

        String s = service.find();
        System.out.println(s);

    }

}
