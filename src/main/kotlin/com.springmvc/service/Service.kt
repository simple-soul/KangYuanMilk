package com.springmvc.service

import com.springmvc.Bean.*

/**
 * Created by simple_soul on 2017/7/15.
 */

/**
 *  对用户操作的业务层,实现详见 {@link com.springmvc.service.impl.Android.UserServiceImpl}
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
    fun setDefaultAddress(address: Address): Boolean

    /**
     * 获取默认收货地址
     * @param user 用户信息
     * @return Address 地址信息
     */
    fun getDefaultAddress(user: User): Address?

    /**
     * 添加收货地址
     * @param address 收货地址的id和用户id
     * @return Boolean 是否添加成功
     */
    fun setAddress(address: Address): Boolean

    /**
     * 获取地址的全称(Utils)
     * @param list 需要获取全称的address对象
     * @return List<Address> 返回全称
     */
    fun getAllName(list: ArrayList<Address>): List<Address>

    /**
     * 更改收货地址
     * @param address 地址信息
     * @return Boolean 修改是否成功
     */
    fun changeAddress(address: Address): Boolean

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
    /**
     * 获取七牛云域名
     * @return String 返回域名
     */
    fun getQiNiu(): String

    /**
     * 修改七牛云域名
     * @param domain 现在的域名
     */
    fun setQiNiu(domain: String): Boolean

    /**
     * 获取全国地址
     * @return List<Ads> 地址列表
     */
    fun getAdsList(): List<Ads>
}

interface StaffWebService
{
    /**
     * 员工登录
     * @param check 验证信息
     * @return Staff 返回员工信息
     */
    fun login(check: Check): Staff?

    /**
     * 更新用户密码
     * @param check 验证信息(包含用户名和密码)
     * @return Boolean 是否成功
     */
    fun updatePassword(check: Check): Boolean

    /**
     * 搜索用户
     * @param query 一个查询信息(包括关键字和第几行)
     * @return List<Staff> 一组员工信息
     */
    fun searchStaffs(query: Query): List<Staff>?

    /**
     * 得到员工人数
     * @return Int 员工人数
     */
    fun getStaffCount(): Int

    /**
     * 忘记密码
     * @param staff 员工信息(进行对比验证)
     * @return Boolean 是否验证通过
     */
    fun forget(staff: Staff): Boolean

    /**
     * 删除员工信息
     * @param staff 员工信息
     * @return Boolean
     */
    fun delete(staff: Staff): Boolean

    /**
     * 修改员工信息
     * @param staff 员工信息
     * @return Boolean
     */
    fun update(staff: Staff): Boolean

    /**
     * 添加员工
     * @param staff 员工信息
     * @return Boolean
     */
    fun insert(staff: Staff): Boolean
}