//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7669_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M7669_0 extends BaseWrite {
    public M7669_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_7669_0 object1 = (Vo_7669_0)object;
        GameWriteTool.writeInt(writeBuf, object1.id);
        GameWriteTool.writeInt(writeBuf, object1.damage_type);
    }

    public int cmd() {
        return 7669;
    }
}
