package com.example.ztelocker.module

import com.tech.ztelocker.api.ApiHelper
import com.tech.ztelocker.api.ApiHelperImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModuleBinds {
    @Binds
    abstract fun bindsUserRepository(impl: ApiHelperImp): ApiHelper
}