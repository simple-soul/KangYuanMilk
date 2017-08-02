package com.springmvc.interceptor

import com.google.gson.Gson
import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.StringResponse
import com.springmvc.exception.SystemException
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
    /**
     * 进入页面前,拦截判断
     */
    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean
    {
        request?.requestURL?.let {
            request.session?.getAttribute("name")?.let { return true } ?: request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response)
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
        val systemException: SystemException?
        val result: ServerResponse = ServerResponse(500)
        if (null != ex)
        {
            if (ex.message != null && ex is Exception)
            {
                systemException = SystemException(ex.message!!)
            }
            else
            {
                systemException = SystemException("服务器发生未知错误")
            }
            println("服务器错误----------->${ex.message}")
        }
        else
        {
            systemException = SystemException("服务器发生未知错误")
        }

        result.response = StringResponse(false, systemException.message)
        val gson = Gson()
        response?.writer!!.write(gson.toJson(result))
    }
}