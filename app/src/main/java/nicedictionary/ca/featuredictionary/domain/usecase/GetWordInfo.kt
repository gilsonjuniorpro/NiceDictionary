package nicedictionary.ca.featuredictionary.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nicedictionary.ca.core.util.Resource
import nicedictionary.ca.featuredictionary.domain.model.WordInfo
import nicedictionary.ca.featuredictionary.domain.repository.WordInfoRepository

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if(word.isBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word = word)
    }
}
