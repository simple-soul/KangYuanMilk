package com.springmvc.controller.Android

import com.springmvc.Bean.*
import com.springmvc.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by simple_soul on 2017/9/8.
 */
@Controller
@RequestMapping("/android/order")
class OrderController
{
    @Autowired private lateinit var orderService: OrderService

    @ResponseBody
    @RequestMapping("/getOrderInfo/{user_id}/{state}", method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun getOrderInfo(@PathVariable("user_id") user_id: Int, @PathVariable("state") state: Int): ServerResponse
    {
        return ServerResponse(200, OrderResponse(true, orderService.getOrderInfo(State(user_id, state))))
    }

    @ResponseBody
    @RequestMapping("/updateOrder/{order_id}/{state}", method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun updateOrder(@PathVariable("order_id") order_id: Int, @PathVariable("state") state: Int): ServerResponse
    {
        return ServerResponse(200, BooleanResponse(orderService.updateOrder(State(order_id, state))))
    }

    @ResponseBody
    @RequestMapping("/setOrderInfo", method = arrayOf(RequestMethod.POST))
    fun setOrderInfo(@RequestBody order : Order): ServerResponse
    {
        return ServerResponse(200, BooleanResponse(orderService.setOrderInfo(order)))
    }

    @ResponseBody
    @RequestMapping("/setCartInfo", method = arrayOf(RequestMethod.POST))
    fun setCartInfo(@RequestBody order : Order): ServerResponse
    {
        return ServerResponse(200, BooleanResponse(orderService.setCartInfo(order)))
    }
}