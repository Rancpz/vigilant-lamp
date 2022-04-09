import compzx.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestBoundApi {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //spring data 为了方便开发者对redis进行更加友好的操作 提供了boud api的简化操作
    @Test
    public void testBound(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

//        redisTemplate.opsForValue().set("name","tom");
//        Object name = redisTemplate.opsForValue().get("name");
//        redisTemplate.opsForValue().append("name", "你好");
//        Object name1 = redisTemplate.opsForValue().get("name");
//        System.out.println(name + "   " + name1);

        // 对字符串类型的key进行绑定 后续所有操作都基于此key
//        BoundValueOperations<String, String> nameValueOps = stringRedisTemplate.boundValueOps("name");
//        nameValueOps.set("marry");
//        nameValueOps.append("hello!");
//        System.out.println(nameValueOps.get());

        //list set zset hash
        BoundListOperations<String, String> boundValueOperations = stringRedisTemplate.boundListOps("lists");
        boundValueOperations.leftPushAll("aa","bb","cc");
        boundValueOperations.range(0,-1).forEach(u-> System.out.println(u));
    }
    /**
     *  针对处理 key value都是string类型的数据库 使用StringRedisTemplate
     *  针对处理 key value 存在对象的情况下 使用RedisTemplate
     *  针对大量对同一个key进行操作的，可以使用 boundXXXOps 来进行key的绑定
     */
}
