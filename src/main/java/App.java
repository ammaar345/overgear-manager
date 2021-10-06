import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
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
