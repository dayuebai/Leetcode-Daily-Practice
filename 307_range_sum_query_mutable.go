type NumArray struct {
    BIT []int
    nums []int
}


func Constructor(nums []int) NumArray {
    numsArr := NumArray{make([]int, len(nums) + 1), nums}
    for i, v := range nums {
        numsArr.init(i, v)
    }
    return numsArr
}


func (this *NumArray) Update(index int, val int)  {
    diff := val - this.nums[index]
    this.nums[index] = val
    this.init(index, diff)
}


func (this *NumArray) SumRange(left int, right int) int {
    return this.getSum(right+1) - this.getSum(left)
}

func (this *NumArray) init(index int, val int) {
    index++
    for index <= len(this.nums) {
        this.BIT[index] += val
        index += index & (-index) // Go to parent node
    }
}

func (this *NumArray) getSum(idx int) int {
    sum := 0
    for idx > 0 {
        sum += this.BIT[idx]
        idx -= idx & (-idx)
    }
    return sum
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * obj.Update(index,val);
 * param_2 := obj.SumRange(left,right);
 */
