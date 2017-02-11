package cn.jims.dao.cache;

import cn.jims.entity.Book;
import cn.jims.entity.PoolConfig;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * redis缓存
 */
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PoolConfig jedisPool;

    //protostuff序列化entity.
    private RuntimeSchema<Book> schema = RuntimeSchema.createFrom(Book.class);

    /*public RedisDao(String ip, int port) {
        JedisPool jedisPool = new JedisPool(ip,port);
    }*/
    //JedisPool jedisPool = new PoolConfig();

    public Book getBook(long bookId) {
        System.out.println(jedisPool.getIp()+"==="+jedisPool.getPort());
        //redis操作逻辑
        try {
            System.out.println("========7===========");
            Jedis jedis = jedisPool.getResource();
            System.out.println("========8===========");
            try {
                String key = "book:" + bookId;
                //并没有实现内部序列化操作
                //get-->byte[]-->反序列化-->Object(Book)
                //采用自定义序列化方式
                byte[] bytes = jedis.get(key.getBytes());
                // 缓存中获取
                if (bytes != null) {
                    //空对象
                    Book book = schema.newMessage();
                    // 反序列化
                    ProtostuffIOUtil.mergeFrom(bytes, book, schema);
                    return book;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        System.out.println("=======9========");
        return null;
    }

    public String putBook(Book book) {
        // Book-->序列化-->byte[]
        try {
            System.out.println("=========5=========");
            Jedis jedis = jedisPool.getResource();
            System.out.println("=========6=========");
            try {
                System.out.println("=========1========");
                String key = "book:" + book.getBookid();
                byte[] bytes = ProtostuffIOUtil.toByteArray(book, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //缓存时间
                int timeout = 60 * 60; // 1小时
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                System.out.println("=========2========");
                System.out.println(result);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
