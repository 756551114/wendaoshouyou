package com.cool.wendao.data.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cool.wendao.community.core.Deleted;
import com.cool.wendao.community.model.NpcDialogueFrame;
import com.cool.wendao.community.server.BaseNpcDialogueFrameService;
import com.cool.wendao.data.dao.NpcDialogueFrameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BaseNpcDialogueFrameServiceImpl implements BaseNpcDialogueFrameService {
    @Autowired
    private NpcDialogueFrameMapper npcDialogueFrameMapper;


    @Override
    public List<NpcDialogueFrame> findByName(String name) {
        Example example = new Example(NpcDialogueFrame.class);
        example.createCriteria().andCondition("deleted=", Deleted.NOT_DELETED.value()).andCondition("name=",name);
        return npcDialogueFrameMapper.selectByExample(example);
    }
}
