package com.springmvc.service.impl

import com.springmvc.Bean.Address
import com.springmvc.Bean.User
import com.springmvc.mapper.UserMapper
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 * Created by simple_soul on 2017/7/15.
 */
/**
 *  关于用户的功能的业务层的具体实现类
 */
@Service("userService")
open class UserServiceImpl:  UserService
{
    @Autowired lateinit var userMapper: UserMapper

    override fun getUserDefaultAddress(user: User): Int?
    {
        val id = userMapper.findDefaultAddressIdById(user)
        return id
    }

    override fun getUserAddress(user: User): List<Address>?
    {
        val list = userMapper.findAddressById(user)
        return list
    }

    override fun getUserHead(name: String): String?
    {
        val head = userMapper.findHeadByName(name)
        return head
    }

    override fun checkName(user: User): Boolean
    {
        val fuser = userMapper.findUserByName(user)
        println("检查用户名---$fuser")
        return (fuser == null)
    }


    override fun changeInfo(user: User): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun login(user: User): User
    {
        val fUser= userMapper.findUserByName(user)
        return user
    }


    override fun forget()
    {

    }


    override fun register(user: User): Boolean
    {
        val fuser = userMapper.findUserByName(user)
        if (fuser == null)
        {
            user.date = Date()
            val id = userMapper.addUser(user)
            if (id != null && id > 0)
            {
                return true
            }
            return false
        }
        else
            return true
    }
}