package ru.is88.ststest

import java.io.Serializable
import java.util.*

class Models {

    interface Inlinable : Serializable {
        fun inline(): String
    }

    /**
     * Все новые классы должны наследовать интерфейс Inlinable
     *
     * Я предпочёл этот новый интерфейс переопределению toString, поскольку
     * когда новый программист будет добавлять новый тип, он не сможет не переопределить inline()
     *
     * К сожалению, я не смог вынести this.javaClass.simpleName в какое-нибудь одно место
     */

    class Notice (private val flightDate: Date? = null,
                  private val gate: String? = null) : Inlinable {
        override fun inline(): String {
            return this.javaClass.simpleName + " – $flightDate, $gate"
        }

    }

    class Event (private val startTime: Date? = null,
                 private val endTime: Date? = null,
                 private val name: String? = null) : Inlinable {
        override fun inline(): String {
            return this.javaClass.simpleName + " – $startTime, $endTime, $name"
        }
    }

    class Move (private val fromPlace: String? = null,
                private val toPlace: String? = null,
                private val estimateTime: TimeInterval? = null) : Inlinable {
        override fun inline(): String {
            return this.javaClass.simpleName + " – $fromPlace, $toPlace, $estimateTime"
        }
    }
}