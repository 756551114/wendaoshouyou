package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_62209_0;

import java.util.List;

@Service
public class M62209_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_62209_0> object1 = (List<Vo_62209_0>) object;
        GameWriteTool.writeShort(writeBuf, object1.size());
        for (int i = 0; i < object1.size(); i++) {
            GameWriteTool.writeString(writeBuf, object1.get(i).stringformat);
            GameWriteTool.writeString(writeBuf, object1.get(i).title);
            GameWriteTool.writeInt(writeBuf, object1.get(i).titled_left_time);
        }

    }

    @Override
    public int cmd() {
        return 62209;
    }
}





