package org.linlinjava.litemall.gameserver.data.game;

/**
 * 获得套装效果
 */
public class SuitEffectUtils {

    /**
     * @param sex    0男1女
     * @param attrib 等级
     * @param polar  相性
     * @return
     */
    public static int[] suit(int sex, int attrib,int polar,int eq_polar) {

        int[] suit_light_effects = {7001, 7002, 7003, 7004, 7005};
        int[] effect_suit = new int[2];
        effect_suit[1] = suit_light_effects[eq_polar - 1];
        if (attrib <= 79) {
            int[][] suit_icons = {{860701, 870702, 870703, 860704, 860705}, {870701, 860702, 860703, 870704, 870705}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        } else if (attrib <= 89) {
            int[][] suit_icons = {{860801, 870802, 870803, 860804, 860805}, {870801, 860802, 870803, 860804, 860805}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        } else if (attrib < 99) {
            int[][] suit_icons = {{860901, 870902, 870903, 860904, 860905}, {870901, 860902, 860903, 870904, 870905}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        } else if (attrib < 109) {
            int[][] suit_icons = {{861001, 871002, 871003, 861004, 861005}, {871001, 861002, 861003, 871004, 871005}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        } else if (attrib < 119) {
            int[][] suit_icons = {{861101, 871102, 871103, 861104, 861105}, {871101, 861102, 861103, 871104, 871105}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        } else if (attrib < 129) {
            int[][] suit_icons = {{861201, 871202, 871203, 861204, 861205}, {871201, 861202, 861203, 871204, 871205}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        } else {
            int[][] suit_icons = {{861301, 871302, 871303, 861304, 861305}, {871301, 861302, 861303, 871304, 871305}};
            effect_suit[0] = suit_icons[sex][polar - 1];
        }

        return effect_suit;

    }
}
