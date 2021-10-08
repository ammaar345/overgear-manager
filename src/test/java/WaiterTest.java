import overgeared.Manager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WaiterTest {
    @Test
    public void bread() {
        Manager manager = new Manager();
        manager.sendReport("ammaar", "monday", "friday");
        System.out.println(manager.daysToBeReplaced());
        System.out.println(manager.daysOff());
        System.out.println(manager.waitersRequestedOffDays());
//        System.out.println(manager.waitersWorkingDays());
//        System.out.println(manager.updateWaiterShift("Joe",day));
    }
}
