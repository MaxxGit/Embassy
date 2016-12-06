package stm.com.embassy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsolateActivity extends AppCompatActivity {

    private String TAG = "ConsolateActivity";

    private ListView consolates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consolate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Intent intent = new Intent(getApplicationContext(), ConsolateMapsActivity.class);
//                startActivity(intent);
//            }
//        });

        consolates = (ListView)findViewById(R.id.consolates);
        consolates.setAdapter(getListAdapter());
        consolates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, String.valueOf(position));
//                Intent in=new Intent(CuacaNowActivity.this,DetailActivity.class);
//                startActivity(in)
            }
        });
    }

    private ListAdapter getListAdapter() {
        List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();
        String[] eventsItem = getResources().getStringArray(R.array.consolates_item);
        for (int i = 0; i < eventsItem.length; i++) {
            Map<String, Object> event = new HashMap<String, Object>();
            String label = getString(getResources().getIdentifier(eventsItem[i] + "_label", "string", getPackageName()));
            String title = "";
            String content = getString(getResources().getIdentifier(eventsItem[i] + "_content", "string", getPackageName()));
            int image = getResources().getIdentifier(eventsItem[i] + "_view", "drawable", getPackageName());
            event.put(EventActivity.MENU_ATTR_ID, eventsItem[i]);
            event.put(EventActivity.MENU_ATTR_LABEL, label);
            event.put(EventActivity.MENU_ATTR_TITLE, title);
            event.put(EventActivity.MENU_ATTR_CONTENT, content);
            event.put(EventActivity.MENU_ATTR_ICON, image);
            events.add(event);
        }

        String[] from = new String[] { EventActivity.MENU_ATTR_LABEL, EventActivity.MENU_ATTR_TITLE, EventActivity.MENU_ATTR_CONTENT, EventActivity.MENU_ATTR_ICON };
        int[] to = new int[] { R.id.event_item, R.id.event_title, R.id.event_content, R.id.event_image };
        SimpleAdapter adapter = new SimpleAdapter(this, events, R.layout.adapter_events, from, to);
        return adapter;
    }

}
