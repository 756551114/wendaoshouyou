package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45143_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45555_0;
import org.linlinjava.litemall.gameserver.data.write.M45555_0;
import org.linlinjava.litemall.gameserver.data.write.M45143_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//验证账号
@Service
public class C45144_0 implements GameHandler {
    private static final Logger logger = LoggerFactory.getLogger(C45144_0.class);

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String account = GameReadTool.readString(buff).substring(6);
        Accounts useraccount = GameData.that.baseAccountsService.findOneByToken(account);
        if (useraccount == null) {
            logger.info("验证不通过");
            return;
        }
        Vo_45143_0 vo_45143_0 = new Vo_45143_0();
        vo_45143_0.line_name = "";
        vo_45143_0.expect_time = 1;
        vo_45143_0.reconnet_time = 0;
        vo_45143_0.waitCode = 1;
        vo_45143_0.count = 1;
        vo_45143_0.keep_alive = 1;
        vo_45143_0.need_wait = 0;
        vo_45143_0.indsider_lv = 255;
        vo_45143_0.gold_coin = 0;
        vo_45143_0.status = 0;
        Vo_45555_0 vo_45555_0 = new Vo_45555_0();
        vo_45555_0.type = "normal";
        vo_45555_0.cookie = "2960226";

        final ByteBuf write = new M45143_0().write(vo_45143_0);
        final ByteBuf write1 = new M45555_0().write(vo_45555_0);
        ctx.writeAndFlush(write);
        ctx.writeAndFlush(write1);
    }

    @Override
    public int cmd() {
        return 45144;
    }
}