package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;


@Service
public class M61671_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {

        Vo_61671_0 object1 = (Vo_61671_0) object;
        GameWriteTool.writeInt(writeBuf, object1.id);

        GameWriteTool.writeByte(writeBuf, object1.count);
        for (int i = 0; i < object1.count; i++) {
            GameWriteTool.writeByte(writeBuf, (Integer) object1.list.get(i));
        }
    }

    @Override
    public int cmd() {
        return 61671;
    }
}


