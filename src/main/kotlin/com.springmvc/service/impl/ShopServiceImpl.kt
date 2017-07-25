package com.springmvc.service.impl

import com.springmvc.Bean.Milk
import com.springmvc.Bean.MilkCategory
import com.springmvc.mapper.ShopMapper
import com.springmvc.service.ShopService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/24.
 */
@Service("shopService")
class ShopServiceImpl: ShopService
{
    @Autowired lateinit var shopMapper: ShopMapper

    override fun getMilkData(): List<Milk>?
    {

        return shopMapper.getMilkData()
    }

    override fun getMilkCategory(): List<MilkCategory>?
    {
        return shopMapper.getMilkCategory()
    }

}