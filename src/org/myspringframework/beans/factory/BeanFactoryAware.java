package org.myspringframework.beans.factory;

import org.myspringframework.beans.factory.BeanFactory;

public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory);

}