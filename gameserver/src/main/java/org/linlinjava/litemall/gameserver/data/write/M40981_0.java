package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40981_0;
@Service
public class M40981_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_40981_0 object1 = (Vo_40981_0)object;
 GameWriteTool.writeInt(writeBuf,object1.start_time);

 GameWriteTool.writeInt(writeBuf,object1.end_time);

 GameWriteTool.writeShort(writeBuf,object1.icon);

 GameWriteTool.writeString(writeBuf,object1.word);

 GameWriteTool.writeString(writeBuf,object1.gather_style);
}@Override
    public int cmd() {
        return 40981;
    }
}






