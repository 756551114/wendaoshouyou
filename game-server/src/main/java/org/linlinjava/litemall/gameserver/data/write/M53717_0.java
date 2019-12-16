package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53717_0;
@Service
public class M53717_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_53717_0 object1 = (Vo_53717_0)object;
 GameWriteTool.writeInt(writeBuf,object1.attacker_id);

 GameWriteTool.writeInt(writeBuf,object1.victim_id);

 GameWriteTool.writeByte(writeBuf,object1.type);

 GameWriteTool.writeByte(writeBuf,object1.result);

 GameWriteTool.writeString(writeBuf,object1.itemName);
}@Override
    public int cmd() {
        return 53717;
    }
}






