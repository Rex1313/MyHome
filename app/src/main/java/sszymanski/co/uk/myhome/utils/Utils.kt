package sszymanski.co.uk.myhome.utils

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils

/**
 * Created by rex on 28/01/2018.
 */
class Utils {

    companion object {
        fun getMd5Hash(password:String) = Hex.encodeHex(DigestUtils.md5(password))
    }
}