package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45105_0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class M45105_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45105_0 object1 = (Vo_45105_0) object;
        GameWriteTool.writeString(writeBuf, object1.goodId);

        GameWriteTool.writeByte(writeBuf, object1.status);

        GameWriteTool.writeInt(writeBuf, object1.endTime);

        Petbeibao list = object1.petbeibao;




        GameWriteTool.writeShort(writeBuf, list.petShuXing.size());
        for (int j = 0; j < list.petShuXing.size(); j++) {

            PetShuXing petShuXing = list.petShuXing.get(j);
            GameWriteTool.writeByte(writeBuf, list.petShuXing.get(j).no);

            GameWriteTool.writeByte(writeBuf, list.petShuXing.get(j).type1);

            Map<Object, Object> map = new HashMap<>();
            map = UtilObjMapshuxing.PetShuXing(petShuXing);
            map.remove("no");
            map.remove("type1");



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
        return 45105;
    }
}