package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_14337_0;
@Service
public class M14337_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_14337_0 object1 = (Vo_14337_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeInt(writeBuf,object1.type);

 GameWriteTool.writeInt(writeBuf,object1.life_plus);

 GameWriteTool.writeInt(writeBuf,object1.max_life_plus);

 GameWriteTool.writeInt(writeBuf,object1.mana_plus);

 GameWriteTool.writeInt(writeBuf,object1.max_mana_plus);

 GameWriteTool.writeInt(writeBuf,object1.phy_power_plus);

 GameWriteTool.writeInt(writeBuf,object1.mag_power_plus);

 GameWriteTool.writeInt(writeBuf,object1.speed_plus);

 GameWriteTool.writeInt(writeBuf,object1.def_plus);

 GameWriteTool.writeByte(writeBuf,object1.free);
}@Override
    public int cmd() {
        return 14337;
    }
}












