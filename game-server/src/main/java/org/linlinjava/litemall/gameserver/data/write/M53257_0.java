package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53257_0;
@Service
public class M53257_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_53257_0 object1 = (Vo_53257_0)object;
 GameWriteTool.writeByte(writeBuf,object1.vipType);

 GameWriteTool.writeInt(writeBuf,object1.leftTime);

 GameWriteTool.writeInt(writeBuf,object1.curTime);

 GameWriteTool.writeByte(writeBuf,object1.isGet);

 GameWriteTool.writeByte(writeBuf,object1.tempInsider);
}@Override
    public int cmd() {
        return 53257;
    }
}

