package com.pipe.d.dev.recommendarch.common.model

import com.pipe.d.dev.recommendarch.R
import com.pipe.d.dev.recommendarch.common.entities.MyException
import com.pipe.d.dev.recommendarch.common.utils.Constants

open class BaseRepository {
    protected suspend fun executeAction(myException: MyException =
                                  MyException(Constants.EC_UNKNOWN, R.string.common_unknown_error),
                              block: suspend () -> Unit) {
        try {
            block()
        } catch (e: Exception) {
            throw myException
        }
    }
}