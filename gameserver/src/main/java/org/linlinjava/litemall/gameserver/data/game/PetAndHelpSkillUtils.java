package org.linlinjava.litemall.gameserver.data.game;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

/**
 * 宠物和技能的操作类
 */
public class PetAndHelpSkillUtils {
    private static String skillJson = null;

    /**
     * 返回技能的最大等级
     *
     * @param attrib 等级
     * @returngetMaxSkill
     */
    public static int getMaxSkill(int attrib) {
        int maxSkill = (int) (attrib * 1.6);
        return maxSkill;
    }


    public static List<JSONObject> getNomelSkills(int pet, int pMetal, int attrib, boolean isMagic) throws JSONException {
        return getNomelSkills(pet, pMetal, attrib, isMagic, "");
    }

    /**
     * * 获得基本普通技能的方法
     * * 获得守护和宝宝的
     * * 天生技能和天书技能通过数据库获取
     *
     * @param pet     1宠物 2守护
     * @param pMetal  金木水火土 12345
     * @param attrib  宠物/守护等级
     * @param isMagic 是否是法攻 true  法攻
     */
    public static List<JSONObject> getNomelSkills(int pet, int pMetal, int attrib, boolean isMagic, String skill_value) throws JSONException {
        if (skillJson == null) {
            BufferedReader br = getResFile();
            StringBuilder strb = new StringBuilder();
            br.lines().forEach((f) -> strb.append(f));
            skillJson = strb.toString();

        }
        JSONArray jsonArray = new JSONArray(skillJson);
        //守护
        //"物伤", "法伤", "障碍", "辅助", "被动"
        //"WS", "FS", "ZA", "FZ", "BD"
        //攻击  辅助  拿人物的技能
        // 取技能 守护的攻击技能是1 19 32 50 100循序领取5个技能
        int[] sh_gj = {1, 19, 32, 50, 100};
        int sh_gj_count = 0;//守护技能个数
        for (int i = sh_gj.length - 1; i >= 0; i--) {
            if (attrib >= sh_gj[i]) {
                sh_gj_count = i + 1;
                break;
            }
        }


        //法攻技能
        List<JSONObject> sh_gj_list = new ArrayList<>();

        // 取技能 守护的辅助技能是1, 1, 1, 50, 100循序领取5个技能
        int[] sh_fz = {1, 1, 1, 50, 100};
        int sh_fz_count = 0;//守护辅助技能个数
        for (int i = sh_fz.length - 1; i >= 0; i--) {
            if (attrib >= sh_fz[i]) {
                sh_fz_count = i + 1;
                break;
            }
        }
        //辅助技能
        List<JSONObject> sh_fz_list = new ArrayList<>();


        //宠物
        // 基本技能 124技能 天书 天生技能需要在数据表中获取
        List<JSONObject> pet_gj_list = new ArrayList<>();
        int[] pet_gj = {20, 40, 60};
        List<Integer> pet_gj_counts = new ArrayList<>();
        for (int i = pet_gj.length - 1; i >= 0; i--) {
            if (attrib >= pet_gj[i]) {
                if (i == 2) {
                    pet_gj_counts.add(1);
                    pet_gj_counts.add(2);
                    pet_gj_counts.add(4);
                } else if (i == 1) {
                    pet_gj_counts.add(1);
                    pet_gj_counts.add(2);
                } else {
                    pet_gj_counts.add(1);
                }
                break;
            }
        }
        if (pet == 2 && (null == skill_value || skill_value.isEmpty())) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                int metal = jsonObject.optInt("metal");
                String skillType = jsonObject.optString("skillType");
                int skillIndex = jsonObject.optInt("skillIndex");
                if (skillType.contentEquals("FS") && pMetal == metal && (pMetal == 1 || pMetal == 2 || pMetal == 3) && skillIndex <= sh_gj_count) {
                    int[] skillNum_round = skillNum(jsonObject, getMaxSkill(attrib));
                    jsonObject.put("skillNum", skillNum_round[0]);
                    jsonObject.put("skillRound", skillNum_round[1]);
                    jsonObject.put("skillLevel", getMaxSkill(attrib));
                    jsonObject.remove("skillUse");
//                    jsonObject.remove("skillRound");
                    jsonObject = appendBP(jsonObject, skillType, skillIndex, attrib);
                    sh_gj_list.add(jsonObject);
                } else if (skillType.contentEquals("WS") && pMetal == metal && (pMetal == 4 || pMetal == 5) && skillIndex <= sh_gj_count) {
                    int[] skillNum_round = skillNum(jsonObject, getMaxSkill(attrib));
                    jsonObject.put("skillNum", skillNum_round[0]);
                    jsonObject.put("skillRound", skillNum_round[1]);
                    jsonObject.put("skillLevel", getMaxSkill(attrib));
                    jsonObject.remove("skillUse");
//                    jsonObject.remove("skillRound");
                    jsonObject = appendBP(jsonObject, skillType, skillIndex, attrib);
                    sh_gj_list.add(jsonObject);
                } else if (skillType.contentEquals("FZ") && pMetal == metal && skillIndex <= sh_fz_count) {
                    int[] skillNum_round = skillNum(jsonObject, getMaxSkill(attrib));
                    jsonObject.put("skillNum", skillNum_round[0]);
                    jsonObject.put("skillRound", skillNum_round[1]);
                    jsonObject.put("skillLevel", getMaxSkill(attrib));
                    jsonObject.remove("skillUse");
//                    jsonObject.remove("skillRound");
                    jsonObject = appendBP(jsonObject, skillType, skillIndex, attrib);
                    sh_fz_list.add(jsonObject);
                }
            }
            sh_gj_list.addAll(sh_fz_list);
            return sh_gj_list;
        } else if (pet == 1 && isMagic && (null == skill_value || skill_value.isEmpty())) {//人物的1 2 4技能
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                int metal = jsonObject.optInt("metal");
                String skillType = jsonObject.optString("skillType");
                int skillIndex = jsonObject.optInt("skillIndex");
                if (pet_gj_counts.contains(skillIndex)) {
                    if (skillType.contentEquals("FS") && pMetal == metal) {
                        int[] skillNum_round = skillNum(jsonObject, getMaxSkill(attrib));
                        jsonObject.put("skillNum", skillNum_round[0]);
                        jsonObject.put("skillRound", skillNum_round[1]);
                        jsonObject.put("skillLevel", getMaxSkill(attrib));
                        jsonObject.remove("skillUse");
                        jsonObject.remove("skillRound");
                        jsonObject = appendBP(jsonObject, skillType, skillIndex, attrib);
                        pet_gj_list.add(jsonObject);
                    }
                }

            }
            return pet_gj_list;
        } else {
            if (null != skill_value && !skill_value.isEmpty()) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.optJSONObject(i);
                    int metal = jsonObject.optInt("metal");
                    String skillType = jsonObject.optString("skillType");
                    int skillIndex = jsonObject.optInt("skillIndex");
                    String skillType_skillIndex = String.format("%s_%d", skillType, skillIndex);
                    if (skill_value.contains(skillType_skillIndex) && pMetal == metal) {
                        int[] skillNum_round = skillNum(jsonObject, getMaxSkill(attrib));
                        jsonObject.put("skillNum", skillNum_round[0]);
                        jsonObject.put("skillRound", skillNum_round[1]);
                        jsonObject.put("skillLevel", getMaxSkill(attrib));
                        jsonObject.remove("skillUse");
                        jsonObject = appendBP(jsonObject, skillType, skillIndex, attrib);
                        if (skillIndex == 5) {//如果有5技能+
                            if (sh_gj_count >= 5) {
                                pet_gj_list.add(jsonObject);
                            }
                        } else {
                            pet_gj_list.add(jsonObject);
                        }
                    }

                }
                return pet_gj_list;
            }
        }

        return sh_gj_list;

    }


    private static JSONObject appendBP(JSONObject jsonObject, String skillType, int skillIndex, int attrib) throws JSONException {
        int[] bp = getBlueAndPoints(skillType, skillIndex, attrib);
        jsonObject.put("skillBlue", bp[0]);
        jsonObject.put("skillPoint", bp[1]);
        return jsonObject;
    }


    /**
     * 获得蓝和潜能点消耗
     * "WS", "FS", "ZA", "FZ", "BD"
     */
    private static int[] getBlueAndPoints(String skillType, int skillIndex, int attrib) {
        int[] bp = {1, 1};
        if (attrib == 1) {
            return bp;
        }
        if (skillType.contentEquals("WS")) {
            bp[0] = (int) (attrib * 17.5);
            bp[1] = attrib * attrib * 60;
        } else {

            Hashtable<String, Double> addHashtable = new Hashtable<>();
            addHashtable.put("FS", 0d);
            addHashtable.put("ZA", 0.3d);
            addHashtable.put("FZ", 0.4d);
            addHashtable.put("BD", 0.5d);
            Double add = addHashtable.get(skillType);
            if (null == add) {
                add = 0d;
            }
            switch (skillIndex) {
                case 1:
                    bp[0] = (int) (attrib * (10.7 + add));
                    bp[1] = (int) (attrib * attrib * (15.7 + add));
                    break;
                case 2:
                    bp[0] = (int) (attrib * (13.5 + add));
                    bp[1] = (int) (attrib * attrib * (14 + add));
                    break;
                case 3:
                    bp[0] = (int) (attrib * (15.5 + add));
                    bp[1] = (int) (attrib * attrib * (22 + add));
                    break;
                case 4:
                    bp[0] = (int) (attrib * (25 + add));
                    bp[1] = (int) (attrib * attrib * (33 + add));
                    break;
                case 5:
                    bp[0] = (int) (attrib * (28 + add));
                    bp[1] = (int) (attrib * attrib * (43 + add));
                    break;

            }

        }

        return bp;
    }


    /**
     * 计算技能当前攻击目标个数
     *
     * @param skillObject
     * @param skill       技能的等级
     */
    public static int[] skillNum(JSONObject skillObject, int skill) {
        JSONArray jsonArray = skillObject.optJSONArray("skillUse");
        JSONArray jsonArrayRound = skillObject.optJSONArray("skillRound");

        int[] num_round = new int[2];
        if (null == jsonArray || jsonArray.length() == 0) {
            num_round[0] = 1;
        }
        if (null == jsonArrayRound || jsonArrayRound.length() == 0) {
            num_round[1] = 1;
        }

        //打几个怪
        if (num_round[0] == 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                int skillLevelMin = jsonObject.optInt("skillLevelMin");
                int skillLevel = jsonObject.optInt("skillLevel");
                int skillNum = jsonObject.optInt("skillNum");
                if (skill >= skillLevelMin && skill <= skillLevel) {
                    num_round[0] = skillNum;
                }

            }
        }
        if (num_round[0] == 0) {
            num_round[0] = 1;
        }


        //持续回合
        if (num_round[1] == 0) {
            for (int i = 0; i < jsonArrayRound.length(); i++) {
                JSONObject jsonObject = jsonArrayRound.optJSONObject(i);
                int skillLevelMin = jsonObject.optInt("skillLevelMin");
                int skillLevel = jsonObject.optInt("skillLevel");
                int skillRound = jsonObject.optInt("skillRound");
                if (skill >= skillLevelMin && skill <= skillLevel) {
                    num_round[1] = skillRound;
                }

            }
        }
        if (num_round[1] == 0) {
            num_round[1] = 1;
        }


        return num_round;
    }


    private static ResourceLoader resourceLoader = new DefaultResourceLoader();
    private static final Logger log = LoggerFactory.getLogger(PetAndHelpSkillUtils.class);

    private static BufferedReader getResFile() {
        Resource resource = resourceLoader.getResource("classpath:static/user_skill.json");
        BufferedReader br = null;
        try {
            final InputStream inputStream = resource.getInputStream();
            InputStreamReader fr = new InputStreamReader(inputStream);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            log.error("", e);
        }
        return br;
    }

    public static JSONObject jsonArray(int skillNo) {
        if (skillJson == null) {
            BufferedReader br = getResFile();
            StringBuilder strb = new StringBuilder();
            br.lines().forEach((f) -> strb.append(f));
            skillJson = strb.toString();

        }
        JSONArray jsonArray = new JSONArray(skillJson);
        String leixing = null;
        int skillIndex = 0;
        String skill_attrib = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            int no = jsonObject.optInt("skillNo");
            if (no == skillNo) {
                leixing = jsonObject.optString("skillType");
                skillIndex = jsonObject.optInt("skillIndex");
                skill_attrib = jsonObject.optString("skill_attrib");
                return jsonObject;
            }
        }
        return null;
    }

    /**
     * 计算技能当前攻击目标个数
     * <p>
     * //     * @param skillObject
     *
     * @param skill 技能的等级
     */
    public int skillNummax(int skillNo, int skill) {
        JSONObject skillObject = jsonArray(skillNo);
        JSONArray jsonArray = skillObject.optJSONArray("skillUse");

        if (null == jsonArray || jsonArray.length() == 0) {
            return 1;
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            int skillLevelMin = jsonObject.optInt("skillLevelMin");
            int skillLevel = jsonObject.optInt("skillLevel");
            int skillNum = jsonObject.optInt("skillNum");
            if (skill >= skillLevelMin && skill <= skillLevel) {
                return skillNum;
            }
        }
        return 1;
    }

    /**
     * 获得蓝和潜能点消耗
     * "WS", "FS", "ZA", "FZ", "BD"
     */
    public int[] getBlueAndPointsLan(int skillNo, int attrib) {
        if (skillJson == null) {
            BufferedReader br = getResFile();
            StringBuilder strb = new StringBuilder();
            br.lines().forEach((f) -> strb.append(f));
            skillJson = strb.toString();
        }
        JSONArray jsonArray = new JSONArray(skillJson);
//        try {
//            areaData = IOUtils.toString(areaRes.getInputStream(), Charset.forName("UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String leixing = null;
        int skillIndex = 0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            int no = jsonObject.optInt("skillNo");
            if (no == skillNo) {
                leixing = jsonObject.optString("skillType");
                skillIndex = jsonObject.optInt("skillIndex");
                break;
            }
        }
        int[] bp = {1, 1};
        if (attrib == 1) {
            return bp;
        }
        if (leixing.contentEquals("WS")) {
            bp[0] = (int) (attrib * 17.5);
            bp[1] = attrib * attrib * 60;
        } else {

            Hashtable<String, Double> addHashtable = new Hashtable<>();
            addHashtable.put("FS", 0d);
            addHashtable.put("ZA", 0.3d);
            addHashtable.put("FZ", 0.4d);
            addHashtable.put("BD", 0.5d);
            Double add = addHashtable.get(leixing);
            if (null == add) {
                add = 0d;
            }
            switch (skillIndex) {
                case 1:
                    bp[0] = (int) (attrib * (10.7 + add));
                    bp[1] = (int) (attrib * attrib * (15.7 + add));
                    break;
                case 2:
                    bp[0] = (int) (attrib * (13.5 + add));
                    bp[1] = (int) (attrib * attrib * (14 + add));
                    break;
                case 3:
                    bp[0] = (int) (attrib * (15.5 + add));
                    bp[1] = (int) (attrib * attrib * (22 + add));
                    break;
                case 4:
                    bp[0] = (int) (attrib * (25 + add));
                    bp[1] = (int) (attrib * attrib * (33 + add));
                    break;
                case 5:
                    bp[0] = (int) (attrib * (28 + add));
                    bp[1] = (int) (attrib * attrib * (43 + add));
                    break;
            }
            if (leixing.contentEquals("BD")) {
                bp[1] = attrib * 70000 + 140000;
            }
        }
        return bp;
    }

}
