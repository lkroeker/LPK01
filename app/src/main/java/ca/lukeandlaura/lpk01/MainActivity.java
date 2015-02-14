package ca.lukeandlaura.lpk01;

import android.app.Activity;
import android.graphics.Color;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Settings Fragment creation
    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
        }

    }

    //Menu items change background colour
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch(item.getItemId()){
            case R.id.menu_pink:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.rgb(255, 89, 177));
                return true;

            case R.id.menu_yellow:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.YELLOW);
                return true;

            case R.id.menu_green:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.menu_orange:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.rgb(242,113,43));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
