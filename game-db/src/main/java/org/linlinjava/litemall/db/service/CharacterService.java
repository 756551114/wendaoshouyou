//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.linlinjava.litemall.db.service;

import java.util.List;
import org.linlinjava.litemall.db.domain.Characters;
import org.linlinjava.litemall.db.domain.example.CharactersExample;
import org.linlinjava.litemall.db.domain.example.CharactersExample.Criteria;
import org.linlinjava.litemall.db.service.base.BaseCharactersService;
import org.springframework.stereotype.Service;

@Service
public class CharacterService extends BaseCharactersService {
    public CharacterService() {
    }

    public Characters findOneByName(String name) {
        CharactersExample example = new CharactersExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andNameEqualTo(name);
        return this.mapper.selectOneByExampleWithBLOBs(example);
    }

    public List<Characters> findByAccountId(Integer accountId) {
        CharactersExample example = new CharactersExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andAccountIdEqualTo(accountId);
        return this.mapper.selectByExampleWithBLOBs(example);
    }

    public Characters findOneByID(int id) {
        CharactersExample example = new CharactersExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andIdEqualTo(id);
        return this.mapper.selectOneByExampleWithBLOBs(example);
    }

    public Characters finOnByGiD(String gid) {
        CharactersExample example = new CharactersExample();
        Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andGidEqualTo(gid);
        return this.mapper.selectOneByExampleWithBLOBs(example);
    }
}
