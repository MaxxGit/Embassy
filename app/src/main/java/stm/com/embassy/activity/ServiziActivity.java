package stm.com.embassy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import stm.com.embassy.R;

public class ServiziActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servizi);

    }

    public void onClickPassaporti(View view){
        Intent intent = new Intent(this, PassaportiActivity.class);
        startActivity(intent);
    }
}
