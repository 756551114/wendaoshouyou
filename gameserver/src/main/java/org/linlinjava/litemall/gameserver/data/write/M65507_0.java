package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Petbeibao;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class M65507_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Petbeibao> list = (List<Petbeibao>) object;

        GameWriteTool.writeShort(writeBuf, list.size());

        for (int i = 0; i < list.size(); i++) {

            GameWriteTool.writeByte(writeBuf, list.get(i).no);

            GameWriteTool.writeInt(writeBuf, list.get(i).id);

            GameWriteTool.writeShort(writeBuf, list.get(i).petShuXing.size());
            for (int j = 0; j < list.get(i).petShuXing.size(); j++) {

                PetShuXing petShuXing = list.get(i).petShuXing.get(j);
                GameWriteTool.writeByte(writeBuf, list.get(i).petShuXing.get(j).no);

                GameWriteTool.writeByte(writeBuf, list.get(i).petShuXing.get(j).type1);

                Map<Object, Object> map = new HashMap<>();
                map = UtilObjMapshuxing.PetShuXing(petShuXing);
                map.remove("no");
                map.remove("type1");



                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getKey().equals("all_polar") || entry.getKey().equals("upgrade_magic") || entry.getKey().equals("upgrade_total")) {
                        continue;
                    }
                    if (entry.getValue().equals(0)&&(entry.getKey().equals("dex")||entry.getKey().equals("def")||entry.getKey().equals("mana")||entry.getKey().equals("parry")||entry.getKey().equals("accurate")||entry.getKey().equals("wiz"))){
                        it.remove();
                    }

                    if (entry.getValue().equals("")) {
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
        }

    }

    @Override
    public int cmd() {
        return 65507;
    }


}
