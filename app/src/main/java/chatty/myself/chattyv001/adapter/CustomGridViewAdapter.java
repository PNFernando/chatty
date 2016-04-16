package chatty.myself.chattyv001.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.material.widget.RadioButton;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.IOException;
import java.util.ArrayList;

import chatty.myself.chattyv001.R;
import chatty.myself.chattyv001.model.Chatty;
import chatty.myself.chattyv001.model.showmodel.ShowChatty;

/**
 * @author manish.s
 */
public class CustomGridViewAdapter extends BaseAdapter {
    Context context;
    int layoutResourceId;
    ArrayList<ShowChatty> data = new ArrayList<ShowChatty>();

    public CustomGridViewAdapter(Context context, int layoutResourceId, ArrayList<ShowChatty> data) {

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    public CustomGridViewAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

//        ImageView imageView = new ImageView(context);
//
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.txtName = (TextView) row.findViewById(R.id.txt_name);
            holder.imageView = (ImageView) row.findViewById(R.id.item_image);
            holder.txtAge = (TextView) row.findViewById(R.id.txt_age);
            holder.txtStatus = (RadioButton) row.findViewById(R.id.radioButton);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
//
//        Item item = data.get(position);
//        holder.txtTitle.setText(item.getTitle());
//        holder.imageItem.setImageBitmap(item.getImage());

        ImageView imageView = (ImageView) row.findViewById(R.id.item_image);
        TextView nameView = (TextView) row.findViewById(R.id.txt_name);
        TextView ageText = (TextView) row.findViewById(R.id.txt_age);
        RadioButton radioButton = (RadioButton) row.findViewById(R.id.radioButton);

        ShowChatty item = data.get(position);
        holder.txtName.setText(item.getName());

        if (item.getStatus()){
            holder.txtStatus.setChecked(true);
        }else {
            holder.txtStatus.setChecked(false);
        }

        //holder.imageUrl.setImageBitmap(item.getImage());

        Picasso.with(context).load(Uri.parse(item.getUrl())).into(holder.imageView);




        holder.txtAge.setText(item.getAge());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //imageView.setAlpha(127);
        return row;
    }

    static class RecordHolder {
        TextView txtName;
        ImageView imageView;
        TextView txtAge;
        RadioButton txtStatus;

    }
}