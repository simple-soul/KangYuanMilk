package com.springmvc.controller.Android

import com.springmvc.Bean.*
import com.springmvc.service.OtherService
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by simple_soul on 2017/7/21 <br>
 */
/**
 * 关于用户的表现层操作
 */
@Controller
@RequestMapping("/android/user")
class UserController
{
    @Autowired lateinit var userService: UserService
    @Autowired lateinit var otherService: OtherService

    /**
     * 用户注册
     */
    @ResponseBody
    @RequestMapping("/register", method = arrayOf(RequestMethod.POST))
    fun register(@RequestBody user: User?): ServerResponse
    {
        println("register客户端传来的数据----------->$user")
        user?.user_name?.let { return ServerResponse(200, BooleanResponse(userService.register(user))) } ?: return ServerResponse(400)
    }

    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping("/login", method = arrayOf(RequestMethod.POST))
    fun login(@RequestBody user: User?): ServerResponse
    {
        println("login客户端传来的数据----------->$user")
        user?.user_name?.let {
            val result = userService.login(user)
            return ServerResponse(200, UserResponse(result !== null, result))
        } ?: return ServerResponse(400)
    }

    /**
     * 检查用户名是否重复
     */
    @ResponseBody
    @RequestMapping("/checkName", method = arrayOf(RequestMethod.POST))
    fun checkName(@RequestBody user: User?): ServerResponse
    {
        println("checkName客户端传来的数据----------->$user")
        user?.user_name?.let { return ServerResponse(200, BooleanResponse(userService.checkName(it))) } ?: return ServerResponse(400)
    }

    /**
     * 获取用户头像
     */
    @ResponseBody
    @RequestMapping("/getHead", method = arrayOf(RequestMethod.POST))
    fun getHead(@RequestBody user: User?): ServerResponse
    {
        println("getHead客户端传来的数据----------->$user")
        user?.user_name?.let {
            val result = userService.getUserHead(it)
            return ServerResponse(200, StringResponse(result != null, result))
        } ?: return ServerResponse(400)
    }

    /**
     * 获取用户所有地址信息
     */
    @ResponseBody
    @RequestMapping("/getAddress", method = arrayOf(RequestMethod.POST))
    fun getAddress(@RequestBody user: User?): ServerResponse
    {
        println("getAddress客户端传来的数据----------->$user")
        user?.user_id?.let {
            val list = userService.getUserAddress(it)
            val id = userService.getUserDefaultAddress(it)
            return ServerResponse(200, AddressResponse((list != null && id != null), list, id))
        } ?: return ServerResponse(400)
    }

    /**
     * 删除收货地址
     */
    @ResponseBody
    @RequestMapping("/deleteAddress", method = arrayOf(RequestMethod.POST))
    fun deleteAddress(@RequestBody address: Address?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address")
        address?.address_id?.let { return ServerResponse(200, BooleanResponse(userService.deleteAddress(it))) } ?: return ServerResponse(400)
    }

    /**
     * 设置默认收货地址
     */
    @ResponseBody
    @RequestMapping("/setDefaultAddress", method = arrayOf(RequestMethod.POST))
    fun setDefaultAddress(@RequestBody address: Address?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address")
        val result = ServerResponse(if (address?.address_id == null || address.user_id == null) 400 else 200)
        if (address?.address_id != null && address.user_id != null)
        {
            result.response.result = userService.setDefaultAddress(address)
        }
        return result
    }

    /**
     * 添加收货地址
     */
    @ResponseBody
    @RequestMapping("/setAddress", method = arrayOf(RequestMethod.POST))
    fun setAddress(@RequestBody address: Address?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address")
        val result = ServerResponse(if (address?.address_content == null || address.user_id == null) 400 else 200)
        if (address?.address_content != null && address.user_id != null)
        {
            result.response.result = userService.setAddress(address)
        }
        return result
    }

    /**
     * 更新用户数据
     */
    @ResponseBody
    @RequestMapping("/update", method = arrayOf(RequestMethod.POST))
    fun update(@RequestBody user: User?): ServerResponse
    {
        println("update客户端传来的数据----------->$user")
        user?.let { return ServerResponse(200, StringResponse(userService.changeInfo(it), otherService.getQiNiu())) } ?: return ServerResponse(400)
    }

    /**
     * 修改地址信息
     */
    @ResponseBody
    @RequestMapping("/changeAddress", method = arrayOf(RequestMethod.POST))
    fun changeAddress(@RequestBody address: Address?): ServerResponse
    {
        println("update客户端传来的数据----------->$address")
        address?.address_id?.let { return ServerResponse(200, BooleanResponse(userService.changeAddress(address))) } ?: return ServerResponse(400)
    }
}