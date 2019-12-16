package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class M65527_3 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List object1 = (List) object;

        GameWriteTool.writeInt(writeBuf, (Integer) object1.get(0));

        GameWriteTool.writeShort(writeBuf, 2);
        BuildFields.get("pot").write(writeBuf, object1.get(1));
        BuildFields.get("resist_poison").write(writeBuf, object1.get(2));


    }

    @Override
    public int cmd() {
        return 65527;
    }
}
























































































































































