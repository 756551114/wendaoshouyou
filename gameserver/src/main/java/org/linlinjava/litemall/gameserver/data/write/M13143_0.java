package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_13143_0;
@Service
public class M13143_0  extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_13143_0 object1 = (Vo_13143_0)object;
 GameWriteTool.writeInt(writeBuf,object1.result);

 GameWriteTool.writeShort(writeBuf,object1.privilege);

 GameWriteTool.writeString(writeBuf,object1.ip);

 GameWriteTool.writeShort(writeBuf,object1.port);

 GameWriteTool.writeInt(writeBuf,object1.seed);

 GameWriteTool.writeInt(writeBuf,object1.auth_key);

 GameWriteTool.writeShort(writeBuf,object1.id);

 GameWriteTool.writeString(writeBuf,object1.serverName);

 GameWriteTool.writeByte(writeBuf,object1.serverStatus);

 GameWriteTool.writeString(writeBuf,object1.msg);
}@Override
    public int cmd() {
        return 13143;
    }
}











