package io.aristiyo.favouritefeature

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.aristiyo.capstone.di.AppEntryPoint

@Component(dependencies = [AppEntryPoint::class])
interface FavouriteComponent {
    fun inject(fragment: FavouriteFragment)

    @Component.Builder
    interface Builder {
        fun context(
            @BindsInstance context: Context,
        ): Builder

        fun appDependencies(appEntryPoint: AppEntryPoint): Builder

        fun build(): FavouriteComponent
    }
}
