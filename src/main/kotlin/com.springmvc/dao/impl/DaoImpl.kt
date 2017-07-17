package com.springmvc.dao.impl

import com.springmvc.Bean.User
import com.springmvc.dao.UserDao
import com.springmvc.utils.DBUtils
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import javax.annotation.Resource

/**
 * Created by simple_soul on 2017/7/15.
 */

@Repository("userDao")
open class UserDaoImpl: UserDao
{
    val temple = JdbcTemplate(DBUtils())

    override fun add(user: User)
    {
//        val sql = "insert into user value(?, ?)"
//        temple.update(sql, )
    }

}