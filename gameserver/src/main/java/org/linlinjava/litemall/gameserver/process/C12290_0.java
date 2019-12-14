package org.linlinjava.litemall.gameserver.process;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import org.linlinjava.litemall.db.domain.Accounts;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.gameserver.GameHandler;
import org.linlinjava.litemall.gameserver.data.GameReadTool;
import org.linlinjava.litemall.gameserver.data.vo.ListVo_61537_0;
import org.linlinjava.litemall.gameserver.data.write.M61537_0;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.netty.ServerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


//请求用户角色
@Service
public class C12290_0 implements GameHandler {
    private static final Logger logger = LoggerFactory.getLogger(C12290_0.class);

    @Override
    public void process(ChannelHandlerContext ctx, ByteBuf buff) {



        String user = GameReadTool.readString(buff);

        int auth_key = GameReadTool.readInt(buff);

        int seed = GameReadTool.readInt(buff);

        int emulator = GameReadTool.readByte(buff);

        int sight_scope = GameReadTool.readByte(buff);

        String version = GameReadTool.readString(buff);

        String clientid = GameReadTool.readString(buff);

        int netStatus = GameReadTool.readShort(buff);

        int adult = GameReadTool.readByte(buff);

        String signature = GameReadTool.readString(buff);

        String clientname = GameReadTool.readString(buff);

        int redfinger = GameReadTool.readByte(buff);

        user = user.substring(6);
        final Accounts accounts = GameData.that.baseAccountsService.findOneByToken(user);
        List<Characters> charactersList = GameData.that.characterService.findByAccountId(accounts.getId());
        ListVo_61537_0 listvo_61537_0 = C8284_0.listjiaose(charactersList);


        final ByteBuf write = new M61537_0().write(listvo_61537_0);
        ctx.writeAndFlush(write);


        GameObjectChar gameSession = new GameObjectChar(accounts.getId(), ctx);
        final Attribute<GameObjectChar> attr = ctx.channel().attr(ServerHandler.akey);
        attr.set(gameSession);
    }

    @Override
    public int cmd() {
        return 12290;
    }
}