package cc.ehan.config;

import cc.ehan.mybatis.datascope.ManagerDataScopeInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cc.ehan.*.mapper"})
public class MybatisConfig {

    @Bean
    public ManagerDataScopeInterceptor managerDataScopeInterceptor() {
        return new ManagerDataScopeInterceptor();
    }
}
