package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_36871_0;
@Service
public class M36871_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_36871_0 object1 = (Vo_36871_0)object;
 GameWriteTool.writeString(writeBuf,object1.msg_type);

 GameWriteTool.writeInt(writeBuf,object1.icon);

 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeShort(writeBuf,object1.level);

 GameWriteTool.writeString(writeBuf,object1.gid);

 GameWriteTool.writeString(writeBuf,object1.name);

 GameWriteTool.writeString(writeBuf,object1.party);

 GameWriteTool.writeInt(writeBuf,object1.friend_score);

 GameWriteTool.writeInt(writeBuf,object1.setting_flag);

 GameWriteTool.writeShort(writeBuf,object1.char_status);

 GameWriteTool.writeByte(writeBuf,object1.vip);

 GameWriteTool.writeString(writeBuf,object1.serverId);

 GameWriteTool.writeString(writeBuf,object1.account);

 GameWriteTool.writeByte(writeBuf,object1.polar);

 GameWriteTool.writeByte(writeBuf,object1.isInThereFrend);

 GameWriteTool.writeInt(writeBuf,object1.ringScore);

 GameWriteTool.writeByte(writeBuf,object1.comeback_flag);
}@Override
    public int cmd() {
        return 36871;
    }
}


















