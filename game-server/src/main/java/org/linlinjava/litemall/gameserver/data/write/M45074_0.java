package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45074_0;

import java.util.List;

@Service
public class M45074_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_45074_0> object1 = (List<Vo_45074_0>) object;
        GameWriteTool.writeByte(writeBuf, object1.size());
        for (int i = 0; i <object1.size() ; i++) {
            Vo_45074_0 obj = object1.get(i);

            GameWriteTool.writeString(writeBuf, obj.guardName);

            GameWriteTool.writeShort(writeBuf, obj.guardLevel);

            GameWriteTool.writeShort(writeBuf, obj.guardIcon);

            GameWriteTool.writeShort(writeBuf, obj.guardOrder);

            GameWriteTool.writeInt(writeBuf, obj.guardId);
        }


    }

    @Override
    public int cmd() {
        return 45074;
    }
}






















