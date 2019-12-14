package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40964_0;

@Service
public class M40964_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_40964_0 object1 = (Vo_40964_0) object;
        GameWriteTool.writeShort(writeBuf, object1.type);

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeString(writeBuf, object1.param);

        GameWriteTool.writeShort(writeBuf, object1.rightNow);
    }

    @Override
    public int cmd() {
        return 40964;
    }
}





