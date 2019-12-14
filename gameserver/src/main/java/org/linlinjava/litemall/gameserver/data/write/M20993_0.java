package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20993_0;
@Service
public class M20993_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_20993_0 object1 = (Vo_20993_0)object;
 GameWriteTool.writeByte(writeBuf,object1.is_startup);

 GameWriteTool.writeInt(writeBuf,object1.total_online);

 GameWriteTool.writeInt(writeBuf,object1.last_online);

 GameWriteTool.writeByte(writeBuf,object1.adult_status);

 GameWriteTool.writeByte(writeBuf,object1.switch3);

 GameWriteTool.writeByte(writeBuf,object1.switch5);

 GameWriteTool.writeByte(writeBuf,object1.second_enable);

 GameWriteTool.writeByte(writeBuf,object1.switch7);

 GameWriteTool.writeShort(writeBuf,object1.player_age);

 GameWriteTool.writeByte(writeBuf,object1.is_guest);

 GameWriteTool.writeShort(writeBuf,object1.small_age);

 GameWriteTool.writeInt(writeBuf,object1.young_coin_cost_limit);

 GameWriteTool.writeInt(writeBuf,object1.small_age_online);

 GameWriteTool.writeInt(writeBuf,object1.young_online);
}@Override
    public int cmd() {
        return 20993;
    }
}















