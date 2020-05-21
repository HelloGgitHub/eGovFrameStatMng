package egovframework.com.batch;


import egovframework.com.stat.dao.ResultMngService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SysLogSummaryJob implements Job {

    @Autowired
    ResultMngService resultMngService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {


        /*
         * Job Interface를 implements하여
         * execute 메소드에 로직을 넣는다.
         * */
        log.info("--------------------------sysLogjobstart---------------------------");
        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        try {
            int inputCnt = resultMngService.insertSysLogSum(sqlInpt);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}




