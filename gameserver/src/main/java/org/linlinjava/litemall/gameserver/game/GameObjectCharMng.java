package org.linlinjava.litemall.gameserver.game;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameObjectCharMng {
    private static final List<GameObjectChar> gameObjectCharList = new CopyOnWriteArrayList<>();

    public static void add(GameObjectChar gameObjectChar) {
        if (gameObjectCharList.contains(gameObjectChar)) {
            for (GameObjectChar gameSession : gameObjectCharList) {
                if (gameObjectChar.chara.id == gameSession.chara.id) {
//                    gameSession.offline();
                    gameSession.ctx.disconnect();
                    gameObjectChar.gameTeam = gameSession.gameTeam;
                    gameObjectCharList.remove(gameSession);
                }
            }
        }
        gameObjectCharList.add(gameObjectChar);
    }

    public static void sendAll(BaseWrite baseWrite, Object obj) {
        for (int i = 0; i < gameObjectCharList.size(); i++) {
            final GameObjectChar session = gameObjectCharList.get(i);
            final ByteBuf write = baseWrite.write(obj);
            session.ctx.writeAndFlush(write);
        }
    }

    public static List<GameObjectChar> getGameObjectCharList() {
        return gameObjectCharList;
    }

    public static void sendAllmap(BaseWrite baseWrite, Object obj, int mapid) {
        for (int i = 0; i < gameObjectCharList.size(); i++) {
            final GameObjectChar gameObjectChar = gameObjectCharList.get(i);
            if (gameObjectChar.gameMap.id == mapid) {
                final ByteBuf write = baseWrite.write(obj);
                gameObjectChar.ctx.writeAndFlush(write);
            }
        }
    }

    public static void sendAllmapname(BaseWrite baseWrite, Object obj, String mapname) {
        for (int i = 0; i < gameObjectCharList.size(); i++) {
            final GameObjectChar gameObjectChar = gameObjectCharList.get(i);
            if (gameObjectChar.gameMap.name.equals(mapname)) {
                final ByteBuf write = baseWrite.write(obj);
                gameObjectChar.ctx.writeAndFlush(write);
            }
        }
    }

    public static final GameObjectChar getGameObjectChar(int id) {
        for (GameObjectChar gameObjectChar : gameObjectCharList) {
            if (gameObjectChar.chara.id == id) {
                return gameObjectChar;
            }
        }
        return null;
    }

    public static final List<GameObjectChar> getAll() {
        return gameObjectCharList;
    }

    public static void remove(GameObjectChar gameObjectChar) {
        gameObjectChar.chara.updatetime = System.currentTimeMillis();
        save(gameObjectChar);
    }

    public static void save(GameObjectChar gameObjectChar) {
        gameObjectChar.characters.setData(JSONUtils.toJSONString(gameObjectChar.chara));
        GameData.that.baseCharactersService.updateById(gameObjectChar.characters);
    }

}
