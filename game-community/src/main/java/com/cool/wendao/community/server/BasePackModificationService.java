package com.cool.wendao.community.server;

import com.cool.wendao.community.model.PackModification;

public interface BasePackModificationService {
    PackModification findOneByAlias(String itemName);

    PackModification findOneByStr(String str);
}
