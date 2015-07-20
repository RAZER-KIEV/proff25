package hw7.notes.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendorTest {
    private Vendor vendor;

    @Before
    public void setUp() {
        vendor = new Vendor();
    }

    @Test
    public void testEqualsLegalAllFieldsNotNullAndSame() {
        vendor.setName("Sony");
        Vendor newVendor = new Vendor();
        newVendor.setName("Sony");
        boolean actual = vendor.equals(newVendor);
        boolean expected = true;
        assertEquals(expected,actual);
    }

    @Test
    public void testEqualsLegalAllFieldsNotNullAndNotSame() {
        vendor.setName("Sony");
        Vendor newVendor = new Vendor();
        newVendor.setName("HTC");
        boolean actual = vendor.equals(newVendor);
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void testEqualsLegalNullAntNotNull() {
        // vendor name should be null
        Vendor newVendor = new Vendor();
        newVendor.setName("HTC");
        boolean actual = vendor.equals(newVendor);
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void testEqualsLegalNotNullAntNull() {
        vendor.setName("Sony");
        Vendor newVendor = new Vendor();
        // newVendor name should be null
        boolean actual = vendor.equals(newVendor);
        boolean expected = false;
        assertEquals(expected,actual);
    }

    @Test
    public void testEqualsLegalNullAntNull() {
        // vendor name should be null
        Vendor newVendor = new Vendor();
        // newVendor name should be null
        boolean actual = vendor.equals(newVendor);
        boolean expected = true;
        assertEquals(expected,actual);
    }
}
