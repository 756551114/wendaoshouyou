package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_61537_0;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61537_0;

@Service
public class M61537_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        ListVo_61537_0 vo_61537_0 = (ListVo_61537_0) object;
        GameWriteTool.writeShort(writeBuf, vo_61537_0.a);
        GameWriteTool.writeShort(writeBuf, vo_61537_0.count);

        for (Vo_61537_0 vo : vo_61537_0.vo_61537_0) {
            GameWriteTool.writeShort(writeBuf, 17);
            BuildFields.get(BuildFields.EXTRA_DESC).write(writeBuf, vo.extra_desc);
            BuildFields.get(BuildFields.TRADING_SELL_BUY_TYPE).write(writeBuf, vo.trading_sell_buy_type);
            BuildFields.get(BuildFields.TRADING_STATE).write(writeBuf, vo.trading_state);
            BuildFields.get(BuildFields.PASSIVE_MODE).write(writeBuf, vo.passive_mode);
            BuildFields.get(BuildFields.TRADING_LEFT_TIME).write(writeBuf, vo.trading_left_time);
            BuildFields.get(BuildFields.TRADING_BUYOUT_PRICE).write(writeBuf, vo.trading_buyout_price);
            BuildFields.get(BuildFields.TRADING_PRICE).write(writeBuf, vo.trading_price);
            BuildFields.get(BuildFields.SKILL).write(writeBuf, vo.skill);
            BuildFields.get(BuildFields.METAL).write(writeBuf, vo.metal);
            BuildFields.get(BuildFields.TYPE).write(writeBuf, vo.type);
            BuildFields.get(BuildFields.TRADING_CG_PRICE_TI).write(writeBuf, vo.trading_cg_price_ti);
            BuildFields.get(BuildFields.STR).write(writeBuf, vo.str);
            BuildFields.get(BuildFields.IID_STR).write(writeBuf, vo.iid_str);
            BuildFields.get(BuildFields.DAN_DATA__STATE).write(writeBuf, vo.dan_datastate);
            BuildFields.get(BuildFields.CHAR_ONLINE_STATE).write(writeBuf, vo.char_online_state);
            BuildFields.get(BuildFields.TRADING_ORG_PRICE).write(writeBuf, vo.trading_org_price);
            BuildFields.get(BuildFields.TRADING_APPOINTEE_NAME).write(writeBuf, vo.trading_appointee_name);
            GameWriteTool.writeInt(writeBuf, vo.last_login_time);
        }
        GameWriteTool.writeInt(writeBuf, vo_61537_0.c);

        GameWriteTool.writeByte(writeBuf, vo_61537_0.d);
    }

    @Override
    public int cmd() {
        return 61537;
    }
}






















