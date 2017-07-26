package com.springmvc.Bean

import com.springmvc.annotations.Bean
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
        val address_content: String?,
        val user_head: String?,
        val user_sex: Boolean?,
        var user_registerdate: Date?,
        val remark: String?
               )

@Bean
data class Student(
        val name: String?,
        val id: Int?,
        val age: Int?,
        val money: Int?
                  )

@Bean
data class Address(
        val address_id: Int?,
        val address_content: String?
                  )

@Bean
data class DefaultAddress(
        val address_id: Int?,
        val address_content: String?,
        val user_id: Int?)

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





