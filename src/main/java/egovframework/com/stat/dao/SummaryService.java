package egovframework.com.stat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SummaryService {

    @Autowired
    private SummaryDao mapper;


    public void insertSysLogSummary(){
        int cnt =  mapper.insertSysLogSummary();
    }

    public void insertWebLogSummary(){
        int cnt =  mapper.insertWebLogSummary();
    }


}
