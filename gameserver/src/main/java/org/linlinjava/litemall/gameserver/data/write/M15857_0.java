package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_15857_0;
@Service
public class M15857_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_15857_0 object1 = (Vo_15857_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeInt(writeBuf,object1.hitter_id);

 GameWriteTool.writeInt(writeBuf,object1.point);

 GameWriteTool.writeInt(writeBuf,object1.effect_no);

 GameWriteTool.writeInt(writeBuf,object1.damage_type);
}@Override
    public int cmd() {
        return 15857;
    }
}






