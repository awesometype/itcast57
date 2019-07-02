package com.wenbronk.spring03.aop.transactionManager.factory;

import com.wenbronk.spring03.aop.transactionManager.domain.Account;
import com.wenbronk.spring03.aop.transactionManager.service.AccountService;
import com.wenbronk.spring03.aop.transactionManager.transaction.TransactionManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author wenbronk
 * @Date 2019-06-30
 */
public class BeanFactory {

    private AccountService accountService;
    private TransactionManager transactionManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    public Object getProxy() {
        AccountService service = (AccountService) Enhancer.create(AccountService.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                try {
                    transactionManager.beginTransaction();
                    returnValue = method.invoke(accountService, args);
                    transactionManager.commit();
                } catch (Exception e) {
                    transactionManager.rollback();
                } finally {
                    transactionManager.release();
                }
                return returnValue;
            }
        });
        return service;
    }

}
