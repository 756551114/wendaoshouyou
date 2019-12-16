package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_49159_0;

@Service
public class M49159_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_49159_0 object1 = (Vo_49159_0) object;
        GameWriteTool.writeInt(writeBuf, object1.leftTime);

        GameWriteTool.writeByte(writeBuf, object1.times);

        GameWriteTool.writeByte(writeBuf, object1.leftTimes);

        GameWriteTool.writeByte(writeBuf, object1.isCanSign);

        GameWriteTool.writeByte(writeBuf, object1.isCanGetNewPalyerGift);

        GameWriteTool.writeByte(writeBuf, object1.firstChargeState);

        GameWriteTool.writeByte(writeBuf, object1.cumulativeReward);

        GameWriteTool.writeByte(writeBuf, object1.loginGiftState);

        GameWriteTool.writeByte(writeBuf, object1.activeCount);

        GameWriteTool.writeByte(writeBuf, object1.holidayCount);

        GameWriteTool.writeByte(writeBuf, object1.isCanReplenishSign);

        GameWriteTool.writeByte(writeBuf, object1.chargePointFlag);

        GameWriteTool.writeByte(writeBuf, object1.consumePointFlag);

        GameWriteTool.writeByte(writeBuf, object1.isShowHuiGui);

        GameWriteTool.writeByte(writeBuf, object1.canGetZXQYHuoYue);

        GameWriteTool.writeByte(writeBuf, object1.canGetZXQYSevenLogin);

        GameWriteTool.writeByte(writeBuf, object1.isShowZhaohui);

        GameWriteTool.writeByte(writeBuf, object1.activeVIPFlag);

        GameWriteTool.writeByte(writeBuf, object1.rename_discount_time);

        GameWriteTool.writeByte(writeBuf, object1.summerSF2017);

        GameWriteTool.writeByte(writeBuf, object1.zaohua);

        GameWriteTool.writeByte(writeBuf, object1.welcomeDrawStatue);

        GameWriteTool.writeByte(writeBuf, object1.activeLoginStatue);

        GameWriteTool.writeByte(writeBuf, object1.xundcf);

        GameWriteTool.writeByte(writeBuf, object1.mergeLoginStatus);

        GameWriteTool.writeByte(writeBuf, object1.mergeLoginActiveStatus);

        GameWriteTool.writeByte(writeBuf, object1.reentryAsktaoRecharge);

        GameWriteTool.writeByte(writeBuf, object1.expStoreStatus);

        GameWriteTool.writeByte(writeBuf, object1.isShowXYFL);

        GameWriteTool.writeByte(writeBuf, object1.isShowXFSD);

        GameWriteTool.writeShort(writeBuf, object1.newServeAddNum);
    }

    @Override
    public int cmd() {
        return 49159;
    }
}

