package com.springmvc.controller.Web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by simple_soul on 2017/9/8.
 */

@Controller
class OrderWebController
{
    @ResponseBody
    @RequestMapping("/order")
    fun order(): String
    {
        return "/WEB-INF/jsp/order.jsp"
    }
}