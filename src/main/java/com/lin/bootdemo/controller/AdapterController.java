package com.lin.bootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.lin.bootdemo.model.Adapter;
import com.lin.bootdemo.service.AdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adapter")
public class AdapterController {

    @Autowired
    private AdapterService adapterService;


    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String test() {
        String[] ids = new String[1];
        ids[0] = "1";
        List<Adapter> adapters = adapterService.findByIds(ids);
        return JSON.toJSONString(adapters);
    }

}
