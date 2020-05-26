package egovframework.com.batch;

import egovframework.com.stat.dao.SummaryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class BatchScheduler {

    @Autowired
    SummaryService service;

    @Scheduled(cron ="* 15 * * * *")
    public void SysLogSummary(){
        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));
        service.insertSysLogSummary();
        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));
    }

    @Scheduled(cron ="15 * * * * *")
    public void WebLogSummary() {
        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));
        service.insertWebLogSummary();
        log.info(DateFormatUtils.format(new Date(),"yyyy-MM-dd'T'HH:mm:ssZZ"));
    }

}