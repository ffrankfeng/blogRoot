package com.fengf.bms.controller;

import com.fengf.bms.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/blog-manager")
public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @RequestMapping(value = "/dataupdate",method = RequestMethod.GET)
    public String dataupdate(){
        return "dataupdate";
    }
    @RequestMapping(value = "/updateRedis",method = RequestMethod.POST)
    @ResponseBody
    public void updateRedis(HttpServletResponse response) throws IOException {
        boolean isFinish = updateService.updateRedis();
        response.getWriter().write("{\"isFinish\":\""+isFinish+"\"}");
    }

    @RequestMapping(value = "/updateSolr",method = RequestMethod.POST)
    @ResponseBody
    public void updateSolr(HttpServletResponse response) throws IOException {
        boolean isFinish = updateService.updateSolr();
        response.getWriter().write("{\"isFinish\":\""+isFinish+"\"}");
    }
}
