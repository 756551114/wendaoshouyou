package org.linlinjava.litemall.gameserver.data.write;

import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.db.domain.Npc;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;


@Service
public class M65529_npc extends BaseWrite{
 @Override
 protected void writeO(ByteBuf writeBuf,Object object) {
  Npc npc = (Npc) object;

  GameWriteTool.writeInt(writeBuf, npc.getId());

  GameWriteTool.writeShort(writeBuf, npc.getX());

  GameWriteTool.writeShort(writeBuf, npc.getY());

  GameWriteTool.writeShort(writeBuf, 7);

  GameWriteTool.writeInt(writeBuf, npc.getIcon());

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeShort(writeBuf, 4);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeString(writeBuf, npc.getName());

  GameWriteTool.writeShort(writeBuf, 0);

  GameWriteTool.writeString(writeBuf, "");

  GameWriteTool.writeString(writeBuf, "");

  GameWriteTool.writeString(writeBuf, "");

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, npc.getIcon());

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeString(writeBuf, "");

  GameWriteTool.writeString(writeBuf, "");

  GameWriteTool.writeString(writeBuf, "");

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeInt(writeBuf, 0);

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeByte(writeBuf, 0);

  GameWriteTool.writeShort(writeBuf, 0);


 }@Override
 public int cmd() {
  return 65529;
 }
}






































