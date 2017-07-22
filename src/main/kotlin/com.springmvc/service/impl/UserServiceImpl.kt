package com.springmvc.service.impl

import com.springmvc.Bean.User
import com.springmvc.mapper.UserMapper
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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

    /**
     * 检查用户名是否重复
     * @param user 从客户端传来的用户信息
     * @return <code>true</code>没有重复
     *         <code>false</code>用户名重复
     */
    override fun checkName(user: User): Boolean
    {
        val fuser = userMapper.findUserByName(user)
        if (fuser == null)
            return true
        else
            return true
    }

    /**
     * 修改用户信息
     * @param user 从客户端传来的用户信息
     * @return <code>true</code>修改成功
     *         <code>false</code>修改失败
     */
    override fun changeInfo(user: User): Boolean
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 用户登录
     * @param user 从客户端传来的用户信息
     * @return 返回具体的用户信息
     */
    override fun login(user: User): User
    {
        val fUser= userMapper.findUserByName(user)
        return user
    }

    /**
     * 忘记密码
     */
    override fun forget()
    {

    }

    /**
     * 用户注册
     * @param user 从客户端传来的用户信息
     * @return <code>true</code>注册成功
     *         <code>false</code>注册失败
     */
    override fun register(user: User): Boolean
    {
        val fuser = userMapper.findUserByName(user)
        if (fuser == null)
        {
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