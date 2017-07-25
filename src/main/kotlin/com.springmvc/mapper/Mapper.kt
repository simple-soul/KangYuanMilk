package com.springmvc.mapper

import com.springmvc.Bean.*

/**
 * Created by simple_soul on 2017/7/19.
 */
/**
 * 关于用户的数据库操作
 */
interface UserMapper
{
    fun addUser(user: User): Int?

    fun findUserByName(name: String): User?

    fun findUserById(id: Int): User?

    fun updateUser(user: User):Int?

    fun findHeadByName(name: String):String?

    fun findAddressById(id: Int):List<Address>?

    fun findDefaultAddressIdById(id: Int):Int?

    fun deleteAddress(id: Int): Int?

    fun setDefaultAddress(id: Int): Int?
}

//测试用
interface StudentMapper
{
    fun payMoney()

    fun collectMoney()
}

/**
 * 关于商品的数据库操作
 */
interface ShopMapper
{
    fun getMilkData(): List<Milk>

    fun getMilkCategory(): List<MilkCategory>
}