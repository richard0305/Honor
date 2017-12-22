package ylj.honor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import ylj.requst.ReqParam;
import ylj.requst.ReqType;
import ylj.requst.ReqUrl;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testApi();
    }

    private void testApi() {
        ApiService api = create(ApiService.class);
        api.Login("whoislcj", "123456");
    }

    private <T>T create(Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                // Annotation[]  methodAnnotations = method.getAnnotations();//拿到函数注解数组
                ReqType reqtype=method.getAnnotation(ReqType.class);
                Log.e("YYYYYYYYYY", "reqtype---reqtype->" + reqtype.toString());
                ReqUrl reqUrl=method.getAnnotation(ReqUrl.class);
                Log.e("YYYYYYYYYY", "reqUrl---reqUrl->" + reqUrl.toString());
                Type[] parameterTypes = method.getGenericParameterTypes();
                Log.e("YYYYYYYYYY", "GenericParameterTypes---GenericParameterTypes->" + parameterTypes.toString());
                Annotation[][] reqParamsarray=method.getParameterAnnotations();
                Log.e("YYYYYYYYYY", "ParameterAnnotations---ParameterAnnotations->" + reqParamsarray.toString());
                for(int i=0;i<reqParamsarray.length;i++){
                    Annotation[] annotations=     reqParamsarray[i];
                    if (annotations != null) {
                        ReqParam reqParam = (ReqParam) annotations[0];
                        Log.e("YYYYYYYYYY", "reqParam---reqParam->" + reqParam.value() + "==" + objects[i]);
                    }
                }


                return "我的样子平平无奇";
            }
        });
    }

}
