package com.cool.wendao.community.server;

import com.cool.wendao.community.model.PetHelpType;

public interface BasePetHelpTypeService {
    PetHelpType findOneByName(String name);
}
