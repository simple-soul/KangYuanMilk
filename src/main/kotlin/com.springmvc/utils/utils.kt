package com.springmvc.utils

import org.springframework.jdbc.datasource.DriverManagerDataSource

/**
 * Created by simple_soul on 2017/7/17.
 */
inline fun DBUtils() : DriverManagerDataSource
{
    //设置数据库信息
    val dm = DriverManagerDataSource()
    dm.setDriverClassName("com.mysql.jdbc.Driver")
    dm.url = "jdbc:mysql://localhost:3306/test"
    dm.username = "root"
    dm.password = "gg123456"
    return dm
}