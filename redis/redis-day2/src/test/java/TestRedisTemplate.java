import compzx.Application;
import compzx.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate(){
        /**
         * redisTemplat默认储存的使object类型
         * 默认key value的序列化方式 使用JDK的序列化方式
         * key/value：string 修改默认的key的序列化方案
         */
         //修改key的序列化方式，将key序列化成字符串保存
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //修改value的序列化方式
        //redisTemplate.setValueSerializer(new StringRedisSerializer());

        //修改hash类型数据中 value的key的序列化方式
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        //向redis中存入一个key-value
//        redisTemplate.opsForValue().set("age","18");
//        Object ee = redisTemplate.opsForValue().get("age");
//        System.out.println(ee);
        User user = new User("114","li");
//        redisTemplate.opsForValue().set("user",user);// 保存对象类型的数据时，对象需要进过序列化
//        System.out.println(redisTemplate.opsForValue().get("user"));

        //向redis中存入list类型数据
//        redisTemplate.opsForList().leftPush("lists", user);
//        redisTemplate.opsForSet().add("sets", user);
//        redisTemplate.opsForZSet().add("zsets", user, 10);
//        redisTemplate.opsForHash().put("maps", "user1", user);
         redisTemplate.opsForList().leftPushAll("lists","tom", "marry", "jack");
         redisTemplate.opsForSet().add("sets", "aa");
         redisTemplate.opsForZSet().add("zsets", "bb", 10);
         redisTemplate.opsForHash().put("maps", "name", "tom");
         //每个集合里元素的类型可以不同
    }
}
