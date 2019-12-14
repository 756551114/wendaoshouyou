package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M64981_Fight_Blood extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List object1 = (List) object;

        GameWriteTool.writeInt(writeBuf, (Integer) object1.get(0));

        GameWriteTool.writeShort(writeBuf, 1);
        BuildFields.get("max_life").write(writeBuf, object1.get(1));



    }

    @Override
    public int cmd() {
        return 64981;
    }
}
























































































































































