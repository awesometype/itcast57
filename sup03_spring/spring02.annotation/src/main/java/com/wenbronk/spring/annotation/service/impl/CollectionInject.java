package com.wenbronk.spring.annotation.service.impl;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author wenbronk
 * @Date 2019-06-26
 */
@Component
public class CollectionInject {

    private String[] myStr;
    private List<String> lists;
    private Set<String> sets;
    private Map<String, String> myMap;
    private Properties properties;

    public String[] getMyStr() {
        return myStr;
    }

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
