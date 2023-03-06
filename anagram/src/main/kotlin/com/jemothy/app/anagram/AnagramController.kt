package com.jemothy.app.anagram

import com.beust.klaxon.*
import org.springframework.web.bind.annotation.*

@RestController
// Omitted @Autowired annotation as per section 5 https://www.baeldung.com/kotlin/spring-boot-kotlin
class AnagramController(val anagramService: AnagramService) {
    @GetMapping("/")
    fun index() = "Hello World!"

    @PostMapping("/checkAnagram")
    @ResponseBody
    fun checkAnagramPost(@RequestBody words: String): Any {
        val parser: Parser = Parser.default()
        if (words == null || words.isEmpty()) {
            return parser.parse(StringBuilder("""{"result": "Please check inputs" }""")) as JsonObject
        }
        val result = anagramService.isAnagram(words.split(",")[0], words.split(",")[1])
        return parser.parse(StringBuilder("""{"result": $result }""")) as JsonObject
    }
}