package com.springmvc.service.impl

import com.springmvc.mapper.OtherMapper
import com.springmvc.service.OtherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/26.
 */
@Service(value = "otherService")
class OtherServiceImpl: OtherService
{
    @Autowired lateinit var otherMapper: OtherMapper

    override fun setQiNiu(domain: String): Boolean
    {
        return otherMapper.setDomainName(domain) > 0
    }

    override fun getQiNiu(): String
    {
        return otherMapper.getDomainName()
    }
}