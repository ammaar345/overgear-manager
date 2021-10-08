package overgeared;
//
//import overgeared.Manager;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.*;
import java.sql.*;
//import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        Manager manager = new Manager();
//        List<String> weekdays = new ArrayList<>();
        manager.createTables();
//      manager.updateWaiterShift("tom",weekdays);
//        System.out.println(weekdays);
//        System.out.println(manager.waiterNames());
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

        get("/add_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("weekday", manager.daysOfWeek());
            map.put("days", manager.daysOfWeek());
            for (int i = 1; i < 8; i++) {
                map.put("waiters", manager.waitersWorkingOnTheDay(i));

            }
            return new ModelAndView(map, "update_employees.handlebars");
        }, new HandlebarsTemplateEngine());
        post("/add_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            String waiterNameInsert = req.queryParams("waiterName");
            map.put("weekday", manager.daysOfWeek());
            map.put("days", manager.daysOfWeek());
            for (int i = 1; i < 8; i++) {
                map.put("waiters", manager.waitersWorkingOnTheDay(i));

            }
            manager.addWaiter(waiterNameInsert);
            map.put("weekday", manager.daysOfWeek());

            return new ModelAndView(map, "update_employees.handlebars");

        }, new HandlebarsTemplateEngine());
        post("/clear_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            String waiterNameInsert = req.queryParams("waiterName");
            map.put("weekday", manager.daysOfWeek());
            map.put("days", manager.daysOfWeek());
            for (int i = 1; i < 8; i++) {
                map.put("waiters", manager.waitersWorkingOnTheDay(i));

            }
       manager.clearWaiterShifts();


            return new ModelAndView(map, "update_employees.handlebars");

        }, new HandlebarsTemplateEngine());
        get("/clear_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            String waiterNameInsert = req.queryParams("waiterName");
            map.put("weekday", manager.daysOfWeek());
            map.put("days", manager.daysOfWeek());
            for (int i = 1; i < 8; i++) {
                map.put("waiters", manager.waitersWorkingOnTheDay(i));

            }
            manager.clearWaiterShifts();

            return new ModelAndView(map, "update_employees.handlebars");

        }, new HandlebarsTemplateEngine());


        get("/absence_report", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "absence_report.handlebars");
        }, new HandlebarsTemplateEngine());
        post("/absence_report", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
//            manager.ad

            return new ModelAndView(map, "absence_report.handlebars");
        }, new HandlebarsTemplateEngine());
        get("/update_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("weekday", manager.daysOfWeek());
            map.put("days", manager.daysOfWeek());
            for (int i = 1; i < 8; i++) {
                map.put("waiters", manager.waitersWorkingOnTheDay(i));

            }
            return new ModelAndView(map, "update_employees.handlebars");
        }, new HandlebarsTemplateEngine());

        post("/update_employees", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("weekday", manager.daysOfWeek());
            String waiterName = req.queryParams("employeeName");
            List<String> daysSelected = Arrays.asList(req.queryParamsValues("chkDays"));
//
            map.put("weekday", manager.daysOfWeek());
            map.put("days", manager.daysOfWeek());
            for (int i = 1; i < 8; i++) {
                map.put("waiters", manager.waitersWorkingOnTheDay(i));

            }        manager.updateWaiterShift(waiterName, daysSelected);


            return new ModelAndView(map, "update_employees.handlebars");
        }, new HandlebarsTemplateEngine());
        get("/rosters", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            return new ModelAndView(map, "rosters.handlebars");
        }, new HandlebarsTemplateEngine());

    }
}
