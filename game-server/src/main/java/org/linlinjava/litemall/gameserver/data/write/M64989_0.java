package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_64989_0;

@Service
public class M64989_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_64989_0 object1 = (Vo_64989_0) object;
        GameWriteTool.writeInt(writeBuf, object1.hid);

        GameWriteTool.writeInt(writeBuf, object1.a);


        GameWriteTool.writeShort(writeBuf, object1.list.size());

        for (int i = 0; i < object1.list.size(); i++) {
            GameWriteTool.writeInt(writeBuf, object1.list.get(i));
        }
        for (int i = 0; i < object1.missList.size(); i++) {

            GameWriteTool.writeShort(writeBuf, object1.missList.get(i));
        }
    }

    @Override
    public int cmd() {
        return 64989;
    }
}







