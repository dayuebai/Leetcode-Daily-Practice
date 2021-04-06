import "strings"

func isValidSerialization(preorder string) bool {
    nodes, diff := strings.Split(preorder, ","), 1 // go syntax: short assignment statement with implicit type
    
    for _, value := range nodes {
    
        if diff--; diff < 0 {
            return false
        }
        if value != "#" {
            diff += 2
        }
    }
    return diff == 0
}
