package chatty.myself.chattyv001;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import chatty.myself.chattyv001.uihelper.infomation.FadingActionBarHelper;

/**
 * Created by Pramoda Fernando on 4/17/2015.
 */



public class InfoPageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("My new title");

        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setHideOnContentScrollEnabled(true);
        //  actionBar.setIcon(R.drawable.fab__gradient);


        FadingActionBarHelper helper = new FadingActionBarHelper()
                .headerLayout(R.layout.header)
        .contentLayout(R.layout.activity_info);
        setContentView(helper.createView(this));
        helper.initActionBar(this);
    }



}
