package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16429_0;
@Service
public class M16429_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_16429_0 object1 = (Vo_16429_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeShort(writeBuf,object1.x);

 GameWriteTool.writeShort(writeBuf,object1.y);

 GameWriteTool.writeInt(writeBuf,object1.map_id);
}@Override
    public int cmd() {
        return 16429;
    }
}





