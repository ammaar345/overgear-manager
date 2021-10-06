//import jdk.internal.org.objectweb.asm.Handle;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    String dbDiskURL = "jdbc:h2:file:./manager.db";
    Jdbi jdbi = Jdbi.create(dbDiskURL, "sa", "");
    Handle handle = jdbi.open();

    public List waiterNames() {
        List<String> names = handle.createQuery("select name from waiters")
                .mapTo(String.class)
                .list();

        return names;
    }

    public void createTables() {


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


    }

    public void addWaiter(String name) {

        handle.execute("insert into waiters(name) VALUES (?)", name);
    }


}
