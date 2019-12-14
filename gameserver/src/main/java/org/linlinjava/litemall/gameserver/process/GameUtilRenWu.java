package org.linlinjava.litemall.gameserver.process;

import org.linlinjava.litemall.db.domain.Map;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61553_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61661_0;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61671_0;
import org.linlinjava.litemall.gameserver.data.write.M65529_0;
import org.linlinjava.litemall.gameserver.data.write.M61553_0;
import org.linlinjava.litemall.gameserver.data.write.M61671_0;
import org.linlinjava.litemall.gameserver.data.write.M61661_0;
import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.game.GameObjectChar;
import org.linlinjava.litemall.gameserver.game.GameObjectCharMng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class GameUtilRenWu {

    public static void renwukuangkuang(String task_type, String task_prompt, String show_name, Chara chara1) {
        Vo_61553_0 vo_61553_0 = new Vo_61553_0();
        vo_61553_0.count = 1;
        vo_61553_0.task_type = task_type;
        vo_61553_0.task_desc = "";
        vo_61553_0.task_prompt = task_prompt;
        vo_61553_0.refresh = 1;
        vo_61553_0.task_end_time = 1567909190;
        vo_61553_0.attrib = 1;
        vo_61553_0.reward = "#I经验|人物经验宠物经验#I#I道行|道行#I#I潜能|潜能#I#I武学|武学#I#I金钱|金钱#I";
        vo_61553_0.show_name = show_name;
        vo_61553_0.tasktask_extra_para = "";
        vo_61553_0.tasktask_state = "1";
        GameObjectChar.sendduiwu(new M61553_0(), vo_61553_0, chara1.id);
    }

    public static String shidaolevel(Chara chara) {
        if (!GameUtilRenWu.belongCalendarshidao()) {
            return "";
        }
        GameObjectChar session = GameObjectCharMng.getGameObjectChar(chara.id);
        String[] shidaolevel = {"试道场(60-79)", "试道场(80-89)", "试道场(90-99)", "试道场(100-109)", "试道场(110-119)", "试道场(120-129)"};
        String mapname = "";
        if (session.gameTeam != null && session.gameTeam.duiwu != null) {
            //进入人数
            if (session.gameTeam.duiwu.size() < 3) {
                return mapname;
            }
            for (int i = 0; i < session.gameTeam.duiwu.size(); i++) {
                if (session.gameTeam.duiwu.get(i).level < 60) {
                    return mapname;
                } else if (session.gameTeam.duiwu.get(i).level >= 60 && session.gameTeam.duiwu.get(i).level < 80) {
                    if (mapname.equals("")) {
                        mapname = shidaolevel[0];
                    } else {
                        if (!mapname.equals(shidaolevel[0])) {
                            return "";
                        }
                    }
                } else if (session.gameTeam.duiwu.get(i).level >= 80 && session.gameTeam.duiwu.get(i).level < 90) {
                    if (mapname.equals("")) {
                        mapname = shidaolevel[1];
                    } else {
                        if (!mapname.equals(shidaolevel[1])) {
                            return "";
                        }
                    }
                } else if (session.gameTeam.duiwu.get(i).level >= 90 && session.gameTeam.duiwu.get(i).level < 100) {
                    if (mapname.equals("")) {
                        mapname = shidaolevel[2];
                    } else {
                        if (!mapname.equals(shidaolevel[2])) {
                            return "";
                        }
                    }
                } else if (session.gameTeam.duiwu.get(i).level >= 100 && session.gameTeam.duiwu.get(i).level < 110) {
                    if (mapname.equals("")) {
                        mapname = shidaolevel[3];
                    } else {
                        if (!mapname.equals(shidaolevel[3])) {
                            return "";
                        }
                    }
                } else if (session.gameTeam.duiwu.get(i).level >= 110 && session.gameTeam.duiwu.get(i).level < 120) {
                    if (mapname.equals("")) {
                        mapname = shidaolevel[4];
                    } else {
                        if (!mapname.equals(shidaolevel[4])) {
                            return "";
                        }
                    }
                } else if (session.gameTeam.duiwu.get(i).level >= 120 && session.gameTeam.duiwu.get(i).level < 130) {
                    if (mapname.equals("")) {
                        mapname = shidaolevel[5];
                    } else {
                        if (!mapname.equals(shidaolevel[5])) {
                            return "";
                        }
                    }
                }
            }
        } else {
            return mapname;
        }
//        试道场(60-79)
//        试道场(80-89)
//        试道场(90-99)
//        试道场(110-119)
//        试道场(120-129)
        return mapname;
    }

    public static void feiditu(int mapid, Chara chara) {


        if (GameObjectCharMng.getGameObjectChar(chara.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu.size() > 0) {

            for (int i = 0; i < GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu.size(); i++) {
                if (GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu.get(i).id != chara.id) {
                    Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                    vo_61671_0.id = GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu.get(i).id;
                    vo_61671_0.count = 2;
                    vo_61671_0.list.add(2);
                    vo_61671_0.list.add(5);
                    GameObjectCharMng.getGameObjectChar(chara.id).gameMap.send(new M61671_0(), vo_61671_0);
                    vo_61671_0 = new Vo_61671_0();
                    vo_61671_0.id = chara.id;
                    vo_61671_0.count = 2;
                    vo_61671_0.list.add(2);
                    vo_61671_0.list.add(3);
                    GameObjectCharMng.getGameObjectChar(chara.id).gameMap.send(new M61671_0(), vo_61671_0);
                }
            }
        }


        //----------------------------队员飞看任务怪位置
        for (int i = 0; i < chara.npcchubao.size(); i++) {
            if (mapid == chara.npcchubao.get(i).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcchubao.get(i), chara.id);
            }
        }

        for (int i = 0; i < chara.npcshuadao.size(); i++) {
            if (mapid == chara.npcshuadao.get(i).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcshuadao.get(i), chara.id);
            }
        }

        for (int i = 0; i < chara.npcxuanshang.size(); i++) {
            if (mapid == chara.npcxuanshang.get(i).mapid) {
                GameObjectChar.sendduiwu(new M65529_0(), chara.npcxuanshang.get(i), chara.id);
            }
        }




        Vo_61661_0 vo_61661_0 = GameUtil.a61661(chara);
        GameObjectCharMng.getGameObjectChar(chara.id).gameMap.send(new M61661_0(), vo_61661_0);
        if (GameObjectCharMng.getGameObjectChar(chara.id).gameTeam != null && GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu.size() > 0) {
            if (GameObjectCharMng.getGameObjectChar(chara.id).gameTeam.duiwu.get(0).id == chara.id) {
                Vo_61671_0 vo_61671_0 = new Vo_61671_0();
                vo_61671_0.id = chara.id;
                vo_61671_0.count = 2;
                vo_61671_0.list.add(2);
                vo_61671_0.list.add(3);
                GameObjectCharMng.getGameObjectChar(chara.id).gameMap.send(new M61671_0(), vo_61671_0);
            }
        }

        GameUtil.genchongfei(chara);

    }

    /**
     * 高级挖宝
     *
     * @return
     */
    public static String[] luckFindDraw() {

        String nameType = "";
        String[] yiDing = {"帅帅猴#变异", "蛋蛋鸡#变异", "乖乖狗#变异", "招财猪#变异", "岳麓剑#精怪", "筋斗云#精怪"};
        String[] erDing = {"召唤令·十二生肖#物品"};
        String[] siDing = {"60级首饰#首饰"};
        Random random = new Random();
        int r = random.nextInt(1000) + 1;
        if (r <= 3) {
            nameType = yiDing[random.nextInt(yiDing.length)];
        } else if (r < 20) {
            nameType = erDing[random.nextInt(erDing.length)];
        } else {
            if (r < 50) {
                nameType = siDing[random.nextInt(siDing.length)];
            } else {
                int money = 1000000 + random.nextInt(300000);
                nameType = String.format("%d#金币", money);
            }
        }

        return nameType.split("#");

    }

    /*
     * 传入的日期转换成星期几
     */
    public static String dateToWeekday(Date changeDate) {
        String[] weekdays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        if (changeDate == null) {

        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(changeDate);
        int numOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekdays[numOfWeek];
    }

    public static int dayForWeek(String pTime) throws Throwable {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date tmpDate = format.parse(pTime);

        Calendar cal = new GregorianCalendar();

        cal.set(tmpDate.getYear(), tmpDate.getMonth(), tmpDate.getDay());

        return cal.get(Calendar.DAY_OF_WEEK);
    }


    //回城
    public static void huicheng(Chara chara) {
        Map map = GameData.that.baseMapService.findOneByName("天墉城");
        chara.y = map.getY();
        chara.x = map.getX();
        GameLine.getGameMapname(chara.line, map.getName()).join(GameObjectCharMng.getGameObjectChar(chara.id));
    }

    //试道回城
    public static void shidaohuicheng(Chara chara) {
        chara.shidaodaguaijifen = 0;
        huicheng(chara);
    }

    /**
     *      * 判断时间是否在时间段内  世道任务时间段
     *      * @param nowTime
     *      * @param beginTime
     *      * @param endTime
     *      * @return
     *      
     */
    public static boolean belongCalendarshidao() {
        Date nowTime = null;
        Date beginTime = null;
        Date endTime = null;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
//        SimpleDateFormat df = new SimpleDateFormat("mm");
        try {
            nowTime = df.parse(df.format(new Date()));
            beginTime = df.parse("20:49");
            endTime = df.parse("20:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        //设置开始时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
//设置结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
//处于开始时间之后，和结束时间之前的判断
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


}
