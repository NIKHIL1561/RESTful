package com.pluralsight.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityClientTest {

	@Test
	public void testSearch()
	{
		ActivitySearchClient client = new ActivitySearchClient();
		String param = "description";
		List<String> searchValues = new ArrayList<String>();
		searchValues.add("Swimming");
		searchValues.add("Running");
		
		List<Activity> activities = client.search("description", searchValues);
		System.out.println(activities);
		
		assertNotNull(activities);
		
	}
	
	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get(4567);

		System.out.println(activity.getDescription());

		assertNotNull(activity);
	}

	@Test(expected = RuntimeException.class)
	public void testGet_BadRequest() {
		ActivityClient client = new ActivityClient();
		client.get(456);
	}

	@Test(expected = RuntimeException.class)
	public void testGet_NotFound() {
		ActivityClient client = new ActivityClient();
		client.get(456);
	}

	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();

		// System.out.println(activity.getDescription());

		assertNotNull(activities);
	}

	@Test
	public void testGetUser() {
		ActivityClient client = new ActivityClient();
		User user = client.get("4567", true);

		System.out.println(user.getName());

		assertNotNull(user);
	}

	@Test
	public void testPost() {
		ActivityClient client = new ActivityClient();
		Activity expectedActivity = new Activity(1, "Jogging", 30, null);
		Activity actualActivity = client.create(expectedActivity);

		assertNotNull(actualActivity);
		assertEquals(expectedActivity.getDescription(), actualActivity.getDescription());
		assertEquals(expectedActivity.getDuration(), actualActivity.getDuration());
		assertEquals(expectedActivity.getId(), actualActivity.getId());
		assertEquals(expectedActivity.getUser(), actualActivity.getUser());
	}

	@Test
	public void testPut() {
		Activity expectedActivity = new Activity(2, "Badminton", 60, null);
		ActivityClient client = new ActivityClient();

		Activity actualActivity = client.update(expectedActivity);

		assertNotNull(actualActivity);
		assertEquals(expectedActivity.getDescription(), actualActivity.getDescription());
		assertEquals(expectedActivity.getDuration(), actualActivity.getDuration());
		assertEquals(expectedActivity.getId(), actualActivity.getId());
		assertEquals(expectedActivity.getUser(), actualActivity.getUser());
	}

	@Test
	public void testDelete() {
		int id = 1234;
		ActivityClient client = new ActivityClient();

		Activity actualActivity = client.delete(1234);

		assertNotNull(actualActivity);
		assertEquals(id, actualActivity.getId());
	}

}
