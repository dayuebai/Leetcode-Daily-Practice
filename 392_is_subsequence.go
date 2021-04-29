func isSubsequence(s string, t string) bool {
    i, j := len(s) - 1, len(t) - 1
    for i >= 0 && j >= 0 {
        if s[i] == t[j] {
            i--
            j--
        } else {
            j--
        }
    }
    return i < 0;
}
