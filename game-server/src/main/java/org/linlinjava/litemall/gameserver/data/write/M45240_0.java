package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45240_0;

@Service
public class M45240_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45240_0 object1 = (Vo_45240_0) object;
        GameWriteTool.writeString(writeBuf, object1.tips);

        GameWriteTool.writeInt(writeBuf, object1.down_count);

        GameWriteTool.writeByte(writeBuf, object1.only_confirm);

        GameWriteTool.writeString(writeBuf, object1.confirm_type);

        GameWriteTool.writeString(writeBuf, object1.confirmText);

        GameWriteTool.writeString(writeBuf, object1.cancelText);

        GameWriteTool.writeByte(writeBuf, object1.show_dlg_mode);

        GameWriteTool.writeString(writeBuf, object1.countDownTips);

        GameWriteTool.writeString2(writeBuf, object1.para_str);
    }

    @Override
    public int cmd() {
        return 45240;
    }
}










