package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41488_0;
@Service
public class M41488_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_41488_0 object1 = (Vo_41488_0)object;
 GameWriteTool.writeByte(writeBuf,object1.flag);

 GameWriteTool.writeByte(writeBuf,object1.label);

 GameWriteTool.writeString(writeBuf,object1.para);

 GameWriteTool.writeShort(writeBuf,object1.count2);

 GameWriteTool.writeString(writeBuf,object1.name0);

 GameWriteTool.writeInt(writeBuf,object1.goods_price0);

 GameWriteTool.writeString(writeBuf,object1.name1);

 GameWriteTool.writeInt(writeBuf,object1.goods_price1);

 GameWriteTool.writeString(writeBuf,object1.name2);

 GameWriteTool.writeInt(writeBuf,object1.goods_price2);

 GameWriteTool.writeString(writeBuf,object1.name3);

 GameWriteTool.writeInt(writeBuf,object1.goods_price3);

 GameWriteTool.writeString(writeBuf,object1.name4);

 GameWriteTool.writeInt(writeBuf,object1.goods_price4);

 GameWriteTool.writeString(writeBuf,object1.name5);

 GameWriteTool.writeInt(writeBuf,object1.goods_price5);

 GameWriteTool.writeString(writeBuf,object1.name6);

 GameWriteTool.writeInt(writeBuf,object1.goods_price6);

 GameWriteTool.writeString(writeBuf,object1.name7);

 GameWriteTool.writeInt(writeBuf,object1.goods_price7);

 GameWriteTool.writeString(writeBuf,object1.name8);

 GameWriteTool.writeInt(writeBuf,object1.goods_price8);

 GameWriteTool.writeString(writeBuf,object1.name9);

 GameWriteTool.writeInt(writeBuf,object1.goods_price9);

 GameWriteTool.writeString(writeBuf,object1.name10);

 GameWriteTool.writeInt(writeBuf,object1.goods_price10);

 GameWriteTool.writeString(writeBuf,object1.name11);

 GameWriteTool.writeInt(writeBuf,object1.goods_price11);

 GameWriteTool.writeString(writeBuf,object1.name12);

 GameWriteTool.writeInt(writeBuf,object1.goods_price12);

 GameWriteTool.writeString(writeBuf,object1.name13);

 GameWriteTool.writeInt(writeBuf,object1.goods_price13);

 GameWriteTool.writeString(writeBuf,object1.name14);

 GameWriteTool.writeInt(writeBuf,object1.goods_price14);

 GameWriteTool.writeString(writeBuf,object1.name15);

 GameWriteTool.writeInt(writeBuf,object1.goods_price15);

 GameWriteTool.writeString(writeBuf,object1.name16);

 GameWriteTool.writeInt(writeBuf,object1.goods_price16);

 GameWriteTool.writeString(writeBuf,object1.name17);

 GameWriteTool.writeInt(writeBuf,object1.goods_price17);

 GameWriteTool.writeString(writeBuf,object1.name18);

 GameWriteTool.writeInt(writeBuf,object1.goods_price18);

 GameWriteTool.writeString(writeBuf,object1.name19);

 GameWriteTool.writeInt(writeBuf,object1.goods_price19);
}@Override
    public int cmd() {
        return 41488;
    }
}













































