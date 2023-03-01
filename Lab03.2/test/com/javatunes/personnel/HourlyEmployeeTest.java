package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {

    private HourlyEmployee hourlyEmployee;

    @Before
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("Justin", Date.valueOf("2023-06-15"),50.0,20.0);
    }

    @Test
    public void testPay() {
        assertEquals(1_000.00,hourlyEmployee.pay(),0.001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(250.00,hourlyEmployee.payTaxes(), 0.001);
    }

    @Test
    public void testEquals() {
        HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Justin", Date.valueOf("2023-06-15"),50.0,20.0);
        HourlyEmployee hourlyEmployee3 = new HourlyEmployee("Justin", Date.valueOf("2023-06-14"),25.0,20.0);
        assertEquals(hourlyEmployee, hourlyEmployee2);
        assertNotEquals(hourlyEmployee, hourlyEmployee3);
    }
}