package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12269_0;
@Service
public class M12269_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_12269_0 object1 = (Vo_12269_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeInt(writeBuf,object1.owner_id);
}@Override
    public int cmd() {
        return 12269;
    }
}



