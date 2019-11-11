package com.example.newsanchor.database.sharedpref

import com.chibatching.kotpref.KotprefModel
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE_EVALUATOR

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
object NewsAnchorDefaults : KotprefModel(){
    var isUserLogged by booleanPref(false)
    var appUserName by stringPref()
    var appPassword by stringPref()
    var appEmail by stringPref()
    var isInitialRun by booleanPref(true)
    var authToken by stringPref("")
    var accoutType by stringPref(ACCOUNT_TYPE_EVALUATOR)
    var preferedNewsType by intPref(1)
}