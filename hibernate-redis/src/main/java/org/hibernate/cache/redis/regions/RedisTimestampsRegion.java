package org.hibernate.cache.redis.regions;

import org.hibernate.cache.redis.RedisClient;
import org.hibernate.cache.redis.strategy.IRedisAccessStrategyFactory;
import org.hibernate.cache.spi.TimestampsRegion;

import java.util.Properties;

/**
 * A timestamps region specific wrapper around an Redis instance.
 *
 * @author sunghyouk.bae@gmail.com
 * @since 13. 4. 5. 오후 11:56
 */
public class RedisTimestampsRegion extends RedisGeneralDataRegion implements TimestampsRegion {

    public RedisTimestampsRegion(IRedisAccessStrategyFactory accessStrategyFactory,
                                 RedisClient redis,
                                 String regionName,
                                 Properties props) {
        super(accessStrategyFactory, redis, regionName, props);
    }
}
