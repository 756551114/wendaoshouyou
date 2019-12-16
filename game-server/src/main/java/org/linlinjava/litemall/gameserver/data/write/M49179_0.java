package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49179;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49179_0;

import java.util.List;

@Service
public class M49179_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49179_0 object1 = (Vo_49179_0) object;
        GameWriteTool.writeShort(writeBuf, object1.dealNum);

        GameWriteTool.writeString(writeBuf, object1.sellCash);

        GameWriteTool.writeShort(writeBuf, object1.stallTotalNum);

        GameWriteTool.writeShort(writeBuf, object1.record_count_max);

        List<Vo_49179> vo_49179 = (List<Vo_49179>) object1.vo_49179s;

        GameWriteTool.writeShort(writeBuf, vo_49179.size());

        for (int i = 0; i < vo_49179.size(); i++) {
            Vo_49179 vo_491791 = vo_49179.get(i);

            GameWriteTool.writeString(writeBuf, vo_491791.name);

            GameWriteTool.writeString(writeBuf, vo_491791.id);

            GameWriteTool.writeInt(writeBuf, vo_491791.price);

            GameWriteTool.writeShort(writeBuf, vo_491791.pos);

            GameWriteTool.writeShort(writeBuf, vo_491791.status);

            GameWriteTool.writeInt(writeBuf, vo_491791.startTime);

            GameWriteTool.writeInt(writeBuf, vo_491791.endTime);

            GameWriteTool.writeShort(writeBuf, vo_491791.level);

            GameWriteTool.writeByte(writeBuf, vo_491791.unidentified);

            GameWriteTool.writeShort(writeBuf, vo_491791.amount);

            GameWriteTool.writeShort(writeBuf, vo_491791.req_level);

            GameWriteTool.writeByte(writeBuf, vo_491791.extra);

            GameWriteTool.writeByte(writeBuf, vo_491791.item_polar);

            GameWriteTool.writeByte(writeBuf, vo_491791.cg_price_count);

            GameWriteTool.writeInt(writeBuf, vo_491791.init_price);
        }
    }

    @Override
    public int cmd() {
        return 49179;
    }
}