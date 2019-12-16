package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

public class TestWrite extends BaseWrite{


    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {

    }

    @Override
    public int cmd() {
        return 10000;
    }
}
