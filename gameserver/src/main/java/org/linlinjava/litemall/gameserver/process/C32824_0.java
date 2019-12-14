package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.vo.Vo_32825_0;
import org.linlinjava.litemall.gameserver.data.write.M32825_0;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.springframework.stereotype.Service;

@Service
public class C32824_0 implements GameHandler {


    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        Vo_32825_0 vo_32825_0 = new Vo_32825_0();
        vo_32825_0.name0 = "summer_day_2019_xzjs";
        vo_32825_0.startTime0 = 1562792400;
        vo_32825_0.endTime0 = 1563397199;
        vo_32825_0.name1 = "qixi_2019_qqzy";
        vo_32825_0.startTime1 = 1564952400;
        vo_32825_0.endTime1 = 1565211599;
        vo_32825_0.name2 = "huazhuang_wuhui";
        vo_32825_0.startTime2 = 1562679000;
        vo_32825_0.endTime2 = 1562680800;
        vo_32825_0.name3 = "suiji_richange";
        vo_32825_0.startTime3 = 1563570000;
        vo_32825_0.endTime3 = 1563742799;
        vo_32825_0.name4 = "tianjiangbaohe";
        vo_32825_0.startTime4 = 1562965200;
        vo_32825_0.endTime4 = 1563137999;
        vo_32825_0.name5 = "huanlebaoxiang";
        vo_32825_0.startTime5 = 1563397200;
        vo_32825_0.endTime5 = 1563742799;
        vo_32825_0.name6 = "new_year_attendance";
        vo_32825_0.startTime6 = 1577826000;
        vo_32825_0.endTime6 = 1578430799;
        vo_32825_0.name7 = "qixi_2019_lmqg";
        vo_32825_0.startTime7 = 1564952400;
        vo_32825_0.endTime7 = 1565211599;
        vo_32825_0.name8 = "summer_day_2019_sxdj";
        vo_32825_0.startTime8 = 1562187600;
        vo_32825_0.endTime8 = 1562792399;
        vo_32825_0.name9 = "limit_purchase";
        vo_32825_0.startTime9 = 1561928400;
        vo_32825_0.endTime9 = 1564952399;
        vo_32825_0.name10 = "summer_day_2019_smsz";
        vo_32825_0.startTime10 = 1562792400;
        vo_32825_0.endTime10 = 1563397199;
        vo_32825_0.name11 = "summer_day_2019_sswg";
        vo_32825_0.startTime11 = 1563397200;
        vo_32825_0.endTime11 = 1564001999;
        vo_32825_0.name12 = "yisheng_pengyou";
        vo_32825_0.startTime12 = 1556226000;
        vo_32825_0.endTime12 = 1585601999;
        vo_32825_0.name13 = "reentry_asktao_2016";
        vo_32825_0.startTime13 = 1483218000;
        vo_32825_0.endTime13 = 2113938000;
        vo_32825_0.name14 = "global_double";
        vo_32825_0.startTime14 = 1562668200;
        vo_32825_0.endTime14 = 1562675400;
        vo_32825_0.name15 = "summer_day_2019_bhky";
        vo_32825_0.startTime15 = 1563397200;
        vo_32825_0.endTime15 = 1564001999;
        vo_32825_0.name16 = "month_charge_gift";
        vo_32825_0.startTime16 = 1561928400;
        vo_32825_0.endTime16 = 1564606799;
        vo_32825_0.name17 = "newdisthelp";
        vo_32825_0.startTime17 = 1556312400;
        vo_32825_0.endTime17 = 1557435599;
        vo_32825_0.name18 = "good_voice";
        vo_32825_0.startTime18 = 1561582800;
        vo_32825_0.endTime18 = 1563364800;
        GameObjectChar.send(new M32825_0(), vo_32825_0);
    }

    @Override
    public int cmd() {
        return 32824;
    }
}