//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8165_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M8165_0 extends BaseWrite {
    public M8165_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_8165_0 object1 = (Vo_8165_0)object;
        GameWriteTool.writeString2(writeBuf, object1.msg);
        GameWriteTool.writeShort(writeBuf, object1.active);
    }

    public int cmd() {
        return 8165;
    }
}
