package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WebLogVo {

    private String id;
    private String hostname;
    private String occrrncDe;
    private String url;
    private String rqesterId;
    private String rqesterIp;
}
