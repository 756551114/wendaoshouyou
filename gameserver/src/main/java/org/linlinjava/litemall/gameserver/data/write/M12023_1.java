package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12023_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M12023_1 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_12023_0 object1 = (Vo_12023_0) object;

        GameWriteTool.writeInt(writeBuf, object1.owner_id);

        GameWriteTool.writeInt(writeBuf, object1.id);
        GameWriteTool.writeShort(writeBuf, 0);


    }

    @Override
    public int cmd() {
        return 12023;
    }
}












