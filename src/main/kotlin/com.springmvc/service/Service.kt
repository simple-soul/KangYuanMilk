package com.springmvc.service

import com.springmvc.Bean.Address
import com.springmvc.Bean.Milk
import com.springmvc.Bean.MilkCategory
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
     * @return Boolean 注册是否成功
     */
    fun register(user: User): Boolean

    /**
     * 用户登录
     * @param user 从客户端传来的用户信息
     * @return User 返回具体的用户信息
     */
    fun login(user: User): User?

    /**
     * 忘记密码
     */
    fun forget()

    /**
     * 修改用户信息
     * @param user 从客户端传来的用户信息
     * @return Boolean 是否修改成功
     */
    fun changeInfo(user: User): Boolean

    /**
     * 检查用户名是否重复 {@link checkName}
     * @param name 从客户端传来的用户信息
     * @return Boolean 是否重复
     */
    fun checkName(name: String): Boolean

    /**
     * 通过用户名查找用户头像
     * @param name 用户名
     * @return String 用户头像的url路径
     */
    fun getUserHead(name: String): String?

    /**
     * 获取用户的所有地址信息
     * @param user 从客户端传来的用户信息
     * @return List<Address> 用户的所有地址信息
     */
    fun getUserAddress(user: User): List<Address>?

    /**
     * 获取用户的默认地址id
     * @param user 从客户端传来的用户信息
     * @return Int 用户的默认地址id
     */
    fun getUserDefaultAddress(user: User): Int?

    /**
     * 删除收货地址
     * @param id 收货地址的id
     * @return Boolean 是否删除成功
     */
    fun deleteAddress(id: Int): Boolean

    /**
     * 设置默认收货地址
     * @param id 收货地址的id
     * @return Boolean 是否设置成功
     */
    fun setDefaultAddress(id: Int): Boolean
}

interface StudentService
{
    fun account()
}

interface ShopService
{
    fun getMilkData(): List<Milk>?

    fun getMilkCategory(): List<MilkCategory>?
}