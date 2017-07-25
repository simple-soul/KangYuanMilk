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
open class UserServiceImpl : UserService
{
    override fun setDefaultAddress(id: Int): Boolean
    {
        val result = userMapper.setDefaultAddress(id)
        result?.let { return result > 0 }
        return false
    }

    override fun deleteAddress(id: Int): Boolean
    {
        val result = userMapper.deleteAddress(id)
        result?.let { return result > 0 }
        return false
    }

    @Autowired lateinit var userMapper: UserMapper

    override fun getUserDefaultAddress(user: User): Int?
    {
        val id = user.user_id?.let { userMapper.findDefaultAddressIdById(it) }
        return id
    }

    override fun getUserAddress(user: User): List<Address>?
    {
        val list = user.user_id?.let { userMapper.findAddressById(it) }
        return list
    }

    override fun getUserHead(name: String): String?
    {
        val head = userMapper.findHeadByName(name)
        return head
    }

    override fun checkName(name: String): Boolean
    {
        val fuser = userMapper.findUserByName(name)
        println("检查用户名---$fuser")
        return (fuser == null)
    }


    override fun changeInfo(user: User): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun login(user: User): User?
    {
        val fUser = user.user_name?.let { userMapper.findUserByName(it) }
        fUser?.apply {
            if (fUser.user_pwd == user.user_pwd)
                return user
        }
        return null
    }


    override fun forget()
    {

    }


    override fun register(user: User): Boolean
    {
        val fuser = userMapper.findUserByName(user.user_name!!)
        if (fuser == null)
        {
            user.user_registerdate = Date()
            val id = userMapper.addUser(user)
            if (id != null && id > 0)
                return true
            return false
        }
        else
            return true
    }
}