package stm.com.embassy;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import stm.com.embassy.activity.*;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i( TAG, "MainActivity onCreate !!!" );
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
