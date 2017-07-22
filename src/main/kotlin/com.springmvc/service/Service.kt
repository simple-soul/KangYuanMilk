package com.springmvc.service

import com.springmvc.Bean.Address
import com.springmvc.Bean.User

/**
 * Created by simple_soul on 2017/7/15.
 */

/**
 *  对用户操作的业务层,实现详见 {@link UserServiceImpl}
 */
interface UserService
{
    /**
     * 用户注册(二次检查用户名是否重复)
     * @param user 从客户端传来的用户信息
     * @return <code>true</code>注册成功
     *         <code>false</code>注册失败
     */
    fun register(user: User): Boolean

    /**
     * 用户登录
     * @param user 从客户端传来的用户信息
     * @return 返回具体的用户信息
     */
    fun login(user: User): User?

    /**
     * 忘记密码
     */
    fun forget()

    /**
     * 修改用户信息
     * @param user 从客户端传来的用户信息
     * @return <code>true</code>修改成功
     *         <code>false</code>修改失败
     */
    fun changeInfo(user: User): Boolean

    /**
     * 检查用户名是否重复
     * @param user 从客户端传来的用户信息
     * @return <code>true</code>没有重复
     *         <code>false</code>用户名重复
     */
    fun checkName(user: User): Boolean

    /**
     * 通过用户名查找用户头像
     * @param name 用户名
     * @return 用户头像的url路径
     */
    fun getUserHead(name: String): String?

    /**
     * 获取用户的所有地址信息
     * @param user 从客户端传来的用户信息
     * @return 用户的所有地址信息
     */
    fun getUserAddress(user: User): List<Address>?

    /**
     * 获取用户的默认地址id
     * @param user 从客户端传来的用户信息
     * @return 用户的默认地址id
     */
    fun getUserDefaultAddress(user: User): Int?
}

interface StudentService
{
    fun account()
}