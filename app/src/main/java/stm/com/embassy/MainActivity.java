package stm.com.embassy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
