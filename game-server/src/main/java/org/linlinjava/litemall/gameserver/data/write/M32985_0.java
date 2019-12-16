package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32985_0;
@Service
public class M32985_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_32985_0 object1 = (Vo_32985_0)object;
 GameWriteTool.writeByte(writeBuf,object1.user_is_multi);

 GameWriteTool.writeByte(writeBuf,object1.user_round);

 GameWriteTool.writeByte(writeBuf,object1.user_action);

 GameWriteTool.writeByte(writeBuf,object1.user_next_action);

 GameWriteTool.writeInt(writeBuf,object1.user_para);

 GameWriteTool.writeInt(writeBuf,object1.user_next_para);

 GameWriteTool.writeByte(writeBuf,object1.pet_is_multi);

 GameWriteTool.writeByte(writeBuf,object1.pet_round);

 GameWriteTool.writeByte(writeBuf,object1.pet_action);

 GameWriteTool.writeByte(writeBuf,object1.pet_next_action);

 GameWriteTool.writeInt(writeBuf,object1.pet_para);

 GameWriteTool.writeInt(writeBuf,object1.pet_next_para);
}@Override
    public int cmd() {
        return 32985;
    }
}













