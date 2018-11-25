package com.app;

import org.myspringframework.beans.factory.DisposableBean;
import org.myspringframework.beans.factory.annotation.Autowired;
import org.myspringframework.beans.factory.annotation.PreDestroy;
import org.myspringframework.beans.factory.annotation.stereotype.Component;

@Component
public class ProductService implements DisposableBean {

    @Autowired
    private PromotionService promotionService;

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Override
    public void destroy() {
        System.out.println("invoke destroy() from " + this);
    }

    @PreDestroy
    public void onFactoryClose() {
        System.out.println("invoke onFactoryClose() from " + this);
    }
}
