import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainAppTest {

    // Defining the shipping store class.
    ShippingStore shippingStore;

    // Initalizing base packages to be made.
    Package defaultPack1;
    Package defaultPack2;
    Package defaultPack3;

    /**
     *Setup class is designed to
     * @throws Exception
     */

    @Before
    public void setUp() throws Exception {

        // Creating an empty shipping store array
        shippingStore = new ShippingStore();
        

    }

    /**
     *
     * @throws Exception
     */

    @After
    public void tearDown() throws Exception {
        ShippingStore shippingStore = null;
        Package defaultPack1 = null;
        Package defaultPack2 = null;
        Package defaultPack3 = null;

        // Tracking print out.
        //System.out.println("Test Complete.");

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void main() throws Exception {
    }

}