package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45072_0;
import org.linlinjava.litemall.gameserver.data.write.M45072_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;


@Service
public class C45073_0 implements GameHandler {

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        int gender = GameReadTool.readByte(buff);

        String arr = getRandomJianHan();
        Vo_45072_0 vo_45072_0 = new Vo_45072_0();
        vo_45072_0.new_name = getRandomJianHan();
        final ByteBuf write = new M45072_0().write(vo_45072_0);
        ctx.writeAndFlush(write);
    }

    @Override
    public int cmd() {
        return 45073;
    }

    public  String getRandomJianHan() {
        Random random = new Random();
        int len = random.nextInt(2) + 3;
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        if (GameData.that.baseCharactersService.findOneByName(ret) != null) {
            getRandomJianHan();
        }
        return ret;
    }
}