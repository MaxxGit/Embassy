package stm.com.embassy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventActivity extends AppCompatActivity {

    public static final String MENU_ATTR_ID = "id";
    public static final String MENU_ATTR_TITLE = "title";
    public static final String MENU_ATTR_ICON = "icon";
    public static final String MENU_ATTR_CONTENT = "content";
    public static final String MENU_ATTR_LABEL = "label";

    private ListView events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Eventi");
        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setHomeButtonEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        events = (ListView)findViewById(R.id.events);
        events.setAdapter(getListAdapter());


    }

    private ListAdapter getListAdapter() {
        List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();
        String[] eventsItem = getResources().getStringArray(R.array.events_item);
        for (int i = 0; i < eventsItem.length; i++) {
            Map<String, Object> event = new HashMap<String, Object>();
            String label = getString(getResources().getIdentifier(eventsItem[i] + "_label", "string", getPackageName()));
            String title = getString(getResources().getIdentifier(eventsItem[i] + "_title", "string", getPackageName()));
            String content = getString(getResources().getIdentifier(eventsItem[i] + "_content", "string", getPackageName()));
            event.put(MENU_ATTR_ID, eventsItem[i]);
            event.put(MENU_ATTR_LABEL, label);
            event.put(MENU_ATTR_TITLE, title);
            event.put(MENU_ATTR_CONTENT, content);
            events.add(event);
        }

        String[] from = new String[] { MENU_ATTR_LABEL, MENU_ATTR_TITLE, MENU_ATTR_CONTENT };
        int[] to = new int[] { R.id.event_item, R.id.event_title, R.id.event_content };
        SimpleAdapter adapter = new SimpleAdapter(this, events, R.layout.content_events_item, from, to);
        return adapter;
    }
}
