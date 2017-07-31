package com.springmvc.controller

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
@RequestMapping("/user")
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
        val result = ServerResponse(if (user?.user_name == null) 400 else 200)
        user?.user_name?.let { result.response.result = userService.register(user) }
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
        val result = ServerResponse(if (user?.user_name == null) 400 else 200)
        val fuser = user?.let { userService.login(it) }
        result.response = UserResponse(fuser != null, fuser?.let{ it })
        return result
    }

    /**
     * 检查用户名是否重复
     */
    @ResponseBody
    @RequestMapping("/checkName", method = arrayOf(RequestMethod.POST))
    fun checkName(@RequestBody user: User?): ServerResponse
    {
        println("checkName客户端传来的数据----------->$user")
        val result = ServerResponse(if (user?.user_name == null) 400 else 200)
        user?.user_name?.apply { result.response.result = userService.checkName(user.user_name!!) }
        return result
    }

    /**
     * 获取用户头像
     */
    @ResponseBody
    @RequestMapping("/getHead", method = arrayOf(RequestMethod.POST))
    fun getHead(@RequestBody user: User?): ServerResponse
    {
        println("getHead客户端传来的数据----------->$user")
        val result = ServerResponse(if (user == null) 400 else 200)
        val headUrl = user?.user_name?.let { userService.getUserHead(it) }
        println("获取用户头像--------->$headUrl"+(headUrl != null))
        result.response = StringResponse(headUrl != null, headUrl?.let { it })
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
        val list = user?.user_id?.let { userService.getUserAddress(it) }
        val id = user?.user_id?.let { userService.getUserDefaultAddress(it) }
        result.response = if(list != null && id != null)
            AddressResponse(true, list, id)
        else
            AddressResponse(false)

        return result
    }

    /**
     * 删除收货地址
     */
    @ResponseBody
    @RequestMapping("/deleteAddress", method = arrayOf(RequestMethod.POST))
    fun deleteAddress(@RequestBody address: Address?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address")
        val result = ServerResponse(if (address?.address_id == null) 400 else 200)
        address?.address_id?.let { result.response.result = userService.deleteAddress(it) }
        return result
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
        if(address?.address_id != null && address.user_id != null)
        {
            result.response.result = userService.setDefaultAddress(address)
        }
        return result
    }

    /**
     * 添加收货地址并设为默认
     */
    @ResponseBody
    @RequestMapping("/setAddress", method = arrayOf(RequestMethod.POST))
    fun setAddress(@RequestBody address: Address?): ServerResponse
    {
        println("deleteAddress客户端传来的数据----------->$address")
        val result = ServerResponse(if (address?.address_content == null || address.user_id == null) 400 else 200)
        if(address?.address_content != null && address.user_id != null)
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
        val result = ServerResponse(if(user == null)400 else 200)
        result.response = StringResponse(user?.let { userService.changeInfo(it) }?:false, otherService.getQiNiu())
        return result
    }
}