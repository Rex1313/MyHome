package sszymanski.co.uk.myhome.utils

import org.apache.commons.codec.digest.DigestUtils

/**
 * Created by rex on 28/01/2018.
 */
class Utils {

    companion object {
        fun getMd5Hash(password:String) = DigestUtils.md5Hex(password);
    }
}