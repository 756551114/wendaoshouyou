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
import org.linlinjava.litemall.gameserver.data.vo.Vo_4121_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M4121_0 extends BaseWrite {
    public M4121_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_4121_0> object1 = (List)object;
        GameWriteTool.writeShort(writeBuf, object1.size());
        Iterator var4 = object1.iterator();

        label41:
        while(var4.hasNext()) {
            Vo_4121_0 obj = (Vo_4121_0)var4.next();
            GameWriteTool.writeInt(writeBuf, obj.id);
            GameWriteTool.writeString(writeBuf, obj.gid);
            GameWriteTool.writeInt(writeBuf, obj.suit_icon);
            GameWriteTool.writeShort(writeBuf, obj.weapon_icon);
            GameWriteTool.writeShort(writeBuf, obj.org_icon);
            Map<Object, Object> map = UtilObjMap.Vo_4121_0(obj);
            map.remove("id");
            map.remove("gid");
            map.remove("suit_icon");
            map.remove("weapon_icon");
            map.remove("org_icon");
            map.remove("memberpos_x");
            map.remove("memberpos_y");
            map.remove("membermap_id");
            map.remove("memberteam_status");
            map.remove("membercard_name");
            map.remove("membercomeback_flag");
            map.remove("memberlight_effect_count");
            Iterator it = map.entrySet().iterator();

            while(true) {
                Entry entry;
                do {
                    if (!it.hasNext()) {
                        GameWriteTool.writeShort(writeBuf, map.size());
                        Iterator var10 = map.entrySet().iterator();

                        while(var10.hasNext()) {
//                            Entry<Object, Object> entry = (Entry)var10.next();
                            entry = (Entry)var10.next();
                            if (BuildFields.data.get((String)entry.getKey()) != null) {
                                BuildFields.get((String)entry.getKey()).write(writeBuf, entry.getValue());
                            } else {
                                System.out.println(entry.getKey());
                            }
                        }

                        GameWriteTool.writeShort(writeBuf, obj.memberpos_x);
                        GameWriteTool.writeShort(writeBuf, obj.memberpos_y);
                        GameWriteTool.writeInt(writeBuf, obj.membermap_id);
                        GameWriteTool.writeByte(writeBuf, obj.memberteam_status);
                        GameWriteTool.writeString(writeBuf, obj.membercard_name);
                        GameWriteTool.writeByte(writeBuf, obj.membercomeback_flag);
                        GameWriteTool.writeByte(writeBuf, obj.memberlight_effect_count);
                        continue label41;
                    }

                    entry = (Entry)it.next();
                } while(!entry.getValue().equals(0) && !entry.getKey().equals(""));

                it.remove();
            }
        }

    }

    public int cmd() {
        return 4121;
    }
}
