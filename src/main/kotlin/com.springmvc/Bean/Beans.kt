package com.springmvc.Bean

import com.springmvc.annotations.Bean
import sun.security.x509.DistributionPoint
import java.math.BigDecimal
import java.util.*

/**
 * Created by simple_soul on 2017/7/15.
 */

@Bean
data class User(
        val user_name: String?,
        val user_id: Int?,
        val user_pwd: String?,
        val user_tel: String?,
        val user_idcard: String?,
        val address_id: Int?,
        var address_content: String?,
        var user_head: String?,
        val user_sex: Boolean?,
        var user_registerdate: Date?,
        val remark: String?
)

@Bean
data class Address(
        val address_id: Int?,
        var address_content: String?,
        val user_id: Int?,
        val ads_id: Int?
)

@Bean
data class Ads(
        val id: Int,
        val parentId: Int,
        val code: Int,
        val name: String
)

@Bean
data class Milk(
        val milk_id: Int?,
        val milk_name: String?,
        val category_id: Int?,
        val milk_price: BigDecimal?,
        val milk_introduce: String?,
        val milk_spec: String?,
        val milk_sales: Int?,
        val remark: String?
)

@Bean
data class MilkCategory(
        val category_id: Int?,
        val category_name: String?,
        val remark: String?
)

@Bean
data class Order(
        val order_id: Int?,
        val order_number: String?,
        val user_id: Int?,
        val address_content: String?,
        val courier_id: Int?,
        val distribution_startdate: Date?,
        val distribution_enddate: Date?,
        val distribution_renew: Int?,
        var order_date: Date?,
        val order_money: BigDecimal?,
        val remark: String?
)

@Bean
data class Staff(
        val staff_id: Int?,
        val staff_name: String?,
        val staff_username: String?,
        val staff_pwd: String,
        val staff_sex: Boolean?,
        val staff_idcard: String?,
        val staff_tel: String?,
        val staff_authority: Int,
        val isdeleted: Boolean?,
        val remark: String?
)

@Bean
data class Query(
        val key: String?,
        val num: Int = 0
)

@Bean
data class Check(
        val username: String,
        val password: String,
        val code: String = "",
        val remember: Boolean = false
)


