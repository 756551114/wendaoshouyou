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
import javax.annotation.PostConstruct;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.fight.BattleUtils;
import org.linlinjava.litemall.gameserver.fight.FightTianshuMap;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.netty.NettyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class GameCore {
    public static GameCore that;
    private static final Logger log = LoggerFactory.getLogger(GameCore.class);
    protected List<GameLine> gameLineList = new ArrayList();
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private List<BaseWrite> baseWrites;
    private static final Map<Integer, BaseWrite> basewriteMap = new HashMap();
    public NettyServer server;
    public long currentTime = 0L;

    public GameCore() {
    }

    public void init(NettyServer server) {
        log.error("game init begin!");
        this.server = server;

        for(int i = 0; i < 14; ++i) {
            GameLine gameLine = (GameLine)this.applicationContext.getBean("glllbawsdfawelllll", GameLine.class);
            gameLine.lineNum = i + 1;
            gameLine.lineName = "一战功成 " + gameLine.lineNum;
            this.gameLineList.add(gameLine);
            gameLine.init();
        }

        BuildFields.init();
        BuildFields.add();
        BattleUtils.init();
        FightTianshuMap.init();
        log.error("game init over!");
    }

    @PostConstruct
    public void initAfter() {
        that = this;
        Iterator var1 = this.baseWrites.iterator();

        while(var1.hasNext()) {
            BaseWrite baseWrite = (BaseWrite)var1.next();
            basewriteMap.put(baseWrite.cmd(), baseWrite);
        }

    }

    public static <T> T getBean(String name, Class<T> cls) {
        return that.applicationContext.getBean(name, cls);
    }

    protected static BaseWrite getBaseWrite(int cmd) {
        return (BaseWrite)basewriteMap.get(cmd);
    }

    public static GameLine getGameLine(int line) {
        Iterator var1 = that.gameLineList.iterator();

        GameLine gameLine;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            gameLine = (GameLine)var1.next();
        } while(gameLine.lineNum != line);

        return gameLine;
    }

    public List<GameLine> getGameLineAll() {
        return this.gameLineList;
    }
}
