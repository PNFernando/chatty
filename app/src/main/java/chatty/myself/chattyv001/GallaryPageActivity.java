package chatty.myself.chattyv001;

import android.app.Activity;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

import chatty.myself.chattyv001.uihelper.gallary.QuiltView;


/**
 * Created by Pramoda Fernando on 4/18/2015.
 */

@EActivity(R.layout.activity_gallary)
public class GallaryPageActivity extends Activity {

    public QuiltView quiltView;

    @AfterViews
    void afterView() {
        quiltView = (QuiltView) findViewById(R.id.quilt);
        quiltView.setChildPadding(5);
        addTestQuilts(200);
    }

    public void addTestQuilts(int num) {
        ArrayList<ImageView> images = new ArrayList<ImageView>();
        for (int i = 0; i < num; i++) {
            ImageView image = new ImageView(this.getApplicationContext());
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (i % 2 == 0)
                image.setImageResource(R.drawable.anushka);
            else
                image.setImageResource(R.drawable.love);
            images.add(image);
        }
        quiltView.addPatchImages(images);
    }


}
