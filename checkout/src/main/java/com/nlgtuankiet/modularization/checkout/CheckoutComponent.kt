package com.nlgtuankiet.modularization.checkout

import com.nlgtuankiet.modularization.CoreComponent
import com.nlgtuankiet.modularization.coreComponent
import dagger.Component

@Component(
    dependencies = [CoreComponent::class]
)
interface CheckoutComponent {
    fun inject(activity: CheckoutActivity)

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): CheckoutComponent
    }

    companion object {
        fun inject(activity: CheckoutActivity) {
            DaggerCheckoutComponent.factory()
                .create(coreComponent = activity.coreComponent)
                .inject(activity)
        }
    }
}