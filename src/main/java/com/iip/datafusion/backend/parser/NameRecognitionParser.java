package com.iip.datafusion.backend.parser;

import com.iip.datafusion.backend.job.algorithm.NameRecognitionJob;
import com.iip.datafusion.backend.job.algorithm.TextRankJob;
import com.iip.datafusion.nsps.model.NameRecognitionConfiguration;
import com.iip.datafusion.nsps.model.TextRankConfiguration;

/**
 * @Author Junnor.G
 * @Date 2018/2/1 下午4:19
 */
public class NameRecognitionParser implements Parser{
    public static NameRecognitionJob parse(NameRecognitionConfiguration configuration)throws Exception{

        NameRecognitionJob job = new NameRecognitionJob();

        job.setCorpusPath(configuration.getCorpusPath());
        job.setTableName(configuration.getTableName());
        job.setDataSourceId(configuration.getDataSourceId());
        return job;

    }
}
