package com.springmvc.service

import com.springmvc.Bean.User

/**
 * Created by simple_soul on 2017/7/15.
 */

interface UserService
{
    fun register(user: User)

    fun login(user: User)

    fun forget()
}