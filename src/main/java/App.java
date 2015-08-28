import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/index.vtl");
      
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/client-form", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/client-form.vtl");
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());
      
      String name = request.queryParams("clientName");
      int phone = Integer.parseInt(request.queryParams("clientPhone"));
      int stylist_id = Integer.parseInt(request.queryParams("stylistId"));
      Client newClient = new Client(name, phone, stylist_id);
      newClient.save();
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/new-stylist", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/new-stylist.vtl");
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());
      
      String name = request.queryParams("stylistName");
      Stylist newStylist = new Stylist(name);
      newStylist.save();

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    get("/client/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-client.vtl");
      model.put("client", Client.find(Integer.parseInt(request.params(":id"))));
      model.put("clients", Client.all());
      model.put("stylists", Stylist.all());

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/client/:id/edit-client-success", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/edit-client-success.vtl");
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      String name = request.queryParams("clientName");
      int phone = Integer.parseInt(request.queryParams("clientPhone"));
      int stylist_id = Integer.parseInt(request.queryParams("stylistId"));
      client.update(name, phone, stylist_id);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    post("/client/:id/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      Client client = Client.find(Integer.parseInt(request.params(":id")));
      client.delete();
      model.put("clients", Client.all());
      model.put("template", "templates/edit-client-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
