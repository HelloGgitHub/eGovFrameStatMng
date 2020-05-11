package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WebLogVo {

    private String requestId;
    private String hostname;
    private String occrrncDe;
    private String Url;
    private String rqesterId;
    private String rqesterIp;
}
