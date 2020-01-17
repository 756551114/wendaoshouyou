//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.game;

import com.cool.wendao.community.server.*;
import org.springframework.stereotype.Service;
import com.reger.dubbo.annotation.Inject;

import javax.annotation.PostConstruct;

@Service
public class GameData {
    public static GameData that;

    @Inject
    public BaseCharactersService baseCharactersService;
    @Inject
    public CharacterService characterService;
    @Inject
    public BasePetService basePetService;
    @Inject
    public BaseExperienceService baseExperienceService;
    @Inject
    public BaseStoreInfoService baseStoreInfoService;
    @Inject
    public BaseZhuangbeiInfoService baseZhuangbeiInfoService;
    @Inject
    public BaseChoujiangService baseChoujiangService;
    @Inject
    public BaseShowTasksService baseShowTasksService;
    @Inject
    public BasePetHelpTypeService basePetHelpTypeService;
    @Inject
    public BaseDaySignPrizeService baseDaySignPrizeService;
    @Inject
    public BaseSaleGoodService baseSaleGoodService;
    @Inject
    public SaleGoodService saleGoodService;
    @Inject
    public BaseNpcService baseNpcService;
    @Inject
    public BaseMapService baseMapService;
    @Inject
    public BaseAccountsService baseAccountsService;
    @Inject
    public BaseNpcPointService baseNpcPointService;
    @Inject
    public BaseNpcDialogueService baseNpcDialogueService;
    @Inject
    public BaseNpcDialogueFrameService baseNpcDialogueFrameService;
    @Inject
    public BaseCreepsStoreService baseCreepsStoreService;
    @Inject
    public BaseGroceriesShopService baseGroceriesShopService;
    @Inject
    public BaseMedicineShopService baseMedicineShopService;
    @Inject
    public BaseSaleClassifyGoodService baseSaleClassifyGoodService;
    @Inject
    public BaseStoreGoodsService baseStoreGoodsService;
    @Inject
    public BaseShuxingduiyingService baseShuxingduiyingService;
    @Inject
    public BasePackModificationService basePackModificationService;
    @Inject
    public BaseSkillMonsterService baseSkillMonsterService;
    @Inject
    public BaseRenwuService baseRenwuService;
    @Inject
    public BaseRenwuMonsterService baseRenwuMonsterService;
    @Inject
    public BaseExperienceTreasureService baseExperienceTreasureService;
    @Inject
    public BaseNoticeService baseNoticeService;
    @Inject
    public BaseChargeService baseChargeService;
    @Inject
    public BaseVipAddService baseVipAddService;

    @Inject
    public BlackListService blackListService;

    public GameData() {
    }

    @PostConstruct
    public void initAfter() {
        that = this;
    }
}
