package com.guppies.operation;

/**
 * 3、新建业务处理类，用于在OperationAutoConfiguration中生成对象
 */
public class OperationService {

    /**
     * 业务名称
     */
    private String name;

    public OperationService(String name) {
        this.name = name;
    }

    /**
     * 获取业务名称
     * @return
     */
    public String showName() {
        return "业务名称：" + this.name;
    }

}
