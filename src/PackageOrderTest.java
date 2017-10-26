import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Package order test is designed to go through and test said class
 */
public class PackageOrderTest {

    // Initalizing base packages to be made.
    PackageOrder testPackage;
    PackageOrder testPackage2;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testPackage = new PackageOrder("12345","Box", "Ground", "First", 5.00f, 53);
        testPackage2 = new PackageOrder("12345", "Box", "Metro", "First", 4.0f, 50);
    }

    /**
     *
     * @throws Exception
     */

    @After
    public void tearDown() throws Exception {
        testPackage = null;
        testPackage2 = null;

        System.out.println("Test Complete.");
    }

    /**\
     *
     * @throws Exception
     */

    @Test
    public void testGetTrackingNumber() throws Exception {
        assertEquals("12345", testPackage.getTrackingNumber());
    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void testGetType() throws Exception {
        assertEquals("Box", testPackage.getType());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testGetSpecification() throws Exception {
        assertEquals("Ground", testPackage.getSpecification());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testGetMailingClass() throws Exception {
        assertEquals("First", testPackage.getMailingClass());
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testGetWeight() throws Exception {
        assertEquals(5.0f, testPackage.getWeight(), 0.0f);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testGetVolume() throws Exception {
        assertEquals(53, testPackage.getVolume());
    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void testToString() throws Exception {
        assertThat("12345 Box Ground First 5.00 53\n", is(testPackage.toString()));
    }

    /**
     *
     * @throws Exception
     */

    @Test
    public void testEquals() throws Exception {
        assertTrue("Tracking numbers are not equal", testPackage.equals(testPackage2));
    }

}