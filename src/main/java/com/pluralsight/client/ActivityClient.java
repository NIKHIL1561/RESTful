package com.pluralsight.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityClient
{

   private Client client;

   public ActivityClient()
   {
      client = ClientBuilder.newClient();
   }

   public Activity get(int id)
   {
      WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
      Response response = target.path("activities/" + id).request().get(Response.class);

      if (response.getStatus() != Status.OK.getStatusCode())
      {
         throw new RuntimeException(response.getStatus() + ": there was an error on the server");
      }
      return response.readEntity(Activity.class);
   }

   public List<Activity> get()
   {
      return client.target("http://localhost:8080/exercise-services/webapi/activities")
            .request(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Activity>>()
            {
            });
   }

   public User get(String id, boolean bool)
   {
      WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
      User response = target.path("activities/" + id + "/user").request().get(User.class);
      return response;
   }

   public Activity create(Activity activity)
   {
      WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
      Response response = target.path("activities/activity")
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(activity, MediaType.APPLICATION_JSON));
      
      if (response.getStatus() != Status.OK.getStatusCode())
      {
         throw new RuntimeException(response.getStatus() + ": there was an error on the server");
      }
      
      return response.readEntity(Activity.class);
   }

   public Activity update(Activity activity)
   {
      WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
      Response response = target.path("activities/" + activity.getId())
            .request(MediaType.APPLICATION_JSON)
            .put(Entity.entity(activity, MediaType.APPLICATION_JSON));
      
      if (response.getStatus() != Status.OK.getStatusCode())
      {
         throw new RuntimeException(response.getStatus() + ": there was an error on the server");
      }
      
      return response.readEntity(Activity.class);
   }

   public Activity delete(int id)
   {      
      WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
      Response response = target.path("activities/" + id)
            .request()
            .delete(Response.class);
      
      if (response.getStatus() != Status.OK.getStatusCode())
      {
         throw new RuntimeException(response.getStatus() + ": there was an error on the server");
      }
      
      return response.readEntity(Activity.class);
   }
}
