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

    fun getDefaultAddress(user: User): Address?

    fun setAddress(address: Address): Int?

    fun findAdsById(id: Int): Ads

    fun changeAddress(address: Address): Int

    fun findUsers(query: Query): List<User>

    fun  getUserCount(): Int

}

/**
 * 关于商品的数据库操作
 */
interface ShopMapper
{
    fun getMilkData(pages: Pages): List<Milk>

    fun getMilkCategory(): List<MilkCategory>

    fun getClassify(): List<Classify>

    fun getActivityByClassify(classify: Int): List<Data>

    fun getHotMilk(): List<Data>

    fun getNewMilk(): List<Data>

    fun getActivityById(activity_id: Int): Activity

    fun getMilkById(milk_id: Int): Milk

    fun getMilkByCategory(query: Query): List<Data>

    fun search(query: Query): List<Data>

    fun searchActivity(query: Query): List<Activity>

    fun getActivityCount(): Int

    fun getMilkCount(): Int
}

/**
 * 关于订单的数据库操作
 */
interface OrderMapper
{
    fun getOrderInfo(id: Int): List<Order>

    fun getCartInfo(id: Int): List<Order>

    fun setOrderInfo(order : Order): Int

    fun setCartInfo(order : Order): Int

    fun setDistribution(distribution : Distribution): Int
}

/**
 * 其他的一些操作
 */
interface OtherMapper
{
    fun getDomainName(): String

    fun setDomainName(domain: String): Int

    fun getAdsList(): List<Ads>
}


interface StaffMapper
{
    fun findStaffByUsername(check: Check): Staff?

    fun updatePassword(check: Check): Int

    fun findStaffs(query: Query): List<Staff>?

    fun getStaffsCount(): Int

    fun findStaffByIdcard(idcard: String): Staff

    fun deleteStaff(staff: Staff): Int

    fun updateStaff(staff: Staff): Int

    fun insertStaff(staff: Staff): Int
}