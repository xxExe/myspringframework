package org.myspringframework.beans.factory;

/**
 * Интерфейс для бинов, у которых есть метод, вызываемый при закрытии фабрики
 */
public interface DisposableBean {

    /**
     * вызывается при закрытии фабрики
     */
    void destroy();
}
