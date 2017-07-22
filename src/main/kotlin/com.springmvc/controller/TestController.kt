package com.springmvc.controller

import com.springmvc.Bean.User
import com.springmvc.exception.SystemException
import com.springmvc.service.StudentService
import com.springmvc.service.UserService
import com.springmvc.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * Created by simple_soul on 2017/7/15.
 */
@Controller
@RequestMapping("/test")
class TestController
{
    @Autowired lateinit var userService: UserService
    @Autowired lateinit var studentService: StudentService

    @ResponseBody
    @RequestMapping("/getJson", method = arrayOf(RequestMethod.POST), consumes = arrayOf("application/json"))
    fun getJson(@RequestBody user: User): User
    {
        return user
    }

    @RequestMapping("/tx", method = arrayOf(RequestMethod.POST), consumes = arrayOf("application/json"))
    fun register(response: HttpServletResponse)
    {
        studentService.account()
    }
}