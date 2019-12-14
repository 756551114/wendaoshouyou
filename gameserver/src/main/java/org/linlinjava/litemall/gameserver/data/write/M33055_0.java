package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_33055_0;
@Service
public class M33055_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_33055_0 object1 = (Vo_33055_0)object;
 GameWriteTool.writeByte(writeBuf,object1.is_enable);

 GameWriteTool.writeByte(writeBuf,object1.enable_gold_stall_cash);

 GameWriteTool.writeByte(writeBuf,object1.sell_cash_aft_days);

 GameWriteTool.writeByte(writeBuf,object1.start_gold_stall_cash);

 GameWriteTool.writeByte(writeBuf,object1.enable_appoint);

 GameWriteTool.writeByte(writeBuf,object1.enable_autcion);

 GameWriteTool.writeInt(writeBuf,object1.close_time);
}@Override
    public int cmd() {
        return 33055;
    }
}








