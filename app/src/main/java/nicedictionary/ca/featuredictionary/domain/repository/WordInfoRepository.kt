package nicedictionary.ca.featuredictionary.domain.repository

import kotlinx.coroutines.flow.Flow
import nicedictionary.ca.core.util.Resource
import nicedictionary.ca.featuredictionary.domain.model.WordInfo

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>

}
