import overgeared.Manager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WaiterTest {
    @Test
    public void bread() {
        Manager manager = new Manager();
        manager.createTables();
        manager.addWaiter("Joe");
        manager.addWaiter("Tom");
        manager.addWaiter("Thabo");
        List<String> day = new ArrayList<>();
        day.add("Monday");
        day.add("Wednesday");
        List<String> days = new ArrayList<>();
        days.add("Friday");
        days.add("Tuesday");
        days.add("Sunday");
        manager.updateWaiterShift("tom",day);
        manager.updateWaiterShift("thabo",days );
        System.out.println(manager.countWaiters());
//        System.out.println(manager.waitersWorkingDays());
//        System.out.println(manager.updateWaiterShift("Joe",day));
    }
}
