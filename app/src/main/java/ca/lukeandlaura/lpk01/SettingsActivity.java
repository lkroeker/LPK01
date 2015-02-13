package ca.lukeandlaura.lpk01;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class SettingsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout settings_view = (RelativeLayout) findViewById(R.id.settings_view);

        switch(item.getItemId()){
            case R.id.pinkSettingsButton:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                settings_view.setBackgroundColor(Color.rgb(255, 89, 177));
                return true;

            case R.id.yellowSettingsButton:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                settings_view.setBackgroundColor(Color.YELLOW);
                return true;

            case R.id.greenSettingsButton:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                settings_view.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.defaultSettingsButton:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                settings_view.setBackgroundColor(Color.rgb(242,113,43));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
