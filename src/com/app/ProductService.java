package com.app;

import org.myspringframework.beans.factory.annotation.Autowired;
import org.myspringframework.beans.factory.annotation.stereotype.Component;

@Component
public class ProductService {

    @Autowired
    private PromotionService promotionService;

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
}
