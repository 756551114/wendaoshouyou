package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12028_0;
@Service
public class M12028_0  extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_12028_0 object1 = (Vo_12028_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeShort(writeBuf,object1.effect_no);

 GameWriteTool.writeInt(writeBuf,object1.type);
 if(object1.name!=null){
     GameWriteTool.writeString(writeBuf,object1.name);
 }
}@Override
    public int cmd() {
        return 12028;
    }
}




