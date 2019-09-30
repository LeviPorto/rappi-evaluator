package com.levi.rappievaluator.service

import com.datastax.driver.core.utils.UUIDs
import com.levi.rappievaluator.RappiEvaluatorApplication
import com.levi.rappievaluator.domain.Rating
import com.levi.rappievaluator.domain.enumeration.ImprovementType
import com.levi.rappievaluator.domain.enumeration.RangeTime
import com.levi.rappievaluator.dto.RatingDTO
import com.levi.rappievaluator.dto.UnitAverageDTO
import com.levi.rappievaluator.dto.UserDTO
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [RappiEvaluatorApplication::class])
@ActiveProfiles("test")
class EvaluationProcessorServiceTest {

    @Autowired
    private val service: EvaluationProcessorService? = null

    @MockBean
    private val cachedEvaluatorProcessorService: CachedEvaluationProcessorService? = null


    companion object {
        private val UUID: UUID = UUIDs.timeBased()
        private val INSTANT: Instant = Instant.now()

        private const val DELTA = 1e-15

        private const val RATING_VALUE_ONE = 1.0
        private const val RATING_VALUE_THREE = 3.0
        private const val RATING_RESTAURANT_ID = 1
        private const val RATING_ORDER_ID = 1
        private const val FIRST_USER_ID = 1
        private const val FIRST_USER_NAME = "Test Name 1"
        private const val SECOND_USER_ID = 2
        private const val SECOND_USER_NAME = "Test Name 2"
        private const val RATING_COMMENT = "Test Comment"
        private const val UNIT_AVERAGE_RATING_COUNT = 1
        private const val UNIT_AVERAGE_RATING_SUM = 4.0
    }

    @Test
    fun calculateAverageRestaurantRatings() {
        val ratings = givenRatings()
        val calculatedValue = service!!.calculateAverageRestaurantRatings(givenActualRating(), ratings)
        Assert.assertEquals(2.0, calculatedValue, DELTA)
    }

    @Test
    fun calculateCachedAverageRestaurantRatings() {
        val cachedUnitAverage = givenUnitAverageStoredInCache()
        val calculatedValue = service!!.calculateCachedAverageRestaurantRatings(givenActualRating(), cachedUnitAverage)
        Assert.assertEquals(3.5, calculatedValue, DELTA)
    }

    private fun givenActualRating(): Rating {
        return Rating(UUID, RATING_VALUE_THREE, RATING_RESTAURANT_ID, RATING_ORDER_ID, FIRST_USER_ID, RATING_COMMENT,
                INSTANT, true, RangeTime.UNTIL_FIFTEEN_MINUTES, ImprovementType.ATTENDANCE)
    }

    private fun givenRatings(): List<RatingDTO> {
        return listOf(RatingDTO(UUID, RATING_VALUE_THREE, RATING_RESTAURANT_ID, UserDTO(FIRST_USER_ID, FIRST_USER_NAME),
                RATING_COMMENT, INSTANT), RatingDTO(UUID, RATING_VALUE_ONE, RATING_RESTAURANT_ID,
                UserDTO(SECOND_USER_ID, SECOND_USER_NAME), RATING_COMMENT, INSTANT))
    }

    private fun givenUnitAverageStoredInCache(): UnitAverageDTO {
        return UnitAverageDTO(UNIT_AVERAGE_RATING_SUM, UNIT_AVERAGE_RATING_COUNT)
    }

}
