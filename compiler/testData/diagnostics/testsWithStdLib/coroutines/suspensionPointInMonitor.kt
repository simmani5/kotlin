// !DIAGNOSTICS: -UNUSED_PARAMETER, -USELESS_IS_CHECK
// SKIP_TXT

val lock = Any()

fun builder(c: suspend () -> Unit) {}

suspend fun suspensionPoint() {}

fun test() {
    builder {
        synchronized(lock) {
            <!SUSPENSION_POINT_INSIDE_SYNCHRONIZED!>suspensionPoint<!>()
        }

        synchronized(lock) label@{
            <!SUSPENSION_POINT_INSIDE_SYNCHRONIZED!>suspensionPoint<!>()
        }

        synchronized(lock, { <!SUSPENSION_POINT_INSIDE_SYNCHRONIZED!>suspensionPoint<!>() })
    }
}

suspend fun run() {
    synchronized(lock) {
        <!SUSPENSION_POINT_INSIDE_SYNCHRONIZED!>suspensionPoint<!>()
    }
}

suspend fun ifWhenAndOtherNonsence() {
    synchronized(lock) {
        if (lock == Any()) {
            when (1) {
                is Int -> {
                    return@synchronized 1 + <!SUSPENSION_POINT_INSIDE_SYNCHRONIZED!>returnsInt<!>()
                }
                else -> {}
            }
        } else {}
    }
}

suspend fun returnsInt(): Int = 0