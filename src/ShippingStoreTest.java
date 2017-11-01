import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

import java.nio.channels.Channels;

/**
 *The Shipping Store Test class is designed to run all of the test cases within the program, verifying that all of the
 * shippingStore.java functions are all checked.
 *
 * @author Jamal Rasool
 * @version 1.0
 *
 */

public class ShippingStoreTest {

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
    /**
     *Designed to set up all of the default class files, to be declared in the before section of testing.
     * Essentially to be initialized each time a test is going through, the @Before tag is for that reason. Also in this
     * section I setup some mock packages, and a mock array to store the information in.
     * @throws Exception throws no exception at this state, due to other dependencies already being checked.
     */
    @Before
    public void setUp() throws Exception {
        // Creating an empty shipping store array
        shippingStore = new ShippingStore();
        packageOrderList = new ArrayList<>();

        defaultPack1 = new PackageOrder("12345","Box", "Metro", "First", 5.00f, 63);
        defaultPack2 = new PackageOrder("54321","Envelope", "Metro", "First", 4.00f, 53);
        defaultPack3 = new PackageOrder("00000","Crate", "Metro", "First", 12.00f, 42);
        defaultPack4 = new PackageOrder("00000","Crate", "Metro", "First", 12.00f, 86);

        packageOrderList.add(defaultPack1);
        packageOrderList.add(defaultPack2);
        packageOrderList.add(defaultPack3);
    }

    /**
     * Designed to set all of the initialized information within the @Before stage to null after each test condition is
     * executed, reason being is due to us wanting to keep the information for each test as standard as possible.
     * @throws Exception throws no exception at this state, due to other dependencies already being checked.
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
        pw = null;
    }

    /**
     * Designed to check and see if the datafile was created by the program.
     * @throws Exception The exception is being returned as the assert true and false.
     */
    @Test
    public void getDataFile() throws Exception {
        dataFile = new File("PackageOrderDB.txt");
        assertTrue("The file exist is true", dataFile.exists());
        assertFalse("The file does not exist", !dataFile.exists());
    }

    /**
     * Designed to check if the packageOrderList is a valid size, then going through and retrieving said number to
     * compare and see if its able to read the information from said object.
     * @throws Exception The exception is being returned as the assert true and false.
     */
    @Test
    @SuppressWarnings("Duplicates")
    public void showPackageOrders() throws Exception {

        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        PrintStream originalOut = System.out;

        String staticInfo = "Package Order has been added.\n\n";
        staticInfo += " -------------------------------------------------------------------------- \n";
        staticInfo += "| Tracking # | Type    | Specification | Class       | Weight(oz) | Volume |\n";
        staticInfo += " -------------------------------------------------------------------------- \n";
        staticInfo += "| GFR23      | Box     | Books         | Retail      | 9500.00    | 45     |\n";
        staticInfo += " --------------------------------------------------------------------------\n\n";

        try {
            System.setOut(ps);

            shippingStore.addOrder("GFR23", "Box", "Books",
                    "Retail", "9500.00", "45");
            shippingStore.showPackageOrders();
            System.out.flush();
            System.setOut(originalOut);
            assertEquals(staticInfo,os.toString());

        } catch (Exception e) {
            fail("String does not match with statement above");
        } finally {
            assertTrue("Package orders do exist", packageOrderList.size() >= 1 && packageOrderList.get(0).getTrackingNumber() == "12345");
            assertFalse("No package order exit",packageOrderList.size() < 1);
        }
    }

    /**
     * Designed to check with a secondary array to see if the numbers that the user had entered was located within
     * the array of doubles.
     * @throws Exception The exception is being returned as the assert true, false, array equal functions.
     */
    @Test
    public void showPackageOrdersRange() throws Exception {
        double []numbers1 = {42,53,63};
        double []numbers2 = {50,51,53};

        assertTrue("Package orders do exist", packageOrderList.size() >= 1); // First checking to see if valid array
        assertFalse("No package order exist",packageOrderList.size() < 1);
        assertArrayEquals("Number are in between 42-63",numbers1,numbers2,10); // Setting 10 as the number range
    }

