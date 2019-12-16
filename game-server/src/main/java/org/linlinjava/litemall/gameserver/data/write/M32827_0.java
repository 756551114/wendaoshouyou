package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32827_0;
@Service
public class M32827_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_32827_0 object1 = (Vo_32827_0)object;
 GameWriteTool.writeByte(writeBuf,object1.has_pwd);

 GameWriteTool.writeByte(writeBuf,object1.isReleaseLock);

 GameWriteTool.writeInt(writeBuf,object1.reset_start);

 GameWriteTool.writeInt(writeBuf,object1.reset_end);

 GameWriteTool.writeInt(writeBuf,object1.reset_days);
}@Override
    public int cmd() {
        return 32827;
    }
}






