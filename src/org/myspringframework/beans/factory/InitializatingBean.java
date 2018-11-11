package org.myspringframework.beans.factory;

public interface InitializatingBean {

    /**
     * Выполняется после выставления бину свойств
     */
    void afterPropertiesSet();

}
