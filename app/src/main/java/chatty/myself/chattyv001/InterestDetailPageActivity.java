package chatty.myself.chattyv001;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import chatty.myself.chattyv001.model.InterrestDetail;
import chatty.myself.chattyv001.model.ResponseMessage;
import chatty.myself.chattyv001.service.InterrestDetailService;
import chatty.myself.chattyv001.utill.SessionManagement;

/**
 * Created by Pramoda Fernando on 4/13/2015.
 */

@EActivity(R.layout.activity_interest)
public class InterestDetailPageActivity extends Activity {

    @Bean
    SessionManagement sessionManagement;

    private static final String[] GENDER = new String[]{"MALE", "FEMALE"};

    @ViewById
    Spinner gender_spinner;

    @ViewById
    EditText txt_firstage;


    @ViewById
    EditText txt_secondage;


    @ViewById
    EditText txt_country1;

    @ViewById
    EditText txt_country2;

    @ViewById
    EditText txt_country3;

    @RestService
    InterrestDetailService interrestDetailService;





    private ArrayAdapter<CharSequence> adapter;


    @AfterViews
    void initView() {
     adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, GENDER);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender_spinner.setAdapter(adapter);
    }

    @Click
    void btNext(View view) {

        InterrestDetail interrestDetail =  new InterrestDetail();
        String userId = sessionManagement.getSESSION().get("login_user_id").toString();
        Log.v("NEW USER ID BY SEETION",userId);
        interrestDetail.setUserId(Long.parseLong(userId));
        interrestDetail.setGender("Female");
        interrestDetail.setFirstage(Integer.parseInt(txt_firstage.getText().toString()));
        interrestDetail.setSecondage(Integer.parseInt(txt_secondage.getText().toString()));
        interrestDetail.setCountry1(txt_country1.getText().toString());
        interrestDetail.setCountry2(txt_country2.getText().toString());
        interrestDetail.setCountry3(txt_country3.getText().toString());

        saveInterrestDetail(interrestDetail);


        Intent intent = new Intent(this, LoadingPageActivity_.class);
        startActivity(intent);
        finish();
    }

    @Background
    void saveInterrestDetail(InterrestDetail interrestDetail){
        ResponseMessage responseMessage = interrestDetailService.saveInterrestDetail(interrestDetail);

        Log.v("INTER ID", responseMessage.getData().toString());
    }

    @UiThread
    void showMessage(String text) {
        Log.v("THREAD WORKING INTERREST DETAIL", text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT);
    }


}
