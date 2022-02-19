package com.rivaldy.id.base.di

import com.apollographql.apollo3.ApolloClient
import com.rivaldy.id.base.data.AppDataManager
import com.rivaldy.id.base.data.remote.ApiService
import com.rivaldy.id.base.data.remote.AppApiHelper
import com.rivaldy.id.base.data.remote.graphql.AppGraphqlHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by rivaldy on 05/01/22.
 * Find me on my Github -> https://github.com/im-o
 */

@Module
@InstallIn(SingletonComponent::class)
object AppHelperModule {

    // api, local storage, sharedPreference, dataStore

    @Provides
    fun providesAppApiHelper(apiService: ApiService) = AppApiHelper(apiService)

    @Provides
    fun providesAppGraphqlHelper(apolloClient: ApolloClient) = AppGraphqlHelper(apolloClient)

    @Provides
    fun providesAppDataManager(appApiHelper: AppApiHelper, appGraphqlHelper: AppGraphqlHelper): AppDataManager {
        return AppDataManager(appApiHelper, appGraphqlHelper)
    }
}