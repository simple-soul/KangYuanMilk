package com.springmvc.service

import com.springmvc.Bean.*

/**
 * Created by simple_soul on 2017/7/15.
 */

/**
 *  对用户操作的业务层,实现详见 {@link com.springmvc.service.impl.UserServiceImpl}
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
     * @param user_id 用户id
     * @return List<Address> 用户的所有地址信息
     */
    fun getUserAddress(user_id: Int): List<Address>?

    /**
     * 获取用户的默认地址id
     * @param user_id 用户id
     * @return Int 用户的默认地址id
     */
    fun getUserDefaultAddress(user_id: Int): Int?

    /**
     * 删除收货地址
     * @param id 收货地址的id
     * @return Boolean 是否删除成功
     */
    fun deleteAddress(id: Int): Boolean

    /**
     * 设置默认收货地址
     * @param address 收货地址的id和用户id
     * @return Boolean 是否设置成功
     */
    fun setDefaultAddress(address: DefaultAddress): Boolean

    /**
     * 添加收货地址
     * @param address 收货地址的id和用户id
     * @return Boolean 是否添加成功
     */
    fun setAddress(address: DefaultAddress): Boolean

    /**
     * 获取用户信息
     * @param id 用户id
     * @return User 用户信息
     */
    fun getUserInfo(id: Int): User?
}

/**
 *  对用户操作的业务层,实现详见 {@link UserServiceImpl}
 */
interface ShopService
{
    /**
     * 获取牛奶数据
     * @return List<Milk> 所有的牛奶数据
     */
    fun getMilkData(): List<Milk>?

    /**
     * 获取牛奶分类
     * @return List<MilkCategory> 所有的牛奶分类
     */
    fun getMilkCategory(): List<MilkCategory>?
}

interface OrderService
{
    fun getOrderInfo(id: Int)

    fun getCartInfo(id: Int)

    fun setOrderInfo()

    fun setCartInfo()
}

interface OtherService
{
    fun getQiNiu(): String
}