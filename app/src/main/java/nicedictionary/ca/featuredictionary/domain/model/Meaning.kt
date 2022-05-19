package nicedictionary.ca.featuredictionary.domain.model

import nicedictionary.ca.featuredictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)
