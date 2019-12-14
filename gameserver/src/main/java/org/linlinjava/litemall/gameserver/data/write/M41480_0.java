package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41480_0;

import java.util.List;

@Service
public class M41480_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_41480_0> object1 = (List<Vo_41480_0>) object;
        GameWriteTool.writeInt(writeBuf, object1.get(0).online_time);
        GameWriteTool.writeByte(writeBuf, object1.size());
        for (int i = 0; i < object1.size(); i++) {
            Vo_41480_0 object2 = object1.get(i);
            GameWriteTool.writeByte(writeBuf, object2.index);

            GameWriteTool.writeShort(writeBuf, object2.time);

            GameWriteTool.writeString(writeBuf, object2.name);

            GameWriteTool.writeByte(writeBuf, object2.brate);
        }
    }

    @Override
    public int cmd() {
        return 41480;
    }
}



































