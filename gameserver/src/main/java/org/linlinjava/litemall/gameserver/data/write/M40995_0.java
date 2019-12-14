package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40995_0;
@Service
public class M40995_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_40995_0 object1 = (Vo_40995_0)object;
 GameWriteTool.writeByte(writeBuf,object1.flag);

 GameWriteTool.writeInt(writeBuf,object1.money);

 GameWriteTool.writeString(writeBuf,object1.surlus);

 GameWriteTool.writeString(writeBuf,object1.overflow);

 GameWriteTool.writeInt(writeBuf,object1.amount);

 GameWriteTool.writeByte(writeBuf,object1.choice);

 GameWriteTool.writeByte(writeBuf,object1.prize);

 GameWriteTool.writeByte(writeBuf,object1.leftCount);
}@Override
    public int cmd() {
        return 40995;
    }
}









