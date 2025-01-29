package com.example.adminer.data.repositories

import com.example.adminer.data.entities.Absence
import com.example.adminer.data.http.NetworkResult
import com.example.adminer.data.mocks.absences

class AbsencesRepositoryImpl(): AbsencesRepository {
    override suspend fun getMockAbsences(): NetworkResult<List<Absence>> {
        return NetworkResult.Success(absences)
    }
}