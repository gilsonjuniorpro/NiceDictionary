package nicedictionary.ca.featuredictionary.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import nicedictionary.ca.core.util.Resource
import nicedictionary.ca.featuredictionary.data.local.WordInfoDao
import nicedictionary.ca.featuredictionary.data.remote.DictionaryApi
import nicedictionary.ca.featuredictionary.domain.model.WordInfo
import nicedictionary.ca.featuredictionary.domain.repository.WordInfoRepository
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }

        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Whoops, something went wrong",
                data = wordInfos
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = wordInfos
            ))
        }
    }
}
