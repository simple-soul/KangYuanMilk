package com.springmvc.service.impl

import com.springmvc.Bean.Distribution
import com.springmvc.Bean.Order
import com.springmvc.Bean.Query
import com.springmvc.Bean.State
import com.springmvc.mapper.OrderMapper
import com.springmvc.service.OrderService
import com.springmvc.utils.initCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/26.
 */
@Service(value = "orderService")
class OrderServiceImpl: OrderService
{
    override fun getOrderCount() : Int
    {
        return orderMapper.getOrderCount()
    }

    override fun updateOrder(state : State) : Boolean
    {
        return orderMapper.updateOrder(state) > 0
    }

    override fun searchOrder(query : Query) : List<Order>
    {
        query.page = (query.page-1)*query.num
        val array = ArrayList<Order>()
        when(query.level)
        {
            3 -> {
                query.level = null
                val list = orderMapper.searchOrder(query)
                list.forEach {
                    if(it.order_date!! > it.distribution_startdate && it.order_date!! < it.distribution_enddate)
                        array.add(it)
                }
            }

            1 -> {
                query.level = null
                val list = orderMapper.searchOrder(query)
                list.forEach {
                    if(it.order_date!! > it.distribution_enddate)
                        array.add(it)
                }
            }
            else -> return orderMapper.searchOrder(query)
        }
        return array
    }

    @Autowired private lateinit var orderMapper: OrderMapper

    override fun getOrderInfo(state : State) : List<Order>
    {
        val array = ArrayList<Order>()
        when(state.state)
        {
            3 -> {
                state.state = null
                val list = orderMapper.getOrderInfo(state)
                list.forEach {
                    if(it.order_date!! > it.distribution_startdate && it.order_date!! < it.distribution_enddate)
                        array.add(it)
                }
            }

            1 -> {
                state.state = null
                val list = orderMapper.getOrderInfo(state)
                list.forEach {
                    if(it.order_date!! > it.distribution_enddate)
                        array.add(it)
                }
            }
            else -> orderMapper.getOrderInfo(state)
        }
        return array
    }

    override fun setOrderInfo(order : Order) : Boolean
    {
        val dis = Distribution(null,order.distribution_startdate,order.distribution_enddate,order.distribution_renew)
        val id = orderMapper.setDistribution(dis)
        order.distribution_id = id
        order.order_number = initCode()
        return orderMapper.setOrderInfo(order) > 0
    }

    override fun setCartInfo(order : Order) : Boolean
    {
        val dis = Distribution(null,order.distribution_startdate,order.distribution_enddate,order.distribution_renew)
        val id = orderMapper.setDistribution(dis)
        order.distribution_id = id
        return orderMapper.setCartInfo(order) > 0
    }

}
