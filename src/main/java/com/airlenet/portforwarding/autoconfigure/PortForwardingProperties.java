package com.airlenet.portforwarding.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "airlenet.port-forwarding")
@Data
public class PortForwardingProperties {
    /**
     * 是否启用端口转发
     */
    private boolean enable = true;
    /**
     * 端口转发模式，支持 local，remote 两种
     */
    private String mode = "local";//local ,remote
    /**
     * SSH服务器ip
     */
    private String host;
    /**
     * SSH访问端口
     */
    private int port;
    /**
     * SSH连接用户名
     */
    private String user;
    /**
     * SSH连接密码
     */
    private String password;

    /**
     * 本地端口
     */
    private int localPort;

    /**
     * 远程服务器
     */
    private String remoteHost;
    /**
     * 远程服务端口
     */
    private int remotePort;
}
