import "sort"

func maxFrequency(nums []int, k int) int {
    l, maxFreq, nCopy := 0, 1, make([]int, len(nums))
    copy(nCopy, nums)
    sort.Ints(nCopy)
    sum := 0
    
    fmt.Println(nCopy)
    
    for r := 0; r < len(nCopy); r++ {
        sum += nCopy[r]
        for sum + k < nCopy[r] * (r - l + 1) {
            sum -= nCopy[l]
            l++
        }
        if cur := r - l + 1; cur > maxFreq {
            maxFreq = cur
        }
    }
    return maxFreq
}
