package com.springmvc.controller.Android

import com.springmvc.Bean.*
import com.springmvc.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by simple_soul on 2017/7/24.
 */
@Controller
@RequestMapping("/android/shop")
class ShopController
{
    @Autowired private lateinit var shopService: ShopService

    /**
     * 获取牛奶数据
     */
    @ResponseBody
    @RequestMapping("/getMilkData", method = arrayOf(RequestMethod.POST))
    fun getMilkData(@RequestBody pages: Pages): ServerResponse
    {
        return if(pages.page != 0)
            ServerResponse(200, MilksResponse(true, shopService.getMilkData(pages)))
        else
            ServerResponse(400)
    }

    /**
     * 获取牛奶分类
     */
    @ResponseBody
    @RequestMapping("/getMilkCategory", method = arrayOf(RequestMethod.POST))
    fun getMilkCategory(): ServerResponse
    {
        return ServerResponse(200, MilkCategoryResponse(true, shopService.getMilkCategory()))
    }

    /**
     * 获取首页信息
     */
    @ResponseBody
    @RequestMapping("/getIndex", method = arrayOf(RequestMethod.POST))
    fun getIndex(): ServerResponse
    {
        return ServerResponse(200, ResultsResponse(true, shopService.getIndex()))
    }

    /**
     * 根据id获取活动信息
     */
    @ResponseBody
    @RequestMapping("/getActivityById/{id}", method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun getActivityById(@PathVariable("id") id: Int): ServerResponse
    {
        return ServerResponse(200, ActivityResponse(true, shopService.getActivityById(id)))
    }

    /**
     * 根据id获取牛奶信息
     */
    @ResponseBody
    @RequestMapping("/getMilkById/{id}", method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun getMilkById(@PathVariable("id") id: Int): ServerResponse
    {
        return ServerResponse(200, MilkResponse(true, shopService.getMilkById(id)))
    }

    /**
     * 根据分类获取牛奶列表
     */
    @ResponseBody
    @RequestMapping("/getMilkByCategory/{id}/{page}/{num}", method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun getMilkByCategory(@PathVariable("id") id: Int, @PathVariable("page") page: Int, @PathVariable("num") num: Int): ServerResponse
    {
        val query = Query("", id, (page-1)*num, num)
        return ServerResponse(200, DataResponse(true, shopService.getMilkByCategory(query)))
    }

    /**
     * 搜索商品
     */
    @ResponseBody
    @RequestMapping("/search", method = arrayOf(RequestMethod.POST))
    fun search(@RequestBody query: Query): ServerResponse
    {
        return ServerResponse(200, DataResponse(true, shopService.search(query)))
    }
}

