//import jdk.internal.org.objectweb.asm.Handle;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    String dbDiskURL = "jdbc:h2:file:./overgeared.db";
    Jdbi jdbi = Jdbi.create(dbDiskURL, "sa", "");
    Handle handle = jdbi.open();

    public List waiterNames() {
        List<String> names = handle.createQuery("select name from waiters")
                .mapTo(String.class)
                .list();

        return names;
    }

    public void createTables() {
//        handle.execute("drop table weekdays");
////        handle.execute("drop table waiters");
//        handle.execute("drop table shifts");
handle.execute("drop table if exists waiters");

        handle.execute("drop table if exists weekdays");

        handle.execute("drop table if exists shifts");
        handle.execute("create table if not exists waiters(id integer identity,name varchar(50))");
        handle.execute("create table if not exists weekdays(id integer identity , name varchar(50))");
        handle.execute("create table if not exists shifts ( id integer identity, waiternameid int not null,weekdayid int not null, FOREIGN key (waiternameid) REFERENCES waiters(id),FOREIGN key (weekdayid) REFERENCES weekdays(id))    ");
        handle.execute("insert into weekdays (name)VALUES('Monday')");
        handle.execute("insert into weekdays (name)VALUES('Tuesday')");
        handle.execute("insert into weekdays (name)VALUES('Wednesday')");
        handle.execute("insert into weekdays (name)VALUES('Thursday')");
        handle.execute("insert into weekdays (name)VALUES('Friday')");
        handle.execute("insert into weekdays (name)VALUES('Saturday')");
        handle.execute("insert into weekdays (name)VALUES('Sunday')");

        List<String> days = handle.createQuery("select name from weekdays").mapTo(String.class).list();
        List<String>names=handle.createQuery("select name from waiters").mapTo(String.class).list();
        List<String>shifts=handle.createQuery("select * from shifts").mapTo(String.class) .list();
        System.out.println(days);
        System.out.println(names);
        System.out.println(shifts);
    }

    public void addWaiter(String name) {
        int checkIfUserExist = handle.select("select count(*) from waiters where name = ?", name)
                .mapTo(int.class)
                .findOnly();

        if (checkIfUserExist < 1) {
            handle.execute("insert into waiters(name) VALUES (?)", name);
        }

//        else if (checkIfUserExist > 0) {
//            updateWaiterShift(name);
//        }

// handle.execute("delete from shifts where waiternameid=?",)x  x
    }

    public void updateWaiterShift(String waiterName, List<String> weekday) {
        int userExists = handle.select("select count(*) from waiters where name = ?", waiterName)
                .mapTo(int.class)
                .findOnly();
        int waiterID = handle.select("select id from waiters where name is=?", waiterName).mapTo(int.class).findOnly();
        if (userExists < 1) {

//            loop over checked list
            for (String day : weekday) {
                // code block to be executed
                String id = handle.select("select id from weekdays where name=?", day).mapTo(String.class).findOnly();
//             System.out.println(day);
                int v = 0;
                int idVal = Integer.parseInt(id);
                handle.execute("insert into shifts (waiternameid,weekdayid)VALUES(?,?)", idVal, waiterID);

            }
//             } else if (userExists == 1) {
//            int id = handle.execute("select id from waiters where name =?", waiterName);
//            handle.execute("UPDATE shifts\n" +
//                    "SET weekdayid = ?, ...\n" +
//                    "WHERE waiternameid=?", id, id);

        }

//set foreign key weekday id to equal the id of the waiter entered where the waiter's id was first found
    }

}
