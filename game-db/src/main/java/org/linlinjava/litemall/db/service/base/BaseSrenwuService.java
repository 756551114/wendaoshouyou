//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SrenwuMapper;
import org.linlinjava.litemall.db.domain.Srenwu;
import org.linlinjava.litemall.db.domain.example.SrenwuExample;
import org.linlinjava.litemall.db.domain.example.SrenwuExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSrenwuService {
    @Autowired
    protected SrenwuMapper mapper;

    public BaseSrenwuService() {
    }

    @Cacheable(
            cacheNames = {"Srenwu"},
            key = "#id"
    )
    public Srenwu findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Srenwu"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Srenwu findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Srenwu srenwu) {
        srenwu.setAddTime(LocalDateTime.now());
        srenwu.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(srenwu);
    }

    @CachePut(
            cacheNames = {"Srenwu"},
            key = "#srenwu.id"
    )
    public int updateById(Srenwu srenwu) {
        srenwu.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(srenwu);
    }

    @CacheEvict(
            cacheNames = {"Srenwu"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Srenwu> findByPid(String pid) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
        return this.mapper.selectByExample(example);
    }

    public List<Srenwu> findByRid(Integer rid) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRidEqualTo(rid);
        return this.mapper.selectByExample(example);
    }

    public List<Srenwu> findBySkillName(String skillName) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectByExample(example);
    }

    public List<Srenwu> findBySkillJieshao(String skillJieshao) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillJieshaoEqualTo(skillJieshao);
        return this.mapper.selectByExample(example);
    }

    public List<Srenwu> findBySkillDqti(String skillDqti) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillDqtiEqualTo(skillDqti);
        return this.mapper.selectByExample(example);
    }

    public List<Srenwu> findBySkillXck(String skillXck) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillXckEqualTo(skillXck);
        return this.mapper.selectByExample(example);
    }

    public Srenwu findOneByPid(String pid) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPidEqualTo(pid);
        return this.mapper.selectOneByExample(example);
    }

    public Srenwu findOneByRid(Integer rid) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andRidEqualTo(rid);
        return this.mapper.selectOneByExample(example);
    }

    public Srenwu findOneBySkillName(String skillName) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectOneByExample(example);
    }

    public Srenwu findOneBySkillJieshao(String skillJieshao) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillJieshaoEqualTo(skillJieshao);
        return this.mapper.selectOneByExample(example);
    }

    public Srenwu findOneBySkillDqti(String skillDqti) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillDqtiEqualTo(skillDqti);
        return this.mapper.selectOneByExample(example);
    }

    public Srenwu findOneBySkillXck(String skillXck) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillXckEqualTo(skillXck);
        return this.mapper.selectOneByExample(example);
    }

    public List<Srenwu> findAll(int page, int size, String sort, String order) {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Srenwu> findAll() {
        SrenwuExample example = new SrenwuExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
