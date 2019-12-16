package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class M61677_01 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_61677_0 object1 = (Vo_61677_0) object;
        GameWriteTool.writeString(writeBuf, object1.store_type);

        GameWriteTool.writeInt(writeBuf, object1.npcID);


        GameWriteTool.writeShort(writeBuf, 1);

        GameWriteTool.writeByte(writeBuf, object1.isGoon);
        GameWriteTool.writeShort(writeBuf, object1.pos);


    }

    @Override
    public int cmd() {
        return 61677;
    }

    public boolean weizhi(List<Goods> list, int j) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).pos, list.get(i).pos);
        }
        if (map.get(j) == null) {
            return true;
        }
        return false;
    }

}
