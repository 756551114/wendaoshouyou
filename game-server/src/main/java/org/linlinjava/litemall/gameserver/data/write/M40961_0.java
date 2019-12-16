package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_40961_0;

@Service
public class M40961_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_40961_0 object1 = (Vo_40961_0) object;
        GameWriteTool.writeShort(writeBuf, object1.count);

        GameWriteTool.writeString(writeBuf, object1.id);

        GameWriteTool.writeShort(writeBuf, object1.type);

        GameWriteTool.writeString(writeBuf, object1.sender);

        GameWriteTool.writeString(writeBuf, object1.title);

        GameWriteTool.writeString2(writeBuf, object1.msg);

        GameWriteTool.writeString2(writeBuf, object1.attachment);

        GameWriteTool.writeInt(writeBuf, object1.create_time);

        GameWriteTool.writeInt(writeBuf, object1.expired_time);

        GameWriteTool.writeShort(writeBuf, object1.status);
    }

    @Override
    public int cmd() {
        return 40961;
    }
}











