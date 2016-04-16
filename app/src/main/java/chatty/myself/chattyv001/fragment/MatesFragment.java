package chatty.myself.chattyv001.fragment;

import android.support.v4.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import chatty.myself.chattyv001.R;
import chatty.myself.chattyv001.adapter.CustomGridViewAdapter;
import chatty.myself.chattyv001.model.Chatty;
import chatty.myself.chattyv001.model.showmodel.ShowChatty;

/**
 * Created by Pramoda Fernando on 4/15/2015.
 */

@EFragment
public class MatesFragment  extends Fragment {
    GridView gridView;
    ArrayList<ShowChatty> gridArray = new ArrayList<ShowChatty>();
    CustomGridViewAdapter customGridAdapter;

    public MatesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = "Jackson";
        String url = "http://i1.kym-cdn.com/entries/icons/original/000/014/421/33padm1.png";
        String age = "22";
//

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
        View rootView = inflater.inflate(R.layout.fragment_mates, container, false);
        gridView = (GridView) rootView.findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this.getActivity(), R.layout.row_chatty, gridArray);
        gridView.setAdapter(customGridAdapter);

        // Inflate the layout for this fragment
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
}
