//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data.game;

public class PackUtils {
    public PackUtils() {
    }

    public static int demonStoneValue(int type) {
        int skill = type % 10 + 1;
        int silver_coin = 3000 + skill * 1000;
        int def = skill * skill * 100;
        int parry = skill * 32;
        int wiz = skill * skill * 30;
        int accurate = skill * skill * 66;
        int dex = skill * skill * 66;
        int[] manas = new int[]{0, 43, 174, 392, 696, 1089, 1568, 2134, 2787, 3528};
        if (skill > 9) {
            skill = 9;
        }

        int mana = manas[skill];
        int swType = type / 10;
        switch(swType) {
            case 10:
                return def;
            case 11:
            case 13:
            case 15:
            case 17:
            case 19:
            default:
                return 100;
            case 12:
                return parry;
            case 14:
                return wiz;
            case 16:
                return accurate;
            case 18:
                return mana;
            case 20:
                return dex;
        }
    }

    public static int comparator(String str) {
        return comparator(str, false);
    }

    public static int comparator(String str, boolean noAppraisal) {
        String zb = "流云扇#乙木神剑#寒风枪#暴雨梨花枪#云龙枪#蕴雷枪#风火游龙枪#九转金刚刃#混元斩龙戟#骷髅爪#幽冥鬼爪#噬魂魔爪#拂兰指#啼血爪#七巧玲珑爪#镇魂摄天刺#昆吾剑#追魂剑#九黎剑#轩辕剑#紫青玄魔剑#封神诛仙剑#百花扇#蔽日扇#乾坤扇#五彩神焰扇#离火七翎扇#赤霄烈焰扇#霹雳锤#晃金锤#撼地锤#破天锤#加持杵#炼狱麒麟杵#风雷如意杵#白玉冠#乾坤冠#龙冠#蟠龙冠#九霄烈焰冠#星耀冠#七星宝冠#凤尾钗#鱼尾冠#凤冠#金霞冠#九霄凤鸣冠#凌波霞冠#天灵宝冠#金丝甲#八卦衣#连环甲#金缕衣#天衣#瀚宇法袍#诸天法袍#水合袍#狐皮袄#蛟皮袄#天蚕衣#霓裳羽衣#星晶法衣#神鸢凤裘#亮银靴#疾风履#无影靴#天行履#踏云靴#御风履#钧天履#长剑#青锋剑#沉香剑#飞虹剑#乾元剑#斩妖剑#簪子#布裙#麻鞋#折扇#精铁扇#飞凤钗#布鞋#绛紫裙#逍遥扇#碧玉钗#马靴#虹羽衣#玉骨扇#蝴蝶钗#牛皮靴#凤暖袍#阴阳扇#金钗#长筒靴#锦月袄#凤羽扇#珍珠钗#追云履#凝霜衣#铁爪#虎爪#残青爪#阴风爪#寒冰刺#铜锤#流星锤#八棱锤#亮银锤#乌金锤#混元锤#方巾#布衣#长枪#铁枪#皮帽#虎皮衣#点钢枪#青铜盔#青铜铠#乌金枪#冲天盔#皂罗袍#火焰枪#虎头盔#金锁甲#双头枪#神龙盔#莽龙袍";
        if (zb.contains(str)) {
            return noAppraisal ? 1000 + zb.indexOf(str) : zb.indexOf(str);
        } else {
            String dj_ss = "纹龙佩#温玉玦#血心石#八角晶牌#蟠螭结#青珑挂珠#紫晶坠子#三才项圈#幻彩项链#雪魂丝链#金刚手镯#七星手链#凤舞环#龙鳞手镯#法文手轮";
            if (dj_ss.contains(str)) {
                return 2000 + dj_ss.indexOf(str);
            } else {
                String gj_ss = "七龙珠#金蝉宝囊#通灵宝玉#寒玉龙勾#八宝如意#天机锁链#秘魔灵珠#金碧莲花#流光绝影#五蕴悯光#九天霜华#闭月双环#三清手镯#天星奇光#碎梦涵光";
                if (gj_ss.contains(str)) {
                    return 2200 + gj_ss.indexOf(str);
                } else {
                    String fb = "番天印#定海珠#混元金斗#阴阳镜#金蛟剪#九龙神火罩#卸甲金葫";
                    if (fb.contains(str)) {
                        return 2400 + fb.indexOf(str);
                    } else {
                        String cjhsj = "超级黑水晶";
                        if (str.contains(cjhsj)) {
                            return 2500;
                        } else {
                            String zbdj = "超级黑水晶#混沌玉#超级灵石#超级晶石#超级粉水晶#黄水晶#超级绿水晶#超级圣水晶#超级女娲石#天星石#装备共鸣石";
                            if (zbdj.contains(str)) {
                                return 2600 + zbdj.indexOf(str);
                            } else {
                                String tjmj = "防微杜渐秘笈#拔苗助长秘笈#鞭长莫及秘笈#天生神力秘笈#十万火急秘笈#如意圈秘笈#神龙罩秘笈#乾坤罩秘笈#舍命一击秘笈#漫天血舞秘笈#游说之舌秘笈#死亡缠绵秘笈#神圣之光秘笈#翻转乾坤秘笈";
                                if (tjmj.contains(str)) {
                                    return 2700 + tjmj.indexOf(str);
                                } else {
                                    String cwdj = "超级归元露#宠物强化丹#神兽丹#超级神兽丹#宠物经验丹#驯兽决#高级驯兽决#召唤令·十二生肖#召唤令·上古神兽#点化丹#羽化丹#精怪诱饵#风灵丸#聚灵石#宠物顿悟丹#骑宠灵魄#纪念宠元神";
                                    if (cwdj.contains(str)) {
                                        return 2900 + cwdj.indexOf(str);
                                    } else {
                                        String ts = "天书#魔引#青木#烈炎#狂暴#碎石#惊雷#云体#尽忠#先风#怒击#修罗术#降魔斩#寒冰#反击#破天";
                                        if (ts.contains(str)) {
                                            return 2000 + ts.indexOf(str);
                                        } else {
                                            String ys = "凝香幻彩#炫影霜星#风寂云清#枯月流魂#冰落残阳#雷极弧光";
                                            if (ys.contains(str)) {
                                                return 2100 + ys.indexOf(str);
                                            } else {
                                                String qtdj = "血玲珑#法玲珑#中级血玲珑#中级法玲珑#血玲珑·融合#法玲珑·融合#超级血玲珑#超级法玲珑#无量心经#火眼金睛#超级藏宝图#藏宝图#急急如律令#超级仙风散#宠风散#紫气鸿蒙#天神护佑#修炼卷轴#改头换面卡#神木鼎#通天令牌#通天令牌·融合#藏宝箱#钥匙串#超级洗髓丹#易经洗髓丹#五行合缘露#仙魔散#喇叭#强盗领赏令#九曲玲珑笔";
                                                if (qtdj.contains(str)) {
                                                    return 2200 + qtdj.indexOf(str);
                                                } else {
                                                    String zh = "如意刷道令#银钥匙";
                                                    if (zh.contains(str)) {
                                                        return 2400 + zh.indexOf(str);
                                                    } else {
                                                        String k_end = "卡";
                                                        return str.contains(k_end) ? 2500 : 3000;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
