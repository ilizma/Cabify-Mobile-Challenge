package com.ilizma.marketplace.flow.navigator

import android.app.Activity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BackNavigatorImpTest {

    @RelaxedMockK
    private lateinit var activity: Activity

    private lateinit var navigator: BackNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        navigator = BackNavigatorImp(
            activity = activity,
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when navigate is called, then activity finish is called`() {
            // when
            navigator.navigate()

            // then
            verify { activity.finish() }
        }

    }

}