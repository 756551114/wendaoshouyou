//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
        List<org.linlinjava.litemall.db.domain.Map> all = GameData.that.baseMapService.findAll();
        Iterator var2 = all.iterator();

        while(var2.hasNext()) {
            org.linlinjava.litemall.db.domain.Map map = (org.linlinjava.litemall.db.domain.Map)var2.next();
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
