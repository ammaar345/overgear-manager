import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.createTables();
        manager.addWaiter("joe");
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
