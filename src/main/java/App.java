import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFiles.location("/public");
//        get("/", (req, res) -> {
//            Map<String, Object> map = new HashMap<>();
//            res.redirect("/hello");
////            return new ModelAndView(map, ".handlebars");
//        }, new HandlebarsTemplateEngine());

    }
}
