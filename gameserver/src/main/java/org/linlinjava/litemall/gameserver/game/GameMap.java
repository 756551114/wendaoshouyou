package org.linlinjava.litemall.gameserver.game;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.db.domain.NpcPoint;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service("gmmmasdfasdfmmmm")
@Scope("prototype")
public class GameMap {
    private static final Logger log = LoggerFactory.getLogger(GameMap.class);
    public int id;
    public String name;
    public int x;
    public int y;
    public List<GameObjectChar> sessionList = new CopyOnWriteArrayList<>();

    //试道
    public GameShiDao gameShiDao = new GameShiDao();

    public List<GameObjectChar> getSessionList() {
        return sessionList;
    }

    public void join(GameObjectChar gameObjectChar) {
        gameObjectChar.gameMap.leave(gameObjectChar);
        sessionList.remove(gameObjectChar);
        sessionList.add(gameObjectChar);
        final Chara chara = gameObjectChar.chara;
        final List<Npc> npcList = GameData.that.baseNpcService.findByMapId(id);
        gameObjectChar.gameMap = this;
//
        chara.mapid = id;
        chara.mapName = name;
        Vo_45157_0 vo_45157_0 = new Vo_45157_0();
        vo_45157_0.id = chara.id;
        vo_45157_0.mapId = chara.mapid;
        gameObjectChar.sendOne(new M45157_0(), vo_45157_0);

        Vo_65505_0 vo_65505_1 = GameUtil.a65505(chara);
        gameObjectChar.sendOne(new M65505_0(), vo_65505_1);

        for (Npc npc : npcList) {
            gameObjectChar.sendOne(new M65529_npc(), npc);
        }
        final List<NpcPoint> list = GameData.that.baseNpcPointService.findByMapname(name);

        gameObjectChar.sendOne(new M65531_0(), list);


        Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara);
        send(new M65529_0(), vo_65529_0);


        if (gameObjectChar.gameTeam != null && gameObjectChar.gameTeam.duiwu != null && gameObjectChar.gameTeam.duiwu.size() > 0) {
            Vo_61671_0 vo_61671_0 = new Vo_61671_0();
            vo_61671_0.id = gameObjectChar.gameTeam.duiwu.get(0).id;
            vo_61671_0.count = 2;
            vo_61671_0.list.add(2);
            vo_61671_0.list.add(3);
            gameObjectChar.gameMap.send(new M61671_0(), vo_61671_0);
        }

        //发送地图其他人信息
        for (GameObjectChar gameSession : sessionList) {
            if (gameSession.ctx != null && gameSession.chara != null) {
                vo_65529_0 = GameUtil.a65529(gameSession.chara);
                GameUtil.genchongfei(gameSession.chara);
                gameObjectChar.sendOne(new M65529_0(), vo_65529_0);



                if (gameSession.gameTeam != null && gameSession.gameTeam.duiwu != null && gameSession.gameTeam.duiwu.size() > 0) {
                    Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                    vo_61671_0.id = gameSession.gameTeam.duiwu.get(0).id;
                    vo_61671_0.count = 2;
                    vo_61671_0.list.add(2);
                    vo_61671_0.list.add(3);
                    gameObjectChar.sendOne(new M61671_0(), vo_61671_0);
                }

            }
        }


        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.mapid;
        vo_61671_0.count = 0;

