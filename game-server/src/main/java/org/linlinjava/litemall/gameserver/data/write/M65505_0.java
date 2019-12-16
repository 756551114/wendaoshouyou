package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65505_0;
@Service
public class M65505_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_65505_0 object1 = (Vo_65505_0)object;
 GameWriteTool.writeInt(writeBuf,object1.map_id);

 GameWriteTool.writeString(writeBuf,object1.map_name);

 GameWriteTool.writeString(writeBuf,object1.map_show_name);

 GameWriteTool.writeShort(writeBuf,object1.x);

 GameWriteTool.writeShort(writeBuf,object1.y);

 GameWriteTool.writeInt(writeBuf,object1.map_index);

 GameWriteTool.writeShort(writeBuf,object1.compact_map_index);

 GameWriteTool.writeByte(writeBuf,object1.floor_index);

 GameWriteTool.writeByte(writeBuf,object1.wall_index);

 GameWriteTool.writeByte(writeBuf,object1.is_safe_zone);

 GameWriteTool.writeByte(writeBuf,object1.is_task_walk);

 GameWriteTool.writeByte(writeBuf,object1.enter_effect_index);
}@Override
    public int cmd() {
        return 65505;
    }
}













