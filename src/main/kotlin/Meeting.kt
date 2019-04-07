import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Meeting {

    private lateinit var place: String
    private lateinit var time: LocalDateTime
    val into = this
    val at = this

    infix fun room(r: String) {
        place = r
    }


    infix fun time(t: LocalDateTime) {
        time = t
    }

    fun String.into() {
        place = this
    }

    override fun toString(): String {
        val d = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            .format(time)
        val t = DateTimeFormatter.ofPattern("HH:mm")
            .format(time)
        return "Meeting will be the $d at $t in $place"
    }
}