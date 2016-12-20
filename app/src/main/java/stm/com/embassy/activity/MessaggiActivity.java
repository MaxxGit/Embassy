package stm.com.embassy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import stm.com.embassy.MainActivity;
import stm.com.embassy.R;
import stm.com.embassy.app.Config;
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
        private TextView txtRegId, txtMessage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_messaggi);

            txtMessage = (TextView) findViewById(R.id.txt_push_message);

            mRegistrationBroadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                    // checking for type intent filter
                    if (intent.getAction().equals(Config.REGISTRATION_COMPLETE)) {
                        // gcm successfully registered
                        // now subscribe to `global` topic to receive app wide notifications
                        FirebaseMessaging.getInstance().subscribeToTopic(Config.TOPIC_GLOBAL);

                    } else if (intent.getAction().equals(Config.PUSH_NOTIFICATION)) {
                        // new push notification is received

                        String message = intent.getStringExtra("message");

                        Toast.makeText(getApplicationContext(), "Push notification: " + message, Toast.LENGTH_LONG).show();

                        txtMessage.setText(message);
                    }
                }
            };

        }

    @Override
    protected void onResume() {
        super.onResume();

        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(Config.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }


}

