package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32811_0;
@Service
public class M32811_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_32811_0 object1 = (Vo_32811_0)object;
 GameWriteTool.writeShort(writeBuf,object1.size);

 GameWriteTool.writeShort(writeBuf,object1.max_size);

 GameWriteTool.writeShort(writeBuf,object1.top_size);
}@Override
    public int cmd() {
        return 32811;
    }
}




