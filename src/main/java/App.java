import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;
//import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();
        List<String> weekdays = new ArrayList<>();
manager.createTables();
        weekdays.add("Monday");
        weekdays.add("Tuesday");
      manager.updateWaiterShift("tom",weekdays);
//        System.out.println(weekdays);
        System.out.println(manager.waiterNames());
        port(2000);
        staticFiles.location("/public");
         get("/roster", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "roster.handlebars");
        }, new HandlebarsTemplateEngine());

        get("/login/roster", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "roster.handlebars");
        }, new HandlebarsTemplateEngine());


        get("/login", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "login.handlebars");
        }, new HandlebarsTemplateEngine());

//        get("/roster", (req, res) -> {
//            Map<String, Object> map = new HashMap<>();
////            res.redirect("/hello");
//            return new ModelAndView(map, "roster.handlebars");
//        }, new HandlebarsTemplateEngine());
//
//        get("/roster", (req, res) -> {
//            Map<String, Object> map = new HashMap<>();
////            res.redirect("/hello");
//            return new ModelAndView(map, "roster.handlebars");
//        }, new HandlebarsTemplateEngine());
    }
}
