package com.springmvc.mapper

import com.springmvc.Bean.Student
import com.springmvc.Bean.User

/**
 * Created by simple_soul on 2017/7/19.
 */

interface UserMapper
{
    fun addUser(user: User): Int?

    fun findUserByName(user: User): User?

    fun findUserById(user: User): User?

    fun updateUser(user: User):Int?


}

//测试用
interface StudentMapper
{
    fun payMoney()

    fun collectMoney()
}