package com.tutrit.persistence;

import com.tutrit.bean.Engineer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryEngineerPersistenceTest {
    MemoryEngineerPersistence engineerPersistence;

    @BeforeEach
    void beforeEach() {
        engineerPersistence = new MemoryEngineerPersistence(new UUIDWrapperMock());
        engineerPersistence.deleteAll();
    }


    @Test
    void save() {
        List<Engineer> engineersStart = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(0, engineersStart.size());
        var engineerExpected0 = new Engineer("0", "FirstName0", "LastName0", "Admin0");
        var engineerExpected1 = new Engineer("1", "FirstName1", "LastName1", "Admin1");
        var engineer0 = new Engineer("", "FirstName0", "LastName0", "Admin0");
        var engineer1 = new Engineer("", "FirstName1", "LastName1", "Admin1");
        assertEquals(engineerExpected0, engineerPersistence.save(engineer0));
        assertEquals(engineerExpected1, engineerPersistence.save(engineer1));
        List<Engineer> engineersEnd = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(2, engineersEnd.size());
    }

    @Test
    void findById() {
        List<Engineer> engineersStart = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(0, engineersStart.size());
        var engineerExpected0 = new Engineer("0", "FirstName0", "LastName0", "Admin0");
        var engineerExpected1 = new Engineer("1", "FirstName1", "LastName1", "Admin1");
        var engineer0 = new Engineer("", "FirstName0", "LastName0", "Admin0");
        var engineer1 = new Engineer("", "FirstName1", "LastName1", "Admin1");
        engineerPersistence.save(engineer0);
        engineerPersistence.save(engineer1);
        assertEquals(engineerExpected0, engineerPersistence.findById("0"));
        assertEquals(engineerExpected1, engineerPersistence.findById("1"));
    }

    @Test
    void findAll() {
        List<Engineer> engineersStart = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(0, engineersStart.size());
        var engineer0 = new Engineer("", "FirstName0", "LastName0", "Admin0");
        var engineer1 = new Engineer("", "FirstName1", "LastName1", "Admin1");
        engineerPersistence.save(engineer0);
        List<Engineer> engineersMedium = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(1, engineersMedium.size());
        engineerPersistence.save(engineer1);
        List<Engineer> engineersEnd = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(2, engineersEnd.size());
    }

    @Test
    void update() {
        var engineer0 = new Engineer("", "FirstName0", "LastName0", "Admin0");
        var engineer1 = new Engineer("", "FirstName1", "LastName1", "Admin1");
        var engineer2 = new Engineer("", "FirstName2", "LastName2", "Admin2");
        var engineer4 = new Engineer("", "FirstName4", "LastName4", "Admin4");
        var engineerExpected1 = new Engineer("1", "FirstName1", "LastName1", "Admin1");
        var engineerExpected4 = new Engineer("1", "FirstName4", "LastName4", "Admin4");
        engineerPersistence.save(engineer0);
        engineerPersistence.save(engineer1);
        engineerPersistence.save(engineer2);
        assertEquals(engineerExpected1, engineerPersistence.findById("1"));
        engineerPersistence.update("1", engineer4);
        assertEquals(engineerExpected4, engineerPersistence.findById("1"));
    }

    @Test
    void delete() {
        List<Engineer> engineersStart = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(0, engineersStart.size());
        var engineer0 = new Engineer("", "FirstName0", "LastName0", "Admin0");
        var engineer1 = new Engineer("", "FirstName1", "LastName1", "Admin1");
        var engineer2 = new Engineer("", "FirstName2", "LastName2", "Admin2");
        engineerPersistence.save(engineer0);
        engineerPersistence.save(engineer1);
        engineerPersistence.save(engineer2);
        List<Engineer> engineersMedium1 = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(3, engineersMedium1.size());
        assertFalse(engineerPersistence.delete("4"));
        List<Engineer> engineersMedium2 = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(3, engineersMedium2.size());
        assertNotNull(engineerPersistence.findById("1"));
        assertTrue(engineerPersistence.delete("1"));
        List<Engineer> engineersEnd = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(2, engineersEnd.size());
        assertNull(engineerPersistence.findById("1"));
    }

    @Test
    void deleteAll() {
        List<Engineer> engineersStart = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(0, engineersStart.size());
        var engineer0 = new Engineer("", "FirstName0", "LastName0", "Admin0");
        var engineer1 = new Engineer("", "FirstName1", "LastName1", "Admin1");
        var engineer2 = new Engineer("", "FirstName2", "LastName2", "Admin2");
        engineerPersistence.save(engineer0);
        engineerPersistence.save(engineer1);
        engineerPersistence.save(engineer2);
        List<Engineer> engineersMedium = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(3, engineersMedium.size());
        engineerPersistence.deleteAll();
        List<Engineer> engineersEnd = (List<Engineer>) engineerPersistence.findAll();
        assertEquals(0, engineersEnd.size());
    }
}
