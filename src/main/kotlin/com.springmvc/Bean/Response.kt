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

class ServerResponse(var status: Int, var response: Response = BooleanResponse(status == 200))

class BooleanResponse(override var result: Boolean): Response

class StringResponse(override var result: Boolean, var message: String?): Response

class UserResponse(override var result: Boolean, var user: User? = null): Response

class AddressResponse(override var result: Boolean, var addresses: List<Address>? = null, var defaultId: Int? = null): Response

class MilksResponse(override var result: Boolean, var milks: List<Milk>? = null): Response

class MilkResponse(override var result: Boolean, var milk: Milk): Response

class MilkCategoryResponse(override var result: Boolean, var milkCategory: List<MilkCategory>? = null): Response

class StaffsResponse(override var result: Boolean, val staffs: List<Staff>?, val count: Int): Response

class AdsResponse(override var result: Boolean, val adsList: List<Ads>): Response

class DefAddressResponse(override var result: Boolean, var address: Address?): Response

class UserListResponse(override var result: Boolean, var users: List<User>, val domain: String, val count: Int): Response

class ResultsResponse(override var result: Boolean, val resultList: List<Result>): Response

class DataResponse(override var result: Boolean, val dataList: List<Data>): Response

class ActivityResponse(override var result: Boolean, val activity: Activity): Response


