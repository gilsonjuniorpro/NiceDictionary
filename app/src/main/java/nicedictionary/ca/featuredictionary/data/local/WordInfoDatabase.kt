package nicedictionary.ca.featuredictionary.data.local

import androidx.room.Database
import androidx.room.TypeConverters
import nicedictionary.ca.featuredictionary.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase {

    abstract val dao: WordInfoDao

}
