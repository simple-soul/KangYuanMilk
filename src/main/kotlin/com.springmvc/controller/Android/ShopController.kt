package com.springmvc.controller.Android

import com.springmvc.Bean.MilkCategoryResponse
import com.springmvc.Bean.MilkResponse
import com.springmvc.Bean.Pages
import com.springmvc.Bean.ServerResponse
import com.springmvc.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by simple_soul on 2017/7/24.
 */
@Controller
@RequestMapping("/android/shop")
class ShopController
{
    @Autowired lateinit var shopService: ShopService

    /**
     * 获取牛奶数据
     */
    @ResponseBody
    @RequestMapping("/getMilkData", method = arrayOf(RequestMethod.POST))
    fun getMilkData(@RequestBody pages: Pages): ServerResponse
    {
        val result = ServerResponse(200)
        val milks = shopService.getMilkData()
        val response = MilkResponse(milks != null)
        milks?.let { response.milks = it }
        result.response = response
        return result
    }

    /**
     * 获取牛奶分类
     */
    @ResponseBody
    @RequestMapping("/getMilkCategory", method = arrayOf(RequestMethod.POST))
    fun getMilkCategory(): ServerResponse
    {
        val result = ServerResponse(200)
        val category = shopService.getMilkCategory()
        val response = MilkCategoryResponse(category != null)
        category?.let { response.milkCategory = it }
        result.response = response
        return result
    }
}

