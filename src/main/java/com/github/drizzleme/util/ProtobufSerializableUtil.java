package com.github.drizzleme.util;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with socket-codec
 *
 * @author ; DRIZZLEME
 *         DATE : 2016/9/23
 */
public class ProtobufSerializableUtil{
    private ProtobufSerializableUtil(){}

    private static Objenesis objenesis = new ObjenesisStd(true);

    private static ConcurrentHashMap<Class, Schema> schemaCaches = new ConcurrentHashMap<>();

    private static <T> Schema<T> findSchema(Class<T> cls){
        Schema schema = schemaCaches.get(cls);
        if(schema == null){
            synchronized (ProtobufSerializableUtil.class){
                schema = schemaCaches.get(cls);
                if(schema == null){
                    schema = RuntimeSchema.createFrom(cls);
                    schemaCaches.put(cls,schema);
                }
            }
        }
        return schema;
    }


    public static <T> byte[] toByteArray(T obj){
        LinkedBuffer linkedBuffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try{
            return ProtobufIOUtil.toByteArray(obj,(Schema<T>) findSchema(obj.getClass()), linkedBuffer);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            linkedBuffer.clear();
        }
    }

    public static <T> T mergeFrom(byte[] bytes, Class<T> cls){
       T message =  objenesis.newInstance(cls);
        ProtobufIOUtil.mergeFrom(bytes, message, findSchema(cls));
        return message;
    }

}
