package com.airlenet.portforwarding.autoconfigure;

import com.airlenet.portforwarding.PortForwardingService;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration(proxyBeanMethods = false)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
//@AutoConfigureAfter(PropertyPlaceholderAutoConfiguration.class)
//@AutoConfigureBefore(value = {DataSourceAutoConfiguration.class , HibernateJpaAutoConfiguration.class, DruidDataSourceAutoConfigure.class,WebMvcAutoConfiguration.class})
@EnableConfigurationProperties(PortForwardingProperties.class)
public class PortForwardingAutoConfigure {

    public PortForwardingAutoConfigure(){

    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    PortForwardingService portforwardingService(PortForwardingProperties properties) {
        return new PortForwardingService(properties);
    }


}
