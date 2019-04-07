import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

fun main() {
    val meetings = listOf(
        "core" meeting {
            into room "Toronto"
            at time (7 April 2019 at 18..0)
        },
        "evolution" meeting {
            at time (8 May 2019 at 10..20)
            into room "Shanghai"
        }
    )

    meetings.forEach { println(it) }
}

infix fun LocalDate.at(t: IntRange): LocalDateTime =
    this.atTime(t.first, t.last, 0)

@Suppress("FunctionName")
infix fun Int.April(year: Int): LocalDate =
    localDate(year, Month.APRIL)

@Suppress("FunctionName")
infix fun Int.May(year: Int): LocalDate =
    localDate(year, Month.MAY)

private fun Int.localDate(year: Int, month: Month) = LocalDate
    .of(year, month, this)

infix fun String.meeting(block: Meeting.() -> Unit): Meeting =
    Meeting().apply(block)

