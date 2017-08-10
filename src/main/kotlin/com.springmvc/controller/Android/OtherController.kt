package com.springmvc.controller.Android

import com.springmvc.Bean.AdsResponse
import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.StringResponse
import com.springmvc.service.OtherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/android/other")
class OtherController
{
    @Autowired lateinit var otherService: OtherService

    @ResponseBody
    @RequestMapping("/getQiniu", method = arrayOf(RequestMethod.POST))
    fun getQiniu(): ServerResponse
    {
        return ServerResponse(200, StringResponse(true, otherService.getQiNiu()))
    }

    @ResponseBody
    @RequestMapping("/getAdsList", method = arrayOf(RequestMethod.POST))
    fun getAdsList(): ServerResponse
    {
        return ServerResponse(200, AdsResponse(true, otherService.getAdsList()))
    }
}