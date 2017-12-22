package ylj.honor;

import ylj.requst.ReqParam;
import ylj.requst.ReqType;
import ylj.requst.ReqUrl;

/**
 * Created by 我的样子平平无奇 on 2017/12/22 15:57.
 * Email: 2256669598@qq.com
 */

public interface ApiService {

    @ReqType(reqType = ReqType.ReqTypeEnum.post)
    @ReqUrl(reqUrl = "www.baidu.com")
    String Login(@ReqParam("userid")String useid,@ReqParam("pwd")String pwd);
}
