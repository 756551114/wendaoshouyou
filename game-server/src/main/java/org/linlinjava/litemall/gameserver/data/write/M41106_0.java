package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41106_0;
@Service
public class M41106_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_41106_0 object1 = (Vo_41106_0)object;
 GameWriteTool.writeByte(writeBuf,object1.month);

 GameWriteTool.writeInt(writeBuf,object1.startTime);

 GameWriteTool.writeInt(writeBuf,object1.endTime);

 GameWriteTool.writeByte(writeBuf,object1.count);

 GameWriteTool.writeString(writeBuf,object1.item_name0);

 GameWriteTool.writeByte(writeBuf,object1.item_amount0);

 GameWriteTool.writeByte(writeBuf,object1.item_gift0);

 GameWriteTool.writeString(writeBuf,object1.item_icon0);

 GameWriteTool.writeString(writeBuf,object1.item_name1);

 GameWriteTool.writeByte(writeBuf,object1.item_amount1);

 GameWriteTool.writeByte(writeBuf,object1.item_gift1);

 GameWriteTool.writeString(writeBuf,object1.item_icon1);

 GameWriteTool.writeString(writeBuf,object1.item_name2);

 GameWriteTool.writeByte(writeBuf,object1.item_amount2);

 GameWriteTool.writeByte(writeBuf,object1.item_gift2);

 GameWriteTool.writeString(writeBuf,object1.item_icon2);

 GameWriteTool.writeString(writeBuf,object1.item_name3);

 GameWriteTool.writeByte(writeBuf,object1.item_amount3);

 GameWriteTool.writeByte(writeBuf,object1.item_gift3);

 GameWriteTool.writeString(writeBuf,object1.item_icon3);
}@Override
    public int cmd() {
        return 41106;
    }
}





















