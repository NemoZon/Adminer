package com.example.adminer.di

import com.example.adminer.data.http.AuthAPI
import com.example.adminer.data.http.UsersAPI
import com.example.adminer.data.repositories.AbsencesRepository
import com.example.adminer.data.repositories.AbsencesRepositoryImpl
import com.example.adminer.data.repositories.EvaluationsRepository
import com.example.adminer.data.repositories.EvaluationsRepositoryImpl
import com.example.adminer.data.repositories.LessonsRepository
import com.example.adminer.data.repositories.LessonsRepositoryImpl
import com.example.adminer.data.repositories.ObjectRepository
import com.example.adminer.data.repositories.ObjectRepositoryImpl
import com.example.adminer.data.repositories.UsersRepository
import com.example.adminer.data.repositories.UsersRepositoryImpl
import com.example.adminer.viewmodel.AbsencesViewModel
import com.example.adminer.viewmodel.EvaluationsViewModel
import com.example.adminer.viewmodel.LessonsViewModel
import com.example.adminer.viewmodel.ObjectsViewModel
import com.example.adminer.viewmodel.UsersViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

val appModules = module {
    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single<EvaluationsRepository> { EvaluationsRepositoryImpl(get()) }
    single<LessonsRepository> { LessonsRepositoryImpl(get()) }
    single<AbsencesRepository> { AbsencesRepositoryImpl(get()) }
    single<ObjectRepository> { ObjectRepositoryImpl(get()) }

    single { Dispatchers.IO }
    single { UsersViewModel(get()) }
    single { EvaluationsViewModel(get()) }
    single { LessonsViewModel(get()) }
    single { AbsencesViewModel(get()) }
    single { ObjectsViewModel(get()) }

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