//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import java.util.Iterator;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_11757_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M11757_0 extends BaseWrite {
    public M11757_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_11757_0 object1 = (Vo_11757_0)object;
        GameWriteTool.writeInt(writeBuf, object1.id);
        GameWriteTool.writeShort(writeBuf, object1.list.size());
        Iterator var4 = object1.list.iterator();

        while(var4.hasNext()) {
            Integer integer = (Integer)var4.next();
            GameWriteTool.writeInt(writeBuf, integer);
        }

    }

    public int cmd() {
        return 11757;
    }
}
