package com.wenbronk.actvititi03.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-25 09:26
 * description: 用于跳过security验证的， 或者直接关闭security验证
 */
//@Configuration
//public class SecurityConfigUtils {
//    private Logger logger = LoggerFactory.getLogger(SecurityConfigUtils.class);
//
//    @Bean
//    public UserDetailsService myUserDetailsService() {
//
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//
//        String[][] usersGroupsAndRoles = {
//                {"salaboy", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
//                {"ryandawsonuk", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
//                {"erdemedeiros", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
//                {"other", "password", "ROLE_ACTIVITI_USER", "GROUP_otherTeam"},
//                {"system", "password", "ROLE_ACTIVITI_USER"},
//                {"admin", "password", "ROLE_ACTIVITI_ADMIN"},
//        };
//
//        for (String[] user : usersGroupsAndRoles) {
//            //从下 标为2 开始 取到这个数组最后的数据
//            List<String> authoritiesStrings = Arrays.asList(Arrays.copyOfRange(user, 2, user.length)); //copyOfRange 是将一个数组 转换为之取的数据 转为list集合操作
//            logger.info("> Registering new user: " + user[0] + " with the following Authorities[" + authoritiesStrings + "]"); //这句代码的意思是 把这个list遍历转成 SimpleGrantedAuthority对象 通过collect(Collectors.toList()) 再转成list集合
//            inMemoryUserDetailsManager.createUser(new User(user[0], passwordEncoder().encode(user[1]),authoritiesStrings.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
//
//        }
//        return inMemoryUserDetailsManager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}

// 直接跳过security验证
@Configuration
public class SecurityConfigUtils extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
    }
}
