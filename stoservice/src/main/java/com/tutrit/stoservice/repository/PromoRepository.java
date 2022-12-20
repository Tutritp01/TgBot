package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Promo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class PromoRepository implements Repository<Promo, String>, MyIdGenerator<Promo> {

    public static final java.util.logging.Logger logger = Logger.getLogger(PromoRepository.class.getName());

    private static Set<Promo> promoSet = new HashSet<>();


    @Override
    public Promo save(Promo promo) {
        if (!promoSet.contains(promo)) {
            setUUID(promo);
            setDateStamp(promo);
            promoSet.add(promo);
        } else {
            logger.info("Promo already exists");
        }
        return promo;
    }

    @Override
    public void saveAll(Iterable<Promo> promoSet) {
        promoSet.forEach(this::save);
    }

    @Override
    public Promo find(Promo promo) {
        return findById(promo.getId());
    }

    @Override
    public Iterable<Promo> findAll() {
        return promoSet;
    }

    @Override
    public Promo findById(String id) {
        Promo promo = new Promo();
        try {
            if (!isContains(id)) {
                throw new PromoRepository.PromoNotFoundException("Promo not found!");
            }
            for (Promo value : promoSet) {
                if (id.equals(value.getId())) {
                    promo = value;
                }
            }
        } catch (PromoNotFoundException e) {
            logger.severe("Promo not found!");
        }
        return promo;
    }

    @Override
    public Promo update(Promo promo) {
        delete(findById(promo.getId()));
        return save(promo);
    }

    @Override
    public boolean delete(Promo promo) {
        if (promoSet.contains(promo)) {
            promoSet.remove(promo);
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return promoSet.remove(findById(id));
    }

    @Override
    public int count() {
        return promoSet.size();
    }

    public boolean isContains(String id) {
        Promo promo = null;
        for (Promo value : promoSet) {
            if (id.equals(value.getId())) {
                promo = value;
            }
        }
        return promo != null;
    }

    private static class PromoNotFoundException extends Exception {
        public PromoNotFoundException(String s) {
        }
    }

    @Override
    public void setUUID(Promo promo) {
        promo.setId(UUID.randomUUID().toString());
    }

    public static void setDateStamp(Promo promo) {
        promo.setTimeStamp(LocalDateTime.now());
    }

    public void clean() {
        promoSet.clear();
    }

}

