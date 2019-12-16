//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.fight;

import java.util.List;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

public interface FightSkill {
    List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng);

    int getStateType();

    static FightFabaoSkill getFabaoSkill(String name) {
        byte var2 = -1;
        switch(name.hashCode()) {
            case 23433827:
                if (name.equals("定海珠")) {
                    var2 = 1;
                }
                break;
            case 29614673:
                if (name.equals("番天印")) {
                    var2 = 0;
                }
                break;
            case 38182589:
                if (name.equals("阴阳镜")) {
                    var2 = 3;
                }
                break;
            case 666597108:
                if (name.equals("卸甲金葫")) {
                    var2 = 4;
                }
                break;
            case 859821330:
                if (name.equals("混元金斗")) {
                    var2 = 2;
                }
        }

        switch(var2) {
            case 0:
                return new FantianyingSkill();
            case 1:
                return new DinghaizhuSkill();
            case 2:
                return new HunyuanjindouSkill();
            case 3:
                return new YinyangjingSkill();
            case 4:
                return new XiejiajinhuSkill();
            default:
                return null;
        }
    }

    static boolean isOpSkill(int para) {
        switch(para) {
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
                return false;
            default:
                return true;
        }
    }

    static FightSkill getFightSkill(int action, int para) {
        if (action == 2 && para == 0) {
            System.out.println("error getFightSkill");
        }

        switch(action) {
            case 1:
                return new DefenseSkill();
            case 2:
                return new NormalAttackSkill();
            case 3:
                switch(para) {
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 161:
                    case 162:
                    case 163:
                    case 164:
                    case 165:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                        return new CastMagic11Skill();
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        return new ZhangAiJin21Skill();
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                        return new FuzhuJin31Skill();
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                        return new ZhangaiMu71Skill();
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                        return new FuzhuMu81Skill();
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                        return new ZhangaiShui121Skill();
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                        return new FuzhuShui131Skill();
                    case 171:
                    case 172:
                    case 173:
                    case 174:
                    case 175:
                        return new ZhangaiHuo171Skill();
                    case 181:
                    case 182:
                    case 183:
                    case 184:
                    case 185:
                        return new FuzhuHuo181Skill();
                    case 221:
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                        return new ZhangAiTu221Skill();
                    case 231:
                    case 232:
                    case 233:
                    case 234:
                    case 235:
                        return new FuzhuTu231Skill();
                    case 501:
                        return new CastMagic501Skill();
                }
            case 14:
                return new ZhaohuiSkill();
            case 4:
                return new UseItemSkill();
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            default:
                return null;
            case 7:
                return new FleeSkill();
            case 8:
                return new ZhaoChuSkill();
            case 9:
                return new CatchPetSkill();
        }
    }
}
