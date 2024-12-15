package com.winter.university.controller.reponse

data class BaseResponse<T> (
    val code: Int,
    val message: String,
    val body: T?,
) {
    companion object {
        fun <T> success(body: T?): BaseResponse<T> {
            return BaseResponse(code = 200, message = "success", body = body)
        }

        fun <T> error(message: String, body: T?): BaseResponse<T> {
            return BaseResponse(code = 400, message = message, body = body)
        }
    }
}