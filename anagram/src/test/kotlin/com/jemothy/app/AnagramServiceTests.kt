package com.jemothy.app

import com.jemothy.app.anagram.AnagramService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AnagramServiceTest {
    private val anagramService: AnagramService = AnagramService()
    @Test
    fun shouldBeTrueForActualAnagram() {
        var result = anagramService.isAnagram("TomMarvoloRiddle", "IAmLordVoldemort")
        assertNotNull(result)
        assertTrue(result)
    }

    @Test
    fun shouldBeFalseForBadAnagram() {
        var result = anagramService.isAnagram("jarjarbinks", "harrypotter")
        assertNotNull(result)
        assertFalse(result)
    }

    @Test
    fun shouldReturnFalseWhenRepeatingCharsBreakAnagram() {
        var result1 = anagramService.isAnagram("dessert","stressed")
        assertNotNull(result1)
        assertFalse(result1)
        var result2 = anagramService.isAnagram("1","111")
        assertNotNull(result2)
        assertFalse(result2)
        var result3 = anagramService.isAnagram("222","2")
        assertNotNull(result3)
        assertFalse(result3)
    }
}
