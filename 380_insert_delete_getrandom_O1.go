type RandomizedSet struct {
    posMap map[int]int
    nums []int
}


/** Initialize your data structure here. */
func Constructor() RandomizedSet {
    return RandomizedSet{make(map[int]int), make([]int, 0)}
}


/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
func (this *RandomizedSet) Insert(val int) bool {
    if _, isExist := this.posMap[val]; isExist {
        return false
    }
    this.posMap[val] = len(this.nums)
    this.nums = append(this.nums, val)
    return true
}


/** Removes a value from the set. Returns true if the set contained the specified element. */
func (this *RandomizedSet) Remove(val int) bool {
    if idx, isExist := this.posMap[val]; isExist {
        l := len(this.nums)
        swapVal := this.nums[l - 1]
        this.nums[idx] = swapVal
        this.posMap[swapVal] = idx
        delete(this.posMap, val)
        this.nums = this.nums[:l-1]
        return true
        
    } else {
        return false;
    }
}


/** Get a random element from the set. */
func (this *RandomizedSet) GetRandom() int {
    return this.nums[rand.Intn(len(this.nums))]
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
