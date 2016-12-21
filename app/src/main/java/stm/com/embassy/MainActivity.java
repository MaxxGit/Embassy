package stm.com.embassy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import stm.com.embassy.activity.*;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i( TAG, "MainActivity onCreate !!!" );
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        LoginButton loginButton = (LoginButton) findViewById(R.id.loginButton);

        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList("public_profile","email","user_friends"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                graphRequest(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
                nameView.setText(" ");
                LoginManager.getInstance().logOut();

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }



    public void graphRequest(AccessToken token){
        GraphRequest request = GraphRequest.newMeRequest(token,new GraphRequest.GraphJSONObjectCallback(){

            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                String name = null;
                String surname =  null;
                try {
                    name =(String) object.get("first_name");
                    surname = (String) object.get("last_name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
                nameView.setText("" + name + " " + surname);


            }
        });

        Bundle b = new Bundle();
        b.putString("fields","id,email,first_name,last_name,picture.type(large)");
        request.setParameters(b);
        request.executeAsync();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);


    }

    public void onInfoClick(View view){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void onConsolateClick(View view){
        Intent intent = new Intent(this, ConsolateActivity.class);
        startActivity(intent);
    }

    public void onEventClick(View view){
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    public void onServiziClick(View view){
        Intent intent = new Intent(this, ServiziActivity.class);
        startActivity(intent);
    }

    public void onMessaggiClick(View view){
        Intent intent = new Intent(this, MessaggiActivity.class);
        startActivity(intent);
    }


}
