package com.springmvc.controller.Web

import com.springmvc.Bean.Query
import com.springmvc.Bean.ServerResponse
import com.springmvc.Bean.UserListResponse
import com.springmvc.service.OtherService
import com.springmvc.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class UserWebController
{
    @Autowired lateinit var userService: UserService
    @Autowired lateinit var otherService: OtherService

    @RequestMapping("/user")
    fun user(): String
    {
        return "/WEB-INF/jsp/user.jsp"
    }

    @ResponseBody
    @RequestMapping("/user/find")
    fun find(@RequestBody query: Query): ServerResponse
    {
        println("find客户端传来的数据----------->$query")
        val list = userService.findUsers(query)
        return ServerResponse(200, UserListResponse(true, list, otherService.getQiNiu(), userService.getCount()))
    }
}