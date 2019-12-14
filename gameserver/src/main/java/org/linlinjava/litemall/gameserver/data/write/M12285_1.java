package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M12285_1 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        int id = (int) object;
        GameWriteTool.writeInt(writeBuf,id);
        GameWriteTool.writeByte(writeBuf,1);
    }

    @Override
    public int cmd() {
        return 12285;
    }
}











