import (
    "sort"
)

type BIT struct {
    sums []int
}

func (t *BIT) Update(idx int, delta int) {
    for idx < len(t.sums) {
        t.sums[idx] += delta
        idx += idx & (-idx)
    }
}

func (t *BIT) Query(idx int) int {
    sum := 0
    for idx > 0 {
        sum += t.sums[idx]
        idx -= idx & (-idx)
    }
    return sum
}

func countSmaller(nums []int) []int {
    sorted, ranks := make([]int, len(nums)), make(map[int]int)
    copy(sorted, nums)
    sort.Ints(sorted)
    
    rank := 0
    for i, v := range sorted {
        if i == 0 || sorted[i] != sorted[i-1] {
            rank++
            ranks[v] = rank
        }
    }
    
    tree, ans := BIT{make([]int, len(ranks) + 1)}, make([]int, len(nums))
    for i := len(nums) - 1; i >= 0; i-- {
        sum := tree.Query(ranks[nums[i]] - 1)
        ans[i] = sum
        tree.Update(ranks[nums[i]], 1)
    }
    return ans
}
