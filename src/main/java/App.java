import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println(manager.createTables());
        List<String> weekdays = new ArrayList<>();

        weekdays.add("Monday");
        weekdays.add("Tuesday");
      manager.updateWaiterShift("tom",weekdays);
//        System.out.println(weekdays);
        System.out.println(manager.waiterNames());

        staticFiles.location("/public");
        get("/", (req, res) -> {
            Map<String, Object> map = new HashMap<>();


//            res.redirect("/roster");
//            res.redirect("/roster");
            return new ModelAndView(map, "roster.handlebars");
        }, new HandlebarsTemplateEngine());

    }
}
