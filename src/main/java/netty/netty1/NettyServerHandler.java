package netty.netty1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;

public class NettyServerHandler extends ChannelHandlerAdapter {


    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8);
        System.out.println("The Netty Server receive order:"+body);
        String currentTime="QUERY TIME ORDER".equalsIgnoreCase(body)?new
                java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
        ByteBuf resp= Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
    }

    public void channelReadCompleter(ChannelHandlerContext ctx){
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }


}
