package org.hibernate.cache.redis;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.redis.util.RedisTool;
import org.hibernate.cfg.Settings;

import java.util.Properties;

/**
 * A non-singleton RedisRegionFactory implementation.
 *
 * @author sunghyouk.bae@gmail.com
 * @since 13. 4. 6. 오전 12:41
 */
@Slf4j
public class RedisRegionFactory extends AbstractRedisRegionFactory {

    private RedisClient redis;

    public RedisRegionFactory(Properties props) {
        super(props);
    }

    @Override
    public void start(Settings settings, Properties properties) throws CacheException {
        if (log.isDebugEnabled())
            log.debug("Start region factory");

        this.settings = settings;

        try {
            this.redis = RedisTool.createRedisClient(props);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

    @Override
    public void stop() {
        if (log.isDebugEnabled())
            log.debug("Stop regoin factory");

        try {
            redis.flushDb();
            redis = null;
        } catch (Exception e) {
            log.error("redis region factory fail to stop.", e);
        }
    }
}
