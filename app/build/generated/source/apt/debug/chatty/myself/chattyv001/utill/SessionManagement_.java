//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package chatty.myself.chattyv001.utill;

import android.content.Context;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class SessionManagement_
    extends SessionManagement
{

    private Context context_;
    private static SessionManagement_ instance_;

    private SessionManagement_(Context context) {
        context_ = context;
    }

    public static SessionManagement_ getInstance_(Context context) {
        if (instance_ == null) {
            OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(null);
            instance_ = new SessionManagement_(context.getApplicationContext());
            instance_.init_();
            OnViewChangedNotifier.replaceNotifier(previousNotifier);
        }
        return instance_;
    }

    private void init_() {
    }

}
