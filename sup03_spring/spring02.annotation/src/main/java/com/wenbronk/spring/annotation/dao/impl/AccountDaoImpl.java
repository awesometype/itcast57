package com.wenbronk.spring.ioc.dao.impl;

import com.wenbronk.spring.ioc.dao.AccountDao;
import com.wenbronk.spring.ioc.service.impl.CollectionInject;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
public class AccountDaoImpl implements AccountDao {

    private String name;
    private Integer age;
    private Date birthday;
    private CollectionInject collectionInject;

    public AccountDaoImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public CollectionInject getCollectionInject() {
        return collectionInject;
    }

    public void setCollectionInject(CollectionInject collectionInject) {
        this.collectionInject = collectionInject;
    }

    @Override
    public String find() {
        System.out.println(Arrays.toString(collectionInject.getMyStr()));
        System.out.println(collectionInject.getLists());
        System.out.println(collectionInject.getSets());
        System.out.println(collectionInject.getMyMap());
        System.out.println(collectionInject.getProperties());

        return this.name + ": " + this.age + ": " + this.birthday;
    }
}
