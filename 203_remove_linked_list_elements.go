/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
import "fmt"

func removeElements(head *ListNode, val int) *ListNode {
    dummy := &ListNode{0, head}
    for cur := dummy; cur != nil && cur.Next != nil; {
        if cur.Next.Val == val {
            cur.Next = cur.Next.Next
        } else {
            cur = cur.Next
        }
    }
    return dummy.Next
}
