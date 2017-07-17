package com.springmvc.controller

import com.springmvc.Bean.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * Created by simple_soul on 2017/7/15.
 */
@Controller
class TestController
{
    @ResponseBody
    @RequestMapping("/getJson", method = arrayOf(RequestMethod.POST), consumes = arrayOf("application/json"))
    fun getJson(@RequestBody user: User): User
    {
        return user
    }

    @ResponseBody
    @RequestMapping("/test")
    fun test(request: HttpServletRequest, response: HttpServletResponse): User
    {
        println(request.getParameter("name"))

        response.characterEncoding = "utf-8"
        response.contentType = "application/json;charset=utf-8"
        val user2 = User("barry")
        return user2
    }

    @RequestMapping("/hello")
    fun hello()
    {

    }
}