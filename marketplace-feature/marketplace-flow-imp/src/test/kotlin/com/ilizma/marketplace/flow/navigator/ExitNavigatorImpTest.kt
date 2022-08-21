package com.ilizma.game.flow.navigator

import android.app.Activity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ExitNavigatorImpTest {

    @RelaxedMockK
    private lateinit var activity: Activity

    private lateinit var navigator: ExitNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        navigator = ExitNavigatorImp(
            activity = activity,
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when navigate is called, then navigate is executed`() {
            // when
            navigator.navigate()

            // then
            verify { activity.finish() }
        }

    }

}