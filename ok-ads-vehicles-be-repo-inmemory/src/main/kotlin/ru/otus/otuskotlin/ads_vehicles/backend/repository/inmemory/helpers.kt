package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory

import org.cache2k.Cache
import org.cache2k.Cache2kBuilder
import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel
import java.util.concurrent.TimeUnit
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun <D, M : IModel> buildCache(
        ttl: Duration,
        initObjects: Collection<M>,
        mappingFunc: (M) -> D
): Cache<String, D> = object : Cache2kBuilder<String, D>() {}
        .expireAfterWrite(ttl.toLongMilliseconds(), TimeUnit.MILLISECONDS)
        .suppressExceptions(false)
        .build()
        .also { cache ->
            initObjects.forEach {
                if (!cache.containsKey(it.id)) {
                    cache.put(it.id, mappingFunc(it))
                }
            }
        }