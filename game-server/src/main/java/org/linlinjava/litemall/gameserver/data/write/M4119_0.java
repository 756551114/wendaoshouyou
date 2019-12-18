//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4119_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Service
public class M4119_0 extends BaseWrite {
    public M4119_0() {
    }

    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_4119_0> object1 = (List)object;
        GameWriteTool.writeShort(writeBuf, object1.size());

        for (Vo_4119_0 obj : object1) {
            GameWriteTool.writeInt(writeBuf, obj.id);
            GameWriteTool.writeString(writeBuf, obj.gid);
            GameWriteTool.writeInt(writeBuf, obj.suit_icon);
            GameWriteTool.writeShort(writeBuf, obj.weapon_icon);
            GameWriteTool.writeShort(writeBuf, obj.org_icon);
            Map<Object, Object> map = UtilObjMap.Vo_4119_0(obj);
            map.remove("id");
            map.remove("gid");
            map.remove("membercard_name");
            map.remove("memberlight_effect_count");
            map.remove("suit_icon");
            map.remove("weapon_icon");
            map.remove("conutnumber");
            map.remove("org_icon");
            Iterator<Entry<Object, Object>> it = map.entrySet().iterator();
            GameWriteTool.writeShort(writeBuf, map.size());

            Set<Entry<Object, Object>> entries = map.entrySet();
            entries.forEach(entry ->{
                if (BuildFields.data.get((String)entry.getKey()) != null) {
                    BuildFields.get((String)entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            });
            GameWriteTool.writeString(writeBuf, obj.membercard_name);
            GameWriteTool.writeByte(writeBuf, obj.memberlight_effect_count);
        }



    }

    @Override
    public int cmd() {
        return 4119;
    }
}
