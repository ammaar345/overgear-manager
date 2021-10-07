package overgeared;

public class Waiter extends Manager {
    public void requestAbsentDay(String dayAbsent, String dayReplaced, String Name) {
        handle.execute("insert into absentRequests(name,day_absent,day_replaced,)VALUES(?,?,?)");

    }
}
