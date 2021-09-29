package com.pluralsight;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource
{
   private ActivityRepository repo = new ActivityRepositoryStub();
   
   @GET
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<Activity> getAllActivities()
   {
      return repo.findAllActivities();
   }
   
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Path("activity")
   public Activity createActivity(Activity activity)
   {
      System.out.println(activity.getDescription());
      System.out.println(activity.getDuration());
      
      repo.create();
      
      return activity;
   }
   
   @PUT
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   @Path("{activity}")
   public Response updateActivity(Activity activity)
   {
      System.out.println(activity.getDescription());
      System.out.println(activity.getDuration());
      
      repo.update();
      
      return Response.ok().entity(activity).build();
   }
   
   @DELETE
   @Produces(MediaType.APPLICATION_JSON)
   @Path("{activityId}")
   public Response deleteActivity(@PathParam("activityId") int id)
   {
     
      Activity activity = repo.delete(id);
      
      return Response.ok().entity(activity).build();
   }
   
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("{activityId}")
   public Response getActivity(@PathParam("activityId") int activityId)
   {
      if(activityId < 1000)
      {
         return Response.status(Status.BAD_REQUEST).build();
      }
      
      Activity activity = repo.getActivity(activityId);
      
      if(activity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      
      return Response.ok().entity(activity).build();
   }
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("{activityId}/user")
   public User getActivityUser(@PathParam("activityId") int activityId)
   {
      return repo.getActivity(activityId).getUser();
   }
}
