//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service;

import java.util.List;
import org.linlinjava.litemall.db.domain.SaleGood;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample;
import org.linlinjava.litemall.db.domain.example.SaleGoodExample.Criteria;
import org.linlinjava.litemall.db.service.base.BaseSaleGoodService;
import org.springframework.stereotype.Service;

@Service
public class SaleGoodService extends BaseSaleGoodService {
    public SaleGoodService() {
    }

    public SaleGood findOneByGoodsId(String goodsId) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGoodsIdEqualTo(goodsId);
        return this.mapper.selectOneByExampleWithBLOBs(example);
    }

    public List<SaleGood> findByStr(String str) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andStrEqualTo(str);
        return this.mapper.selectByExampleWithBLOBs(example);
    }

    public List<SaleGood> findByOwnerUuid(String ownerUuid) {
        SaleGoodExample example = new SaleGoodExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwnerUuidEqualTo(ownerUuid);
        return this.mapper.selectByExampleWithBLOBs(example);
    }
}
