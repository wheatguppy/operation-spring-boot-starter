package com.guppies.operation;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 2、新建属性类，用于读取properties配置文件中配置的对应属性
 */
@ConfigurationProperties(prefix = "guppies.operation")
public class OperationProperties {

    /**
     * 业务名称，默认为none
     */
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
