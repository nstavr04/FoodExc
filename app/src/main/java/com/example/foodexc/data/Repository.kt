package com.example.foodexc.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

// Scope annotation.
// Only use one instance of this until it is destroyed
@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localDataSource

}