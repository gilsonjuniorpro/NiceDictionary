package nicedictionary.ca.featuredictionary.data.remote.dto

import nicedictionary.ca.featuredictionary.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions?.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}
