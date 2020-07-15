
fun main() {

    fun method(x: Int, y: Int, z: Int) : Int {

        fun Int.isEven() : Boolean {
            return (this and 1) == 0
        }

        val list = MutableList(1000) { index -> 0 }

        for (i in 1 until list.size) {
            if (i.isEven()) {
                list[i] = list[i-1] - y
            } else {
                list[i] = list[i-1] + x
            }
            //if (list[i] == z) return i
        }

        println(list)

        return -1
    }

    val x = 2
    val y = 1
    val z = 3

    println(method(x, y, z))
}
