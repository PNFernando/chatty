package chatty.myself.chattyv001;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import chatty.myself.chattyv001.adapter.FragmentDrawer;
import chatty.myself.chattyv001.fragment.AlertsFragment;
import chatty.myself.chattyv001.fragment.AlertsFragment_;
import chatty.myself.chattyv001.fragment.ChattyFragment;
import chatty.myself.chattyv001.fragment.ChattyFragment_;
import chatty.myself.chattyv001.fragment.MatesFragment;
import chatty.myself.chattyv001.fragment.MatesFragment_;
import chatty.myself.chattyv001.fragment.NewChattyFragment;
import chatty.myself.chattyv001.fragment.NewChattyFragment_;

/**
 * Created by Pramoda Fernando on 4/13/2015.
 */

@EActivity(R.layout.activity_living)
public class LivingPageActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener  {


    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;



    @AfterViews
    void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

    }
//


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }


    @Background
    void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = AlertsFragment_.builder().build();

//                title = getString(R.string.title_alerts);
                title = "Alerts";
                break;
            case 1:
                fragment =  ChattyFragment_.builder().build();
//                title = getString(R.string.title_chatty);
                title = "Chatty";
                break;
            case 2:
                fragment = NewChattyFragment_.builder().build();
             //   title = getString(R.string.title_newchatty);
                title = "New Chatty";
                break;

            case 3:
                fragment =  MatesFragment_.builder().build();
             //   title = getString(R.string.title_mates);
                title = "My Mates";
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
          // getSupportActionBar().setTitle(title);
        }
    }





}
