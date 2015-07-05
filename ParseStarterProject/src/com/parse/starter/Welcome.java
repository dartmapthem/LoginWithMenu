package com.parse.starter;

/**
 * Created by yiningchen on 7/1/15.
 */
import com.parse.ParseUser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.parse.ParseQuery;
import com.parse.ParseObject;
import com.parse.GetCallback;
import java.util.List;
import com.parse.ParseException;

public class Welcome extends Activity {

    // Declare Variable
    Button logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.welcome);

        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        String struser = currentUser.getUsername().toString();

        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);

        // Set the currentUser String into TextView
        txtuser.setText("You are logged in as " + struser);

        // Locate Button in welcome.xml
        logout = (Button) findViewById(R.id.logout);

        // Logout Button Click Listener
        logout.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                ParseUser.logOut();
                finish();
            }
        });

        // Dummy Queries

        ParseQuery<ParseObject> query = ParseQuery.getQuery("DataBase");
        query.whereEqualTo("UserName", "NH");
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (object == null) {
                    System.out.println("The getFirst request failed.");
                } else {
                    //Retrieved the object
                    System.out.println("Longitude="+object.getDouble("longitude"));
                    System.out.println("Latitude="+object.getDouble("latitude"));
                }
            }
        });
    }
}