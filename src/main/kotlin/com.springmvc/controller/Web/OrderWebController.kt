package com.springmvc.controller.Web

import com.springmvc.Bean.OrderResponse
import com.springmvc.Bean.Query
import com.springmvc.Bean.ServerResponse
import com.springmvc.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by simple_soul on 2017/9/8.
 */

@Controller
class OrderWebController
{
    @Autowired private lateinit var orderService: OrderService

    @RequestMapping("/order")
    fun order(): String
    {
        return "/WEB-INF/jsp/order.jsp"
    }

    @ResponseBody
    @RequestMapping("/searchOrder", method = arrayOf(RequestMethod.POST))
    fun searchOrder(@RequestBody query : Query): ServerResponse
    {
        return ServerResponse(200, OrderResponse(true, orderService.searchOrder(query), orderService.getOrderCount()))
    }
}