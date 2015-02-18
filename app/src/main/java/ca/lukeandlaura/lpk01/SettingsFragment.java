package ca.lukeandlaura.lpk01;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.RelativeLayout;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

    public static final String BACKGROUND_COLOUR = "background_colour";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                // listener implementation
            }
        };
        prefs.registerOnSharedPreferenceChangeListener(listener);
        // Load the fragmented_preferences_inner from an XML resource
        //addPreferencesFromResource(R.xml.fragmented_preferences_inner);
        addPreferencesFromResource(R.xml.preferences);
    }

    public void onSharedPreferenceChanged(SharedPreferences prefs,String key){
        //complete this from Google samples
        if(key.equals(BACKGROUND_COLOUR)){
            RelativeLayout main = (RelativeLayout) getActivity().findViewById(R.id.main_view);
            main.setBackgroundColor(Color.parseColor(prefs.getString(key, "")));

        }


    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

}