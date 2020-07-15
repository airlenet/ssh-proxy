package com.airlenet.portforwarding;

import com.airlenet.portforwarding.autoconfigure.PortForwardingProperties;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class PortForwardingService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(PortForwardingService.class);
    private PortForwardingProperties properties;

    public PortForwardingService(PortForwardingProperties properties) {
        this.properties = properties;
    }

    public void portforwarding() throws Exception {
        if (!properties.isEnable()) {
            logger.info("PortForwarding {}", properties.isEnable());//是否启用端口转发
            return;
        }
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(properties.getUser(), properties.getHost(), properties.getPort());
            session.setPassword(properties.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            // step1：建立ssh连接
            session.connect();
            logger.info("PortForwarding SSH Server Version={}", session.getServerVersion());//这里打印SSH服务器版本信息
            //step2：
            if ("local".equals(properties.getMode())) {
                //设置SSH本地端口转发，本地转发到远程
                int assinged_port = session.setPortForwardingL(properties.getLocalPort(), properties.getRemoteHost(), properties.getRemotePort());
                logger.info("PortForwarding  localhost:{} -->({}:{})--> {}:{}", assinged_port,properties.getHost(), properties.getPort(), properties.getRemoteHost(), properties.getRemotePort());
            } else if ("remote".equals(properties.getMode())) {
                //设置SSH远程端口转发，远程转发到本地
                session.setPortForwardingR(properties.getRemotePort(), properties.getRemoteHost(), properties.getLocalPort());
                logger.info("PortForwarding  {}:{} -->({}:{})--> localhost:{} ", properties.getRemoteHost(), properties.getRemotePort(), properties.getHost(), properties.getPort(),properties.getLocalPort());
            } else {
                throw new Exception("not support " + properties.getMode());
            }
        } catch (Exception e) {
            logger.error("PortForwarding {}", e.getMessage());
            if (null != session) {
                //关闭ssh连接
                session.disconnect();
            }
            throw e;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        portforwarding();
    }
}
