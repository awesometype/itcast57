package com.wenbronk.common.test.jwt;

import io.jsonwebtoken.*;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-29 11:19
 * description:
 */
public class JwtTest {

    @Test
    public void testCreateToken() {
        long time = System.currentTimeMillis();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("aaa")
                .setIssuer("wenbronk")
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + 10 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, "singingkey");
        System.out.println(jwtBuilder.compact());
    }

    @Test
    public void testReadFromToken() {
        String compact = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhYWEiLCJpc3MiOiJ3ZW5icm9uayIsImlhdCI6MTU2NzA0OTE2OCwiZXhwIjoxNTY3MDQ5NzY4fQ.4_vPhQHF9jQpA38MhJO9nDA7W10OxCz8lLWXsS-D4hA";

        Claims claims = Jwts.parser()
                .setSigningKey("singingkey")
                .parseClaimsJws(compact)
                .getBody();

        System.out.println(claims.getId());
        System.out.println(claims.getIssuer());
        System.out.println(claims.getIssuedAt());
    }

    @Test
    public void testCreateCustom() {
        long now = System.currentTimeMillis();//当前时间
        long exp = now + 1000 * 60 * 10;//过期时间为1分钟
        JwtBuilder builder = Jwts.builder()
                .setId("888")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "signingkey")
                .setExpiration(new Date(exp))
                .claim("roles", "admin") //自定义claims存储数据
                .claim("logo", "logo.png");
        System.out.println(builder.compact());
    }

    @Test
    public void testReadCustom() {
        String compact = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1NjcwNDkzMTMsImV4cCI6MTU2NzA0OTkxMiwicm9sZXMiOiJhZG1pbiIsImxvZ28iOiJsb2dvLnBuZyJ9.WCtFqzEqxxG3SLQaRirYQOH6O5OQb2MVzddVKq-iRuA";
        Claims claims = Jwts.parser()
                .setSigningKey("signingkey")
                .parseClaimsJws(compact)
                .getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        System.out.println("roles:"+claims.get("roles"));
        System.out.println("logo:"+claims.get("logo"));

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()) );
    }

}
