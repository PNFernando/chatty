package chatty.myself.chattyv001.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;

import chatty.myself.chattyv001.R;
import chatty.myself.chattyv001.model.Alert;
import chatty.myself.chattyv001.model.showmodel.ShowAlert;
import chatty.myself.chattyv001.service.AlertService;
import chatty.myself.chattyv001.service.UserService;
import chatty.myself.chattyv001.utill.SessionManagement;


/**
 * Created by Pramoda Fernando on 4/16/2015.
 */

@EBean
public class AlertListAdapter extends BaseAdapter {

    @RestService
    AlertService alertService;

    @RestService
    UserService userService;

    @RootContext
    Context context;

    @Bean
    SessionManagement sessionManagement;

    private AlertViewClickListner alertViewClickListner;

    ArrayList<ShowAlert> alertDetailsList = new ArrayList<ShowAlert>();

    @AfterInject
    void initAdapter() {
       loadAlerts();
    }


    @Background
    void loadAlerts() {
        alertDetailsList.clear();
        alertDetailsList.addAll(alertService.getShowAlertByUserId(Long.parseLong(sessionManagement.getSESSION().get("login_user_id").toString())));
        onLoad();

    }

    @UiThread
    void onLoad() {
        this.notifyDataSetChanged();
    }

    public AlertListAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return alertDetailsList.size();
    }

    @Override
    public ShowAlert getItem(int position) {
        return alertDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.row_alert, parent, false);

            holder = new RecordHolder();
            holder.txtName = (TextView) row.findViewById(R.id.txt_name);
            holder.imageItem = (ImageView) row.findViewById(R.id.thumbnail);
            holder.txtAge = (TextView) row.findViewById(R.id.txt_age);
            holder.txtBywhome = (TextView) row.findViewById(R.id.txt_bywhome);
            holder.txttagLine = (TextView) row.findViewById(R.id.txt_tagline);
            holder.txtDateTime = (TextView) row.findViewById(R.id.txt_time);


            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }


        TextView txtname = (TextView) row.findViewById(R.id.txt_name);
        ImageView imageItem = (ImageView) row.findViewById(R.id.thumbnail);
        TextView txtAge = (TextView) row.findViewById(R.id.txt_age);
        TextView txtBywhome = (TextView) row.findViewById(R.id.txt_bywhome);
        TextView txttagLine = (TextView) row.findViewById(R.id.txt_tagline);
        TextView txtdatetime = (TextView) row.findViewById(R.id.txt_time);

       ShowAlert showAlert = alertDetailsList.get(position);
        holder.txtName.setText(showAlert.getName());
        holder.txttagLine.setText(showAlert.getTagline());
        holder.txtBywhome.setText(showAlert.getBywhome());
        holder.txtAge.setText(showAlert.getAge());
        holder.txtDateTime.setText(showAlert.getTime());




        Picasso.with(context).load(Uri.parse(showAlert.getUrl())).into(holder.imageItem);

        imageItem.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        holder.imageItem.setImageBitmap(alert.getImage());
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        //imageView.setAlpha(127);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertViewClickListner.onClick(getItem(position),v);
            }
        });
        return row;

    }



    static class RecordHolder {
        TextView txtName;
        ImageView imageItem;
        TextView txttagLine;
        TextView txtAge;
        TextView txtBywhome;
        TextView txtDateTime;

    }
    public void setOnAlertClickListner(AlertViewClickListner alertViewClickListner) {

        this.alertViewClickListner = alertViewClickListner;
    }

    public interface AlertViewClickListner {
        void onClick(ShowAlert showAlert, View view);
    }
}
