package nicedictionary.ca.featuredictionary.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nicedictionary.ca.core.util.GsonParser
import nicedictionary.ca.featuredictionary.data.local.WordInfoDao
import nicedictionary.ca.featuredictionary.data.local.WordInfoDatabase
import nicedictionary.ca.featuredictionary.data.remote.DictionaryApi
import nicedictionary.ca.featuredictionary.data.repository.WordInfoRepositoryImpl
import nicedictionary.ca.featuredictionary.domain.repository.WordInfoRepository
import nicedictionary.ca.featuredictionary.domain.usecase.GetWordInfo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideGetWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGetWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "dictionary_db"
        )
        .addTypeConverter(GsonParser(Gson()))
        .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }


}
