package com.iip.datafusion.dgs.controller.integrity;

import com.iip.datafusion.backend.job.integrity.IntegrityJob;
import com.iip.datafusion.dgs.model.integrity.IntegrityConfiguration;
import com.iip.datafusion.dgs.service.integrity.IntegrityService;
import com.iip.datafusion.util.jsonutil.Result;
import com.iip.datafusion.util.userutil.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class IntegrityController {

    @Autowired
    IntegrityService integrityService;
    @Autowired
    UserManager userManager;

    @RequestMapping(path = {"/dgs/integrity/commitjob"}, method = RequestMethod.POST)
    @ResponseBody
    public Result checkIntegrity(@RequestBody IntegrityConfiguration integrityConfiguration) {
        System.out.println("Get checkIntegrity message");
        try{
            IntegrityJob integrityJob = integrityService.commitJob(integrityConfiguration,userManager.getUserId());
            while (integrityJob.getResult()==null){

            }
            Result res = integrityJob.getResult();
            //res.setMsg(integrityJob.getJobId());
            return res;
        }catch (Exception e){
            return new Result(0,e.getMessage(),null);
        }
        //return new Result();
    }
    /*
    @RequestMapping(path = {"/dgs/updateIntegrity"}, method = RequestMethod.POST)
    @ResponseBody
    public Result updateIntegrity(@RequestBody UpdateIntegrityConfiguration updateIntegrityConfiguration) {
        try{
            IntegrityJob integrityJob = UpdateIntegrityParser.parse(updateIntegrityConfiguration);
            return integrityJob.run();
        }catch (Exception e){
            return new Result(0,e.getMessage(),null);
        }
        //return new Result();
    }
    */


}
