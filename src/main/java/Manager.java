import java.sql.*;

public class Manager {

    public void createTables() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:sqlite:manager.db");
            Statement statement = connection.createStatement();

//            Faker faker = new Faker();
            // create a database connection

            statement.setQueryTimeout(30);  // set timeout to 30 sec.
//            statement.executeUpdate("drop table if exists waiters");
            statement.executeUpdate("create table if not exists waiters(id integer not null primary key,name string)");
            statement.executeUpdate("create table if not exists weekdays(id integer not null primary key , name string)");
            statement.executeUpdate("create table if not exists shifts ( id serial not null primary key,waiternameid int not null,weekdayid int not null, FOREIGN key (waiternameid) REFERENCES waiters(id),FOREIGN key (weekdayid) REFERENCES weekdays(id))    ");


            String sqlInsertDay1 = "insert into weekdays (id,name)VALUES(?,?)";
            PreparedStatement st1 = connection.prepareStatement(sqlInsertDay1);
            st1.setString(2, "Monday");
            st1.executeUpdate();
            st1.setString(2, "Tuesday");
            st1.executeUpdate();
            st1.setString(2, "Wednesday");
            st1.executeUpdate();
            st1.setString(2, "Thursday");
            st1.executeUpdate();
            st1.setString(2, "Friday");
            st1.executeUpdate();
            st1.setString(2, "Saturday");
            st1.executeUpdate();
            st1.setString(2, "Sunday");
            st1.executeUpdate();
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public void addWaiter() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:sqlite:overgeared.db");
            Statement statement = connection.createStatement();

            String sqlInsertWaiter = "insert into waiter(id,name) VALUES (?,?)";
            PreparedStatement insertWaiter = connection.prepareStatement(sqlInsertWaiter);
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    public void updateWaiter() {

    }

}
