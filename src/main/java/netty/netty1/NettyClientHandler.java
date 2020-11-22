package netty.netty1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class NettyClientHandler  extends ChannelHandlerAdapter {
    private static final Logger logger=Logger.getLogger(NettyClientHandler.class.getName());
    private int counter;
    private byte[] req;
    public NettyClientHandler() {
         req=("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
    }

    public void channelActive(ChannelHandlerContext ctx){
        ByteBuf message=null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    public void channelRead(ChannelHandlerContext ctx,Object msg) {
//        ByteBuf buf=(ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, StandardCharsets.UTF_8);
        String body=(String) msg;
        System.out.println("Now is: "+body+" ;the counter is: "+ ++counter);

    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        logger.warning("Unexpected excetpion from downstream:"+cause.getMessage());
        ctx.close();
    }


}
