package com.springmvc.exception

import com.google.gson.Gson
import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.StringResponse
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by simple_soul on 2017/7/21.
 */
/**
 * 服务器异常解析器，处理出现的异常，并以json形式返回客户端,继承自 @link #HandlerExceptionResolver
 */
class SystemExceptionResolver : HandlerExceptionResolver
{
    override fun resolveException(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?): ModelAndView
    {
        val systemException: SystemException?
        val result: ServerResponse?

        if (null != ex)
        {
            if (ex.message != null && ex is Exception)
            {
                systemException = SystemException(ex.message!!)
                result = ServerResponse(500)
            }
            else
            {
                systemException = SystemException("服务器发生未知错误")
                result = ServerResponse(501)
            }
        }
        else
        {
            systemException = SystemException("服务器发生未知错误")
            result = ServerResponse(501)
        }

        val res = StringResponse(false)
        res.message = systemException.message
        result.response = res
        val gson = Gson()
        response?.writer!!.write(gson.toJson(result))

        return ModelAndView()
    }
}