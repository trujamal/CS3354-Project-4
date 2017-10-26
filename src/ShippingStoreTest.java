import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class ShippingStoreTest {

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

        // Tracking print out.
        //System.out.println("Test Complete.");

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getDataFile() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void showPackageOrders() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void showPackageOrdersRange() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void findPackageOrder() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void searchPackageOrder() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void addOrder() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void removeOrder() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getPackageOrder() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void read() throws Exception {
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void flush() throws Exception {
    }

}