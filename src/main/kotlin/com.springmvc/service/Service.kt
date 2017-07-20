package com.springmvc.service

import com.springmvc.Bean.User
import org.springframework.stereotype.Service

/**
 * Created by simple_soul on 2017/7/15.
 */
interface UserService
{
    fun register(user: User)

    fun login(user: User)

    fun forget()
}