package egovframework.com.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import egovframework.com.stat.service.SummaryService;


@Component
public class BatchScheduler {

    @Autowired
    SummaryService service;

    @Scheduled(cron ="00 05 01 * * *")
    public void SysLogSummary(){
        String batchDate = DateFormatUtils.format(new Date(),"yyyyMMdd");
//        log.info( "WebLogSummary    " + batchDate);
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("OCCRRNC_DT", batchDate);
        sqlInpt.put("BATCH_NM", "SysLogSummary");
        service.insertBatchHistory(sqlInpt);
        
        
        try {
        	int cnt = service.insertSysLogSummary();
        	sqlInpt.put("WRK_CNT", cnt);
            sqlInpt.put("SCS_YN", "Y");
        }catch(Exception e) {
        	sqlInpt.put("WRK_CNT", 0);
            sqlInpt.put("SCS_YN", "N");
        }

        
        service.updateBatchHistory(sqlInpt);

//        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));
    }

    @Scheduled(cron ="00 10 01 * * *")
    public void WebLogSummary() {

        String batchDate = DateFormatUtils.format(new Date(),"yyyyMMdd");
//        log.info( "WebLogSummary    " + batchDate);

        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("OCCRRNC_DT", batchDate);
        sqlInpt.put("BATCH_NM", "WebLogSummary");
        service.insertBatchHistory(sqlInpt);
        
        try {
        	int cnt = service.insertWebLogSummary();
        	sqlInpt.put("WRK_CNT", cnt);
            sqlInpt.put("SCS_YN", "Y");
        }catch(Exception e) {
        	sqlInpt.put("WRK_CNT", 0);
            sqlInpt.put("SCS_YN", "N");
        }

        service.updateBatchHistory(sqlInpt);
//        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));
    }

}
