package com.springmvc.service.impl

import com.springmvc.Bean.*
import com.springmvc.mapper.ShopMapper
import com.springmvc.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/24.
 */
@Service("shopService")
class ShopServiceImpl : ShopService
{
    override fun getClassify() : List<Classify>
    {
        return shopMapper.getClassify()
    }

    override fun searchActivity(query: Query): List<Activity>
    {
        query.page = (query.page-1)*query.num
        return shopMapper.searchActivity(query)
    }

    override fun getActivityCount(): Int
    {
        return shopMapper.getActivityCount()
    }

    override fun getMilkCount(): Int
    {
        return shopMapper.getMilkCount()
    }

    override fun getActivityById(activity_id: Int): Activity
    {
        return shopMapper.getActivityById(activity_id)
    }

    override fun getMilkById(milk_id: Int): Milk
    {
        return shopMapper.getMilkById(milk_id)
    }

    override fun getMilkByCategory(query: Query): List<Data>
    {
        return shopMapper.getMilkByCategory(query)
    }

    override fun search(query: Query): List<Data>
    {
        query.page = (query.page-1)*query.num
        return shopMapper.search(query)
    }

    override fun getIndex(): List<Result>
    {
        val classes = shopMapper.getClassify()
        val results = ArrayList<Result>()
        classes.forEach {
            val result = Result(it.classify_name, null, it.classify_type)
            when (it.classify_type)
            {
                "HEADER_BANNER", "NEW_ACTIVITY" -> result.dataInfoList = shopMapper.getActivityByClassify(it.classify_id)
                "HOT_PRODUCT" -> result.dataInfoList = shopMapper.getHotMilk()
                "NEW_PRODUCT" -> result.dataInfoList = shopMapper.getNewMilk()
            }
            results.add(result)
        }
        return results
    }

    @Autowired private lateinit var shopMapper: ShopMapper

    override fun getMilkData(pages: Pages): List<Milk>?
    {
        pages.page = pages.num * (pages.page - 1)
        return shopMapper.getMilkData(pages)
    }

    override fun getMilkCategory(): List<MilkCategory>?
    {
        return shopMapper.getMilkCategory()
    }

}