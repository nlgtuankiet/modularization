package com.nlgtuankiet.modularization

import com.google.common.base.Optional
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class IntentProviderImplTest {

    @Test
    fun `have all intent binding`() {
        val component: AppComponent = DaggerAppComponent.factory().create(mock())
        val intentProviderImpl: IntentProviderImpl = component.intentProviderImpl()
        IntentProviderImpl::class.java.declaredFields.forEach { field ->
            if (field.type == Optional::class.java) {
                field.isAccessible = true
                val optionalBinding = field.get(intentProviderImpl) as Optional<*>
                // ensure binding exists
                check(optionalBinding.isPresent) {
                    "Binding for field $field doesn't exist in dagger dependency graph"
                }
            }
        }
    }
}
