package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {

    private SalariedEmployee salariedEmployee;
    private SalariedEmployee salariedEmployee2;

    @Before
    public void setUp() {
        salariedEmployee = new SalariedEmployee("Justin", Date.valueOf("2023-06-15"),100_000.00);
    }

    @Test
    public void testPay() {
        assertEquals(100_000.00,salariedEmployee.pay(),0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(30_000.00, salariedEmployee.payTaxes(),0.001);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_differentHireDate() {
        salariedEmployee2.setSalary(10.0);
        assertNotEquals(salariedEmployee,salariedEmployee2);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(salariedEmployee,salariedEmployee2);
    }
}