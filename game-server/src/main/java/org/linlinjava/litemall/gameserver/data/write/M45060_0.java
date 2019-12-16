package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45060_0;

@Service
public class M45060_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45060_0 object1 = (Vo_45060_0) object;
        GameWriteTool.writeShort(writeBuf, object1.hasBonus);

        GameWriteTool.writeShort(writeBuf, object1.xy_higest);

        GameWriteTool.writeShort(writeBuf, object1.fm_higest);

        GameWriteTool.writeShort(writeBuf, object1.fx_higest);

        GameWriteTool.writeInt(writeBuf, object1.off_line_time);

        GameWriteTool.writeShort(writeBuf, object1.buy_one);

        GameWriteTool.writeShort(writeBuf, object1.buy_five);

        GameWriteTool.writeShort(writeBuf, object1.buy_time);

        GameWriteTool.writeShort(writeBuf, object1.max_buy_time);

        GameWriteTool.writeShort(writeBuf, object1.offlineStatus);

        GameWriteTool.writeShort(writeBuf, object1.max_turn);

        GameWriteTool.writeString(writeBuf, object1.lastTaskName);

        GameWriteTool.writeShort(writeBuf, object1.max_double);

        GameWriteTool.writeShort(writeBuf, object1.max_jiji);

        GameWriteTool.writeShort(writeBuf, object1.jijiStatus);

        GameWriteTool.writeShort(writeBuf, object1.chongfengsan_time);

        GameWriteTool.writeShort(writeBuf, object1.max_chongfengsan_time);

        GameWriteTool.writeShort(writeBuf, object1.ziqihongmeng_time);

        GameWriteTool.writeShort(writeBuf, object1.max_ziqihongmeng_time);

        GameWriteTool.writeShort(writeBuf, object1.max_chongfengsan);

        GameWriteTool.writeShort(writeBuf, object1.chongfengsan_status);

        GameWriteTool.writeShort(writeBuf, object1.max_ziqihongmeng);

        GameWriteTool.writeShort(writeBuf, object1.ziqihongmeng_status);

        GameWriteTool.writeByte(writeBuf, object1.hasDaofaBonus);

        GameWriteTool.writeShort(writeBuf, object1.count);

        GameWriteTool.writeString(writeBuf, object1.taskName);

        GameWriteTool.writeShort(writeBuf, object1.taskTime);

        GameWriteTool.writeString(writeBuf, object1.taskName1);

        GameWriteTool.writeShort(writeBuf, object1.taskTime1);

        GameWriteTool.writeString(writeBuf, object1.taskName2);

        GameWriteTool.writeShort(writeBuf, object1.taskTime2);
    }

    @Override
    public int cmd() {
        return 45060;
    }
}
































