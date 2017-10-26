import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Package order test is designed to go through and test said class
 */
public class PackageOrderTest {

    // Defining the shipping store class.
    ShippingStore shippingStore;

    // Initalizing base packages to be made.
    PackageOrder defaultPack1;
    PackageOrder defaultPack2;
    PackageOrder defaultPack3;
    PackageOrder defaultPack4;


    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        // Creating an empty shipping store array
        shippingStore = new ShippingStore();

        defaultPack1 = new PackageOrder("12345","Box", "Metro", "First", 5.00f, 53);
        defaultPack2 = new PackageOrder("54321","Envelope", "Metro", "First", 4.00f, 53);
        defaultPack3 = new PackageOrder("00000","Crate", "Metro", "First", 12.00f, 53);
        defaultPack4 = new PackageOrder("00000","Crate", "Metro", "First", 12.00f, 53);

    }

    /**
     *
     * @throws Exception
     */

    @After
    public void tearDown() throws Exception {

        shippingStore = null;
        defaultPack1 = null;
        defaultPack2 = null;
        defaultPack3 = null;

        System.out.println("Test Complete.");
    }

    /**\
     *
     * @throws Exception
     */

    @Test
    public void getTrackingNumber() throws Exception {
        assertEquals("12345", defaultPack1.getTrackingNumber());

    }

    /**
     *
     * @throws Exception
     */


    @Test
    public void getType() throws Exception {
        assertEquals("Box", defaultPack1.getType());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getSpecification() throws Exception {
        assertEquals("Metro", defaultPack1.getSpecification());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getMailingClass() throws Exception {
        assertEquals("First", defaultPack1.getMailingClass());

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getWeight() throws Exception {
        assertEquals(4.0f, defaultPack2.getWeight(), 0.0f);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        assertEquals("00000 Crate Metro First 12.00 53\n", defaultPack3.toString());
    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void getVolume() throws Exception {
        assertEquals(53, defaultPack3.getVolume(), 0.0);
    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void equals() throws Exception {
        // Testing to see if its false
        assertFalse("This is suppose to be false", defaultPack1.equals(defaultPack2));

        // Test to see if its true or not
        assertTrue("This is suppose to be true", defaultPack3.equals(defaultPack4));

    }

}