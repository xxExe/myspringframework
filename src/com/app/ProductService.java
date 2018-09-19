package com.app;

import org.myspringframework.beans.factory.stereotype.Component;

@Component
public class ProductService {

    private PromotionService promotionService;

    public PromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
}
