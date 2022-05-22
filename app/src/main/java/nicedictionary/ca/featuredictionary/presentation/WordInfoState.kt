package nicedictionary.ca.featuredictionary.presentation

import nicedictionary.ca.featuredictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
