package com.springmvc.controller.Web

import cn.dsna.util.images.ValidateCode
import com.springmvc.Bean.*
import com.springmvc.service.StaffWebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/web")
class StaffWebController
{
    @Autowired lateinit var staffService: StaffWebService

    @RequestMapping("/login")
    fun login(response: HttpServletResponse, session: HttpSession): String
    {
        //安全退出
        session.invalidate()
        val cookie = Cookie("kangyuan_name", "")
        cookie.maxAge = 0
        response.addCookie(cookie)

        return "/WEB-INF/jsp/login.jsp"
    }

    @ResponseBody
    @RequestMapping("/login2", method = arrayOf(RequestMethod.POST))
    fun login2(session: HttpSession, response: HttpServletResponse, @RequestBody check: Check): ServerResponse
    {
        println("login2客户端传来的数据----------->$check")
        val code = check.code.toLowerCase()
        val vCode = session.getAttribute("code").toString().toLowerCase()
        println("vCode-------->$vCode")
        val staff = staffService.login(check)
        val cookies = ArrayList<Cookie>()
        //先验证身份
        if (staff != null && staff.staff_pwd == check.password && code == vCode)
        {
            cookies.add(Cookie("kangyuan_name", staff.staff_name))
            cookies.add(Cookie("kangyuan_pass", staff.staff_pwd))
            cookies.add(Cookie("kangyuan_lv", "${staff.staff_authority}"))

            //勾选了记住密码
            if (check.remember)
            {
                //设置cookie过期时间
                cookies.forEach { it.maxAge = 60 * 60 * 24 * 7 }
            }
            //保存session
            session.setAttribute("kangyuan_name", check.username)
            //发送cookie
            cookies.forEach { response.addCookie(it) }

            return ServerResponse(200)
        }
        else
        {
            val s = ServerResponse(200)
            s.response.result = false
            return s
        }
    }

    @RequestMapping("/index")
    fun index(): String
    {
        return "/WEB-INF/jsp/frame.jsp"
    }
    @RequestMapping("/index2")
    fun index2(): String
    {
        return "/WEB-INF/jsp/index.jsp"
    }
    @RequestMapping("/address")
    fun address(): String
    {
        return "/WEB-INF/jsp/address.jsp"
    }
    @RequestMapping("/staff")
    fun staff(): String
    {
        return "/WEB-INF/jsp/staff.jsp"
    }

    @RequestMapping("/getCode")
    fun getCode(session: HttpSession, response: HttpServletResponse)
    {
        response.contentType = "image/png"
        val vCode = ValidateCode(120, 50, 4, 20)
        val code = vCode.code
        session.setAttribute("code", code)
        vCode.write(response.outputStream)
    }

    @ResponseBody
    @RequestMapping("/forget", method = arrayOf(RequestMethod.POST))
    fun forget(@RequestBody staff: Staff): ServerResponse
    {
        println("forget客户端传来的数据----------->$staff")

        return ServerResponse(200, BooleanResponse(staffService.forget(staff)))
    }

    @ResponseBody
    @RequestMapping("/change", method = arrayOf(RequestMethod.POST))
    fun change(request: HttpServletRequest, pass: String): ServerResponse
    {
        println("change客户端传来的数据----------->$pass")
        var name: String? = null
        request.cookies.forEach { if(it.name == "kangyuan_name") name = it.value}
        return ServerResponse(200, BooleanResponse(staffService.updatePassword(Check(name!!, pass))))
    }


    @ResponseBody
    @RequestMapping("/findStaff")
    fun findStaff(@RequestBody query: Query): ServerResponse
    {
        println("findStaff客户端传来的数据----------->$query")
        val result = staffService.searchStaffs(query)
        return ServerResponse(200, StaffsResponse(result != null, result, staffService.getStaffCount()))
    }
}