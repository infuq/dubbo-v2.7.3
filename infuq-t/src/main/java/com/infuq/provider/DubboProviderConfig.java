package com.infuq.provider;


import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableDubbo(scanBasePackages = "com.infuq.provider")
public class DubboProviderConfig {


    /**
     * 应用名配置,等同于 <dubbo:application name="infuq-provider"  />
     *
     * @return ApplicationConfig
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("infuq-provider");
        return applicationConfig;
    }

    /**
     * 注册中心配置,等同于 <dubbo:registry protocol="zookeeper" address="zk.infuq.com:2181" check="false" />
     *
     * @return RegistryConfig
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("zk.infuq.com:2181");
        registryConfig.setAddress("192.168.0.107:2181");
        registryConfig.setProtocol("zookeeper");
//        registryConfig.setDynamic(true);
        registryConfig.setCheck(true);
        return registryConfig;
    }

    /**
     * 协议配置,等同于 <dubbo:protocol name="dubbo" port="20880" threads="200" threadpool="cached" />
     *
     * @return ProtocolConfig
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        protocolConfig.setThreads(200);
        protocolConfig.setThreadpool("cached");
        return protocolConfig;
    }



}
