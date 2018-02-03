package sszymanski.co.uk.myhome.data

import io.reactivex.Observable
import retrofit2.http.*
import sszymanski.co.uk.myhome.data.pojo.LoginRequest
import sszymanski.co.uk.myhome.data.pojo.LoginResponse

/**
 * Created by rex on 03/02/2018.
 */
interface UserService{
    @POST("home/auth")
    @FormUrlEncoded
    fun authorize(@Field("name")name:String, @Field("pwd") pwd:String): Observable<LoginResponse>
}