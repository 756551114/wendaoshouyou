package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32747_0;

import java.util.List;

@Service
public class M32747_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {


        List<Vo_32747_0> obj = (List<Vo_32747_0>) object;
        if (obj.size() > 0) {
            GameWriteTool.writeInt(writeBuf, obj.get(0).id);
        }

        GameWriteTool.writeShort(writeBuf, obj.size());
        for (int i = 0; i < obj.size(); i++) {
            Vo_32747_0 object1 = obj.get(i);

            GameWriteTool.writeShort(writeBuf, object1.skill_no);

            GameWriteTool.writeShort(writeBuf, object1.skill_attrib1);

            GameWriteTool.writeShort(writeBuf, object1.skill_level);

            GameWriteTool.writeShort(writeBuf, object1.level_improved);

            GameWriteTool.writeShort(writeBuf, object1.skill_mana_cost);

            GameWriteTool.writeInt(writeBuf, object1.skill_nimbus);

            GameWriteTool.writeByte(writeBuf, object1.skill_disabled);

            GameWriteTool.writeShort(writeBuf, object1.range);

            GameWriteTool.writeShort(writeBuf, object1.max_range);

            GameWriteTool.writeShort(writeBuf, object1.count1);

            for (int j = 0; j < object1.count1; j++) {

                GameWriteTool.writeString(writeBuf, object1.s1);

                GameWriteTool.writeInt(writeBuf, object1.s2);
            }

            GameWriteTool.writeByte(writeBuf, object1.isTempSkill);
        }

    }

    @Override
    public int cmd() {
        return 32747;
    }
}
















