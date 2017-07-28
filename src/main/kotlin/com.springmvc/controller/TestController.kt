package com.springmvc.controller

import com.springmvc.Bean.Address
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by simple_soul on 2017/7/28.
 */
@Controller
class TestController
{
    @RequestMapping("/first")
    fun first(): ModelAndView
    {
        val mav = ModelAndView()
        mav.viewName ="test.jsp"
        val address = Address(1, "王家村89号")
        mav.addObject("address", address)
        return mav
    }
}