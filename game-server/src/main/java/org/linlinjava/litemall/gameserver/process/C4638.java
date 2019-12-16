package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8131_0;
import org.linlinjava.litemall.gameserver.data.write.M8131_0;
import org.springframework.stereotype.Service;

@Service
public class C4638 implements GameHandler {
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        ByteBuf type = GameReadTool.readLenBuffer2(buff);

        int cookie = GameReadTool.readInt(buff);

        Vo_8131_0 vo_8131_0 = new Vo_8131_0();
        vo_8131_0.buf = "";
        vo_8131_0.cookie = cookie+1;
        new M8131_0().write(vo_8131_0);
    }

    @Override
    public int cmd() {
        return 4638;
    }
}
