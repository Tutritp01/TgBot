package com.tutrit.stoservice.repository;

import com.tutrit.stoservice.bean.Promo;
import com.tutrit.stoservice.mock.PromoRepositoryUUIDMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PromoRepositoryTest {

    PromoRepository promoRepository;

    @BeforeEach
    public void setUp() {
        promoRepository = new PromoRepositoryUUIDMock();
        promoRepository.clean();

    }

    @Test
    void save() {
        Promo promo1 = new Promo("id1", 15, "kupon1",null, null, null, null, null);
        Promo promo2 = new Promo("id2", 20, "kupon2",null, null, null, null, null);
        Promo promo3 = new Promo("id3", 25, "kupon3",null, null, null, null, null);
        int expected = promoRepository.count() + 3;
        promoRepository.save(promo1);
        promoRepository.save(promo2);
        promoRepository.save(promo3);

        assertEquals(expected, promoRepository.count());
    }

    @Test
    void saveAll() {
        Promo promo4 = new Promo("id4", 30, "kupon4",null, null, null, null, null);
        Promo promo5 = new Promo("id5", 35, "kupon5",null, null, null, null, null);
        Promo promo6 = new Promo("id6", 40, "kupon6",null, null, null, null, null);
        int expected = promoRepository.count() + 3;
        Set<Promo> set = Set.of(promo4, promo5, promo6);
        promoRepository.saveAll(set);

        assertEquals(expected, promoRepository.count());
    }

    @Test
    void find() {
        Promo promo7 = new Promo("id7", 45, "kupon7",null, null, null, null, null);
        Promo promo8 = new Promo("id8", 50, "kupon8",null, null, null, null, null);
        promoRepository.save(promo7);
        promoRepository.save(promo8);

        assertEquals(promo7, promoRepository.find(promo7));
    }

    @Test
    void findAll() {
        Promo promo9 = new Promo("id9", 55, "kupon9",null, null, null, null, null);
        Promo promo10 = new Promo("id10", 60, "kupon10",null, null, null, null, null);
        promoRepository.save(promo9);
        promoRepository.save(promo10);
        int count = 0;
        for (Promo promo : promoRepository.findAll()) {
            count++;
        }

        assertEquals(promoRepository.count(), count);
    }

    @Test
    void findById() {
        Promo promo11 = new Promo("spyValues1", 65, "kupon11",null, null, null, null, null);
        Promo promo12 = new Promo("spyValues2", 70, "kupon12",null, null, null, null, null);
        promoRepository.save(promo11);
        promoRepository.save(promo12);

        assertEquals(promo12, promoRepository.findById(promo12.getId()));
    }

    @Test
    void update() {
        Promo promo13 = new Promo("spyValues1", 75, "kupon13",null, null, null, null, null);
        Promo promo14 = new Promo("spyValues1", 80, "kupon14",null, null, null, null, null);
        promoRepository.save(promo13);
        promoRepository.update(promo14);

        assertEquals(promo14, promoRepository.findById(promo14.getId()));
    }

    @Test
    void delete() {
        int expected;
        expected = promoRepository.count();
        Promo promo15 = new Promo("spyValues2", 85, "kupon15",null, null, null, null, null);
        Promo promo16 = new Promo("spyValues3", 90,"kupon16", null, null, null, null, null);
        promoRepository.save(promo15);
        promoRepository.save(promo16);
        promoRepository.delete(promo15);
        promoRepository.delete(promo16);

        assertEquals(expected, promoRepository.count());
    }

    @Test
    void deleteById() {
        Promo promo17 = new Promo("spyValues1", 95, "kupon17",null, null, null, null, null);
        Promo promo18 = new Promo("spyValues2", 15, "kupon18",null, null, null, null, null);
        int expected = promoRepository.count();
        promoRepository.save(promo17);
        promoRepository.save(promo18);
        promoRepository.deleteById("spyValues1");
        promoRepository.deleteById("spyValues2");

        assertEquals(expected, promoRepository.count());
    }

    @Test
    void count() {
        int count = 0;
        for (Promo promo : promoRepository.findAll()) {
            count++;
        }

        assertEquals(promoRepository.count(), count);
    }

    @Test
    void isContains() {
        Promo promo19 = new Promo("id19", 20, "kupon19",null, null, null, null, null);
        Promo promo20 = new Promo("id20", 25, "kupon20",null, null, null, null, null);
        promoRepository.save(promo19);

        assertTrue(promoRepository.isContains(promo19.getId()));
        assertFalse(promoRepository.isContains(promo20.getId()));
    }
}
