package com.ilizma.androidtest

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.commitNow
import androidx.fragment.testing.R
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.ilizma.androidtest.activity.HiltTestActivity

const val THEME_EXTRAS_BUNDLE_KEY = "androidx.fragment.app.testing.FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY"

inline fun <reified F : Fragment> launchFragmentInHiltContainer(
    fragmentArgs: Bundle? = null,
    @StyleRes themeResId: Int = R.style.FragmentScenarioEmptyFragmentActivityTheme,
    factory: FragmentFactory? = null,
    crossinline action: F.() -> Unit = {},
) {

    ComponentName(
        ApplicationProvider.getApplicationContext(),
        HiltTestActivity::class.java,
    ).let {
        Intent.makeMainActivity(it)
            .putExtra(
                THEME_EXTRAS_BUNDLE_KEY,
                themeResId,
            )
    }.let {
        ActivityScenario.launch<HiltTestActivity>(it).onActivity { activity ->
            factory?.let {
                activity.supportFragmentManager.fragmentFactory = factory
            }
            val fragment = activity.supportFragmentManager.fragmentFactory
                .instantiate(requireNotNull(F::class.java.classLoader), F::class.java.name)
            fragment.arguments = fragmentArgs
            activity.supportFragmentManager.commitNow {
                add(android.R.id.content, fragment, "")
            }
            (fragment as F).action()
        }

    }

}