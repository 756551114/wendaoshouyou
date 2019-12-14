package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.Vo_13143_0;
import org.linlinjava.litemall.gameserver.data.write.M13143_0;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//请求进入该服
@Service
public class C9040_0 implements GameHandler {
    private static final Logger log = LoggerFactory.getLogger(C9040_0.class);
    @Value("${netty.ip}")
    private String ip;
    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {

        String type = GameReadTool.readString(buff);

        String account = GameReadTool.readString(buff);
        log.debug("account : " + account);

        String password = GameReadTool.readString(buff);

        String mac = GameReadTool.readString(buff);

        String aaass = GameReadTool.readString(buff);

        String lock = GameReadTool.readString(buff);

        String dist = GameReadTool.readString(buff);

        int from3rdSdk = GameReadTool.readByte(buff);

        String channel = GameReadTool.readString(buff);

        String os_ver = GameReadTool.readString(buff);

        String term_info = GameReadTool.readString(buff);

        String imei = GameReadTool.readString(buff);

        String client_original_ver = GameReadTool.readString(buff);

        int not_replace = GameReadTool.readByte(buff);

        final int size = GameObjectCharMng.getAll().size();
        Vo_13143_0 vo_13143_0 = new Vo_13143_0();
        vo_13143_0.result = 1;
        vo_13143_0.privilege = 0;
        vo_13143_0.ip = ip;
        vo_13143_0.port = 14721;
        vo_13143_0.seed = 1446640884;
        vo_13143_0.auth_key = 7726836;
        vo_13143_0.id = 1;
        vo_13143_0.serverName = "一战功成";
        vo_13143_0.serverStatus = 3;
        vo_13143_0.msg = "允许该账号登录";


        final ByteBuf write = new M13143_0().write(vo_13143_0);
        ctx.writeAndFlush(write);
    }

    @Override
    public int cmd() {
        return 9040;
    }
}