//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SkillsChongwMapper;
import org.linlinjava.litemall.db.domain.SkillsChongw;
import org.linlinjava.litemall.db.domain.example.SkillsChongwExample;
import org.linlinjava.litemall.db.domain.example.SkillsChongwExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSkillsChongwService {
    @Autowired
    protected SkillsChongwMapper mapper;

    public BaseSkillsChongwService() {
    }

    @Cacheable(
            cacheNames = {"SkillsChongw"},
            key = "#id"
    )
    public SkillsChongw findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"SkillsChongw"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public SkillsChongw findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(SkillsChongw skillsChongw) {
        skillsChongw.setAddTime(LocalDateTime.now());
        skillsChongw.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(skillsChongw);
    }

    @CachePut(
            cacheNames = {"SkillsChongw"},
            key = "#skillsChongw.id"
    )
    public int updateById(SkillsChongw skillsChongw) {
        skillsChongw.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(skillsChongw);
    }

    @CacheEvict(
            cacheNames = {"SkillsChongw"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<SkillsChongw> findByOwnerid(String ownerid) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwneridEqualTo(ownerid);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findBySkllCwid(String skllCwid) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkllCwidEqualTo(skllCwid);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findBySkillIdHex(String skillIdHex) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillIdHexEqualTo(skillIdHex);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findBySkillName(String skillName) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findBySkillReqMenpai(Integer skillReqMenpai) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillReqMenpaiEqualTo(skillReqMenpai);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findBySkillLevel(Integer skillLevel) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findBySkillMubiao(Integer skillMubiao) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findByTianshuId(String tianshuId) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTianshuIdEqualTo(tianshuId);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findByTianshuName(String tianshuName) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTianshuNameEqualTo(tianshuName);
        return this.mapper.selectByExample(example);
    }

    public SkillsChongw findOneByOwnerid(String ownerid) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andOwneridEqualTo(ownerid);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneBySkllCwid(String skllCwid) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkllCwidEqualTo(skllCwid);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneBySkillIdHex(String skillIdHex) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillIdHexEqualTo(skillIdHex);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneBySkillName(String skillName) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneBySkillReqMenpai(Integer skillReqMenpai) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillReqMenpaiEqualTo(skillReqMenpai);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneBySkillLevel(Integer skillLevel) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillLevelEqualTo(skillLevel);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneBySkillMubiao(Integer skillMubiao) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMubiaoEqualTo(skillMubiao);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneByTianshuId(String tianshuId) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTianshuIdEqualTo(tianshuId);
        return this.mapper.selectOneByExample(example);
    }

    public SkillsChongw findOneByTianshuName(String tianshuName) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTianshuNameEqualTo(tianshuName);
        return this.mapper.selectOneByExample(example);
    }

    public List<SkillsChongw> findAll(int page, int size, String sort, String order) {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<SkillsChongw> findAll() {
        SkillsChongwExample example = new SkillsChongwExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
