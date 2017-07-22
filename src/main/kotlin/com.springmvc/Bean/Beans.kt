package com.springmvc.Bean

import com.springmvc.annotations.Bean
import org.springframework.stereotype.Component
import java.util.*

/**
 * Created by simple_soul on 2017/7/15.
 */
/**
 *
 */
@Bean
@Component(value = "user")
data class User(
        var name: String?,
        var id: Int?,
        var pass: String?,
        var tel: String?,
        var idCard: String?,
        var address: String?,
        var head: String?,
        var sex: Boolean?,
        var date: Date?,
        var remark: String?
               )

@Bean
@Component(value = "student")
data class Student(
        var name: String?,
        var id: Int?,
        var age: Int?,
        var money: Int?
                  )

@Bean
data class Address(
        var id: Int?,
        var content: String?
                  )






