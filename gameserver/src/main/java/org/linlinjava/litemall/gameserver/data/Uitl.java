//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.data;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Uitl {
    public static Map data = new HashMap();
    public static String[] arr = new String[]{"name", "str", "phy_power", "accurate", "con", "life", "max_life", "def", "wiz", "mag_power", "mana", "max_mana", "dex", "speed", "parry", "attrib_point", "polar_point", "stamina", "max_stamina", "tao", "friend", "nil", "total_pk", "degree", "exp", "pot", "cash", "balance", "gender", "master", "level", "skill", "party/name", "party/contrib", "nick", "title", "nice", "reputation", "couple", "icon", "type", "durability", "max_durability", "polar", "metal", "wood", "water", "fire", "earth", "resist_metal", "resist_wood", "resist_water", "resist_fire", "resist_earth", "exp_to_next_level", "resist_poison", "resist_frozen", "resist_sleep", "resist_forgotten", "resist_confusion", "longevity", "martial", "intimacy", "shape", "resist_point", "loyalty", "double_hit", "stunt", "counter_attack", "life_recover", "mana_recover", "life_recover_rate", "mana_recover_rate", "item_type", "total_score", "nil", "counter_attack_rate", "double_hit_rate", "stunt_rate", "damage_sel", "family", "req_str", "total_died", "item_unique", "damage_sel_rate", "portrait", "passive_mode", "static_mode", "source", "signature", "character/harmony", "character/kindness", "character/carefulness", "character/courage", "character/desc", "party/desc", "party/job", "family_title", "party/title", "apprentice_title", "req_con", "req_wiz", "req_dex", "pet_life_shape", "pet_mana_shape", "pet_speed_shape", "pet_phy_shape", "pet_mag_shape", "rank", "penetrate", "nil", "nil", "nil", "nil", "nil", "special_icon", "penetrate_rate", "nimbus", "silver_coin", "gold_coin", "extra_life", "extra_mana", "have_coin_pwd", "max_cash", "max_balance", "ignore_resist_metal", "ignore_resist_wood", "ignore_resist_water", "ignore_resist_fire", "ignore_resist_earth", "ignore_resist_forgotten", "ignore_resist_poison", "ignore_resist_frozen", "ignore_resist_sleep", "ignore_resist_confusion", "super_excluse_metal", "super_excluse_wood", "super_excluse_water", "super_excluse_fire", "super_excluse_earth", "B_skill_low_cost", "C_skill_low_cost", "D_skill_low_cost", "super_poison", "super_sleep", "super_forgotten", "super_confusion", "super_frozen", "enhanced_metal", "enhanced_wood", "enhanced_water", "enhanced_fire", "enhanced_earth", "mag_dodge", "jinguang-zhaxian_counter_att_rate", "zhaiye-feihua_counter_att_rate", "dishui-chuanshi_counter_att_rate", "juhuo-fentian_counter_att_rate", "luotu-feiyan_counter_att_rate", "metal_mag_power", "wood_mag_power", "water_mag_power", "fire_mag_power", "earth_mag_power", "card_level", "max_card_amount", "card_amount", "ignore_all_resist_polar", "ignore_all_resist_except", "release_forgotten", "release_poison", "release_frozen", "release_sleep", "release_confusion", "tao_ex", "owner_name", "nil", "backup_loyalty", "use_skill_d", "max_degree", "cost_num", "con_max", "str_max", "wiz_max", "dex_max", "con_add", "str_add", "wiz_add", "dex_add", "practice_times", "double_points", "enable_double_points", "can_buy_dp_times", "online", "arena_rank", "party_name", "unidentified", "degree_32", "store_exp", "equip_identify", "desc", "equip_type", "amount", "owner_id", "req_level", "attrib", "value", "rebuild_level", "color", "quality", "use_times", "max_use_times", "carpet_radius", "equip_page", "max_req_level", "create_time", "ct_data/score", "ct_data/top_rank", "real_desc", "all_attrib", "all_polar", "all_resist_polar", "all_resist_except", "all_skill", "mstunt_rate", "nil", "nil", "nil", "nil", "skill_develop/exp", "skill_develop/intimacy", "life_effect", "mana_effect", "attack_effect", "speed_effect", "phy_effect", "mag_effect", "phy_absorb", "mag_absorb", "add_max_life", "add_max_mana", "add_user_level", "add_random_skill", "double_time", "add_pet_level", "pet_ahead_skill", "pet_longevity", "upgrade_type", "add_pet_exp", "house/id", "house/house_class", "plant_level", "plant_exp", "nil", "nil", "nil", "nil", "nil", "nil", "to_be_deleted", "locked", "pet_upgraded", "left_time_to_delete", "extra_desc", "phy_rebuild_level", "mag_rebuild_level", "raw_name", "suit_polar", "suit_enabled", "gift", "recognize/recognized", "party_stage_party_name", "party_stage_passed_count", "party_stage_cost_time", "party_stage_member_name", "prop2_color", "wrestle/score", "wrestle_score", "def_effect", "combat_guard", "nil", "combined", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "weapon_icon", "suit_icon", "org_icon", "tao_effect", "mount_type", "suit_light_effect", "suit_polar_preview", "nil", "nil", "nil", "signature", "insider_time", "user_state", "auto_reply", "friend_image", "gid", "iid_str", "auto_fight", "free_rename", "voucher", "use_money_type", "lock_exp", "shuadao/jiji-rulvling", "fetch_nice", "recharge", "extra_life_effect", "extra_mana_effect", "extra_mag_effect", "extra_phy_effect", "extra_speed_effect", "morph_life_times", "morph_mana_times", "morph_speed_times", "morph_phy_times", "morph_mag_times", "morph_life_stat", "morph_mana_stat", "morph_speed_stat", "morph_phy_stat", "morph_mag_stat", "free_unlock_exp_times", "nil", "nil", "week_act", "comeback_flag", "placed_amount", "achieve", "achieve_name", "achieve_time", "nil", "upgrade/state", "upgrade/type", "upgrade/level", "upgrade/exp", "upgrade/exp_to_next_level", "upgrade/max_polar_extra", "upgrade_level", "has_upgraded", "limit_use_time", "fasion_type", "food_num", "max_food_num", "house_id", "comfort", "couple_name", "house_type", "sub_type", "couple_gid", "exp_ware_data/unlock_time", "exp_ware_data/lock_time", "exp_ware_data/exp_ware", "exp_ware_data/fetch_times", "exp_ware_data/today_fetch_times", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "enhanced_phy", "ignore_mag_dodge", "nil", "nil", "nil", "popular", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "trading_goods_gid", "trading_state", "trading_left_time", "trading_price", "trading_org_price", "trading_cg_price_ti", "trading_cg_price_ct", "char_online_state", "trading_sell_buy_type", "trading_appointee_name", "trading_buyout_price", "dan_data/state", "dan_data/stage", "dan_data/exp", "dan_data/exp_to_next_level", "dan_data/attrib_point", "dan_data/polar_point", "not_check_bw", "has_break_lv_limit", "dan_data/today_exp", "soul_state", "horn_name", "jewelry_essence", "transform_num", "transform_cool_ti", "marriage_start_time", "book_id", "fasion_custom_disable", "fasion_effect_disable", "marriage/book_id", "strengthen_jewelry_num", "strengthen_level", "strengthen_exp", "strengthen_degree", "mon_tao", "mon_tao_ex", "last_mon_tao", "last_mon_tao_ex", "mon_martial", "last_mon_martial", "mon_tao_rank", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "phy_rebuild_rate", "mag_rebuild_rate", "life_add_temp", "mana_add_temp", "phy_power_add_temp", "mag_power_add_temp", "speed_add_temp", "def_add_temp", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "phy_rebuild_add", "mag_rebuild_add", "pet_life_shape_temp", "pet_mana_shape_temp", "pet_speed_shape_temp", "pet_phy_shape_temp", "pet_mag_shape_temp", "evolve_degree", "power", "skill_low_cost", "rebuild_degree", "time", "effect_foot", "fight_score", "recv_gid", "suit_level", "suit_degree", "status_poison", "status_sleep", "status_forgotten", "status_frozen", "status_confusion", "status_joint_attack", "status_revive", "status_stunt", "status_double_hit", "status_damage_sel", "status_counter_attack", "status_protected", "status_speed", "status_phy_power", "status_defense", "status_max_life", "status_dodge", "status_def", "status_recover_life", "status_metal", "status_wood", "status_water", "status_fire", "status_earth", "status_leech_phy_damage", "status_leech_mag_damage", "status_passive_attack", "status_deadly_kiss", "status_loyalty", "status_immune_phy_damage", "status_immune_mag_damage", "status_polar_changed", "status_fanzhuan_qiankun", "status_mana_shield", "status_passive_mag_attack", "status_add_life_by_mana", "combat_guard_index", "salary", "party", "population", "party_war_win", "level_up_time", "higest_xiangy", "higest_chub", "higest_fum", "higest_tongtt", "higest_yasby", "tontt_layer", "money", "tao_rank", "nil", "lottery_times", "shadow_self", "enchant", "enchant_nimbus", "max_enchant_nimbus", "card_type", "effect_time", "shenmu_points", "enable_shenmu_points", "gift_key", "expired_time", "evolve", "insider_level", "evolve_level", "mailing_item_times", "mount_attrib/end_time", "mount_attrib/move_speed", "capacity_level", "hide_mount", "deadline", "merge_rate", "equip_perfect_percent", "dunwu_times", "dunwu_rate", "pet_anger", "status_huanbing_zhiji", "status_aitong_yujue", "status_shushou_jiuqin", "status_wenfeng_sangdan", "status_yangjing_xurui", "status_xuwu", "item_polar", "shuadao/ziqihongmeng", "extra_skill", "extra_skill_level", "diandqk_frozen_round", "status_chaofeng", "status_diandao_qiankun", "status_jingangquan", "status_qinmi_wujian", "status_tianyan", "status_wuji_bifan", "status_show_opponent_life", "status_add_life_by_mana_add", "status_recover_life_add", "status_def_add", "status_phy_power_add", "status_mag_power_add", "status_speed_add", "brother/appellation", "shuadao/ruyi_point", "chushi_ex", "phy_power_without_intimacy", "mag_power_without_intimacy", "def_without_intimacy", "origin_intimacy", "douchong_rank", "upgrade_immortal", "upgrade_magic", "upgrade/total", "artifact_upgraded_enabled", "status_qisha_yin", "status_qisha_yang", "eclosion", "eclosion_nimbus", "max_eclosion_nimbus", "status_all_resist_except_add", "eclosion_stage", "status_yanchuan_shenjiao", "boss_anger", "higest_score", "party/id", "status_daofa_wubian", "obtain_time", "effect_waist", "effect_head", "status_weiya", "status_weiya_count", "graphic_instruction_mark", "status_diliebo_flag", "part_index", "part_color_index", "npc_chat", "follow_pet_type", "dye_icon", "fasion_id", "fasion_visible", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "nil", "shidao-dahui", "higest_feixdx", "open_state"};

    public Uitl() {
    }

    public static String scale(String arr) {
        long dec_num = Long.parseLong(arr, 16);
        return String.valueOf(dec_num);
    }

    public static boolean add(String arr) {
        data.put("d097", "53399");
        data.put("d111", "53521");
        data.put("811f", "33055");
        data.put("121e", "4638-");
        data.put("1fc3", "8131");
        data.put("3fff", "16383");
        data.put("fff7", "65527");
        String arr1 = (String)data.get(arr);
        return arr1 != null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String scale10 = "fff7";
        System.out.println(add(scale10));
        scale10 = scale(scale10);
        System.out.println(scale10);
        Str();
    }

    public static void Str() throws UnsupportedEncodingException {
        String value = String.valueOf("2359323031392d30372d30342031353a30");
        byte[] bytes = hexToByteArray(value);
        System.out.println(new String(bytes, "GBK"));

        for(int i = 0; i < bytes.length; ++i) {
            byte aByte = bytes[i];
            System.out.print(aByte + " ");
        }

    }

    public static byte[] hexToByteArray(String inHex) {
        int hexlen = inHex.length();
        byte[] result;
        if (hexlen % 2 == 1) {
            ++hexlen;
            result = new byte[hexlen / 2];
            inHex = "0" + inHex;
        } else {
            result = new byte[hexlen / 2];
        }

        int j = 0;

        for(int i = 0; i < hexlen; i += 2) {
            result[j] = hexToByte(inHex.substring(i, i + 2));
            ++j;
        }

        return result;
    }

    public static byte hexToByte(String inHex) {
        return (byte)Integer.parseInt(inHex, 16);
    }

    public static HashMap<Object, Object> kv() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap();
        objectObjectHashMap.put("3014", "police_kill_num");
        objectObjectHashMap.put("3013", "bully_kill_num");
        objectObjectHashMap.put("3012", "server_name");
        objectObjectHashMap.put("3011", "setting/refuse_be_add_level");
        objectObjectHashMap.put("3010", "setting/auto_reply_msg");
        objectObjectHashMap.put("3009", "setting/refuse_stranger_level");
        objectObjectHashMap.put("3004", "group_id");
        objectObjectHashMap.put("3001", "alias");
        objectObjectHashMap.put("3002", "shuadao/chongfeng-san");
        objectObjectHashMap.put("3000", "marriage/marry_id");
        objectObjectHashMap.put("3008", "announcement");
        objectObjectHashMap.put("3005", "leader_gid");
        objectObjectHashMap.put("3006", "member_gid");
        objectObjectHashMap.put("3003", "group_name");
        objectObjectHashMap.put("3007", "setting");
        objectObjectHashMap.put("3017", "gm_attribs/max_mana");
        objectObjectHashMap.put("3018", "gm_attribs/phy_power");
        objectObjectHashMap.put("3024", "chat_floor");
        objectObjectHashMap.put("3020", "gm_attribs/def");
        objectObjectHashMap.put("3015", "show_sandglass");
        objectObjectHashMap.put("3016", "gm_attribs/max_life");
        objectObjectHashMap.put("3021", "gm_attribs/speed");
        objectObjectHashMap.put("3022", "marriage/couple_gid");
        objectObjectHashMap.put("3023", "chat_head");
        objectObjectHashMap.put("3019", "gm_attribs/mag_power");
        objectObjectHashMap.put("3025", "dist_name");
        return objectObjectHashMap;
    }
}
