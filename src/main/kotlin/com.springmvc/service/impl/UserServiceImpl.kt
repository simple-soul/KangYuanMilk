package com.springmvc.service.impl

import com.springmvc.Bean.Address
import com.springmvc.Bean.DefaultAddress
import com.springmvc.Bean.User
import com.springmvc.mapper.OtherMapper
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
    @Autowired lateinit var userMapper: UserMapper
    @Autowired lateinit var otherMapper: OtherMapper

    override fun getUserInfo(id: Int): User?
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setAddress(address: DefaultAddress): Boolean
    {
        val result = userMapper.setAddress(address)
        val dResult = userMapper.setDefaultAddress(address)
        if (result != null && dResult != null)
        {
            if (result > 0 && dResult > 0)
            {
                return true
            }
        }
        return false
    }

    override fun setDefaultAddress(address: DefaultAddress): Boolean
    {
        val result = userMapper.setDefaultAddress(address)
        result?.let { return result > 0 }
        return false
    }

    override fun deleteAddress(id: Int): Boolean
    {
        val result = userMapper.deleteAddress(id)
        result?.let { return result > 0 }
        return false
    }

    override fun getUserDefaultAddress(user_id: Int): Int?
    {
        val id = userMapper.findDefaultAddressIdById(user_id)
        return id
    }

    override fun getUserAddress(user_id: Int): List<Address>?
    {
        val list = userMapper.findAddressById(user_id)
        return list
    }

    override fun getUserHead(name: String): String?
    {
        val head = userMapper.findHeadByName(name)
        val domainName = otherMapper.getDomainName()
        return head?.let { domainName+it }
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
        val head = user.user_name?.let { getUserHead(it) }
        fUser?.apply {
            if (fUser.user_pwd == user.user_pwd)
            {
                fUser.user_head =head
                return fUser
            }

        }
        return null
    }


    override fun forget()
    {

    }


    override fun register(user: User): Boolean
    {
        val fuser = user.user_name?.let { userMapper.findUserByName(it) }
        if (fuser == null)
        {
            user.user_registerdate = Date()
            val user_id = userMapper.addUser(user)
            if (user_id != null && user_id > 0)
                return true
            return false
        }
        else
            return false
    }
}