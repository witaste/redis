package redisCluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;

@ContextConfiguration(locations = {"classpath:beans-redis.xml"})
@RunWith(SpringJUnit4ClassRunner.class) 
public class TestRedisCluster {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Test
	public void tt(){
		String key = "mmsitestkey";
		if(!jedisCluster.exists(key)){
			jedisCluster.set(key, "1");
			System.out.println(jedisCluster.get(key));
			jedisCluster.del(key);
			System.out.println(jedisCluster.get(key));
			System.out.println(jedisCluster.getClusterNodes());
		}else{
			System.out.println(jedisCluster.get(key));
		}
		
		
		
		
	}
	
	@Test
	public void teststr(){
		String form = "mmsihld"+"%s"+"num";
		
		System.out.println(String.format(form, "123123"));
	}
}
