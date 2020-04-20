package kr.co.sy.myapplication.model.entity

data class AuthEntity(val nickname: String, val password: String, val message: String, val data: Token)

data class Token(val token: String)