//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.PetsMapper;
import org.linlinjava.litemall.db.domain.Pets;
import org.linlinjava.litemall.db.domain.example.PetsExample;
import org.linlinjava.litemall.db.domain.example.PetsExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BasePetsService {
    @Autowired
    protected PetsMapper mapper;

    public BasePetsService() {
    }

    @Cacheable(
            cacheNames = {"Pets"},
            key = "#id"
    )
    public Pets findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Pets"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Pets findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Pets pets) {
        pets.setAddTime(LocalDateTime.now());
        pets.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(pets);
    }

    @CachePut(
            cacheNames = {"Pets"},
            key = "#pets.id"
    )
    public int updateById(Pets pets) {
        pets.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(pets);
    }

    @CacheEvict(
            cacheNames = {"Pets"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Pets> findByOwnerid(String ownerid) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwneridEqualTo(ownerid);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByPetid(String petid) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPetidEqualTo(petid);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByNickname(String nickname) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNicknameEqualTo(nickname);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByName(String name) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByHorsetype(Integer horsetype) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andHorsetypeEqualTo(horsetype);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByType(Integer type) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByLevel(Integer level) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByLiliang(Integer liliang) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLiliangEqualTo(liliang);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByMinjie(Integer minjie) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMinjieEqualTo(minjie);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByLingli(Integer lingli) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLingliEqualTo(lingli);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByTili(Integer tili) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTiliEqualTo(tili);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByDianhualx(Integer dianhualx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDianhualxEqualTo(dianhualx);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByDianhuazd(Integer dianhuazd) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDianhuazdEqualTo(dianhuazd);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByDianhuazx(Integer dianhuazx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDianhuazxEqualTo(dianhuazx);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByYuhualx(Integer yuhualx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuhualxEqualTo(yuhualx);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByYuhuazd(Integer yuhuazd) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuhuazdEqualTo(yuhuazd);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByYuhuazx(Integer yuhuazx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuhuazxEqualTo(yuhuazx);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwjyzx(Integer cwjyzx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwjyzxEqualTo(cwjyzx);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwjyzd(Integer cwjyzd) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwjyzdEqualTo(cwjyzd);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByFeisheng(Integer feisheng) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andFeishengEqualTo(feisheng);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByFsudu(Integer fsudu) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andFsuduEqualTo(fsudu);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByQhcwWg(Integer qhcwWg) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQhcwWgEqualTo(qhcwWg);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByQhcwFg(Integer qhcwFg) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQhcwFgEqualTo(qhcwFg);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwXiangxing(Integer cwXiangxing) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwXiangxingEqualTo(cwXiangxing);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwWuxue(Integer cwWuxue) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwWuxueEqualTo(cwWuxue);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwIcon(String cwIcon) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwIconEqualTo(cwIcon);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwXinfa(Integer cwXinfa) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwXinfaEqualTo(cwXinfa);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findByCwQinmi(Integer cwQinmi) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwQinmiEqualTo(cwQinmi);
        return this.mapper.selectByExample(example);
    }

    public Pets findOneByOwnerid(String ownerid) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwneridEqualTo(ownerid);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByPetid(String petid) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPetidEqualTo(petid);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByNickname(String nickname) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNicknameEqualTo(nickname);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByName(String name) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByHorsetype(Integer horsetype) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andHorsetypeEqualTo(horsetype);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByType(Integer type) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTypeEqualTo(type);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByLevel(Integer level) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLevelEqualTo(level);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByLiliang(Integer liliang) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLiliangEqualTo(liliang);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByMinjie(Integer minjie) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMinjieEqualTo(minjie);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByLingli(Integer lingli) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andLingliEqualTo(lingli);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByTili(Integer tili) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTiliEqualTo(tili);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByDianhualx(Integer dianhualx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDianhualxEqualTo(dianhualx);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByDianhuazd(Integer dianhuazd) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDianhuazdEqualTo(dianhuazd);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByDianhuazx(Integer dianhuazx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andDianhuazxEqualTo(dianhuazx);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByYuhualx(Integer yuhualx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuhualxEqualTo(yuhualx);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByYuhuazd(Integer yuhuazd) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuhuazdEqualTo(yuhuazd);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByYuhuazx(Integer yuhuazx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andYuhuazxEqualTo(yuhuazx);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwjyzx(Integer cwjyzx) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwjyzxEqualTo(cwjyzx);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwjyzd(Integer cwjyzd) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwjyzdEqualTo(cwjyzd);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByFeisheng(Integer feisheng) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andFeishengEqualTo(feisheng);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByFsudu(Integer fsudu) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andFsuduEqualTo(fsudu);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByQhcwWg(Integer qhcwWg) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQhcwWgEqualTo(qhcwWg);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByQhcwFg(Integer qhcwFg) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andQhcwFgEqualTo(qhcwFg);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwXiangxing(Integer cwXiangxing) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwXiangxingEqualTo(cwXiangxing);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwWuxue(Integer cwWuxue) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwWuxueEqualTo(cwWuxue);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwIcon(String cwIcon) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwIconEqualTo(cwIcon);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwXinfa(Integer cwXinfa) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwXinfaEqualTo(cwXinfa);
        return this.mapper.selectOneByExample(example);
    }

    public Pets findOneByCwQinmi(Integer cwQinmi) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCwQinmiEqualTo(cwQinmi);
        return this.mapper.selectOneByExample(example);
    }

    public List<Pets> findAll(int page, int size, String sort, String order) {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Pets> findAll() {
        PetsExample example = new PetsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
