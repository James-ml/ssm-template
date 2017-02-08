package cn.jims.dao.cache;

import cn.jims.entity.Book;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis缓存
 */
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private JedisPool jedisPool;
    private RuntimeSchema<Book> schema = RuntimeSchema.createFrom(Book.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Book getBook(long bookId) {
        //redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "book:" + bookId;
                //并没有实现内部序列化操作
                //get-->byte[]-->反序列化-->Object(Book)
                //采用自定义序列化方式
                //protostuff:entity.
                byte[] bytes = jedis.get(key.getBytes());
                // protostuff序列化 entity
                if (bytes != null) {
                    // 反序列化
                    Book book = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, book, schema);
                    return book;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putBook(Book book) {
        // Book-->序列化-->byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "book:" + book.getBookid();
                byte[] bytes = ProtostuffIOUtil.toByteArray(book, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //缓存时间
                int timeout = 60 * 60; // 1小时
                String result = jedis.setex(key.getBytes(), timeout, bytes);
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
