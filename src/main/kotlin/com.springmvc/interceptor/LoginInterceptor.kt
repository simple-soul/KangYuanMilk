package com.springmvc.interceptor

import com.google.gson.Gson
import com.springmvc.Bean.Check
import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.StringResponse
import com.springmvc.exception.SystemException
import com.springmvc.service.StaffWebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 登录拦截器(拦截所有页面并验证是否登录)
 */
class LoginInterceptor : HandlerInterceptor
{
    @Autowired lateinit var staffService: StaffWebService
    /**
     * 进入页面前,拦截判断
     */
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean
    {
        request?.requestURL?.let {
            request.session?.getAttribute("kangyuan_name")?.let { return true } ?: request.cookies?.let {
                var name: String? = null
                var pass: String? = null
                it.forEach {
                    if (it.name == "kangyuan_name")
                        name = it.value
                    if (it.name == "kangyuan_pass")
                        pass = it.value
                }
                if (name != null && pass != null)
                {
                    val staff = staffService.login(Check(name!!, pass!!))
                    if(staff != null && staff.staff_pwd == pass)
                    {
                        request.session.setAttribute("kangyuan_name", name)
                        return true
                    }
                }

                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response)
            }
        } ?: return false
        return false
    }

    /**
     * 加载页面前,可以加入导航栏等
     */
    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?)
    {

    }

    /**
     * 出现异常时进行处理
     */
    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?)
    {

    }
}