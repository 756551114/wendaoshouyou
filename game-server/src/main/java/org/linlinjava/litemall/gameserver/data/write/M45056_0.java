package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45056_0;
@Service
public class M45056_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_45056_0 object1 = (Vo_45056_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeString(writeBuf,object1.name);

 GameWriteTool.writeShort(writeBuf,object1.portrait);

 GameWriteTool.writeShort(writeBuf,object1.pic_no);

 GameWriteTool.writeString2(writeBuf,object1.content);

 GameWriteTool.writeShort(writeBuf,object1.isComplete);

 GameWriteTool.writeByte(writeBuf,object1.isInCombat);

 GameWriteTool.writeShort(writeBuf,object1.playTime);

 GameWriteTool.writeString(writeBuf,object1.task_type);
}@Override
    public int cmd() {
        return 45056;
    }
}










