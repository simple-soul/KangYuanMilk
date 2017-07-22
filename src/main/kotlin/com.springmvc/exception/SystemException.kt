package com.springmvc.exception

import com.springmvc.annotations.Bean


/**
 * Created by simple_soul on 2017/7/21.
 */

/**
 * 自定义的异常类，继承自Exception
 * @param message 具体错误信息
 */
open class SystemException(override var message: String): Exception()
