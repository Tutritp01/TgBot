package com.tutrit.stoservice.service;

import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.repository.PromoRepository;

public class PromoService {

    private PromoRepository promoRepository;


    public PromoService(final PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    public Promo savePromo(Promo promo) {
        return promoRepository.save(promo);
    }

    public Promo findPromo(String name){
        Iterable<Promo> result = promoRepository.findAll();
        for (Promo promo : result) {
            if(promo.getNamePromo().equals(name)){
                return promo;
            }
        }
        return null;
    }

    public void setPromoRepository(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }
}
