import compzx.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestStringRedisTemplate {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public  void testKey() {
//         判断某个key是否存在
//        Boolean name = stringRedisTemplate.hasKey("username");
//        System.out.println(name);
        //判断key的类型
//        DataType ee = stringRedisTemplate.type("a");
        //返回所有的key
        //Set<String> ee = stringRedisTemplate.keys("*");
        //判断存在时间，-1永久，-2不存在
        //Long ee = stringRedisTemplate.getExpire("ee");
        //随机获得一个key
        //String ee = stringRedisTemplate.randomKey();
        //修改key，原key不存在则报错
        //stringRedisTemplate.rename("a","aa");
        //System.out.println(ee);
        //移动key到指定库
        stringRedisTemplate.move("aa",1);
    }

    @Test
    public void testString() {
        //设置一个string类型数据
        //stringRedisTemplate.opsForValue().set("name","tom");
        //获取redis的value
        //String ee = stringRedisTemplate.opsForValue().get("name");
        //存一个带过期时间的key
        //stringRedisTemplate.opsForValue().set("code","878",120, TimeUnit.SECONDS);
        //stringRedisTemplate.opsForValue().set("namee","哼哼啊啊啊啊");
        //System.out.println(ee);
    }

    @Test
    public void testList(){
        //存入一个list
        //stringRedisTemplate.opsForList().leftPush("lists","tom");
        //一次性存入多个值的list
        //stringRedisTemplate.opsForList().leftPushAll("listes","tom","jack","marry");
        //获取某个list 所有的key
        //List<String> list = stringRedisTemplate.opsForList().range("listes",0,-1);
        //删除范围以外list的key
        //stringRedisTemplate.opsForList().trim("listes", 1, 2);
        //list.forEach(s -> System.out.println(s));
    }
    @Test
    public void testZset(){
        //创建zset类型并存入元素（zset为元素有优先级的set）
        //stringRedisTemplate.opsForZSet().add("zsets","aa",15);
        //获取zset的所有值
        //Set<String> set = stringRedisTemplate.opsForZSet().range("zsets",0,-1);
        //set.forEach(s -> System.out.println(s));
        //返回set大小
        //Long set = stringRedisTemplate.opsForZSet().size("zsets");
        //System.out.println(set);
    }

    @Test
    public void testHash(){
        //存入一个 hash类型数据
        //stringRedisTemplate.opsForHash().put("maps","username","tom");

        //存入有个多个数值的hash
//        HashMap<String,String> map = new HashMap<>();
//        map.put("age", "10");
//        map.put("address", "北京");
//        stringRedisTemplate.opsForHash().putAll("maps",map);

        //获取hash的多个key值
//        List<Object> objects = stringRedisTemplate.opsForHash().multiGet("maps", Arrays.asList("age", "address"));
//        objects.forEach(value-> System.out.println(value));

        //获取hash 单个key对应的值
//        Object o = stringRedisTemplate.opsForHash().get("maps","age");
//        System.out.println(o);

        //获取全部value
        //List<Object> map = stringRedisTemplate.opsForHash().values("maps");

        //获取全部key
        Set<Object> map = stringRedisTemplate.opsForHash().keys("maps");
        map.forEach(a -> System.out.println(a));
    }
}
