package ylj.requst;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 我的样子平平无奇 on 2017/12/22 15:47.
 * Email: 2256669598@qq.com
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqType {
    enum ReqTypeEnum{post,get,delete,put};

    ReqTypeEnum reqType()
            default ReqTypeEnum.post;
}
