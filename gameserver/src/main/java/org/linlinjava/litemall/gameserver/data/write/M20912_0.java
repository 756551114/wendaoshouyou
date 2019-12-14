package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20912_0;
@Service
public class M20912_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_20912_0 object1 = (Vo_20912_0)object;
 GameWriteTool.writeByte(writeBuf,object1.flag);

 GameWriteTool.writeInt(writeBuf,object1.open_time);
}@Override
    public int cmd() {
        return 20912;
    }
}



