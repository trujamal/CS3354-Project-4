import org.junit.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Designed to go through and test all of the individual test files within the system.
 */

public class Main {

    @Test
    public void main() throws Exception {

        Result result;

        // Beging testing Package order
        result = JUnitCore.runClasses(PackageOrderTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Beging testing Shippingstore class
        result = JUnitCore.runClasses(ShippingStoreTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }

}