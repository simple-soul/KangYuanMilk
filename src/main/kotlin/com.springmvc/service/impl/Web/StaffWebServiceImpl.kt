package com.springmvc.service.impl.Web

import com.springmvc.Bean.Check
import com.springmvc.Bean.Query
import com.springmvc.Bean.Staff
import com.springmvc.mapper.StaffMapper
import com.springmvc.service.StaffWebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service(value = "StaffWebService")
class StaffWebServiceImpl : StaffWebService
{
    @Autowired lateinit var staffMapper: StaffMapper

    override fun login(check: Check): Boolean
    {
        val stf = staffMapper.findStaffByUsername(check)
        stf?.staff_pwd?.let { check.password?.let { if (it == check.password) return true } } ?: return false
        return false
    }

    override fun updatePassword(staff: Staff): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun searchStaffs(query: Query): List<Staff>
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}