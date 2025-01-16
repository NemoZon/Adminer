package com.example.adminer.di

import com.example.adminer.data.http.AuthAPI
import com.example.adminer.data.http.UsersAPI
import com.example.adminer.data.repositories.UsersRepository
import com.example.adminer.data.repositories.UsersRepositoryImpl
import com.example.adminer.viewmodel.UsersViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

val appModules = module {
    single<UsersRepository> { UsersRepositoryImpl(get(), get()) }
    single { Dispatchers.IO }
    single { UsersViewModel(get()) }
    single {
        Retrofit.Builder()
            .addConverterFactory(
                Json{
                    ignoreUnknownKeys = true
                }.asConverterFactory(contentType = "application/json".toMediaType())
            )
            .baseUrl("https://api.com/api/")
            .build()
    }
    single { get<Retrofit>().create(UsersAPI::class.java) }
    single { get<Retrofit>().create(AuthAPI::class.java) }
}