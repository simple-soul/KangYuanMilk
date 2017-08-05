package com.springmvc.controller.Web

import cn.dsna.util.images.ValidateCode
import com.springmvc.Bean.Check
import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.Staff
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
        //先验证身份
        if (staffService.login(check) && code == vCode)
        {
            val cookie = Cookie("kangyuan_name", check.username)
            //勾选了记住密码
            if (check.remember)
            {
                //保存session
                session.setAttribute("kangyuan_name", check.username)
                //设置cookie过期时间
                cookie.maxAge = 60 * 60 * 24 * 7
            }
            else
            {
                //保存session
                session.setAttribute("kangyuan_name", check.username)
                //设置cookie过期时间
                cookie.maxAge = 0
            }
            //发送cookie
            response.addCookie(cookie)

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
        return "/WEB-INF/jsp/index.jsp"
    }

    @RequestMapping("/getCode")
    fun getCode(session: HttpSession, response: HttpServletResponse)
    {
        response.contentType = "image/png"
        val vCode = ValidateCode(120,50,4,20)
        val code = vCode.code
        session.setAttribute("code", code)
        vCode.write(response.outputStream)
    }
}