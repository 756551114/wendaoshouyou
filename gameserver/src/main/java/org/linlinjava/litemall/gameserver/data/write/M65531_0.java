package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

import java.util.List;

@Service
public class M65531_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
        List<NpcPoint> list = (List)object;

 GameWriteTool.writeByte(writeBuf,1);

 GameWriteTool.writeShort(writeBuf,list.size());
        for (NpcPoint npcPoint : list) {

            GameWriteTool.writeString(writeBuf,npcPoint.getDoorname());

            GameWriteTool.writeShort(writeBuf,npcPoint.getX());

            GameWriteTool.writeShort(writeBuf,npcPoint.getY());

            GameWriteTool.writeShort(writeBuf,npcPoint.getZ());
        }
}@Override
    public int cmd() {
        return 65531;
    }
}











