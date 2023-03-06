package com.jemothy.app.anagram

import org.springframework.stereotype.Service

@Service
class AnagramService {
    fun isAnagram(word1: String, word2: String): Boolean {
        val letters1: List<String> = word1.lowercase().replace("\\s+".toRegex(), "").split("").sorted()
        val letters2: List<String> = word2.lowercase().replace("\\s+".toRegex(), "").split("").sorted()
        var isAnagram: Boolean = false
        if (letters1.size != letters2.size) return isAnagram
        if (letters1.all { letters2.contains(it) && letters1.size == letters2.size }){
            isAnagram = true
        }
        return isAnagram
    }
}