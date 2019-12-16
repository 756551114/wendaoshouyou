package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_53569_0;
@Service
public class M53569_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_53569_0 object1 = (Vo_53569_0)object;
 GameWriteTool.writeString(writeBuf,object1.gid);

 GameWriteTool.writeByte(writeBuf,object1.online);
}@Override
    public int cmd() {
        return 53569;
    }
}



