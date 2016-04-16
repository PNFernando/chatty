package chatty.myself.chattyv001.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;


import chatty.myself.chattyv001.R;
import chatty.myself.chattyv001.SelectUnitPageActivity;
import chatty.myself.chattyv001.SelectUnitPageActivity_;
import chatty.myself.chattyv001.adapter.CustomGridViewAdapter;
import chatty.myself.chattyv001.model.Chatty;
import chatty.myself.chattyv001.model.showmodel.ShowChatty;

/**
 * Created by Pramoda Fernando on 4/15/2015.
 */

@EFragment
public class ChattyFragment extends Fragment {

    GridView gridView;
    Activity activity;
    ArrayList<ShowChatty> gridArray = new ArrayList<ShowChatty>();
    CustomGridViewAdapter customGridAdapter;
    public ChattyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set grid view item
        String name = "Johnny";
        String url = "http://fc03.deviantart.net/fs70/f/2012/008/6/4/png_johnny_deep_by_clauueditions-d4lqghi.png";
        String age = "22";

        gridArray.add(new ShowChatty(name,url,age,true));
        gridArray.add(new ShowChatty(name,url,age,false));
        gridArray.add(new ShowChatty(name,url,age,true));
        gridArray.add(new ShowChatty(name,url,age,true));
        gridArray.add(new ShowChatty(name,url,age,false));
        gridArray.add(new ShowChatty(name,url,age,true));
        gridArray.add(new ShowChatty(name,url,age,true));
        gridArray.add(new ShowChatty(name,url,age,false));
        gridArray.add(new ShowChatty(name,url,age,false));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_chatty, container, false);

        activity=this.getActivity();
        gridView = (GridView) rootView.findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this.getActivity(), R.layout.row_chatty, gridArray);
        gridView.setAdapter(customGridAdapter);

        // Inflate the layout for this fragment

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, SelectUnitPageActivity_.class);
                startActivity(intent);
            }
        });



        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
