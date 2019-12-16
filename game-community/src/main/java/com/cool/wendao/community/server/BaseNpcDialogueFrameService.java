package com.cool.wendao.community.server;

import com.cool.wendao.community.model.NpcDialogueFrame;

import java.util.List;

public interface BaseNpcDialogueFrameService {
    List<NpcDialogueFrame> findByName(String name);
}
