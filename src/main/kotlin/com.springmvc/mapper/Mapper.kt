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

    fun updateUser(user: User): Int

    fun findHeadByName(name: String): String?

    fun findAddressListByUserId(id: Int): List<Address>?

    fun findAddressById(id: Int): Address

    fun findDefaultAddressIdById(id: Int): Int?

    fun deleteAddress(id: Int): Int?

    fun setDefaultAddress(address: Address): Int?

    fun setAddress(address: Address): Int?

    fun findAdsById(id: Int): Ads
}

/**
 * 关于商品的数据库操作
 */
interface ShopMapper
{
    fun getMilkData(): List<Milk>

    fun getMilkCategory(): List<MilkCategory>
}

/**
 * 关于订单的数据库操作
 */
interface OrderMapper
{
    fun getOrderInfo(id: Int)

    fun getCartInfo(id: Int)

    fun setOrderInfo()

    fun setCartInfo()
}

/**
 * 其他的一些操作
 */
interface OtherMapper
{
    fun getDomainName(): String

    fun setDomainName(domain: String): Int

    fun getAdvert()
}


interface StaffMapper
{
    fun findStaffByUsername(check: Check): Staff?

    fun updatePassword(staff: Staff): Int

    fun getStaffList(start: Int): List<Staff>?

    fun findSomeoneInStaffs(query: Query): List<Staff>?

    fun getStaffsCount(): Int


}