import "math"

func minDays(bloomDay []int, m int, k int) int {
    // 1 <= bloomDay[i] <= 10^9. l is left margin. r is right margin
    n, l, r := len(bloomDay), 1, int(math.Pow(10, 9))
    
    if m * k > n { // must have at least m * k flowers in the garden. Otherwise, return -1
        return -1
    }
    
    for l < r {
        mid := l + (r - l) / 2
        
        bouquet, accumulator := 0, 0
        for i := 0; i < n; i++ {
            if bloomDay[i] > mid {
                accumulator = 0
            } else if accumulator += 1; accumulator == k {
                bouquet++
                accumulator = 0
            }
        }
        if bouquet >= m {
            r = mid
        } else {
            l = mid + 1
        }
    }
    
    return l
}
