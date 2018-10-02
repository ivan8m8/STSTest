package ru.is88.ststest

import java.io.Serializable

data class TimeInterval (var value: Long) : Serializable {
    override fun toString(): String {
        return value.toString() + " km"
    }
}