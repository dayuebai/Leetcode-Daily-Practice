type RandomizedCollection struct {
    posMap map[int][]int
    nums [][]int
}


/** Initialize your data structure here. */
func Constructor() RandomizedCollection {
    return RandomizedCollection{ make(map[int][]int), make([][]int, 0) }
}


/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
func (this *RandomizedCollection) Insert(val int) bool {
    _, isExist := this.posMap[val]
    if !isExist {
        this.posMap[val] = make([]int, 0)
    }  
    this.posMap[val] = append(this.posMap[val], len(this.nums))
    this.nums = append(this.nums, []int{val, len(this.posMap[val]) - 1})
    return isExist
}


/** Removes a value from the collection. Returns true if the collection contained the specified element. */
func (this *RandomizedCollection) Remove(val int) bool {
    if _, isExist := this.posMap[val]; isExist {
        l, numL := len(this.posMap[val]), len(this.nums)
        idx := this.posMap[val][l - 1]
        last := this.nums[numL - 1]
        this.nums[idx][0], this.nums[idx][1] = last[0], last[1]
        this.posMap[last[0]][last[1]] = idx
        this.posMap[val] = this.posMap[val][:l-1]
        if l - 1 == 0 {
            delete(this.posMap, val)
        }
        this.nums = this.nums[:numL - 1]
        return true
    }
    return false
}


/** Get a random element from the collection. */
func (this *RandomizedCollection) GetRandom() int {
    return this.nums[rand.Intn( len(this.nums) )][0]
}


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
