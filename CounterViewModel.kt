package com.example.counterapp.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = mutableStateOf(0) //
    /*
    It is a good practice to use _before defining any private variable

    When an User rotated his device then without MVVM the state is refreshed
    and the value of the variable is reset to the initialised variable.
    That's why MVVM is used in the apps.
    M stands for Model
    V stands for View
    VM stands for View Model.
    Eg:- In an Counter Application, the value of count variable is 0 initially.
    We have defined 2 functions named Increment and Decrement.
    As the name defined one is increasing the value and other one is decreasing the value.
    Here,if we don't use MVVM Structure then the value of count is reset to 0 if the user rotates
    his device.
    To overcome this we use MVVM.
     */

    // Below line of code is used to expose the count as an Immutable State
    val count: MutableState<Int> = _count

    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }
}
