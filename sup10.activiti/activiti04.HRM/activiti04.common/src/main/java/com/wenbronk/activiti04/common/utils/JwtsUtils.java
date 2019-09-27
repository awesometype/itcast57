package com.wenbronk.activiti04.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-29 11:32
 * description:
 */
@Data
@Component
@ConfigurationProperties("jwt.config")
public class JwtsUtils {

    private String key;
    private Long ttl;

    /**
     * 签发 token
     */
    public String createJwts(String id, String subject, Map<String, Object> map) {
        long now = System.currentTimeMillis();
        long exp = now + ttl;
        JwtBuilder jwtBuilder = Jwts.builder().setId(id)
                .setSubject(subject).setIssuedAt(new Date(now))
                .signWith(SignatureAlgorithm.HS256, key);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jwtBuilder.claim(entry.getKey(), entry.getValue());
        }
        if (ttl > 0) {
            jwtBuilder.setExpiration(new Date(exp));
        }
        return jwtBuilder.compact();
    }

    /**
     * 读取
     */
    public Claims parseJwts(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

}
