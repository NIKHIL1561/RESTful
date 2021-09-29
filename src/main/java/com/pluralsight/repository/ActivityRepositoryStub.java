package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	List<Activity> activities;

	public ActivityRepositoryStub() {
		activities = new ArrayList<Activity>();
		Activity activity1 = new Activity(1234, "Swimming", 55, new User(10, "Nikhil"));
		Activity activity2 = new Activity(4567, "Cycling", 120, new User(20, "UG"));
		activities.add(activity1);
		activities.add(activity2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pluralsight.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities() {
		return activities;
	}

	@Override
	public Activity getActivity(int activityId) {
		for (Activity activity : activities) {
			if (activity.getId() == activityId)
				return activity;
		}

		return null;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public Activity delete(int id) {
		for (Activity activity : activities) {
			if (activity.getId() == id)
				return activity;
		}

		return null;
	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions) {
		//select * from activities where description in (?,?,?);
		
		List<Activity> activities = new ArrayList<Activity>();
		activities.add(new Activity(2345, "Swimming", 55, null));
		
		return activities;
	}
}
