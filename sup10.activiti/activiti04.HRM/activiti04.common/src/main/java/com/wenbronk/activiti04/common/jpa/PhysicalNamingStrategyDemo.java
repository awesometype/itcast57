package com.wenbronk.activiti04.common.jpa;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Objects;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-27 11:07
 * description:
 */
public class PhysicalNamingStrategyDemo extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
        if (name == null) {
            return name;
        }
        String columnName = warp(name.getText());
        columnName = replaceFirst(columnName);
        return super.toPhysicalCatalogName(new Identifier(columnName, name.isQuoted()), context);
    }


    public String warp(String columnName) {
        columnName = columnName.replaceAll("[A-Z]", "_$1").toLowerCase();
        columnName = replaceFirst(columnName);
        return columnName;
    }

    public String replaceFirst(String columnName) {
        if (Objects.equals(columnName.charAt(0), "_")) {
            columnName = columnName.replaceFirst("_", "");
        }
        return columnName;
    }
}
