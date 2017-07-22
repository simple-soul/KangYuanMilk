package com.springmvc.Bean

import com.springmvc.annotations.Bean

/**
 * Created by simple_soul on 2017/7/21.
 */
/**
 * 返回数据的接口，可以进行扩展
 */
interface Response
{
    var result: Boolean
}
/**
 * 接口返回类，类中有response属性，可以自行扩展，可以满足所有要求
 * @param status 服务器返回的状态码
 */
@Bean
data class ServerResponse(var status: Int)
{
    var response: Response = BooleanResponse(false)
}

class BooleanResponse(override var result: Boolean): Response

class StringResponse(override var result: Boolean): Response
{
    var message: String? = null
}
class UserResponse(override var result: Boolean): Response
{
    var user: User? = null
}

class AddressResponse(override var result: Boolean): Response
{
    var addresses: List<Address>? = null
    var defaultId: Int? = null
}




