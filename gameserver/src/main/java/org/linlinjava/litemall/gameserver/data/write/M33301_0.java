package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_33301_0;
@Service
public class M33301_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_33301_0 object1 = (Vo_33301_0)object;
 GameWriteTool.writeByte(writeBuf,object1.enable);

 GameWriteTool.writeByte(writeBuf,object1.level);
}@Override
    public int cmd() {
        return 33301;
    }
}



