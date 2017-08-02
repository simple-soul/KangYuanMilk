package com.springmvc.service.impl.Web

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

    override fun login(staff: Staff): Boolean
    {
        val stf = staffMapper.findStaffByUsername(staff)
        stf?.staff_pwd?.let { staff.staff_pwd?.let { if (it == staff.staff_pwd) return true } } ?: return false
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