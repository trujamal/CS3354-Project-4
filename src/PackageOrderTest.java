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

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        // Creating an empty shipping store array
        shippingStore = new ShippingStore();

        defaultPack1 = new PackageOrder("12345","Box", "Metro", "First", 5.0f, 53);
        defaultPack2 = new PackageOrder("54321","Envelope", "Metro", "First", 5.0f, 53);
        defaultPack3 = new PackageOrder("00000","Crate", "Metro", "First", 5.0f, 53);

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
    }

    /**
     *
     * @throws Exception
     */


    @Test
    public void getType() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getSpecification() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getMailingClass() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getWeight() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {

    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void getVolume() throws Exception {
    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void equals() throws Exception {
    }

}