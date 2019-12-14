//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M4155_0 extends BaseWrite {
    public M4155_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        GameWriteTool.writeInt(writeBuf, (Integer)object);
    }

    public int cmd() {
        return 4155;
    }
}
