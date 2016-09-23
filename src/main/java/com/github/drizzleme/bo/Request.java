package com.github.drizzleme.bo;

import com.github.drizzleme.util.ProtobufSerializableUtil;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.UUID;

/**
 * Created with socket-codec
 *
 * @author ; DRIZZLEME
 *         DATE : 2016/9/23
 */
public class Request {
    private String messageId;
    private String bodyClsName;
    private byte[] body;

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getBodyClsName() {
        return bodyClsName;
    }

    public void setBodyClsName(String bodyClsName) {
        this.bodyClsName = bodyClsName;
    }

    public static Request wrap(Object msg){
        if(msg == null){
            throw new RuntimeException("msg is null");
        }
        Request request = new Request();
        request.setMessageId(UUID.randomUUID().toString());
        request.setBodyClsName(msg.getClass().getName());
        request.setBody(ProtobufSerializableUtil.toByteArray(msg));
        return request;
    }

    public static Request decodec(byte[] bytes){
        if(bytes == null || bytes.length == 0){
            throw new RuntimeException("bytes is null");
        }
        return ProtobufSerializableUtil.mergeFrom(bytes, Request.class);
    }

    public byte[] encode(){
        return ProtobufSerializableUtil.toByteArray(this);
    }
}
