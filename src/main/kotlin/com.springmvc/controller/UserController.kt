package com.springmvc.controller

import com.springmvc.Bean.*
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

    /**
     * 用户注册
     */
    @ResponseBody
    @RequestMapping("/register", method = arrayOf(RequestMethod.POST))
    fun register(@RequestBody user: User): ServerResponse
    {
        println("客户端传来的数据----------->$user")
        val result = ServerResponse(200)
        result.response.result = userService.register(user)
        return result
    }

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
    fun login(@RequestBody user: User): ServerResponse
    {
        println("客户端传来的数据----------->$user")
        val result = ServerResponse(200)
        val fuser = userService.login(user)
        val response = UserResponse(fuser != null)
        fuser?.apply { response.user = fuser }
        result.response = response
        return result
    }

    /**
     * 检查用户名是否重复
     */
    @ResponseBody
    @RequestMapping("/checkName", method = arrayOf(RequestMethod.POST))
    fun checkName(@RequestBody user: User): ServerResponse
    {
        println("客户端传来的数据----------->$user")
        val result = ServerResponse(200)
        result.response.result = userService.checkName(user)
        return result
    }

    /**
     * 获取用户头像
     */
    @ResponseBody
    @RequestMapping("/getHead", method = arrayOf(RequestMethod.POST))
    fun getHead(@RequestBody name: String): ServerResponse
    {
        println("客户端传来的数据----------->$name")
        val result = ServerResponse(200)
        val headUrl = userService.getUserHead(name)
        val response =  StringResponse(headUrl != null)
        headUrl?.apply { response.message = headUrl }
        return result
    }

    /**
     * 获取用户所有地址信息
     */
    @ResponseBody
    @RequestMapping("/getAddress", method = arrayOf(RequestMethod.POST))
    fun getAddress(@RequestBody user: User): ServerResponse
    {
        println("客户端传来的数据----------->$user")
        val result = ServerResponse(200)
        val list = userService.getUserAddress(user)
        val id = userService.getUserDefaultAddress(user)
        val response: AddressResponse
        if(list != null && id != null)
        {
            response = AddressResponse(true)
            println("用户地址------$list")
            response.addresses = list
            response.defaultId = id
        }
        else
        {
            response = AddressResponse(false)
        }
        result.response = response
        return result
    }
}