package egovframework.com.stat.dao;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SysLogVo {

    private String requestId;
    private String hostname;
    private String occrrncDe;
    private String rqesterId;
    private String rqesterIp;
    private String svcNm;
    private String methodNm;
    private String processSeCode;
    private String processTime;
    private String errorSe;
    private String errorCo;
    private String errorCode;


}
