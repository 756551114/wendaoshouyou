package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49177_0;

@Service
public class M49177_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49177_0 object1 = (Vo_49177_0) object;
        GameWriteTool.writeByte(writeBuf, object1.isPK);

        GameWriteTool.writeByte(writeBuf, object1.stageId);

        GameWriteTool.writeShort(writeBuf, object1.monsterPoint);

        GameWriteTool.writeShort(writeBuf, object1.pkValue);

        GameWriteTool.writeShort(writeBuf, object1.totalScore);

        GameWriteTool.writeInt(writeBuf, object1.startTime);

        GameWriteTool.writeInt(writeBuf, object1.stage1_duration_time);

        GameWriteTool.writeInt(writeBuf, object1.stage2_duration_time);

        GameWriteTool.writeByte(writeBuf, object1.rank);
    }

    @Override
    public int cmd() {
        return 49177;
    }
}