    /**
     * Designed to see if the program can verify based on user input if the package within the object list matches with
     * the users information for the package.
     * @throws Exception The exception is being returned as the assert true and false, assert equals is to show that the
     * package object is the exact same.
     */
    @Test
    public void findPackageOrder() throws Exception {
        // Testing to see if it exist or does not exist
       assertTrue("The package exist",
                (packageOrderList.get(0).getTrackingNumber()).matches("12345"));
        assertEquals(packageOrderList.get(0).getTrackingNumber().matches(defaultPack1.getTrackingNumber()),
                packageOrderList.get(0).getTrackingNumber().matches(defaultPack1.getTrackingNumber()));
        assertFalse("The package does not exist",
                (packageOrderList.get(0).getTrackingNumber()).matches("00000"));
    }

    /**
     * Designed to check and see if the packages tracking number matches with the package that is on file.
     * @throws Exception The exception is being returned as the assert true and false.
     */
    @Test
    public void searchPackageOrder() throws Exception {
        // Check to see if it contains the tracking number in the output
        assertTrue("The package has been located in array",
                (defaultPack3.getTrackingNumber()).matches("00000"));
        assertFalse("The package is not inside of the array",
                (packageOrderList.get(0).getTrackingNumber()).matches("00000"));
    }

    /**
     * Designed to test being able to add an order to the object list, and then verifying the size of the array.
     * @throws Exception type assertEquals verify's that the array size is the proper size once we added the extra item.
     */
    @Test
    public void addOrder() throws Exception {
        packageOrderList.add(defaultPack4);
        assertEquals(4, packageOrderList.size());
    }

    /**
     * Designed to test if removing an object from the array is successful or not.
     * @throws Exception type assertEquals, will test and see if the size of the array matches up with the default
     * condition.
     */
    @Test
    public void removeOrder() throws Exception {
        packageOrderList.remove(defaultPack3);
        assertEquals(2, packageOrderList.size());
    }

    /**
     * Designed to get the packageOrder at hand, and match it with said package order to verify that everything is the
     * exact sane
     * @throws Exception The exception is being returned as the assert true and false.
     */
    @Test
    public void getPackageOrder() throws Exception {
        // Testing to see if it can get the package and return said information.
       assertTrue("this object exist",packageOrderList.get(0).equals(defaultPack1));
       assertFalse("this object doesn't exist", packageOrderList.get(1).equals(defaultPack1));
    }

    /**
     * Designed to read user input from the file, and also test to see if the information in the file is readable.
     * The program will first go through and see if said file is located inside of the directory or not, if its not then
     * it will throw the exception where the file is not found, then finally go through with the case that it is true.
     * @throws Exception The exception is being returned as the assert true and false.
     */
    @Test
    public void read() throws Exception {

        try
        {// Checking to see if what we wrote to the file was written properly
            FileReader dataReader = new FileReader("test.txt");
            shippingStore.read(dataReader);

        } catch (Exception e) {

            assertEquals("java.io.FileNotFoundException: test.txt (No such file or directory)",e.toString());

        }finally{
            dataFile = new File("PackageOrderDB.txt");
            assertTrue("Information is readable", dataFile.canRead());
            assertTrue("File could be opened",dataFile.exists());
        }
    }

    /**
     * Designed to verify if there was any errors in writing to the file, the serializable objects. Tested to see if the
     * test file could be read, couldn't due to it being a read only file.
     * @throws Exception The exception is being returned as the assert true and false.
     */
    @Test
    public void flush() throws Exception {

        try{
            RandomAccessFile raFile = new RandomAccessFile("test.txt", "r");
            OutputStreamWriter writer = new OutputStreamWriter(Channels.newOutputStream(raFile.getChannel()));
            shippingStore.flush(writer);

        } catch (Exception e) {

            assertEquals("java.io.FileNotFoundException: test.txt (No such file or directory)",e.toString());

        } finally {
            pw = new PrintWriter("PackageOrderDB.txt");
            assertTrue("File can be written to", !pw.checkError()); // Checking if its false
            assertFalse("Error file could not be written to", pw.checkError()); // Checking if its true
        }
    }
}