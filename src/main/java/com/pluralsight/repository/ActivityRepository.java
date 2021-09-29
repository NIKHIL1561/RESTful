package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity getActivity(int activityId);

	void create();

	void update();

	Activity delete(int id);

	List<Activity> findByDescription(List<String> descriptions);

}