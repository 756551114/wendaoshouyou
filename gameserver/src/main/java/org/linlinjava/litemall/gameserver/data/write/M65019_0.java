package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65017_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class M65019_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_65017_0> obj = (List<Vo_65017_0>) object;
        GameWriteTool.writeByte(writeBuf, obj.size());
        for (int i = 0; i < obj.size(); i++) {
            Vo_65017_0 object1 = obj.get(i);

            GameWriteTool.writeInt(writeBuf, object1.id);

            GameWriteTool.writeShort(writeBuf, object1.leader);

            GameWriteTool.writeShort(writeBuf, object1.weapon_icon);

            GameWriteTool.writeShort(writeBuf, object1.pos);

            GameWriteTool.writeShort(writeBuf, object1.rank);

            GameWriteTool.writeShort(writeBuf, object1.vip_type);


            Map<Object, Object> map = new HashMap<>();
            map = UtilObjMap.Vo_65019_0(object1);

            map.remove("id");
            map.remove("leader");
            map.remove("weapon_icon");
            map.remove("pos");
            map.remove("rank");
            map.remove("vip_type");
            map.remove("org_icon");
            map.remove("suit_icon");
            map.remove("suit_light_effect");
            map.remove("special_icon");

            Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();







            GameWriteTool.writeShort(writeBuf, map.size());
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                if (BuildFields.data.get((String) entry.getKey()) != null) {
                    BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            }

            GameWriteTool.writeShort(writeBuf, object1.org_icon);

            GameWriteTool.writeInt(writeBuf, object1.suit_icon);

            GameWriteTool.writeInt(writeBuf, object1.suit_light_effect);

            GameWriteTool.writeInt(writeBuf, object1.special_icon);

        }



        GameWriteTool.writeByte(writeBuf, 0);
        GameWriteTool.writeByte(writeBuf, 0);
    }

    @Override
    public int cmd() {
        return 65019;
    }

}

































































































































