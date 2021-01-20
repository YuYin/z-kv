/*
 * www.zdsoft.cn Inc.
 * Copyright (c) 2005-2017 All Rights Reserved.
 */
package com.z.kv;

import org.rocksdb.RocksDBException;

/**
 * @author <a href=mailto:someharder@gmail.com>yinyu</a> 2021/1/20
 */
public interface DbTemplate {
    byte[] get(byte[] key) throws RocksDBException;

     void put(byte[] key,byte[] value) throws RocksDBException;
}
