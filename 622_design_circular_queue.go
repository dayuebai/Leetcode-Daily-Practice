type MyCircularQueue struct {
    arr []int
    length int
    front int
    rear int
}


func Constructor(k int) MyCircularQueue {
    cQ := MyCircularQueue{make([]int, k), 0, 0, -1}
    return cQ
}


func (this *MyCircularQueue) EnQueue(value int) bool {
    if this.IsFull() {
        return false
    }
    this.rear = (this.rear + 1) % len(this.arr)
    this.arr[this.rear] = value
    this.length++
    return true
}


func (this *MyCircularQueue) DeQueue() bool {
    if this.IsEmpty() {
        return false
    }
    this.front = (this.front + 1) % len(this.arr)
    this.length--
    return true
}


func (this *MyCircularQueue) Front() int {
    if this.IsEmpty() {
        return -1
    }
    return this.arr[this.front]
}


func (this *MyCircularQueue) Rear() int {
    if this.IsEmpty() {
        return -1
    }
    return this.arr[this.rear]
}


func (this *MyCircularQueue) IsEmpty() bool {
    return this.length == 0
}


func (this *MyCircularQueue) IsFull() bool {
    return this.length == len(this.arr)
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.EnQueue(value);
 * param_2 := obj.DeQueue();
 * param_3 := obj.Front();
 * param_4 := obj.Rear();
 * param_5 := obj.IsEmpty();
 * param_6 := obj.IsFull();
 */
