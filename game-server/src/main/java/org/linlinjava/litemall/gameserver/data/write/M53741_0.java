package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Duiyuan;
import org.linlinjava.litemall.gameserver.domain.LieBiao;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class M53741_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<LieBiao> object1 = (List<LieBiao>) object;

        if (object1.size() > 0) {
            GameWriteTool.writeString(writeBuf, object1.get(0).ask_type);
        }


        GameWriteTool.writeShort(writeBuf, object1.size());

        for (LieBiao lieBiao : object1) {
            GameWriteTool.writeString(writeBuf, lieBiao.peer_name);


            GameWriteTool.writeShort(writeBuf, lieBiao.duiyuanList.size());
            for (Duiyuan duiyuan : lieBiao.duiyuanList) {
                GameWriteTool.writeInt(writeBuf, duiyuan.org_icon);

                Map<Object, Object> map = UtilObjMapshuxing.Duiyuan(duiyuan);
                map.remove("org_icon");
                map.remove("mapteamMembersCount");
                map.remove("mapcomeback_flag");


                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0) || entry.getKey().equals("")) {
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


                GameWriteTool.writeByte(writeBuf, duiyuan.mapteamMembersCount);
                GameWriteTool.writeByte(writeBuf, duiyuan.mapcomeback_flag);
            }

        }

    }

    @Override
    public int cmd() {
        return 53741;
    }


}



