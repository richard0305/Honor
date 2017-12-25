package ylj.butf_api;

import android.app.Activity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 我的样子平平无奇 on 2017/12/22 17:23.
 * Email: 2256669598@qq.com
 */

public class MoViewBinder {
    private static  final  ActivityViewFinder activityFinder=new ActivityViewFinder();
    private static  final Map<String,ViewBinder> binderMap=new LinkedHashMap<>();


    public static void bind(Activity activity){
        bind(activity,activity,activityFinder);
    }
    /**
     * '注解绑定
     *
     * @param host   表示注解 View 变量所在的类，也就是注解类
     * @param object 表示查找 View 的地方，Activity & View 自身就可以查找，Fragment 需要在自己的 itemView 中查找
     * @param viewFinder ui绑定提供者接口
     */
    private static void bind(Object host,Object object,ViewFinder viewFinder){
        String className = host.getClass().getName();
        try {
            ViewBinder binder = binderMap.get(className);
            if (binder == null) {
                Class<?> aClass = Class.forName(className + "$$ViewBinder");
                binder = (ViewBinder) aClass.newInstance();
                binderMap.put(className, binder);
            }
            if (binder != null) {
                binder.bindView(host, object, viewFinder);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解除注解绑定 ActivityViewFinder
     *
     * @param host
     */
    public static void unBind(Object host) {
        String className = host.getClass().getName();
        ViewBinder binder = binderMap.get(className);
        if (binder != null) {
            binder.unBindView(host);
        }
        binderMap.remove(className);
    }

}
