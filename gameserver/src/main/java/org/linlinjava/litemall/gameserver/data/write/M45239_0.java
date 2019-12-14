package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45239_0;
@Service
public class M45239_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_45239_0 object1 = (Vo_45239_0)object;
 GameWriteTool.writeInt(writeBuf,object1.ti);

 GameWriteTool.writeByte(writeBuf,object1.state);

 GameWriteTool.writeString(writeBuf,object1.task_name);

 GameWriteTool.writeByte(writeBuf,object1.is_smart);
}@Override
    public int cmd() {
        return 45239;
    }
}





