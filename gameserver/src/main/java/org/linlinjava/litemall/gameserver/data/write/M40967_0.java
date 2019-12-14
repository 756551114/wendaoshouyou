package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.db.domain.CreepsStore;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

import java.util.List;


@Service
public class M40967_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<CreepsStore> list = (List<CreepsStore>) object;
        GameWriteTool.writeByte(writeBuf, 1);
        GameWriteTool.writeShort(writeBuf, list.size());
        for (int i = 0; i < list.size(); i++) {
            GameWriteTool.writeString(writeBuf, list.get(i).getName());
            GameWriteTool.writeInt(writeBuf, list.get(i).getPrice());
            GameWriteTool.writeString(writeBuf, "cash");
        }
    }

    @Override
    public int cmd() {
        return 40967;
    }
}


















































































































































































































