package com.leaf.mybatis.plugin;

import com.leaf.mybatis.data.source.CompositeDataSource;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Method;
import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class SeparatePlugin implements Interceptor {

    private boolean userAnnotation = false;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        String name = method.getName();
        if (!userAnnotation && "query".equals(name)) {
            CompositeDataSource.keys.set(CompositeDataSource.READ_ONLY);
        } else {
            if (method.getAnnotation(ReadOnly.class) != null) {
                if ("query".equals(name)) {
                    CompositeDataSource.keys.set(CompositeDataSource.READ_ONLY);
                }
            }
        }
        return method.invoke(invocation.getTarget(), invocation.getArgs());
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String value = properties.getProperty("userAnnotation");
        if ("true".equals(value)) {
            this.userAnnotation = true;
        }
    }
}
