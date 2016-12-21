package stm.com.embassy.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import stm.com.embassy.MainActivity;
import stm.com.embassy.R;
import stm.com.embassy.app.Config;
import stm.com.embassy.services.MyFirebaseMessagingService;
import stm.com.embassy.utils.NotificationUtils;


import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.support.v4.content.LocalBroadcastManager;
    import android.support.v7.app.AppCompatActivity;
    import android.text.TextUtils;
    import android.util.Log;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.google.firebase.messaging.FirebaseMessaging;


public class MessaggiActivity extends AppCompatActivity {

        private static final String TAG = MessaggiActivity.class.getSimpleName();
        private BroadcastReceiver mRegistrationBroadcastReceiver;
        private TextView txtMessage;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_messaggi);

            txtMessage = (TextView) findViewById(R.id.txt_push_message);

            txtMessage.setText(MyFirebaseMessagingService.getMessageToDisplay());

        }


}

