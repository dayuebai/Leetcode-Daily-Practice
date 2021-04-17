func findDisappearedNumbers(nums []int) []int {
    ans := make([]int, 0)
    for i := 0; i < len(nums); i++ {
        idx := int(math.Abs(float64(nums[i])) - 1)
        nums[idx] = int(math.Abs(float64(nums[idx])) * (-1))
    }
    for i := 0; i < len(nums); i++ {
        if nums[i] > 0 {
            ans = append(ans, i+1)
        }
    }
    return ans
}
