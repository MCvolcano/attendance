package com.mc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：马灿
 * @Description:
 * @Date: 上午 11:38 2018-03-17
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean createFilter(DefaultWebSecurityManager sm) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(sm);
        filter.setLoginUrl("/index.html");
        filter.setUnauthorizedUrl("noqx.html");
        //规则
        Map<String, String> pattern = new HashMap<>();
//        pattern.put("/findAllCategory", "authc,perms[类别管理]");
        pattern.put("/static/**", "anon");
        pattern.put("/**", "anon");
        filter.setFilterChainDefinitionMap(pattern);
        return filter;
    }

    @Bean
    public DefaultWebSecurityManager createSM(JdbcRealm realm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        sm.setRealm(realm);
        sm.setCacheManager(new MemoryConstrainedCacheManager());
        return sm;
    }

    @Bean
    public JdbcRealm createRealm(DruidDataSource ds) {
        JdbcRealm realm =  new JdbcRealm();
        realm.setDataSource(ds);
        realm.setPermissionsLookupEnabled(true);

        // 登录验证
        realm.setAuthenticationQuery("select password from user where account=?");
        // 判断角色
        realm.setUserRolesQuery("select r.rname from role r left join userrole ur on r.rid=ur.rid left join user u on ur.uid=u.id where u.account=?");
        // 判断权限
        realm.setPermissionsQuery("select rs.text from resources rs LEFT JOIN roleres rr on rs.rrid=rr.rrid LEFT join role r on rr.rid=r.rid where r.rname=?");
        return realm;
    }

    //带有@Configuration标签的类会自动调用所有带有Bean标签的文件
    //并将ds 交由spring容器进行管理
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource createDS() {
        DruidDataSource ds = new DruidDataSource();
        return ds;
    }

}
