package nicedictionary.ca.featuredictionary.domain.model

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)
