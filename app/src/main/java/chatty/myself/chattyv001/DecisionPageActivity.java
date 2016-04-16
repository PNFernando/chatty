package chatty.myself.chattyv001;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import chatty.myself.chattyv001.model.Chatty;
import chatty.myself.chattyv001.model.InterrestDetail;
import chatty.myself.chattyv001.model.Mate;
import chatty.myself.chattyv001.model.ResponseMessage;
import chatty.myself.chattyv001.service.ChattyService;
import chatty.myself.chattyv001.service.MateService;
import chatty.myself.chattyv001.utill.SessionManagement;

/**
 * Created by Pramoda Fernando on 4/16/2015.
 */

@EActivity(R.layout.activity_decision)
public class DecisionPageActivity extends Activity {

    @ViewById
    TextView txt_name;

    @ViewById
    TextView txt_age;


    @ViewById
    ImageView thumbnail;

    @Bean
    SessionManagement sessionManagement;

    Intent intent;

    String name;

    @RestService
    MateService mateService;

    @RestService
    ChattyService chattyService;


    @AfterViews
    void afterView() {
        intent = getIntent();
        Log.v("fgfg", intent.getLongExtra("suggestid", 0) + "");
        name = intent.getStringExtra("name");
        txt_name.setText(name);
        txt_age.setText(intent.getStringExtra("age"));
        String url = intent.getStringExtra("url");
        Picasso.with(this).load(url).fit().into(thumbnail);
    }


    @Click
    void bt_info(View view) {
        Intent intent = new Intent(this, InfoPageActivity.class);
        startActivity(intent);
    }

    @Click
    void bt_gallary(View view) {
        Intent intent = new Intent(this, GallaryPageActivity_.class);
        startActivity(intent);
    }

    @Click
    void bt_chatty(View view) {
      showChattyDialog();
    }

    @Click
    void bt_mate(View view) {

        showMateDialog();
    }

    private void showMateDialog() throws Resources.NotFoundException {
        new AlertDialog.Builder(this)
                .setTitle("Are You Sure to Add '" + name + "' as your Mate ?")
                .setMessage("Choose Your Option")
                .setIcon(
                        getResources().getDrawable(
                                android.R.drawable.ic_dialog_alert))
                .setPositiveButton(getResources().getString(R.string.PostiveYesButton),
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                Mate mate = new Mate();
                                String userId = sessionManagement.getSESSION().get("login_user_id").toString();
                                long suggestid = intent.getLongExtra("suggestid", 0);

                                mate.setMateId(suggestid);
                                mate.setUserId(Long.parseLong(userId));
                                saveMate(mate);
                                //Do Something Here

                            }
                        })
                .setNegativeButton(
                        getResources().getString(R.string.NegativeNoButton),
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                finish();
                            }
                        }).show();
    }

    private void showChattyDialog() throws Resources.NotFoundException {
        new AlertDialog.Builder(this)
                .setTitle("Are You Sure to Add '" + name + "' as your Chatty ?")
                .setMessage("Choose Your Option")
                .setIcon(
                        getResources().getDrawable(
                                android.R.drawable.ic_dialog_alert))
                .setPositiveButton(getResources().getString(R.string.PostiveYesButton),
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {

                                Chatty chatty = new Chatty();
                                String userId = sessionManagement.getSESSION().get("login_user_id").toString();
                                long suggestid = intent.getLongExtra("suggestid", 0);

                                chatty.setChattyId(suggestid);
                                chatty.setUserId(Long.parseLong(userId));
                                saveChatty(chatty);
                                //Do Something Here

                            }
                        })
                .setNegativeButton(
                        getResources().getString(R.string.NegativeNoButton),
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                finish();
                            }
                        }).show();
    }

    @Background
    void saveMate(Mate mate){
        ResponseMessage responseMessage = mateService.saveMate(mate);
        Log.v("Mate ID", responseMessage.getData().toString());
    }


    @Background
    void saveChatty(Chatty chatty){
        ResponseMessage responseMessage = chattyService.saveChatty(chatty);
        Log.v("Chatty ID", responseMessage.getData().toString());
    }

}
