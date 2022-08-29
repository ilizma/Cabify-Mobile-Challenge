package com.ilizma.checkout.data.datasource.di

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ilizma.checkout.data.datasource.CheckoutDataSource
import com.ilizma.checkout.data.datasource.CheckoutDataSourceImp
import com.ilizma.checkout.flow.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.flow.mapper.CheckoutInfoMapper
import com.ilizma.checkout.view.fragment.CheckoutScreenFragmentArgs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object CheckoutDataSourceModule {

    @Provides
    fun provideCheckoutDataSource(
        fragment: Fragment,
    ): CheckoutDataSource = CheckoutDataSourceImp(
        checkoutInfoList = {
            CheckoutInfoListMapper(
                mapper = CheckoutInfoMapper(),
            ).from(fragment.navArgs<CheckoutScreenFragmentArgs>().value.articlesArgs)
        },
    )

}