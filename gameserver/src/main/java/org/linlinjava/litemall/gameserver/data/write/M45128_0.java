package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45128_0;

import java.util.HashMap;
import java.util.Map;

@Service
public class M45128_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45128_0 object1 = (Vo_45128_0) object;
        GameWriteTool.writeShort(writeBuf, 1);




        Map<Object, Object> map = new HashMap<>();
            map = UtilObjMap.Vo_45128_0(object1);
            map.remove("no");
            map.remove("type1");
            GameWriteTool.writeByte(writeBuf, object1.no);
            GameWriteTool.writeByte(writeBuf, object1.type1);
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
        return 45128;
    }


}

































