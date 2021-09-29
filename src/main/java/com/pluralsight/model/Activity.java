package com.pluralsight.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Activity
{  
   private int id;
   private String description;
   private int duration;
   private User user;
   public Activity(int id, String desciption, int duration, User user)
   {
      super();
      this.id = id;
      this.description = desciption;
      this.duration = duration;
      this.user = user;
   }
   public Activity()
   {
      super();
   }
   
   
   public int getId()
   {
      return id;
   }
   public void setId(int id)
   {
      this.id = id;
   }
   @XmlElement(name="desc")
   public String getDescription()
   {
      return description;
   }
   public void setDescription(String desciption)
   {
      this.description = desciption;
   }
   public int getDuration()
   {
      return duration;
   }
   public void setDuration(int duration)
   {
      this.duration = duration;
   }
   public User getUser()
   {
      return user;
   }
   public void setUser(User user)
   {
      this.user = user;
   }
   
}
