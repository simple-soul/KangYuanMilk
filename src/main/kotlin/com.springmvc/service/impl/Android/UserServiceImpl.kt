package com.springmvc.service.impl.Android

import com.springmvc.Bean.Address
import com.springmvc.Bean.User
import com.springmvc.mapper.OtherMapper
import com.springmvc.mapper.UserMapper
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

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

    override fun getAllName(list: ArrayList<Address>): List<Address>
    {
        println("开始$list")
        for ((index, item) in list.withIndex())
        {
            val array = arrayListOf<String>()
            array.add(item.address_content!!)
            val id = item.ads_id
            if(id != null)
            {
                var ads = userMapper.findAdsById(id)
                array.add(ads.name)
                while (ads.parentId != 0)
                {
                    ads = userMapper.findAdsById(ads.parentId)
                    println(ads)
                    array.add(ads.name)
                }
            }
            else
            {
                list[index].address_content = array[0]
                break
            }
            println("array=$array,size=${array.size}")

            list[index].address_content = array.fold(StringBuffer()){acc,i -> acc.insert(0, i)}.toString()
        }
        println("最后$list")
        return list
    }

    override fun setAddress(address: Address): Boolean
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

    override fun setDefaultAddress(address: Address): Boolean
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
        val list = userMapper.findAddressListByUserId(user_id)
        return list?.let { getAllName(list as ArrayList<Address>) }
    }

    override fun getUserHead(name: String): String?
    {
        val head = userMapper.findHeadByName(name)
        return head
    }

    override fun checkName(name: String): Boolean
    {
        val fUser = userMapper.findUserByName(name)
        println("检查用户名---$fUser")
        return (fUser == null)
    }


    override fun changeInfo(user: User): Boolean
    {
        val result = userMapper.updateUser(user)
        return result > 0
    }


    override fun login(user: User): User?
    {
        val fUser = user.user_name?.let { userMapper.findUserByName(it) }
        fUser?.apply {
            if (fUser.user_pwd == user.user_pwd)
            {
                val address = fUser.address_id?.let { userMapper.findAddressById(it) }
                val list = ArrayList<Address>()
                address?.let { list.add(it) } ?: return fUser
                val array = getAllName(list)
                fUser.address_content = array[0].address_content
                return fUser
            }
        }
        return null
    }


    override fun forget()
    {
        TODO("忘记密码")
    }


    override fun register(user: User): Boolean
    {
        val fUser = user.user_name?.let { userMapper.findUserByName(it) }
        if (fUser == null)
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