package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45382_0;

@Service
public class M45382_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45382_0 object1 = (Vo_45382_0) object;
        GameWriteTool.writeString(writeBuf, object1.reward_str);

        GameWriteTool.writeByte(writeBuf, object1.level);
    }

    @Override
    public int cmd() {
        return 45382;
    }
}



