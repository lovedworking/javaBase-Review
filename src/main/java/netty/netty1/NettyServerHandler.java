package netty.netty1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class NettyServerHandler extends ChannelHandlerAdapter {
    private int counter;
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, StandardCharsets.UTF_8).substring(0,
//                req.length-System.getProperty("line.separator").length());
        String body=(String)msg;
        System.out.println("The Netty Server receive order:"+body+";the counter is: "+ ++counter);
        String currentTime="QUERY TIME ORDER".equalsIgnoreCase(body)?new
                java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
        currentTime=currentTime+System.getProperty("line.separator");
        ByteBuf resp= Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        ctx.close();
    }


}
