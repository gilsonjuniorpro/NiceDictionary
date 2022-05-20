package nicedictionary.ca.featuredictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import nicedictionary.ca.featuredictionary.domain.model.Meaning
import nicedictionary.ca.featuredictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val sourceUrls: String?,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            phonetic = phonetic,
            sourceUrls = sourceUrls,
            meanings = meanings
        )
    }
}

