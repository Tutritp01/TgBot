package com.tutrit.stoservice.mock;

import com.tutrit.stoservice.bean.Order;
import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.repository.OrderRepository;
import com.tutrit.stoservice.repository.PromoRepository;

public class PromoRepositoryUUIDMock extends PromoRepository {

    @Override
    public void setUUID(Promo promo) {
        promo.setId("spyValues" + count());

    }
}
