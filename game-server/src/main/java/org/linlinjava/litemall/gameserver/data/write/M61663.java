package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.game.GameLine;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.util.DesUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class M61663 extends BaseWrite{
    @Value("${netty.ip}")
    private String ip;
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<GameLine> gameLines= (List<GameLine>) object;
        GameWriteTool.writeShort(writeBuf,gameLines.size());
        for (GameLine gameLine : gameLines) {
            GameWriteTool.writeShort(writeBuf,gameLine.lineNum);
            GameWriteTool.writeString(writeBuf,gameLine.lineName);
            GameWriteTool.writeString(writeBuf, ip);
            GameWriteTool.writeShort(writeBuf,3);
        }
    }

    @Override
    public int cmd() {
        return 61663;
    }
}



