package com.example.recyclerview.common

sealed class Response<out Result, out Error> {
    data class Success<out Result>(val result: Result): Response<Result, Nothing>()
    data class Error<out Error>(val error: Error): Response<Nothing, Error>()
}