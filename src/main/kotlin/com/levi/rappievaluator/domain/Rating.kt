package com.levi.rappievaluator.domain

import com.datastax.driver.core.utils.UUIDs
import com.levi.rappievaluator.domain.enumeration.ImprovementType
import com.levi.rappievaluator.domain.enumeration.RangeTime
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.Indexed
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.io.Serializable
import java.time.Instant
import java.util.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Table
class Rating(
        @PrimaryKey val id: UUID = UUIDs.timeBased(),
        @NotNull @Min(1) @Max(5) @Column val value: Double,
        @NotNull @Indexed @Column val restaurantId: Int,
        @NotNull @Column val orderId: Int,
        @NotNull @Column val userId: Int,
        @Column val comment: String,
        @NotNull @Column val date: Instant,
        @Column val arrivedOnTime: Boolean,
        @Column val arrivalRangeTime: RangeTime,
        @Column val improvementType: ImprovementType
) : Serializable
