package nicedictionary.ca.featuredictionary.domain.model

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)
