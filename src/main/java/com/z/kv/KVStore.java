/*
 * www.zdsoft.cn Inc.
 * Copyright (c) 2005-2017 All Rights Reserved.
 */
package com.z.kv;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author <a href=mailto:someharder@gmail.com>yinyu</a> 2021/1/20
 */
public class KVStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(KVStore.class);

    public static RocksDB db;

    public static String dbDir;

    static {
        RocksDB.loadLibrary();
        init();
    }

    private static void init() {
        synchronized (KVStore.class) {
            try {
                if (dbDir == null) {
                    dbDir = "./rocksDB/";
                }
                File file = new File(dbDir);
                boolean success = false;
                if (!file.exists()) {
                    success = file.mkdirs();
                }
                Options options = new Options();
                options.setCreateIfMissing(true);
                db = RocksDB.open(options, dbDir);

            } catch (RocksDBException e) {
             LOGGER.error("init rockdb error",e);
            }
        }
    }
    public static RocksDB getDbInstance(){
        return db;
    }
}
