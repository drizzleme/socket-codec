package com.github.drizzleme.codec;

import com.github.drizzleme.bo.Request;
import com.github.drizzleme.util.ProtobufSerializableUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created with socket-codec
 *
 * @author ; DRIZZLEME
 *         DATE : 2016/9/23
 */
public class RequestDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() > 0){
            byte[] bytes = new byte[in.readableBytes()];
            in.readBytes(bytes, 0, bytes.length);
            out.add(Request.decodec(bytes));
        }

    }
}
