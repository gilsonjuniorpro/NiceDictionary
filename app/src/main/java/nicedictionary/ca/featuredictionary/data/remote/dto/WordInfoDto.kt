package nicedictionary.ca.featuredictionary.data.remote.dto

import nicedictionary.ca.featuredictionary.data.local.entity.WordInfoEntity
import nicedictionary.ca.featuredictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val phonetic: String?,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>?,
    val word: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings?.map { it.toMeaning() },
            phonetic = phonetic,
            sourceUrls = sourceUrls?.get(0),
            word = word
        )
    }

    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            sourceUrls = sourceUrls?.get(0),
            word = word
        )
    }
}
