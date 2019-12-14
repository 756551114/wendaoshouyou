package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_36889_0;
@Service
public class M36889_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_36889_0 object1 = (Vo_36889_0)object;
 GameWriteTool.writeByte(writeBuf,object1.count);

 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeByte(writeBuf,object1.auto_select);

 GameWriteTool.writeByte(writeBuf,object1.multi_index);

 GameWriteTool.writeByte(writeBuf,object1.action);

 GameWriteTool.writeInt(writeBuf,object1.para);

 GameWriteTool.writeByte(writeBuf,object1.multi_count);

}@Override
    public int cmd() {
        return 36889;
    }
}














