package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_24577_0;
@Service
public class M24577_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_24577_0 object1 = (Vo_24577_0)object;
 GameWriteTool.writeShort(writeBuf,object1.left_time);
}@Override
    public int cmd() {
        return 24577;
    }
}


