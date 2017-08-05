package com.springmvc.utils

import com.qiniu.util.Auth
import org.springframework.jdbc.datasource.DriverManagerDataSource
import java.awt.Color
import java.security.NoSuchAlgorithmException
import java.security.MessageDigest
import kotlin.experimental.and
import java.util.Random




/**
 * Created by simple_soul on 2017/7/17.
 */
inline fun DBUtils(): DriverManagerDataSource
{
    //设置数据库信息
    val dm = DriverManagerDataSource()
    dm.setDriverClassName("com.mysql.jdbc.Driver")
    dm.url = "jdbc:mysql://localhost:3306/test"
    dm.username = "root"
    dm.password = "gg123456"
    return dm
}

inline fun getKey()
{
    val accessKey: String = "KXLzuFCOxgNar5whqU3-0bmrH6rTHOqaidcohRes"
    val secretKey: String = "aiw1aAh-dwA9k6nkWAQLExy2Taz9cE1nFYA_01WY"
    val bucket: String = "bucket"

    val auth = Auth.create(accessKey, secretKey)
    val upToken = auth.uploadToken(bucket)
    println(upToken)
}

inline fun md5(string: String?): String
{
    string ?: return ""
    try {
        //获取md5加密对象
        val instance:MessageDigest = MessageDigest.getInstance("MD5")
        val sb: StringBuffer = StringBuffer()
        for (a in 1..10)
        {
            //对字符串加密，返回字节数组
            val digest: ByteArray = instance.digest(sb.toString().toByteArray())
            sb.setLength(0)
            for (b in digest)
            {
                val i = b.toInt() and 0xff//获取低八位有效值
                var hexString = Integer.toHexString(i)//将整数转化为16进制
                if (hexString.length < 2)
                {
                    hexString = "0" + hexString//如果是一位的话，补0
                }
                sb.append(hexString)
            }
            if (a != 10)
                sb.append("mvc")
        }
        return sb.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

    return ""
}

