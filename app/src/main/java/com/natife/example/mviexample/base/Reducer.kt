package com.natife.example.mviexample.base

interface Reducer<State, Action> {

    val initialState: State

    fun reduce(state: State, action: Action): State

}