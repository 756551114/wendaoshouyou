package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_33049_0;

@Service
public class M33049_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_33049_0 object1 = (Vo_33049_0) object;
        GameWriteTool.writeString(writeBuf, object1.goods_gid);

        GameWriteTool.writeByte(writeBuf, object1.type);

        GameWriteTool.writeByte(writeBuf, object1.result);

        GameWriteTool.writeString(writeBuf, object1.tips);
    }

    @Override
    public int cmd() {
        return 33049;
    }
}





