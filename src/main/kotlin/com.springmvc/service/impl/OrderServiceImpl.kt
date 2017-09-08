package com.springmvc.service.impl

import com.springmvc.Bean.Order
import com.springmvc.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/26.
 */
@Service(value = "orderService")
class OrderServiceImpl: OrderService
{
    @Autowired private lateinit var orderService: OrderService

    override fun getOrderInfo(id : Int) : List<Order>
    {
        return orderService.getOrderInfo(id)
    }

    override fun getCartInfo(id : Int) : List<Order>
    {
        return orderService.getCartInfo(id)
    }

    override fun setOrderInfo(order : Order) : Int
    {
        return orderService.setOrderInfo(order)
    }

    override fun setCartInfo(order : Order) : Int
    {
        return orderService.setCartInfo(order)
    }

}
