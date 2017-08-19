package com.springmvc.controller.Web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ShopWebController
{
    @RequestMapping("/compile")
    fun compile(): String
    {
        return "/WEB-INF/jsp/compile.jsp"
    }
}