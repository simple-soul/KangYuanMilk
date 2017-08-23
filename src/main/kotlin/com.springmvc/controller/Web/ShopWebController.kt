package com.springmvc.controller.Web

import com.springmvc.Bean.*
import com.springmvc.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ShopWebController
{
    @Autowired private lateinit var shopService: ShopService

    @RequestMapping("/compile")
    fun compile(): String
    {
        return "/WEB-INF/jsp/compile.jsp"
    }

    @RequestMapping("/activity")
    fun activity(): String
    {
        return "/WEB-INF/jsp/activity.jsp"
    }

    @RequestMapping("/goods")
    fun goods(): String
    {
        return "/WEB-INF/jsp/goods.jsp"
    }

    @ResponseBody
    @RequestMapping("/shop/findMilk", method = arrayOf(RequestMethod.POST))
    fun findMilk(@RequestBody query: Query): ServerResponse
    {
        println("findMilk客户端传来的数据----------->$query")
        return ServerResponse(200, DataResponse(true, shopService.search(query), shopService.getMilkCount()))
    }

    @ResponseBody
    @RequestMapping("/shop/findActivity", method = arrayOf(RequestMethod.POST))
    fun findActivity(@RequestBody query: Query): ServerResponse
    {
        println("findActivity客户端传来的数据----------->$query")
        return ServerResponse(200, ActivitiesResponse(true, shopService.searchActivity(query), shopService.getActivityCount()))
    }
}