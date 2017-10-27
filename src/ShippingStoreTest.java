import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.io.File;

import static org.junit.Assert.*;

/**
 *
 */
public class ShippingStoreTest {

    // Defining the shipping store class.
    ShippingStore shippingStore;

    private ArrayList<PackageOrder> packageOrderList;

    // Initalizing base packages to be made.
    PackageOrder testPackage1;
    PackageOrder testPackage2;
    PackageOrder testPackage3;

    private File dataFile;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dataFile = new File("PackageOrderDB.txt");
        packageOrderList = new ArrayList<>();
        testPackage1 = new PackageOrder("12345","Box", "Metro", "First", 5.0f, 53);
        testPackage2 = new PackageOrder("54321","Envelope", "Metro", "First", 5.0f, 53);
        testPackage3 = new PackageOrder("00000","Crate", "Metro", "First", 5.0f, 53);
    }

    /**
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        shippingStore = null;
        testPackage1= null;
        testPackage2 = null;
        testPackage3 = null;

        // Tracking print out.
        //System.out.println("Test Complete.");

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getDataFile() throws Exception {
        assertTrue("The data file does not exist", dataFile.exists());
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
        packageOrderList.add(testPackage3);
        //assertEquals("The package was not found.", 0, shippingStore.findPackageOrder("00000"));
        String test = packageOrderList.get(0).getTrackingNumber();
        System.out.println(test);
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
        packageOrderList.add(testPackage1);
        assertEquals(1, packageOrderList.size());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void removeOrder() throws Exception {
        packageOrderList.remove(testPackage1);
        assertEquals(0, packageOrderList.size());
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