package org.myspringframework.beans.factory.annotation;

import org.myspringframework.beans.factory.BeanFactory;

public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory);

}