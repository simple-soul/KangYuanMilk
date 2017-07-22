package com.springmvc.service

import com.springmvc.Bean.Student
import com.springmvc.Bean.User

/**
 * Created by simple_soul on 2017/7/15.
 */

/**
 *  对用户操作的业务层,实现详见 {@link UserServiceImpl}
 */
interface UserService
{
    fun register(user: User): Boolean

    fun login(user: User): User?

    fun forget()

    fun changeInfo(user: User): Boolean

    fun checkName(user: User): Boolean
}

interface StudentService
{
    fun account()
}