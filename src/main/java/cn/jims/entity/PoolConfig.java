package cn.jims.entity;

import redis.clients.jedis.JedisPool;

/**
 * Created by Jims on 2017/2/10.
 */
public class PoolConfig extends JedisPool {
    private String ip;
    private int port;
    private long maxActive;
    private long maxIdle;
    private long maxWait;
    private boolean testOnBorrow;

    public PoolConfig() {
    }

    public PoolConfig(String ip,int port,long maxActive, long maxIdle, long maxWait,boolean testOnBorrow) {
        this.ip = ip;
        this.port = port;
        this.maxActive = maxActive;
        this.maxIdle = maxIdle;
        this.maxWait = maxWait;
        this.testOnBorrow = testOnBorrow;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setMaxActive(long maxActive) {
        this.maxActive = maxActive;
    }

    public void setMaxIdle(long maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public long getMaxActive() {
        return maxActive;
    }

    public long getMaxIdle() {
        return maxIdle;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }
}
