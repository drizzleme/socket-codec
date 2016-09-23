package com.github.drizzleme;

import com.github.drizzleme.util.ProtobufSerializableUtil;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with socket-codec
 *
 * @author ; DRIZZLEME
 * DATE : 2016/9/23
 */
public class ProtobufStuffTest {
    public static void main(String[] args) {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Caffe caffe = new Caffe();
        caffe.setId(current.nextInt(100));
        caffe.setFlag((byte) current.nextInt(Byte.MAX_VALUE));
        caffe.setHeader(UUID.randomUUID().toString());
        byte[] testStrBytes = caffe.getHeader().getBytes();
        current.nextBytes(testStrBytes);
        caffe.setBytes(testStrBytes);
        caffe.setQuest(current.nextBoolean());
        caffe.setVal((float) current.nextGaussian());
        caffe.setD21(current.nextGaussian());

        CaffeInnner caffeInner = new CaffeInnner();
        caffeInner.setId(current.nextInt(100));
        caffeInner.setFlag((byte) current.nextInt(Byte.MAX_VALUE));
        caffeInner.setHeader(UUID.randomUUID().toString());
        testStrBytes = caffe.getHeader().getBytes();
        current.nextBytes(testStrBytes);
        caffeInner.setBytes(testStrBytes);
        caffeInner.setQuest(current.nextBoolean());
        caffeInner.setVal((float) current.nextGaussian());
        caffeInner.setD21(current.nextGaussian());

        caffe.setCaffeInnner(caffeInner);

        final byte[] r = ProtobufSerializableUtil.toByteArray(caffe);

        Caffe c =  ProtobufSerializableUtil.mergeFrom(r, Caffe.class);
        System.out.println(caffe.equals(c));
        System.out.println(c);
        System.out.println(caffe);
    }
}
