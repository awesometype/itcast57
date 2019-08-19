package com.wenbronk.springboot01.start.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Objects;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-07 10:13
 * description:
 */
public class MyPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    // 重载方法， 修改字段物理名称
    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        String text = warp(name.getText());
        if (Objects.equals(text.charAt(0), "_")) {
            text = text.replaceFirst("_", "");
        }
        return super.toPhysicalColumnName(new Identifier(text, name.isQuoted()), context);
    }

    public static String warp(String text) {
        text = text.replaceAll("([A-Z])", "_$1").toLowerCase();
        if (Objects.equals(text.charAt(0), "_")) {
            text = text.replaceFirst("_", "");
        }
        return text;
    }
}
