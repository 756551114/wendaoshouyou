//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service.base;

import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;
import java.util.List;
import org.linlinjava.litemall.db.dao.NoticeMapper;
import org.linlinjava.litemall.db.domain.Notice;
import org.linlinjava.litemall.db.domain.example.NoticeExample;
import org.linlinjava.litemall.db.domain.example.NoticeExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BaseNoticeService {
    @Autowired
    protected NoticeMapper mapper;

    public BaseNoticeService() {
    }

    @Cacheable(
            cacheNames = {"Notice"},
            key = "#id"
    )
    public Notice findById(int id) {
        return this.mapper.selectByPrimaryKeyWithLogicalDelete(id, false);
    }

    @Cacheable(
            cacheNames = {"Notice"},
            key = "#id",
            condition = "#result.deleted == 0"
    )
    public Notice findByIdContainsDelete(int id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public void add(Notice notice) {
        notice.setAddTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        this.mapper.insertSelective(notice);
    }

    @CachePut(
            cacheNames = {"Notice"},
            key = "#notice.id"
    )
    public int updateById(Notice notice) {
        notice.setUpdateTime(LocalDateTime.now());
        return this.mapper.updateByPrimaryKeySelective(notice);
    }

    @CacheEvict(
            cacheNames = {"Notice"},
            key = "#id"
    )
    public void deleteById(int id) {
        this.mapper.logicalDeleteByPrimaryKey(id);
    }

    public List<Notice> findByMessage(String message) {
        NoticeExample example = new NoticeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMessageEqualTo(message);
        return this.mapper.selectByExample(example);
    }

    public List<Notice> findByTime(Integer time) {
        NoticeExample example = new NoticeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTimeEqualTo(time);
        return this.mapper.selectByExample(example);
    }

    public Notice findOneByMessage(String message) {
        NoticeExample example = new NoticeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andMessageEqualTo(message);
        return this.mapper.selectOneByExample(example);
    }

    public Notice findOneByTime(Integer time) {
        NoticeExample example = new NoticeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andTimeEqualTo(time);
        return this.mapper.selectOneByExample(example);
    }

    public List<Notice> findAll(int page, int size, String sort, String order) {
        NoticeExample example = new NoticeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return this.mapper.selectByExample(example);
    }

    public List<Notice> findAll() {
        NoticeExample example = new NoticeExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        return this.mapper.selectByExample(example);
    }
}
