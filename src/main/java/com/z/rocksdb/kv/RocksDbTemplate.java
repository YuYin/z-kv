package com.z.rocksdb.kv;

import org.rocksdb.RocksDBException;

/**
 * @author <a href=mailto:someharder@gmail.com>yinyu</a> 2021/1/20
 */
public class RocksDbTemplate implements DbTemplate {
    public byte[] get(byte[] key) throws RocksDBException {
        return KVStore.getDbInstance().get(key);
    }

    public void put(byte[] key, byte[] value) throws RocksDBException {
         KVStore.getDbInstance().put(key,value);
    }
}
