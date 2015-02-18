package ca.lukeandlaura.lpk01;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity implements HomeFrag.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.main_view) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            HomeFrag firstFragment = new HomeFrag();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            RelativeLayout main = (RelativeLayout) findViewById(R.id.main_view);
            main.setBackgroundColor(Color.parseColor(prefs.getString("background_colour", "")));
            getFragmentManager().beginTransaction().add(R.id.main_view, firstFragment).commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    //Menu items change background colour
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);


        switch(item.getItemId()){
            /*
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

            case R.id.menu_white:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                main_view.setBackgroundColor(Color.rgb(238,238,238));
                //Orange --> Color.rgb(242,113,43)
                return true;
            */
            case R.id.menu_settings:
                if(getFragmentManager().findFragmentByTag(SettingsFragment.class.getName()) == null) {
                    Fragment newSetFrag = getFragmentManager().findFragmentByTag(SettingsFragment.class.getName());
                    if (newSetFrag == null) {
                        newSetFrag = new SettingsFragment();
                    }

                    FragmentTransaction trans = getFragmentManager().beginTransaction();

                    //Replace whatever is in the fragment_container view with this fragment
                    //and add the transaction to the back of the stack so the user can navigate back
                    trans.replace(R.id.main_view, newSetFrag, SettingsFragment.class.getName());
                    //if(getFragmentManager().getBackStackEntryCount() == 0) {
                    trans.addToBackStack(SettingsFragment.class.getName());
                    //}else{
                    //trans.addToBackStack(SettingsFragment.class.getName());
                    //}
                    trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    //Commit the transaction
                    trans.commit();
                    return true;
                }else{
                    return true;
                }

            case R.id.menu_about:
                if(getFragmentManager().findFragmentByTag(AboutFragment.class.getName()) == null) {
                    Fragment aboutFrag = getFragmentManager().findFragmentByTag(AboutFragment.class.getName());
                    if (aboutFrag == null) {
                        aboutFrag = new AboutFragment();
                    }

                    FragmentTransaction aboutTrans = getFragmentManager().beginTransaction();

                    //Replace whatever is in the fragment_container view with this fragment
                    //and add the transaction to the back of the stack so the user can navigate back
                    aboutTrans.replace(R.id.main_view, aboutFrag, AboutFragment.class.getName());
                    //if(getFragmentManager().getBackStackEntryCount() == 0) {
                    aboutTrans.addToBackStack(AboutFragment.class.getName());
                    //}
                    aboutTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    //Commit the transaction
                    aboutTrans.commit();
                    return true;
                }else{
                    return true;
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount() > 0){
            fm.popBackStack();
        }else{
            super.onBackPressed();
        }

    }



}
