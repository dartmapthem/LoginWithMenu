package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;

import com.parse.ParseAnalytics;

public class ParseStarterProjectActivity extends Activity {
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        com.parse.ParseObject testObject = new com.parse.ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

		ParseAnalytics.trackAppOpenedInBackground(getIntent());
        java.util.Map<String, String> dimensions = new java.util.HashMap<String, String>();
        // What type of news is this?
        dimensions.put("category", "politics");
        // Is it a weekday or the weekend?
        dimensions.put("dayType", "weekday");
        // Send the dimensions to Parse along with the 'read' event

        ParseAnalytics.trackEventInBackground("read", dimensions);
	}
}