        gameObjectChar.sendOne(new M61671_0(), vo_61671_0);




    }


    public void joinduiyuan(GameObjectChar gameObjectChar, Chara charaduizhang) {
        gameObjectChar.gameMap.leave(gameObjectChar);
        sessionList.remove(gameObjectChar);
        sessionList.add(gameObjectChar);
        final Chara chara = gameObjectChar.chara;
        final List<Npc> npcList = GameData.that.baseNpcService.findByMapId(id);
        gameObjectChar.gameMap = this;
        chara.x = charaduizhang.x;
        chara.y = charaduizhang.y;
        chara.mapid = charaduizhang.mapid;
        chara.mapName = charaduizhang.mapName;
        Vo_45157_0 vo_45157_0 = new Vo_45157_0();
        vo_45157_0.id = chara.id;
        vo_45157_0.mapId = charaduizhang.mapid;
        gameObjectChar.sendOne(new M45157_0(), vo_45157_0);

        Vo_65505_0 vo_65505_1 = GameUtil.a65505(chara);
        gameObjectChar.sendOne(new M65505_0(), vo_65505_1);

        for (Npc npc : npcList) {
            gameObjectChar.sendOne(new M65529_npc(), npc);
        }
        final List<NpcPoint> list = GameData.that.baseNpcPointService.findByMapname(name);

        gameObjectChar.sendOne(new M65531_0(), list);


        Vo_65529_0 vo_65529_0 = GameUtil.a65529(chara);
        send(new M65529_0(), vo_65529_0);


        for (GameObjectChar gameSession : sessionList) {
            if (gameSession.ctx != null && gameSession.chara != null) {
                vo_65529_0 = GameUtil.a65529(gameSession.chara);
                gameObjectChar.sendOne(new M65529_0(), vo_65529_0);
                GameUtil.genchongfei(gameSession.chara);

                if (gameSession.gameTeam != null && gameSession.gameTeam.duiwu.size() > 0) {
                    Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                    vo_61671_0.id = gameSession.gameTeam.duiwu.get(0).id;
                    vo_61671_0.count = 2;
                    vo_61671_0.list.add(2);
                    vo_61671_0.list.add(3);
                    gameObjectChar.sendOne(new M61671_0(), vo_61671_0);
                }


            }
        }


        Vo_61671_0 vo_61671_0 = new Vo_61671_0();
        vo_61671_0.id = chara.id;
        vo_61671_0.count = 0;

        gameObjectChar.sendOne(new M61671_0(), vo_61671_0);




    }

    public void leave(GameObjectChar gameObjectChar) {
        sendNoMe(new M12285_0(), gameObjectChar.chara.id, gameObjectChar);
        sendNoMe(new M12285_1(), gameObjectChar.chara.genchong_icon, gameObjectChar);
        sessionList.remove(gameObjectChar);
        //TODO 离开房间的通知
    }

    //发送给房间内所有人
    public void send(BaseWrite baseWrite, Object obj) {
        final GameObjectChar session = GameObjectChar.getGameObjectChar();
        final ByteBuf buff = baseWrite.write(obj);
        boolean hasSend = false;
        int sendNum = 0;
        for (GameObjectChar gameSession : sessionList) {
            if (gameSession.ctx != null) {
                sendNum++;
                final ByteBuf copy = buff.copy();
                gameSession.send0(copy);
                if (gameSession == session) {
                    hasSend = true;
                }
            }
        }
        if (!hasSend && session != null) {
            session.send0(buff.copy());
        }
        ReferenceCountUtil.release(buff);
    }

    //发送给房间内除了我之外的所有人
    public void sendNoMe(BaseWrite baseWrite, Object obj, GameObjectChar gameObjectChar) {
        int sendNum = 0;

        final ByteBuf buff = baseWrite.write(obj);
        for (GameObjectChar gameSession : sessionList) {
            if (!gameObjectChar.equals(gameSession)) {
                if (gameSession.ctx != null) {
                    sendNum++;
                    final ByteBuf copy = buff.copy();
                    gameSession.send0(copy);
                }
            }
        }
        ReferenceCountUtil.release(buff);
    }

    //发送给房间内除了队伍之外的所有人
    public void sendNoMeduiwu(BaseWrite baseWrite, Object obj, GameObjectChar gameObjectChar) {
        int sendNum = 0;

        final ByteBuf buff = baseWrite.write(obj);
        for (GameObjectChar gameSession : sessionList) {
            boolean has = false;
            if (gameSession.gameTeam != null && gameSession.gameTeam.duiwu != null) {
                for (int i = 0; i < gameSession.gameTeam.duiwu.size(); i++) {
                    if (gameSession.equals(GameObjectCharMng.getGameObjectChar(gameSession.gameTeam.duiwu.get(i).id))) {
                        has = true;
                    }
                }
                if (!has) {
                    if (gameSession.ctx != null) {
                        sendNum++;
                        final ByteBuf copy = buff.copy();
                        gameSession.send0(copy);
                    }
                }
            } else {
                if (!gameObjectChar.equals(gameSession)) {
                    if (gameSession.ctx != null) {
                        sendNum++;
                        final ByteBuf copy = buff.copy();
                        gameSession.send0(copy);
                    }
                }
            }
        }
        ReferenceCountUtil.release(buff);
    }

    //发送邮件
    public void sendNoMeyoujian(BaseWrite baseWrite, Object obj, GameObjectChar gameObjectChar) {
        final ByteBuf buff = baseWrite.write(obj);
        for (GameObjectChar gameSession : sessionList) {
            if (gameObjectChar.equals(gameSession)) {
                if (gameSession.ctx != null) {
                    final ByteBuf copy = buff.copy();
                    gameSession.send0(copy);
                }
            }
        }
        ReferenceCountUtil.release(buff);
    }


}
