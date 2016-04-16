package chatty.myself.chattyv001.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.List;

import chatty.myself.chattyv001.DecisionPageActivity;
import chatty.myself.chattyv001.DecisionPageActivity_;
import chatty.myself.chattyv001.R;
import chatty.myself.chattyv001.adapter.AlertListAdapter;
import chatty.myself.chattyv001.model.Alert;
import chatty.myself.chattyv001.model.ResponseMessage;
import chatty.myself.chattyv001.model.User;
import chatty.myself.chattyv001.model.showmodel.ShowAlert;
import chatty.myself.chattyv001.service.AlertService;
import chatty.myself.chattyv001.service.UserService;

/**
 * Created by Pramoda Fernando on 4/15/2015.
 */

@EFragment
public class AlertsFragment extends Fragment {


    @ViewById
    ListView list;

    @Bean
    AlertListAdapter adapter;

    Activity activity;

    public AlertsFragment() {

    }

    @AfterViews
    void initView() {
        list.setAdapter(adapter);

        adapter.setOnAlertClickListner(new AlertListAdapter.AlertViewClickListner() {
            @Override
            public void onClick(ShowAlert showAlert, View view) {
                Intent intent = new Intent(AlertsFragment.this.getActivity(), DecisionPageActivity_.class);

                Log.v("suggestFr===========================>",showAlert.getSuggestId()+"");
                intent.putExtra("suggestid",showAlert.getSuggestId());
                intent.putExtra("name",showAlert.getName());
                intent.putExtra("age",showAlert.getAge());
                intent.putExtra("url",showAlert.getUrl());

                startActivity(intent);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alerts, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
