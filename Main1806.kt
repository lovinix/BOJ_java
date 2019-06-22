import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val N = Integer.parseInt(st.nextToken())
        val S = Integer.parseInt(st.nextToken())
        val input = IntArray(N)
        st = StringTokenizer(br.readLine())
        for (i in 0 until N) {
            input[i] = Integer.parseInt(st.nextToken())
        }
        var sum = 0
        var len = Integer.MAX_VALUE
        var i = 0
        var j = 0
        while (i <= N) {
            if (sum >= S) {
                val t = i - j
                if (len > t) len = t
                sum -= input[j++]
            } else {
                if (i == N) break
                sum += input[i++]
            }
        }
        println(if (len == Integer.MAX_VALUE) 0 else len)

    }

