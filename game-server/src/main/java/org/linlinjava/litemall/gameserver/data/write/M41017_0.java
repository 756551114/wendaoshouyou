package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

@Service
public class M41017_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {

        GameWriteTool.writeByte(writeBuf, 4);

        GameWriteTool.writeString(writeBuf, "xiux");

        GameWriteTool.writeString(writeBuf, "xiuxjz");

        GameWriteTool.writeString(writeBuf, "xiuxjz");

        GameWriteTool.writeString(writeBuf, "xiuxjz");
    }

    @Override
    public int cmd() {
        return 41017;
    }
}






