package compzx.cache;


import compzx.utils.ApplicationContextUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


public class RedisCache implements Cache {

    //catch  必须有一个string类型的id参数
    //当前放入缓存的mapper的namespace的值
    private final String id;

    //该参数必须要有一个构造方法
    public RedisCache(String id){
        System.out.println("!@#" + id);
        this.id = id;
    }


    //返回缓存的唯一标识
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        System.out.println("Key:" + key);
        System.out.println("value:" +value);
        getRedisTemplate().opsForHash().put(id.toString(), key.toString(),value);
    }

    @Override
    public Object getObject(Object key) {
        System.out.println("===========本次操作是缓存==========");
        System.out.println("===========" + key.toString());
        return getRedisTemplate().opsForHash().get(id.toString(),key.toString());
    }

    //此方法为mybatis的保留方法，默认没有实现
    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        System.out.println("==========清空缓存======");
        getRedisTemplate().delete(id.toString());
    }

    //清空缓存的方法
    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id.toString()).intValue();
    }

    // 封装redisTemplate方法
    private RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtil.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
