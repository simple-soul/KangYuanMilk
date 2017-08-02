package com.springmvc.controller.Web

import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.Staff
import com.springmvc.service.StaffWebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/web/staff")
class StaffWebController
{
    @Autowired lateinit var staffService: StaffWebService

    @RequestMapping("/login")
    fun login(): String
    {
        return "login"
    }

    @ResponseBody
    @RequestMapping("/login2", method = arrayOf(RequestMethod.POST))
    fun login2(session: HttpSession, @RequestBody staff: Staff?): ServerResponse
    {
        staff?.staff_pwd ?: return ServerResponse(400)
        //先验证身份
        if(staffService.login(staff))
        {
            //保存session
            session.setAttribute("name", staff.staff_name)

            return ServerResponse(200)
        }
        else
        {

        }
//        return "list"
        TODO()
    }
}