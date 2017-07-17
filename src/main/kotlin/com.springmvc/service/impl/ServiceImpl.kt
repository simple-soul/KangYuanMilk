package com.springmvc.service.impl

import com.springmvc.Bean.User
import com.springmvc.dao.UserDao
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/15.
 */

@Service("userService")
open class UserServiceImpl:  UserService
{
    override fun login(user: User)
    {

    }

    override fun forget()
    {

    }

    @Autowired lateinit var userDao: UserDao

    override fun register(user: User)
    {
        userDao.add(user)
    }
}