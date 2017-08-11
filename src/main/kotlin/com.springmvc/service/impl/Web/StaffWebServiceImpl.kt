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
    override fun insert(staff: Staff): Boolean
    {
        return staffMapper.insertStaff(staff) > 0
    }

    override fun update(staff: Staff): Boolean
    {
        return staffMapper.updateStaff(staff) > 0
    }

    override fun delete(staff: Staff): Boolean
    {
        return staffMapper.deleteStaff(staff) > 0
    }

    override fun forget(staff: Staff): Boolean
    {
        val fStaff = staff.staff_idcard?.let { staffMapper.findStaffByIdcard(it)}
        if(fStaff != null && fStaff.staff_name == staff.staff_name && fStaff.staff_tel == staff.staff_tel)
        {
            return staffMapper.updatePassword(Check(fStaff.staff_username!!, staff.staff_pwd)) > 0
        }
        return false
    }

    override fun getStaffCount(): Int
    {
        return staffMapper.getStaffsCount()
    }

    @Autowired lateinit var staffMapper: StaffMapper

    override fun login(check: Check): Staff?
    {
        return staffMapper.findStaffByUsername(check)
    }

    override fun updatePassword(check: Check): Boolean
    {
        return staffMapper.updatePassword(check) > 0
    }

    override fun searchStaffs(query: Query): List<Staff>?
    {
        return staffMapper.findStaffs(query)
    }
}