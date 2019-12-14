//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4275_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M4275_0 extends BaseWrite {
    public M4275_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_4275_0 object1 = (Vo_4275_0)object;
        GameWriteTool.writeInt(writeBuf, object1.a);
    }

    public int cmd() {
        return 4275;
    }
}
