package nicedictionary.ca.featuredictionary.domain.model

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: String?,
    val word: String
)
