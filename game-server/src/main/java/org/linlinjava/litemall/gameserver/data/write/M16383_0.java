package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_16383_0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class M16383_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_16383_0 object1 = (Vo_16383_0) object;
        GameWriteTool.writeShort(writeBuf, object1.channel);

        GameWriteTool.writeInt(writeBuf, object1.id);

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeString2(writeBuf, object1.msg);

        GameWriteTool.writeInt(writeBuf, object1.time);

        GameWriteTool.writeShort(writeBuf, object1.privilege);

        GameWriteTool.writeString(writeBuf, object1.server_name);

        GameWriteTool.writeShort(writeBuf, object1.show_extra);

        GameWriteTool.writeShort(writeBuf, object1.compress);

        GameWriteTool.writeShort(writeBuf, object1.orgLength);

        GameWriteTool.writeShort(writeBuf, object1.cardCount);

        GameWriteTool.writeInt(writeBuf, object1.voiceTime);

        GameWriteTool.writeString2(writeBuf, object1.token);

        GameWriteTool.writeInt(writeBuf, object1.checksum);


        Map<Object, Object> map = new HashMap<>();
        map = UtilObjMap.Vo_16383_0(object1);
        map.remove("channel");
        map.remove("id");

        map.remove("name");
        map.remove("msg");
        map.remove("time");
        map.remove("privilege");
        map.remove("server_name");
        map.remove("show_extra");

        map.remove("compress");
        map.remove("cardCount");
        map.remove("orgLength");
        map.remove("voiceTime");
        map.remove("token");
        map.remove("checksum");


        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            if (entry.getValue().equals(0)) {
                it.remove();
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
    }

    @Override
    public int cmd() {
        return 16383;
    }


}



















