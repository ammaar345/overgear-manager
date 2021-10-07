package overgeared;

import overgeared.Manager;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
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
//      manager.updateWaiterShift("tom",weekdays);
//        System.out.println(weekdays);
        System.out.println(manager.waiterNames());
        port(2000);
        staticFiles.location("/public");
        get("/", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "landingPage.handlebars");
        }, new HandlebarsTemplateEngine());

        get("/manager_chamber", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "manager_chamber.handlebars");
        }, new HandlebarsTemplateEngine());

        get("/absence_report", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "absence_report.handlebars");
        }, new HandlebarsTemplateEngine());

        get("/update_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "update_employees.handlebars");
        }, new HandlebarsTemplateEngine());

        post("/update_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "update_employees.handlebars");
        }, new HandlebarsTemplateEngine());
        get("/rosters", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "rosters.handlebars");
        }, new HandlebarsTemplateEngine());

    }
}
