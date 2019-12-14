package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32896_0;
@Service
public class M32896_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_32896_0 object1 = (Vo_32896_0)object;
 GameWriteTool.writeString(writeBuf,object1.alias0);

 GameWriteTool.writeString(writeBuf,object1.alias1);

 GameWriteTool.writeString(writeBuf,object1.alias2);

 GameWriteTool.writeString(writeBuf,object1.alias3);

 GameWriteTool.writeString(writeBuf,object1.alias4);

 GameWriteTool.writeString(writeBuf,object1.alias5);

 GameWriteTool.writeString(writeBuf,object1.alias6);
}@Override
    public int cmd() {
        return 32896;
    }
}








