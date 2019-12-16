//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.domain.ShouHuShuXing;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M12016_0 extends BaseWrite {
    public M12016_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        List<ShouHu> object1 = (List)object;
        GameWriteTool.writeInt(writeBuf, object1.size());

        for(int i = 0; i < object1.size(); ++i) {
            GameWriteTool.writeInt(writeBuf, ((ShouHu)object1.get(i)).id);
            GameWriteTool.writeShort(writeBuf, ((ShouHu)object1.get(i)).listShouHuShuXing.size());

            for(int j = 0; j < ((ShouHu)object1.get(i)).listShouHuShuXing.size(); ++j) {
                ShouHuShuXing shouHuShuXing = (ShouHuShuXing)((ShouHu)object1.get(i)).listShouHuShuXing.get(j);
                new HashMap();
                if (shouHuShuXing != null) {
                    Map<Object, Object> map = UtilObjMapshuxing.ShouHuShuXing(shouHuShuXing);
                    map.remove("no");
                    map.remove("type1");
                    GameWriteTool.writeByte(writeBuf, shouHuShuXing.no);
                    GameWriteTool.writeByte(writeBuf, shouHuShuXing.type1);
                    GameWriteTool.writeShort(writeBuf, map.size());
                    Iterator var8 = map.entrySet().iterator();

                    while(var8.hasNext()) {
                        Entry<Object, Object> entry = (Entry)var8.next();
                        if (BuildFields.data.get((String)entry.getKey()) != null) {
                            BuildFields.get((String)entry.getKey()).write(writeBuf, entry.getValue());
                        } else {
                            System.out.println(entry.getKey());
                        }
                    }
                }
            }
        }

    }

    public int cmd() {
        return 12016;
    }
}
