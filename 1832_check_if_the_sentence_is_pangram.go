func checkIfPangram(sentence string) bool {
    charSet := make(map[byte]int)
    for i := 0; i < len(sentence); i++ {
        charSet[sentence[i]] += 1
    }
    return len(charSet) == 26
}
