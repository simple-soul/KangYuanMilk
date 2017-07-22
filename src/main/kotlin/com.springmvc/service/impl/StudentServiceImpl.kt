package com.springmvc.service.impl

import com.springmvc.Bean.Student
import com.springmvc.mapper.StudentMapper
import com.springmvc.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by simple_soul on 2017/7/22.
 */
@Transactional
@Service("studentService")
open class StudentServiceImpl: StudentService
{
    @Autowired lateinit var studentMapper: StudentMapper

    override fun account()
    {
        studentMapper.payMoney()

        studentMapper.collectMoney()
    }
}