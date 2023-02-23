import java.util.*

class HanoiTowers(val name: String, var disks: Stack<Int> = Stack())

fun empty(n: Int, from: HanoiTowers, to: HanoiTowers, aux: HanoiTowers) {
    if (n == 1) {
        val disk = from.disks.pop()
        to.disks.push(disk)
        println("Move disk $disk from rod ${from.name} to rod ${to.name}")
        return
    }
    empty(n - 1, from, aux, to)
    val disk = from.disks.pop()
    to.disks.push(disk)
    println("Move disk $disk from rod ${from.name} to rod ${to.name}")
    empty(n - 1, aux, to, from)
}

fun main(){
    val n = 3 // Number of disks
    val from = HanoiTowers("A", Stack<Int>()) // Starting rod
    val to = HanoiTowers("C", Stack<Int>()) // Destination rod
    val aux = HanoiTowers("B", Stack<Int>()) // Auxiliary rod

    for (i in n downTo 1) {
        from.disks.push(i)
    }

    empty(n, from, to, aux) // Solve the problem

}
