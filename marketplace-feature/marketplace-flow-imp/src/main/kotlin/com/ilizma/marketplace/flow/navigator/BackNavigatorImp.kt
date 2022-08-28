package com.ilizma.marketplace.flow.navigator

import android.app.Activity

class BackNavigatorImp(
    private val activity: Activity,
) : BackNavigator {

    override fun navigate() {
        activity.finish()
    }

}