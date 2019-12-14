//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8285_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M8285_0 extends BaseWrite {
    public M8285_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_8285_0 object1 = (Vo_8285_0)object;
        GameWriteTool.writeString(writeBuf, object1.gid);
        GameWriteTool.writeString(writeBuf, object1.name);
    }

    public int cmd() {
        return 8285;
    }
}
