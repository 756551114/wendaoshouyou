//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.NpcDialogueFrameMapper;
import org.linlinjava.litemall.db.domain.NpcDialogueFrame;
import org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample;
import org.linlinjava.litemall.db.domain.example.NpcDialogueFrameExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseNpcDialogueFrameService {
    @Autowired
    protected NpcDialogueFrameMapper mapper;

    public BaseNpcDialogueFrameService() {
    }

    @Cacheable(
            cacheNames = {"NpcDialogueFrame"},
            key = "#id"
    )
    public NpcDialogueFrame findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"NpcDialogueFrame"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public NpcDialogueFrame findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(NpcDialogueFrame npcDialogueFrame) {
        npcDialogueFrame.setAddTime(LocalDateTime.now());
        npcDialogueFrame.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(npcDialogueFrame);
    }

    @CachePut(
            cacheNames = {"NpcDialogueFrame"},
            key = "#npcDialogueFrame.id"
    )
    public int updateById(NpcDialogueFrame npcDialogueFrame) {
        npcDialogueFrame.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(npcDialogueFrame);
    }

    @CacheEvict(
            cacheNames = {"NpcDialogueFrame"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<NpcDialogueFrame> findByPortrait(Integer portrait) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPortraitEqualTo(portrait);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByPicNo(Integer picNo) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPicNoEqualTo(picNo);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByContent(String content) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andContentEqualTo(content);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findBySecretKey(String secretKey) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSecretKeyEqualTo(secretKey);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByName(String name) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByAttrib(Integer attrib) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByUpdateTimes(LocalDateTime updateTimes) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andUpdateTimesEqualTo(updateTimes);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByIdname(Integer idname) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdnameEqualTo(idname);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByNext(String next) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNextEqualTo(next);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByCurrentTask(String currentTask) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByUncontent(String uncontent) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByZhuangbei(String zhuangbei) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andZhuangbeiEqualTo(zhuangbei);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByJingyan(Integer jingyan) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andJingyanEqualTo(jingyan);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findByMoney(Integer money) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
        return this.mapper.selectByExample(example);
    }

    public NpcDialogueFrame findOneByPortrait(Integer portrait) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPortraitEqualTo(portrait);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByPicNo(Integer picNo) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andPicNoEqualTo(picNo);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByContent(String content) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andContentEqualTo(content);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneBySecretKey(String secretKey) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andSecretKeyEqualTo(secretKey);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByName(String name) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByAttrib(Integer attrib) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAttribEqualTo(attrib);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByUpdateTimes(LocalDateTime updateTimes) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andUpdateTimesEqualTo(updateTimes);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByIdname(Integer idname) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdnameEqualTo(idname);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByNext(String next) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNextEqualTo(next);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByCurrentTask(String currentTask) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andCurrentTaskEqualTo(currentTask);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByUncontent(String uncontent) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andUncontentEqualTo(uncontent);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByZhuangbei(String zhuangbei) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andZhuangbeiEqualTo(zhuangbei);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByJingyan(Integer jingyan) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andJingyanEqualTo(jingyan);
        return this.mapper.selectOneByExample(example);
    }

    public NpcDialogueFrame findOneByMoney(Integer money) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMoneyEqualTo(money);
        return this.mapper.selectOneByExample(example);
    }

    public List<NpcDialogueFrame> findAll(int page, int size, String sort, String order) {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<NpcDialogueFrame> findAll() {
        NpcDialogueFrameExample example = new NpcDialogueFrameExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
