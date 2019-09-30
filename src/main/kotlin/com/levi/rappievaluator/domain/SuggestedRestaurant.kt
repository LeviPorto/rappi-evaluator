package com.levi.rappievaluator.domain

import com.datastax.driver.core.utils.UUIDs
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.io.Serializable
import java.util.*
import javax.validation.constraints.NotNull

@Table
class SuggestedRestaurant(@PrimaryKey val id: UUID = UUIDs.timeBased(),
                          @NotNull @Column val name: String,
                          @NotNull @Column val address: String,
                          @Column val count: Int,
                          @NotNull @Column val phone: String) : Serializable {
    constructor(id: UUID, name: String, address: String, phone: String) : this(id, name, address, 1, phone)
}
