package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_20467_0;

import java.util.Iterator;
import java.util.Map;

@Service
public class M20467_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_20467_0 object1 = (Vo_20467_0) object;
        GameWriteTool.writeString(writeBuf, object1.caption);

        GameWriteTool.writeString(writeBuf, object1.content);

        GameWriteTool.writeString(writeBuf, object1.peer_name);

        GameWriteTool.writeString(writeBuf, object1.ask_type);

        GameWriteTool.writeShort(writeBuf, 1);
        GameWriteTool.writeInt(writeBuf, object1.org_icon);

        Map<Object, Object> map = UtilObjMap.Vo_20467_0(object1);
        map.remove("caption");
        map.remove("content");
        map.remove("org_icon");

        map.remove("peer_name");
        map.remove("ask_type");
        map.remove("teamMembersCount");

        map.remove("comeback_flag");

        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            if (entry.getValue() instanceof Integer) {
                if (entry.getValue().equals(0)) {
                    it.remove();
                }
            } else {
                if (entry.getValue() == null) {
                    it.remove();
                }
            }
        }
        GameWriteTool.writeShort(writeBuf, map.size());
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (BuildFields.data.get((String) entry.getKey()) != null) {
                BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
            } else {
                System.out.println(entry.getKey());
            }
        }


        GameWriteTool.writeByte(writeBuf, object1.teamMembersCount);

        GameWriteTool.writeByte(writeBuf, object1.comeback_flag);
    }

    @Override
    public int cmd() {
        return 20467;
    }


}


















