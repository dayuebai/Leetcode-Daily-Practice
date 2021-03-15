func areAlmostEqual(s1 string, s2 string) bool {
    var arr []int
    for i := 0; i < len(s1); i++ {
        if s1[i] != s2[i] {
            arr = append(arr, i)
        }
        if len(arr) > 2 {
            return false
        }
    }
    
    return len(arr) == 0 || len(arr) == 2 && s1[arr[0]] == s2[arr[1]] && s1[arr[1]] == s2[arr[0]]
}
