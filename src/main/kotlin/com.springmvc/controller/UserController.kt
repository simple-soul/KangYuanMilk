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
    fun register(@RequestBody user: User?): ServerResponse
    {
        println("register客户端传来的数据----------->$user")
        val result = ServerResponse(if (user == null) 400 else 200)
        user?.let { result.response.result = userService.register(it) }
        return result
    }

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
    fun login(@RequestBody user: User?): ServerResponse
    {
        println("login客户端传来的数据----------->$user")
        val result = ServerResponse(if (user == null) 400 else 200)
        val fuser = user?.let { userService.login(it) }
        val response = UserResponse(fuser != null)
        fuser?.apply { response.user = fuser }
        result.response = response
        return result
    }

    /**
     * 检查用户名是否重复
     */
    @ResponseBody
    @RequestMapping("/checkName", method = arrayOf(RequestMethod.POST, RequestMethod.GET))
    fun checkName(user_name: String?): ServerResponse
    {
        println("checkName客户端传来的数据----------->$user_name")
        val result = ServerResponse(if (user_name == null) 400 else 200)
        user_name?.apply { result.response.result = userService.checkName(user_name) }
        return result
    }

    /**
     * 获取用户头像
     */
    @ResponseBody
    @RequestMapping("/getHead", method = arrayOf(RequestMethod.POST, RequestMethod.GET))
    fun getHead(user_name: String?): ServerResponse
    {
        println("getHead客户端传来的数据----------->$user_name")
        val result = ServerResponse(if (user_name == null) 400 else 200)
        val headUrl = user_name?.let { userService.getUserHead(it) }
        println("获取用户头像--------->$headUrl"+(headUrl != null))
        val response =  StringResponse(headUrl != null)
        headUrl?.apply { response.message = headUrl }
        result.response = response
        return result
    }

    /**
     * 获取用户所有地址信息
     */
    @ResponseBody
    @RequestMapping("/getAddress", method = arrayOf(RequestMethod.POST))
    fun getAddress(@RequestBody user: User?): ServerResponse
    {
        println("getAddress客户端传来的数据----------->$user")
        val result = ServerResponse(if (user == null) 400 else 200)
        val list = user?.let { userService.getUserAddress(it) }
        val id = user?.let { userService.getUserDefaultAddress(it) }
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

    /**
     * 删除收货地址
     */
    @ResponseBody
    @RequestMapping("/deleteAddress", method = arrayOf(RequestMethod.POST, RequestMethod.GET))
    fun deleteAddress(address_id: Int?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address_id")
        val result = ServerResponse(if (address_id == null) 400 else 200)
        address_id?.let { result.response.result = userService.deleteAddress(it) }
        return result
    }

    /**
     * 设置默认收货地址
     */
    @ResponseBody
    @RequestMapping("/setDefaultAddress", method = arrayOf(RequestMethod.POST, RequestMethod.GET))
    fun setDefaultAddress(address_id: Int?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address_id")
        val result = ServerResponse(if (address_id == null) 400 else 200)
        address_id?.let { result.response.result = userService.setDefaultAddress(it) }
        return result
    }
}