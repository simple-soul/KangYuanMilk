package com.springmvc.Bean

import com.springmvc.annotations.Bean
import org.springframework.stereotype.Component
import java.util.*

/**
 * Created by simple_soul on 2017/7/15.
 */

@Bean
@Component(value = "user")
data class User(var name: String)
{
    var id: Int? = null
    var pass: String? = null
    var tel: String? = null
    var idCard: String? = null
    var address: Int? = null
    var header: String? = null
    var sex: Boolean? = null
    var date: Date = Date()
    var remark: String? = null
}

