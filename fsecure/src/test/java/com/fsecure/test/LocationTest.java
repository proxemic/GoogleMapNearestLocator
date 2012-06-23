/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsecure.test;

import com.fsecure.business.LocationManager;
import org.junit.*;

/**
 *
 * @author Dickson
 */
public class LocationTest {

    public LocationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getNearestPlaceNotNull() {
        LocationManager lm = new LocationManager();        
        Assert.assertNotNull(lm.getNearestLocation(1.22f, 3.22f));
    }
    
}
