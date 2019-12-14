//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.gameserver.game;

import javax.annotation.PostConstruct;
import org.linlinjava.litemall.db.service.CharacterService;
import org.linlinjava.litemall.db.service.SaleGoodService;
import org.linlinjava.litemall.db.service.base.BaseAccountsService;
import org.linlinjava.litemall.db.service.base.BaseCharactersService;
import org.linlinjava.litemall.db.service.base.BaseChargeService;
import org.linlinjava.litemall.db.service.base.BaseChoujiangService;
import org.linlinjava.litemall.db.service.base.BaseCreepsStoreService;
import org.linlinjava.litemall.db.service.base.BaseDaySignPrizeService;
import org.linlinjava.litemall.db.service.base.BaseExperienceService;
import org.linlinjava.litemall.db.service.base.BaseExperienceTreasureService;
import org.linlinjava.litemall.db.service.base.BaseGroceriesShopService;
import org.linlinjava.litemall.db.service.base.BaseMapService;
import org.linlinjava.litemall.db.service.base.BaseMedicineShopService;
import org.linlinjava.litemall.db.service.base.BaseNoticeService;
import org.linlinjava.litemall.db.service.base.BaseNpcDialogueFrameService;
import org.linlinjava.litemall.db.service.base.BaseNpcDialogueService;
import org.linlinjava.litemall.db.service.base.BaseNpcPointService;
import org.linlinjava.litemall.db.service.base.BaseNpcService;
import org.linlinjava.litemall.db.service.base.BasePackModificationService;
import org.linlinjava.litemall.db.service.base.BasePetHelpTypeService;
import org.linlinjava.litemall.db.service.base.BasePetService;
import org.linlinjava.litemall.db.service.base.BaseRenwuMonsterService;
import org.linlinjava.litemall.db.service.base.BaseRenwuService;
import org.linlinjava.litemall.db.service.base.BaseSaleClassifyGoodService;
import org.linlinjava.litemall.db.service.base.BaseSaleGoodService;
import org.linlinjava.litemall.db.service.base.BaseShowTasksService;
import org.linlinjava.litemall.db.service.base.BaseShuxingduiyingService;
import org.linlinjava.litemall.db.service.base.BaseSkillMonsterService;
import org.linlinjava.litemall.db.service.base.BaseStoreGoodsService;
import org.linlinjava.litemall.db.service.base.BaseStoreInfoService;
import org.linlinjava.litemall.db.service.base.BaseZhuangbeiInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GameData {
    public static GameData that;
    @Qualifier("baseCharactersService")
    @Autowired
    public BaseCharactersService baseCharactersService;
    @Qualifier("characterService")
    @Autowired
    public CharacterService characterService;
    @Autowired
    public BasePetService basePetService;
    @Autowired
    public BaseExperienceService baseExperienceService;
    @Autowired
    public BaseStoreInfoService baseStoreInfoService;
    @Autowired
    public BaseZhuangbeiInfoService baseZhuangbeiInfoService;
    @Autowired
    public BaseChoujiangService baseChoujiangService;
    @Autowired
    public BaseShowTasksService baseShowTasksService;
    @Autowired
    public BasePetHelpTypeService basePetHelpTypeService;
    @Autowired
    public BaseDaySignPrizeService baseDaySignPrizeService;
    @Qualifier("baseSaleGoodService")
    @Autowired
    public BaseSaleGoodService baseSaleGoodService;
    @Qualifier("saleGoodService")
    @Autowired
    public SaleGoodService saleGoodService;
    @Autowired
    public BaseNpcService baseNpcService;
    @Autowired
    public BaseMapService baseMapService;
    @Autowired
    public BaseAccountsService baseAccountsService;
    @Autowired
    public BaseNpcPointService baseNpcPointService;
    @Autowired
    public BaseNpcDialogueService baseNpcDialogueService;
    @Autowired
    public BaseNpcDialogueFrameService baseNpcDialogueFrameService;
    @Autowired
    public BaseCreepsStoreService baseCreepsStoreService;
    @Autowired
    public BaseGroceriesShopService baseGroceriesShopService;
    @Autowired
    public BaseMedicineShopService baseMedicineShopService;
    @Autowired
    public BaseSaleClassifyGoodService baseSaleClassifyGoodService;
    @Autowired
    public BaseStoreGoodsService baseStoreGoodsService;
    @Autowired
    public BaseShuxingduiyingService baseShuxingduiyingService;
    @Autowired
    public BasePackModificationService basePackModificationService;
    @Autowired
    public BaseSkillMonsterService baseSkillMonsterService;
    @Autowired
    public BaseRenwuService baseRenwuService;
    @Autowired
    public BaseRenwuMonsterService baseRenwuMonsterService;
    @Autowired
    public BaseExperienceTreasureService baseExperienceTreasureService;
    @Autowired
    public BaseNoticeService baseNoticeService;
    @Autowired
    public BaseChargeService baseChargeService;

    public GameData() {
    }

    @PostConstruct
    public void initAfter() {
        that = this;
    }
}
