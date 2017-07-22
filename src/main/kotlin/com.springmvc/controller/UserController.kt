package com.springmvc.controller

import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.User
import com.springmvc.Bean.UserResponse
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by simple_soul on 2017/7/21.
 */

@Controller
@RequestMapping("/user")
class UserController
{
    @Autowired lateinit var userService: UserService

    @ResponseBody
    @RequestMapping("/register", method = arrayOf(RequestMethod.POST))
    fun register(@RequestBody user: User): ServerResponse
    {
        println("user pass-------------->${user.pass}")
        println("user name-------------->${user.name}")
        val booleanResult = ServerResponse(200)
        booleanResult.response.result = userService.register(user)
        return booleanResult
    }

    @ResponseBody
    @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
    fun login(@RequestBody user: User): ServerResponse
    {
        val booleanResult = ServerResponse(200)
        val fuser = userService.login(user)
        val response = UserResponse(fuser != null)
        fuser?.apply { response.user = fuser }
        booleanResult.response = response
        return booleanResult
    }

    @ResponseBody
    @RequestMapping("/checkName", method = arrayOf(RequestMethod.POST))
    fun checkName(@RequestBody user: User): ServerResponse
    {
        val booleanResult = ServerResponse(200)
        booleanResult.response.result = userService.checkName(user)
        return booleanResult
    }

}