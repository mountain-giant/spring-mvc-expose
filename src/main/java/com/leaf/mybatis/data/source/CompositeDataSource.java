package com.leaf.mybatis.data.source;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CompositeDataSource extends AbstractRoutingDataSource {

    public final static String READ_ONLY = "READ_ONLY";

    public final static String WRITE = "WRITE";

    public final static ThreadLocal<String> keys = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return CompositeDataSource.WRITE;
        }
    };

    @Override
    protected Object determineCurrentLookupKey() {
        return keys.get();
    }
}
