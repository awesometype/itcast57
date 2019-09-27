package com.wenbronk.shiro02.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-04 13:20
 * description:
 */
@Configuration
public class ShiroSessionManangerConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        return redisManager;
    }

    /**
     * 配饰shiro的缓存为redis
     */
    @Bean
    public CacheManager cacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }

    /**
     *  RedisSessionDAO shiro sessionDao层的实现 通过redis
     */
    @Bean
    public SessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    /**
     * 配置会话管理器，指定sessionDao的依赖关系
     */
    @Bean
    public SessionManager customerSessionManager(SessionDAO redisSessionDAO) {
        CustomeSessionManager customeSessionManager = new CustomeSessionManager();
        customeSessionManager.setSessionDAO(redisSessionDAO);
        return customeSessionManager;
    }

}
