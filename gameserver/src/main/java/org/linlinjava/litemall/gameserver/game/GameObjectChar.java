package org.linlinjava.litemall.gameserver.game;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameObjectChar {

    private static final Logger log = LoggerFactory.getLogger(GameObjectChar.class);
    public int accountid;
    public ChannelHandlerContext ctx;
    public static final ThreadLocal<GameObjectChar> GAMEOBJECTCHAR_THREAD_LOCAL = new ThreadLocal();
    public Chara chara;
    public Characters characters;
    public GameMap gameMap;
    public GameTeam gameTeam;
    public int upduizhangid;
    public long heartEcho;

    private AtomicBoolean lock = new AtomicBoolean(false);

    public boolean lock() {
        return lock.compareAndSet(false, true);
    }

    public void unlock() {
        lock.set(false);
    }

    public GameObjectChar(int accountid, ChannelHandlerContext ctx) {
        this.accountid = accountid;
        this.ctx = ctx;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GameObjectChar) {
            GameObjectChar gs = (GameObjectChar) obj;
            if (chara != null && gs.chara != null && chara.id == gs.chara.id) {
                return true;
            }
        }
        return false;
    }

    public void creator(GameTeam gameTeam) {
        this.gameTeam = gameTeam;
    }

    public void init(Characters characters) {
        String data = characters.getData();
        Chara chara = JSONUtils.parseObject(data, Chara.class);
        chara.id = characters.getId();
        this.chara = chara;
        this.characters = characters;
        GameObjectCharMng.add(this);
        final GameMap gameMap = GameLine.getGameMap(chara.line, chara.mapName);
//        if (chara.mapid == 38004) {
//            String shidaolevel = GameUtilRenWu.shidaolevel(chara);
//            gameMap = GameLine.getGameMap(chara.line, shidaolevel);
//        }
        this.gameMap = gameMap;
    }

    public static final GameObjectChar getGameObjectChar() {
        return GAMEOBJECTCHAR_THREAD_LOCAL.get();
    }

    public static void send(BaseWrite baseWrite, Object obj) {
        final GameObjectChar gameObjectChar = GAMEOBJECTCHAR_THREAD_LOCAL.get();
        final ByteBuf write = baseWrite.write(obj);
        gameObjectChar.ctx.writeAndFlush(write);
    }

    public static void send(BaseWrite baseWrite, Object obj, int id) {
        final GameObjectChar gameObjectChar = GameObjectCharMng.getGameObjectChar(id);
        if (gameObjectChar == null) {
            return;
        }
        final ByteBuf write = baseWrite.write(obj);
        gameObjectChar.ctx.writeAndFlush(write);
    }

    public static void sendduiwu(BaseWrite baseWrite, Object obj, int duiyuanid) {

        final GameObjectChar gameObjectChar = GameObjectCharMng.getGameObjectChar(duiyuanid);
        if (gameObjectChar.gameTeam != null && gameObjectChar.gameTeam.duiwu != null) {
            for (int i = 0; i < gameObjectChar.gameTeam.duiwu.size(); i++) {
                GameObjectChar gameObjectChar1 = GameObjectCharMng.getGameObjectChar(gameObjectChar.gameTeam.duiwu.get(i).id);
                final ByteBuf write = baseWrite.write(obj);
                gameObjectChar1.ctx.writeAndFlush(write);
            }
        } else {
            final ByteBuf write = baseWrite.write(obj);
            gameObjectChar.ctx.writeAndFlush(write);
        }

    }



    protected void send0(ByteBuf write) {
        ctx.writeAndFlush(write);
    }

    public void offline() {

        try {
            //TODO 下线需要处理
            if (gameTeam != null && gameTeam.duiwu != null && gameTeam.duiwu.size() > 0) {
                // 队长
                if (gameTeam.duiwu.get(0).id == chara.id) {
                    for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                        List<Vo_4119_0> object1 = new ArrayList<>();
                        GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).sendOne(new M4119_0(), object1);
                        List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
                        GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).sendOne(new M4121_0(), vo_4121_0List);
                        Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                        vo_20480_0.msg = "队伍解散了。";
                        vo_20480_0.time = 1562593376;
                        GameObjectCharMng.getGameObjectChar(gameTeam.zhanliduiyuan.get(i).id).sendOne(new M20480_0(), vo_20480_0);
                        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                        vo_61671_0.id = gameTeam.duiwu.get(i).id;
                        vo_61671_0.count = 0;
                        GameObjectCharMng.getGameObjectChar(chara.id).gameMap.send(new M61671_0(), vo_61671_0);
                    }

                    for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.zhanliduiyuan.size() - 1; i++) {
                        GameObjectCharMng.getGameObjectChar(GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.zhanliduiyuan.get(i + 1).id).gameTeam = null;
                    }
                    GameObjectCharMng.getGameObjectChar(chara.id).gameTeam = null;
                    Vo_61593_0 vo_61593_0 = new Vo_61593_0();
                    vo_61593_0.ask_type = "request_join";
                    GameObjectChar.send(new M61593_0(), vo_61593_0);


                    vo_61593_0 = new Vo_61593_0();
                    vo_61593_0.ask_type = "request_team_leader";
                    GameObjectChar.send(new M61593_0(), vo_61593_0);
                    List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
                    GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M4121_0(), vo_4121_0List);
                    GameObjectCharMng.getGameObjectChar(chara.id).gameTeam = null;
                } else {
                    //队员自己离开队伍
                    Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                    vo_61671_0.id = chara.id;
                    vo_61671_0.count = 0;
                    GameObjectCharMng.getGameObjectChar(chara.id).gameMap.send(new M61671_0(), vo_61671_0);
                    List<Vo_4119_0> object1 = new ArrayList<>();
                    GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M4119_0(), object1);
                    List<Vo_4121_0> vo_4121_0List = new ArrayList<>();
                    GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M4121_0(), vo_4121_0List);
                    Vo_20480_0 vo_20480_0 = new Vo_20480_0();
                    vo_20480_0.msg = "你离开了队伍";
                    vo_20480_0.time = 1562593376;
                    GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M20480_0(), vo_20480_0);
                    for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                        Vo_61661_0 vo_61661_0 = GameUtil.a61661(gameTeam.duiwu.get(i));
                        GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(i).id).sendOne(new M61661_0(), vo_61661_0);
                    }

                    Vo_49189_0 vo_49189_0 = new Vo_49189_0();
                    GameObjectCharMng.getGameObjectChar(chara.id).sendOne(new M49189_0(), vo_49189_0);
                    for (int i = 0; i < gameTeam.duiwu.size(); i++) {
                        if (gameTeam.duiwu.get(i).id == chara.id) {
                            gameTeam.duiwu.remove(i);
                        }
                    }
                    for (int i = 0; i < gameTeam.zhanliduiyuan.size(); i++) {
                        if (gameTeam.zhanliduiyuan.get(i).id == chara.id) {
                            gameTeam.zhanliduiyuan.remove(i);
                        }
                    }
                    List<Chara> duiwu = GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu;
                    GameUtil.a4119(duiwu);
                    GameUtil.a4121(GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.zhanliduiyuan);

                    Vo_20568_0 vo_20568_0 = new Vo_20568_0();
                    vo_20568_0.gid = "";
                    GameObjectCharMng.getGameObjectChar(gameTeam.duiwu.get(0).id).sendOne(new M20568_0(), vo_20568_0);

                    for (int i = 0; i < duiwu.size(); i++) {
                        vo_20480_0 = new Vo_20480_0();
                        vo_20480_0.msg = chara.name + "离开了队伍";
                        vo_20480_0.time = 1562593376;
                        GameObjectCharMng.getGameObjectChar(duiwu.get(i).id).sendOne(new M20480_0(), vo_20480_0);

                        Vo_45124_0 vo_45124_0 = new Vo_45124_0();
                        GameObjectCharMng.getGameObjectChar(duiwu.get(i).id).sendOne(new M45124_0(), vo_45124_0);
                    }
                }
            }
        } catch (Exception e) {
            log.error("", e);
        }
        try {
            gameMap.send(new M12285_1(), chara.id);
            gameMap.leave(GameObjectCharMng.getGameObjectChar(chara.id));
        } catch (Exception e) {
            log.error("", e);
        }
        try {
            chara.updatetime = System.currentTimeMillis();
            chara.online_time = chara.online_time + (chara.updatetime - chara.uptime);
            characters.setData(JSONUtils.toJSONString(chara));
            GameData.that.baseCharactersService.updateById(characters);
        } catch (Exception e) {
            log.error("", e);
        }
        ctx.disconnect();

    }

    //发送消息给其他人
    public void sendOne(BaseWrite baseWrite, Object obj) {
        final ByteBuf buff = baseWrite.write(obj);
        final ByteBuf copy = buff.copy();
        send0(copy);
    }

}
