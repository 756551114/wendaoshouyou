package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_24505_0;

import java.util.Iterator;
import java.util.Map;

@Service
public class M24505_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_24505_0 object1 = (Vo_24505_0) object;
        GameWriteTool.writeShort(writeBuf, object1.update_type);

        GameWriteTool.writeString(writeBuf, object1.groupBuf);

        GameWriteTool.writeString(writeBuf, object1.charBuf);


        Map<Object, Object> map = UtilObjMap.Vo_24505_0(object1);
        map.remove("update_type");
        map.remove("groupBuf");
        map.remove("charBuf");

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

    @Override
    public int cmd() {
        return 24505;
    }

}























