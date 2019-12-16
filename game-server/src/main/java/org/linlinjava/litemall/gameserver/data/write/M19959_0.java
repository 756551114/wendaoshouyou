package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_19959_0;

@Service
public class M19959_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_19959_0 object1 = (Vo_19959_0) object;
        GameWriteTool.writeShort(writeBuf, object1.round);

        GameWriteTool.writeInt(writeBuf, object1.aid);

        GameWriteTool.writeShort(writeBuf, object1.action);

        GameWriteTool.writeInt(writeBuf, object1.vid);

        GameWriteTool.writeInt(writeBuf, object1.para);
    }

    @Override
    public int cmd() {
        return 19959;
    }
}






