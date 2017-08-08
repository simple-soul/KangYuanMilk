package com.springmvc.controller.Android

import com.springmvc.Bean.Address
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

/**
 * Created by simple_soul on 2017/7/28.
 */
@Controller
class TestController
{
    @RequestMapping("/test")
    fun first(): ModelAndView
    {
        val mav = ModelAndView()
        mav.viewName ="test"
        return mav
    }

    @RequestMapping("/requestJson",method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    @ResponseBody
    fun requestJson(@RequestBody address: Address): Address
    {
        println("requestJson接收到了------>$address")
        return address
    }
}