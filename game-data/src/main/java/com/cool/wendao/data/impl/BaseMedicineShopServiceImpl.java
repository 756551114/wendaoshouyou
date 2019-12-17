package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.MedicineShop;
import com.cool.wendao.community.server.BaseMedicineShopService;
import com.cool.wendao.data.dao.MedicineShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseMedicineShopServiceImpl implements BaseMedicineShopService {

    @Autowired
    private MedicineShopMapper medicineShopMapper;

    @Override
    public List<MedicineShop> findAll() {
        Example example = new Example(MedicineShop.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value());
        return medicineShopMapper.selectByExample(example);
    }

    @Override
    public MedicineShop findOneByGoodsNo(Integer pos) {
        Example example = new Example(MedicineShop.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("goods_no=", pos);
        return medicineShopMapper.selectOneByExample(example);
    }
}
