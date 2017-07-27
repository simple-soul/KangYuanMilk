package com.springmvc.utils

import com.qiniu.util.Auth
import org.junit.Test
import org.springframework.jdbc.datasource.DriverManagerDataSource


/**
 * Created by simple_soul on 2017/7/17.
 */
inline fun DBUtils(): DriverManagerDataSource
{
    //设置数据库信息
    val dm = DriverManagerDataSource()
    dm.setDriverClassName("com.mysql.jdbc.Driver")
    dm.url = "jdbc:mysql://localhost:3306/test"
    dm.username = "root"
    dm.password = "gg123456"
    return dm
}

inline fun getKey()
{
    val accessKey: String = "KXLzuFCOxgNar5whqU3-0bmrH6rTHOqaidcohRes"
    val secretKey: String = "aiw1aAh-dwA9k6nkWAQLExy2Taz9cE1nFYA_01WY"
    val bucket: String = "bucket"

    val auth = Auth.create(accessKey, secretKey)
    val upToken = auth.uploadToken(bucket)
    println(upToken)
}

