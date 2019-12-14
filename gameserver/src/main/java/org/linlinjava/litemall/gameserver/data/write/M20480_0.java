package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20480_0;
@Service
public class M20480_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_20480_0 object1 = (Vo_20480_0)object;
 GameWriteTool.writeString2(writeBuf,object1.msg);

 GameWriteTool.writeInt(writeBuf,object1.time);
}@Override
    public int cmd() {
        return 20480;
    }
}



