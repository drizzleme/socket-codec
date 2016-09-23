package com.github.drizzleme.codec;

import com.github.drizzleme.bo.Request;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created with socket-codec
 *
 * @author ; DRIZZLEME
 *         DATE : 2016/9/23
 */
public class RequestEncoder extends MessageToByteEncoder<Request>{
    @Override
    protected void encode(ChannelHandlerContext ctx, Request msg, ByteBuf out) throws Exception {
        byte[] r = msg.encode();
        ByteBuf buf = Unpooled.buffer(r.length + 4);
        buf.writeInt(r.length);
        buf.writeBytes(r);
        out.writeBytes(buf);
    }
}
