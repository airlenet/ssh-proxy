package com.airlenet.portforwarding.autoconfigure;

import com.airlenet.portforwarding.PortForwardingService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(PortForwardingProperties.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PortForwardingAutoConfigure {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    PortForwardingService portforwardingService(PortForwardingProperties properties) {
        return new PortForwardingService(properties);
    }


}
