package org.myspringframework.beans.factory;

/**
 * Интерфейс процессора, выполняющего действия до и после
 * исполнения afterPropertiesSet бинов
 * <p>
 * нужен для реализации какой-нибудь логики
 */
public interface BeanPostProcessor {

    /**
     * Выполняется до afterPropertiesSet
     *
     * @param bean     бин
     * @param beanName имя бина
     * @return обработанный бин
     */
    Object beforePropertiesSet(Object bean, String beanName);

    /**
     * Выполняется после afterPropertiesSet
     *
     * @param bean     бин
     * @param beanName имя бина
     * @return обработанный бин
     */
    Object afterPropertiesSet(Object bean, String beanName);

}