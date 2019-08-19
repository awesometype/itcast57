package com.wenbronk.ssm02.test;

import com.wenbronk.ssm02.controller.UserController;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * describe:
 * wenbronk create at 2019/7/27 13:45
 */
public class AopTest {

    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException {
        String methodName = "findAll";
//        String className = "com.wenbronk.ssm02.controller.UserController";
//        Class<?> aClass = Class.forName(className);

        Class<UserController> aClass = UserController.class;
        Method declaredMethod = aClass.getDeclaredMethod(methodName);

    }

}
