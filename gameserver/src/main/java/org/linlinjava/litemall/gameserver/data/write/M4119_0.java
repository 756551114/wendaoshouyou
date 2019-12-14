//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4119_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M4119_0 extends BaseWrite {
    public M4119_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_4119_0> object1 = (List)object;
        GameWriteTool.writeShort(writeBuf, object1.size());
        Iterator var4 = object1.iterator();

        while(var4.hasNext()) {
            Vo_4119_0 obj = (Vo_4119_0)var4.next();
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
            Iterator var8 = map.entrySet().iterator();

            while(var8.hasNext()) {
                Entry<Object, Object> entry = (Entry)var8.next();
                if (BuildFields.data.get((String)entry.getKey()) != null) {
                    BuildFields.get((String)entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            }

            GameWriteTool.writeString(writeBuf, obj.membercard_name);
            GameWriteTool.writeByte(writeBuf, obj.memberlight_effect_count);
        }

    }

    public int cmd() {
        return 4119;
    }
}
