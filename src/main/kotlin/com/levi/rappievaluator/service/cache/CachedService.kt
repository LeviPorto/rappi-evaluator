package com.levi.rappievaluator.service.cache

import java.util.concurrent.TimeUnit

interface CachedService<K, V> {

    fun retrieveInCache(key: K): V?

    fun saveInCache(key: K, value: V, unit: Int, timeUnit: TimeUnit)

}
