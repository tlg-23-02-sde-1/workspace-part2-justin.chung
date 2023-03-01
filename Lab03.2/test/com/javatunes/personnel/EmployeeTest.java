package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setup() {
        emp1 = new SalariedEmployee("Justin", Date.valueOf("2023-06-15"),100_000.00);
        emp2 = new SalariedEmployee("Justin", Date.valueOf("2023-06-15"),100_000.00);
    }

    @Test
    public void equals_hashCode_shouldReturnTrue_whenObjectsEqual() {
        assertEquals(emp1.hashCode(),emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2000-01-01"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Jill");
        assertNotEquals(emp1,emp2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2);
    }
}