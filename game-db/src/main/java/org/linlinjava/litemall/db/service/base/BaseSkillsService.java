//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.SkillsMapper;
import org.linlinjava.litemall.db.domain.Skills;
import org.linlinjava.litemall.db.domain.example.SkillsExample;
import org.linlinjava.litemall.db.domain.example.SkillsExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseSkillsService {
    @Autowired
    protected SkillsMapper mapper;

    public BaseSkillsService() {
    }

    @Cacheable(
            cacheNames = {"Skills"},
            key = "#id"
    )
    public Skills findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Skills"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Skills findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Skills skills) {
        skills.setAddTime(LocalDateTime.now());
        skills.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(skills);
    }

    @CachePut(
            cacheNames = {"Skills"},
            key = "#skills.id"
    )
    public int updateById(Skills skills) {
        skills.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(skills);
    }

    @CacheEvict(
            cacheNames = {"Skills"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Skills> findBySkillIdHex(String skillIdHex) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillIdHexEqualTo(skillIdHex);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillName(String skillName) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillReqMenpai(Integer skillReqMenpai) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillReqMenpaiEqualTo(skillReqMenpai);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillType(Integer skillType) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillTypeEqualTo(skillType);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillTypeLevel(Integer skillTypeLevel) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillTypeLevelEqualTo(skillTypeLevel);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillMagic(Integer skillMagic) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMagicEqualTo(skillMagic);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillReqLevel(Integer skillReqLevel) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillReqLevelEqualTo(skillReqLevel);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findBySkillContext(String skillContext) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillContextEqualTo(skillContext);
        return this.mapper.selectByExample(example);
    }

    public Skills findOneBySkillIdHex(String skillIdHex) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillIdHexEqualTo(skillIdHex);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillName(String skillName) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillNameEqualTo(skillName);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillReqMenpai(Integer skillReqMenpai) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillReqMenpaiEqualTo(skillReqMenpai);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillType(Integer skillType) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillTypeEqualTo(skillType);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillTypeLevel(Integer skillTypeLevel) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillTypeLevelEqualTo(skillTypeLevel);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillMagic(Integer skillMagic) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillMagicEqualTo(skillMagic);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillReqLevel(Integer skillReqLevel) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillReqLevelEqualTo(skillReqLevel);
        return this.mapper.selectOneByExample(example);
    }

    public Skills findOneBySkillContext(String skillContext) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSkillContextEqualTo(skillContext);
        return this.mapper.selectOneByExample(example);
    }

    public List<Skills> findAll(int page, int size, String sort, String order) {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Skills> findAll() {
        SkillsExample example = new SkillsExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
