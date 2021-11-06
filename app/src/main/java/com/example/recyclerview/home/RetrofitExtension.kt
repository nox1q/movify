package com.example.recyclerview.home

import retrofit2.Call
import java.io.IOException
import java.lang.NullPointerException

fun <T> Call<T>.executeCall(): Response<T, Exception> {
    return try {
        val response = execute()

        when {
            !response.isSuccessful -> Response.Error(Exception())
            response.code() != 200 -> Response.Error(Exception())
            response.body() == null -> Response.Error(NullPointerException())
            else -> Response.Success(response.body()!!)
        }
    } catch (e: IOException) {
        Response.Error(e)
    }
}