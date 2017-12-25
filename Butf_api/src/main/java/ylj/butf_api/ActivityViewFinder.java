package ylj.butf_api;

import android.app.Activity;
import android.view.View;

/**
 * Created by 我的样子平平无奇 on 2017/12/22 17:13.
 * Email: 2256669598@qq.com
 */

public class ActivityViewFinder implements ViewFinder {
    @Override
    public View findView(Object object, int id) {
        return ((Activity)object).findViewById(id);
    }
}
