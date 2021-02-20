package com.airlenet.portforwarding.autoconfigure;

import com.airlenet.portforwarding.PortForwardingService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SshProxyProperties.class)
public class PortForwardingAutoConfigure {


    @Bean
    PortForwardingService portforwardingService(ConfigurableEnvironment environment) {
        SshProxyProperties sshProxyProperties = Binder.get(environment).bindOrCreate("airlenet.sshproxy", SshProxyProperties.class);
        return new PortForwardingService(sshProxyProperties);
    }
}
