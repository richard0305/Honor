package ylj.butf_api;

/**
 * Created by 我的样子平平无奇 on 2017/12/22 17:10.
 * Email: 2256669598@qq.com
 */

public interface ViewBinder<T> {
    void bindView(T host,Object object,ViewFinder finder);
    void  unBindView(T host);
}
