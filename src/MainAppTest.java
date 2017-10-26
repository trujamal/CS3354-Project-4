import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MainAppTest {

    // Defining the shipping store class.
    ShippingStore shippingStore;

    // Initalizing base packages to be made.
    PackageOrder defaultPack1;
    PackageOrder defaultPack2;
    PackageOrder defaultPack3;

    /**
     *Setup class is designed to
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

        // Tracking print out.
        //System.out.println("Test Complete.");

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void main() throws Exception {

        Result result;

        // Begin testing the calculateFine() method of the  Resource.class.
        result = JUnitCore.runClasses(PackageOrder.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Begin testing the Collection.class.
        result = JUnitCore.runClasses(ShippingStore.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }

}