package org.linlinjava.litemall.gameserver.fight;

import java.util.HashMap;
import java.util.Map;

public class FightTianshuMap {

    public static final Map<String,Integer> TIANSHU_EFFECT = new HashMap<>();
    public static void init(){
        TIANSHU_EFFECT.put("修罗术",7041);
        TIANSHU_EFFECT.put("降魔斩",7036);
        TIANSHU_EFFECT.put("怒击",7039);
        TIANSHU_EFFECT.put("烈炎",7034);
        TIANSHU_EFFECT.put("仙风",8050);
        TIANSHU_EFFECT.put("破天",7040);
        TIANSHU_EFFECT.put("狂暴",7037);
        TIANSHU_EFFECT.put("惊雷",7031);
        TIANSHU_EFFECT.put("碎石",7035);
        TIANSHU_EFFECT.put("反击",8049);
        TIANSHU_EFFECT.put("青木",7032);
        TIANSHU_EFFECT.put("尽忠",8240);
        TIANSHU_EFFECT.put("寒冰",7033);
        TIANSHU_EFFECT.put("云体",8051);
        TIANSHU_EFFECT.put("魔引",7038);
    }
}