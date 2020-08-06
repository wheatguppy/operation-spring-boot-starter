package com.guppies.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 4、新建自动配置类
 */
// 表明此类是一个配置类，将变为一个bean被spring进行管理
@Configuration
// 启用属性配置，将读取OperationProperties里面的属性
@EnableConfigurationProperties(OperationProperties.class)
// 当类路径下面有OperationService此类时才自动配置
@ConditionalOnClass(OperationService.class)
// ConditionalOnProperty:判断指定的属性是否具备指定的值
// prefix:配置属性名称的前缀
// name:数组，配置属性完整名称或部分名称；可与prefix组合使用，组成完整的配置属性名称，与value不可同时使用
// value:数组，获取对应property名称的值，与name不可同时使用
// havingValue:可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置
// matchIfMissing:缺少该配置属性时是否可以加载；如果为true，没有该配置属性时也会正常加载；反之则不会生效，默认false
@ConditionalOnProperty(prefix = "guppies.operation", name = "enabled", havingValue = "true")
public class OperationAutoConfiguration {

    @Autowired
    private OperationProperties properties;

    @Bean
    // 当容器中没有指定bean是，创建此bean
    @ConditionalOnMissingBean(OperationService.class)
    public OperationService operationService() {
        return new OperationService(properties.getName());
    }

}
