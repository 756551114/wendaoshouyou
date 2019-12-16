package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53249_1;
@Service
public class M53249_1 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_53249_1 object1 = (Vo_53249_1)object;
 GameWriteTool.writeByte(writeBuf,object1.type);

 GameWriteTool.writeShort(writeBuf,object1.count);

 GameWriteTool.writeString(writeBuf,object1.name0);

 GameWriteTool.writeInt(writeBuf,object1.price0);

 GameWriteTool.writeString(writeBuf,object1.name1);

 GameWriteTool.writeInt(writeBuf,object1.price1);

 GameWriteTool.writeString(writeBuf,object1.name2);

 GameWriteTool.writeInt(writeBuf,object1.price2);

 GameWriteTool.writeString(writeBuf,object1.name3);

 GameWriteTool.writeInt(writeBuf,object1.price3);

 GameWriteTool.writeString(writeBuf,object1.name4);

 GameWriteTool.writeInt(writeBuf,object1.price4);

 GameWriteTool.writeString(writeBuf,object1.name5);

 GameWriteTool.writeInt(writeBuf,object1.price5);
}@Override
    public int cmd() {
        return 53249;
    }
}















