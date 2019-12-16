package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53377_0;
@Service
public class M53377_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_53377_0 object1 = (Vo_53377_0)object;
 GameWriteTool.writeInt(writeBuf,object1.dsicountMonthPrice);

 GameWriteTool.writeInt(writeBuf,object1.dsicountQuaterPrice);

 GameWriteTool.writeInt(writeBuf,object1.dsicountYearPrice);

 GameWriteTool.writeInt(writeBuf,object1.startTime);

 GameWriteTool.writeInt(writeBuf,object1.endTime);
}@Override
    public int cmd() {
        return 53377;
    }
}






