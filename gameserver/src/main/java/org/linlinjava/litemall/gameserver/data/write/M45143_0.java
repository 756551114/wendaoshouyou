package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45143_0;
@Service
public class M45143_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_45143_0 object1 = (Vo_45143_0)object;
 GameWriteTool.writeString(writeBuf,object1.line_name);

 GameWriteTool.writeInt(writeBuf,object1.expect_time);

 GameWriteTool.writeInt(writeBuf,object1.reconnet_time);

 GameWriteTool.writeInt(writeBuf,object1.waitCode);

 GameWriteTool.writeInt(writeBuf,object1.count);

 GameWriteTool.writeByte(writeBuf,object1.keep_alive);

 GameWriteTool.writeByte(writeBuf,object1.need_wait);

 GameWriteTool.writeByte(writeBuf,object1.indsider_lv);

 GameWriteTool.writeInt(writeBuf,object1.gold_coin);

 GameWriteTool.writeByte(writeBuf,object1.status);
}@Override
    public int cmd() {
        return 45143;
    }
}











