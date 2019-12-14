package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49169_0;
@Service
public class M49169_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_49169_0 object1 = (Vo_49169_0)object;
 GameWriteTool.writeByte(writeBuf,object1.monthDays);

 GameWriteTool.writeByte(writeBuf,object1.signDays);

 GameWriteTool.writeByte(writeBuf,object1.isCanSgin);

 GameWriteTool.writeByte(writeBuf,object1.isCanReplenishSign);

 GameWriteTool.writeString(writeBuf,object1.name0);

 GameWriteTool.writeInt(writeBuf,object1.number0);

 GameWriteTool.writeString(writeBuf,object1.name1);

 GameWriteTool.writeInt(writeBuf,object1.number1);

 GameWriteTool.writeString(writeBuf,object1.name2);

 GameWriteTool.writeInt(writeBuf,object1.number2);

 GameWriteTool.writeString(writeBuf,object1.name3);

 GameWriteTool.writeInt(writeBuf,object1.number3);

 GameWriteTool.writeString(writeBuf,object1.name4);

 GameWriteTool.writeInt(writeBuf,object1.number4);

 GameWriteTool.writeString(writeBuf,object1.name5);

 GameWriteTool.writeInt(writeBuf,object1.number5);

 GameWriteTool.writeString(writeBuf,object1.name6);

 GameWriteTool.writeInt(writeBuf,object1.number6);

 GameWriteTool.writeString(writeBuf,object1.name7);

 GameWriteTool.writeInt(writeBuf,object1.number7);

 GameWriteTool.writeString(writeBuf,object1.name8);

 GameWriteTool.writeInt(writeBuf,object1.number8);

 GameWriteTool.writeString(writeBuf,object1.name9);

 GameWriteTool.writeInt(writeBuf,object1.number9);

 GameWriteTool.writeString(writeBuf,object1.name10);

 GameWriteTool.writeInt(writeBuf,object1.number10);

 GameWriteTool.writeString(writeBuf,object1.name11);

 GameWriteTool.writeInt(writeBuf,object1.number11);

 GameWriteTool.writeString(writeBuf,object1.name12);

 GameWriteTool.writeInt(writeBuf,object1.number12);

 GameWriteTool.writeString(writeBuf,object1.name13);

 GameWriteTool.writeInt(writeBuf,object1.number13);

 GameWriteTool.writeString(writeBuf,object1.name14);

 GameWriteTool.writeInt(writeBuf,object1.number14);

 GameWriteTool.writeString(writeBuf,object1.name15);

 GameWriteTool.writeInt(writeBuf,object1.number15);

 GameWriteTool.writeString(writeBuf,object1.name16);

 GameWriteTool.writeInt(writeBuf,object1.number16);

 GameWriteTool.writeString(writeBuf,object1.name17);

 GameWriteTool.writeInt(writeBuf,object1.number17);

 GameWriteTool.writeString(writeBuf,object1.name18);

 GameWriteTool.writeInt(writeBuf,object1.number18);

 GameWriteTool.writeString(writeBuf,object1.name19);

 GameWriteTool.writeInt(writeBuf,object1.number19);

 GameWriteTool.writeString(writeBuf,object1.name20);

 GameWriteTool.writeInt(writeBuf,object1.number20);

 GameWriteTool.writeString(writeBuf,object1.name21);

 GameWriteTool.writeInt(writeBuf,object1.number21);

 GameWriteTool.writeString(writeBuf,object1.name22);

 GameWriteTool.writeInt(writeBuf,object1.number22);

 GameWriteTool.writeString(writeBuf,object1.name23);

 GameWriteTool.writeInt(writeBuf,object1.number23);

 GameWriteTool.writeString(writeBuf,object1.name24);

 GameWriteTool.writeInt(writeBuf,object1.number24);

 GameWriteTool.writeString(writeBuf,object1.name25);

 GameWriteTool.writeInt(writeBuf,object1.number25);

 GameWriteTool.writeString(writeBuf,object1.name26);

 GameWriteTool.writeInt(writeBuf,object1.number26);

 GameWriteTool.writeString(writeBuf,object1.name27);

 GameWriteTool.writeInt(writeBuf,object1.number27);

 GameWriteTool.writeString(writeBuf,object1.name28);

 GameWriteTool.writeInt(writeBuf,object1.number28);

 GameWriteTool.writeString(writeBuf,object1.name29);

 GameWriteTool.writeInt(writeBuf,object1.number29);

 GameWriteTool.writeString(writeBuf,object1.name30);

 GameWriteTool.writeInt(writeBuf,object1.number30);
}@Override
    public int cmd() {
        return 49169;
    }
}



































































