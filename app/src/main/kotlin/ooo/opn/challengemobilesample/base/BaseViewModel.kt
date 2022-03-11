package ooo.opn.challengemobilesample.base

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import ooo.opn.challengemobilesample.model.AlertEvent
import ooo.opn.challengemobilesample.util.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val loadingEvent by lazy { SingleLiveEvent<Boolean>() }
    val alertEvent by lazy { SingleLiveEvent<AlertEvent>() }

    protected fun alert(message: String? = null, @StringRes messageRes: Int? = null) {
        alertEvent.value = AlertEvent(
            message = message,
            messageRes = messageRes
        )
    }

    protected fun showLoading() {
        loadingEvent.value = true
    }

    protected fun hideLoading() {
        loadingEvent.value = false
    }
}