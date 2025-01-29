package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Absence
import com.example.adminer.data.http.NetworkResult

interface AbsencesRepository {
    suspend fun getMockAbsences(): NetworkResult<List<Absence>>
}