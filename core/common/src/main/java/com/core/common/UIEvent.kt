package com.core.common

sealed class UIEvent<T>(val data:T? = null, val message:String? = null ){
    class Success<T>(data:T?) : UIEvent<T>(data = data)
    class Error<T>(message:String) : UIEvent<T>(message = message)
    data class Loading<T>(val isLoading:Boolean) : UIEvent<T>()

}
