package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.ZbAttribute;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class M65511_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        ZbAttribute object1 = (ZbAttribute) object;
        Map<Object, Object> map = new HashMap<>();
        if (object1 != null) {
            map = UtilObjMapshuxing.ZbAttribute(object1);
            Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
            map.remove("id");
            GameWriteTool.writeInt(writeBuf, object1.id);







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
        return 65511;
    }
}








