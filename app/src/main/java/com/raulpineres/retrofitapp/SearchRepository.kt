package com.raulpineres.retrofitapp

import io.reactivex.Observable

//Clase para hacer el repositorio con los parámetros para el API
class SearchRepository(private val apiService: GithubApiService) {
    fun searchUsers(location: String, language: String): Observable<Result> {
        return apiService.search(query = "location:$location language:$language", page = 1, perPage = 20)
    }
}