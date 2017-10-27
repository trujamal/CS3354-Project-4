import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *
 */

public class ShippingStoreTest {
    /**
     *
     * @throws Exception
     */
    // Defining the shipping store class.
    ShippingStore shippingStore;
    File dataFile;
    ArrayList<PackageOrder> packageOrderList;
    PrintWriter pw;


    // Initalizing base packages to be made.
    PackageOrder defaultPack1;
    PackageOrder defaultPack2;
    PackageOrder defaultPack3;
    PackageOrder defaultPack4;

    @Before
    @SuppressWarnings("Duplicates")
    public void setUp() throws Exception {
        // Creating an empty shipping store array
        dataFile = new File("PackageOrderDB.txt");
        shippingStore = new ShippingStore();
        packageOrderList = new ArrayList<>();
         pw = new PrintWriter("PackageOrderDB.txt");

        defaultPack1 = new PackageOrder("12345","Box", "Metro", "First", 5.00f, 53);
        defaultPack2 = new PackageOrder("54321","Envelope", "Metro", "First", 4.00f, 53);
        defaultPack3 = new PackageOrder("00000","Crate", "Metro", "First", 12.00f, 53);
        defaultPack4 = new PackageOrder("00000","Crate", "Metro", "First", 12.00f, 53);

        packageOrderList.add(defaultPack1);
        packageOrderList.add(defaultPack2);
        packageOrderList.add(defaultPack3);

        for (PackageOrder c : packageOrderList) {
            pw.write(c.toString());
        }

    }

    /**
     *
     * @throws Exception
     */
    @After
    @SuppressWarnings("Duplicates")
    public void tearDown() throws Exception {

        packageOrderList = null;
        shippingStore = null;
        defaultPack1 = null;
        defaultPack2 = null;
        defaultPack3 = null;
        defaultPack4 = null;
        dataFile = null;

        // System.out.println("Test Complete.");
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getDataFile() throws Exception {
        assertTrue("The file exist is true", dataFile.exists());
        assertFalse("The file does not exist", !dataFile.exists());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    @SuppressWarnings("Duplicates")
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
        // Testing to see if it exist or does not exist
       assertTrue("The package exist",
                (packageOrderList.get(0).getTrackingNumber()).matches("12345"));
        assertFalse("The package does not exist",
                (packageOrderList.get(0).getTrackingNumber()).matches("00000"));
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void searchPackageOrder() throws Exception {
        // Check to see if it contains the tracking number in the output
        assertTrue("The package has been located in array",
                (packageOrderList.get(0).getTrackingNumber()).matches("12345"));

        assertFalse("The package is not inside of the array",
                (packageOrderList.get(0).getTrackingNumber()).matches("00000"));
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void addOrder() throws Exception {
        packageOrderList.add(defaultPack4);
        assertEquals(4, packageOrderList.size());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void removeOrder() throws Exception {
        packageOrderList.remove(defaultPack3);
        assertEquals(2, packageOrderList.size());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void getPackageOrder() throws Exception {
        // Testing to see if it can get the package and return said information.
       assertTrue("this object exist",packageOrderList.get(0).equals(defaultPack1));
       assertFalse("this object doesn't exist", packageOrderList.get(1).equals(defaultPack1));
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void read() throws Exception {
        // Checking to see if what we wrote to the file was written properly


    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void flush() throws Exception {
        //String reader/string writer
        assertTrue("f", pw.equals(defaultPack1));

    }

}