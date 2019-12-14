package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_65527_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65527_0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class M65527_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        ListVo_65527_0 listVo_65527_0 = (ListVo_65527_0) object;
        GameWriteTool.writeInt(writeBuf, listVo_65527_0.id);
        Vo_65527_0 vo = (Vo_65527_0) listVo_65527_0.vo_65527_0;
        Map<Object, Object> map = new HashMap<>();
        map = UtilObjMap.Vo_65527_0(vo);
        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            if (entry.getValue() instanceof Integer) {
                if (entry.getValue().equals(0) && (!entry.getKey().equals("balance")) && (!entry.getKey().equals("gender"))) {
                    if (!entry.getKey().equals("resist_metal") && !entry.getKey().equals("wood") && !entry.getKey().equals("water") && !entry.getKey().equals("fire") && !entry.getKey().equals("earth") && !entry.getKey().equals("stamina") && !entry.getKey().equals("marriage_book_id")) {
                    }
                }
            } else {
                if (entry.getValue().equals("")) {
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



































































































































































    }


    @Override
    public int cmd() {
        return 65527;
    }


}








