package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61545_0;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class M61545_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_61545_0> vo_61545_0List = (List<Vo_61545_0>) object;
        GameWriteTool.writeShort(writeBuf, vo_61545_0List.size());
        for (Vo_61545_0 object1 : vo_61545_0List) {

            GameWriteTool.writeString(writeBuf, object1.groupBuf);

            GameWriteTool.writeString(writeBuf, object1.charBuf);

            GameWriteTool.writeByte(writeBuf, object1.blocked);

            GameWriteTool.writeByte(writeBuf, object1.online);

            GameWriteTool.writeString(writeBuf, object1.server_name1);

            GameWriteTool.writeByte(writeBuf, object1.insider_level);

            Map<Object, Object> map = UtilObjMap.Vo_61545_0(object1);
            map.remove("groupBuf");
            map.remove("charBuf");
            map.remove("blocked");
            map.remove("online");
            map.remove("server_name1");
            map.remove("insider_level");


            Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();







            GameWriteTool.writeShort(writeBuf, map.size());
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                if (BuildFields.data.get((String) entry.getKey()) != null) {
                    BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                } else {
                    System.out.println(entry.getKey());
                }
            }
        }

    }

    @Override
    public int cmd() {
        return 61545;
    }

}




























