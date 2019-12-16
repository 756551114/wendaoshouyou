//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.game;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("glllbawsdfawelllll")
@Scope("prototype")
public class GameLine {
    public int lineNum;
    public String lineName;
    private List<GameMap> gameRoomList = new ArrayList();
    private Map<String, GameMap> gameRoomNameMap = new HashMap();
    public static GameShuaGuai gameShuaGuai = new GameShuaGuai();

    public GameLine() {
    }

    public void init() {
        List<com.cool.wendao.community.model.Map> all = GameData.that.baseMapService.findAll();
        for (com.cool.wendao.community.model.Map map : all) {
            GameMap gameMap = (GameMap)GameCore.getBean("gmmmasdfasdfmmmm", GameMap.class);
            gameMap.id = map.getMapId();
            gameMap.name = map.getName();
            gameMap.x = map.getX();
            gameMap.y = map.getY();
            this.gameRoomList.add(gameMap);
            this.gameRoomNameMap.put(gameMap.name, gameMap);
        }
    }

    public static GameMap getGameMapname(int line, String mapidname) {
        GameLine gameLine = GameCore.getGameLine(line);
        Iterator var3 = gameLine.gameRoomList.iterator();

        GameMap gameMap;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            gameMap = (GameMap)var3.next();
        } while(!gameMap.name.equals(mapidname));

        return gameMap;
    }

    public static GameMap getGameMap(int line, int mapid) {
        GameLine gameLine = GameCore.getGameLine(line);
        Iterator var3 = gameLine.gameRoomList.iterator();

        GameMap gameMap;
        do {
            if (!var3.hasNext()) {
                return null;
            }

            gameMap = (GameMap)var3.next();
        } while(gameMap.id != mapid);

        return gameMap;
    }

    public static GameMap getGameMap(int line, String mapName) {
        GameLine gameLine = GameCore.getGameLine(line);
        return (GameMap)gameLine.gameRoomNameMap.get(mapName);
    }
}
