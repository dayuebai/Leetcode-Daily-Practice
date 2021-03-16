/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapNodes(head *ListNode, k int) *ListNode {
    var arr []int;
    
    for cur := head; cur != nil; cur = cur.Next {
        arr = append(arr, cur.Val)
    }
    tmp := arr[k-1]
    arr[k-1] = arr[len(arr)-k] 
    arr[len(arr)-k] = tmp
    
    var ans *ListNode
    for i := len(arr)-1; i >= 0; i-- {
        ans = &ListNode{arr[i], ans}
    } 
    return ans
}
