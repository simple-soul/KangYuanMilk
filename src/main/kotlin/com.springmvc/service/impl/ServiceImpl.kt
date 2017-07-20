package com.springmvc.service.impl

import com.springmvc.Bean.User
import com.springmvc.mapper.UserMapper
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.Resource
import javax.annotation.Resources

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

    @Autowired lateinit var userMapper: UserMapper

    override fun register(user: User)
    {
        userMapper.addUser(user)
    }
}