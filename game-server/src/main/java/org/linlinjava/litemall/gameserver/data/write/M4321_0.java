//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4321_0;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;

@Service
public class M4321_0 extends BaseWrite {
    public M4321_0() {
    }

    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_4321_0 object1 = (Vo_4321_0)object;
        GameWriteTool.writeShort(writeBuf, object1.flag);
        GameWriteTool.writeString(writeBuf, object1.dist);
        GameWriteTool.writeString(writeBuf, object1.name);
        GameWriteTool.writeInt(writeBuf, object1.time);
        GameWriteTool.writeShort(writeBuf, object1.a);
        GameWriteTool.writeByte(writeBuf, object1.b);
        GameWriteTool.writeByte(writeBuf, object1.c);
    }

    public int cmd() {
        return 4321;
    }
}
