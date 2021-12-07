open class Word  (
    open var startdiff: Int = 1,
    open val original: String,
    open val translated: String,
    val language: String )
{
    var difficulty: Int = startdiff
        set (value) {
            if (value < 1) {
                field = 1
            } else {
                field = value
            }
        }
}