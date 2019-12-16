package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32825_0;
@Service
public class M32825_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_32825_0 object1 = (Vo_32825_0)object;
 GameWriteTool.writeString(writeBuf,object1.name0);

 GameWriteTool.writeInt(writeBuf,object1.startTime0);

 GameWriteTool.writeInt(writeBuf,object1.endTime0);

 GameWriteTool.writeString(writeBuf,object1.name1);

 GameWriteTool.writeInt(writeBuf,object1.startTime1);

 GameWriteTool.writeInt(writeBuf,object1.endTime1);

 GameWriteTool.writeString(writeBuf,object1.name2);

 GameWriteTool.writeInt(writeBuf,object1.startTime2);

 GameWriteTool.writeInt(writeBuf,object1.endTime2);

 GameWriteTool.writeString(writeBuf,object1.name3);

 GameWriteTool.writeInt(writeBuf,object1.startTime3);

 GameWriteTool.writeInt(writeBuf,object1.endTime3);

 GameWriteTool.writeString(writeBuf,object1.name4);

 GameWriteTool.writeInt(writeBuf,object1.startTime4);

 GameWriteTool.writeInt(writeBuf,object1.endTime4);

 GameWriteTool.writeString(writeBuf,object1.name5);

 GameWriteTool.writeInt(writeBuf,object1.startTime5);

 GameWriteTool.writeInt(writeBuf,object1.endTime5);

 GameWriteTool.writeString(writeBuf,object1.name6);

 GameWriteTool.writeInt(writeBuf,object1.startTime6);

 GameWriteTool.writeInt(writeBuf,object1.endTime6);

 GameWriteTool.writeString(writeBuf,object1.name7);

 GameWriteTool.writeInt(writeBuf,object1.startTime7);

 GameWriteTool.writeInt(writeBuf,object1.endTime7);

 GameWriteTool.writeString(writeBuf,object1.name8);

 GameWriteTool.writeInt(writeBuf,object1.startTime8);

 GameWriteTool.writeInt(writeBuf,object1.endTime8);

 GameWriteTool.writeString(writeBuf,object1.name9);

 GameWriteTool.writeInt(writeBuf,object1.startTime9);

 GameWriteTool.writeInt(writeBuf,object1.endTime9);

 GameWriteTool.writeString(writeBuf,object1.name10);

 GameWriteTool.writeInt(writeBuf,object1.startTime10);

 GameWriteTool.writeInt(writeBuf,object1.endTime10);

 GameWriteTool.writeString(writeBuf,object1.name11);

 GameWriteTool.writeInt(writeBuf,object1.startTime11);

 GameWriteTool.writeInt(writeBuf,object1.endTime11);

 GameWriteTool.writeString(writeBuf,object1.name12);

 GameWriteTool.writeInt(writeBuf,object1.startTime12);

 GameWriteTool.writeInt(writeBuf,object1.endTime12);

 GameWriteTool.writeString(writeBuf,object1.name13);

 GameWriteTool.writeInt(writeBuf,object1.startTime13);

 GameWriteTool.writeInt(writeBuf,object1.endTime13);

 GameWriteTool.writeString(writeBuf,object1.name14);

 GameWriteTool.writeInt(writeBuf,object1.startTime14);

 GameWriteTool.writeInt(writeBuf,object1.endTime14);

 GameWriteTool.writeString(writeBuf,object1.name15);

 GameWriteTool.writeInt(writeBuf,object1.startTime15);

 GameWriteTool.writeInt(writeBuf,object1.endTime15);

 GameWriteTool.writeString(writeBuf,object1.name16);

 GameWriteTool.writeInt(writeBuf,object1.startTime16);

 GameWriteTool.writeInt(writeBuf,object1.endTime16);

 GameWriteTool.writeString(writeBuf,object1.name17);

 GameWriteTool.writeInt(writeBuf,object1.startTime17);

 GameWriteTool.writeInt(writeBuf,object1.endTime17);

 GameWriteTool.writeString(writeBuf,object1.name18);

 GameWriteTool.writeInt(writeBuf,object1.startTime18);

 GameWriteTool.writeInt(writeBuf,object1.endTime18);
}@Override
    public int cmd() {
        return 32825;
    }
}
