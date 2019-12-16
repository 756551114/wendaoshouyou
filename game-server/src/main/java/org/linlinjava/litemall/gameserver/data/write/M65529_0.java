package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_65529_0;
@Service
public class M65529_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_65529_0 object1 = (Vo_65529_0)object;
 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeShort(writeBuf,object1.x);

 GameWriteTool.writeShort(writeBuf,object1.y);

 GameWriteTool.writeShort(writeBuf,object1.dir);

 GameWriteTool.writeInt(writeBuf,object1.icon);

 GameWriteTool.writeInt(writeBuf,object1.weapon_icon);

 GameWriteTool.writeShort(writeBuf,object1.type);

 GameWriteTool.writeInt(writeBuf,object1.sub_type);

 GameWriteTool.writeInt(writeBuf,object1.owner_id);

 GameWriteTool.writeInt(writeBuf,object1.leader_id);

 GameWriteTool.writeString(writeBuf,object1.name);

 GameWriteTool.writeShort(writeBuf,object1.level);

 GameWriteTool.writeString(writeBuf,object1.title);

 GameWriteTool.writeString(writeBuf,object1.family);

 GameWriteTool.writeString(writeBuf,object1.party);

 GameWriteTool.writeInt(writeBuf,object1.status);

 GameWriteTool.writeInt(writeBuf,object1.special_icon);

 GameWriteTool.writeInt(writeBuf,object1.org_icon);

 GameWriteTool.writeInt(writeBuf,object1.suit_icon);

 GameWriteTool.writeInt(writeBuf,object1.suit_light_effect);

 GameWriteTool.writeInt(writeBuf,object1.guard_icon);

 GameWriteTool.writeInt(writeBuf,object1.pet_icon);

 GameWriteTool.writeInt(writeBuf,object1.shadow_icon);

 GameWriteTool.writeInt(writeBuf,object1.shelter_icon);

 GameWriteTool.writeInt(writeBuf,object1.mount_icon);

 GameWriteTool.writeString(writeBuf,object1.alicename);

 GameWriteTool.writeString(writeBuf,object1.gid);

 GameWriteTool.writeString(writeBuf,object1.camp);

 GameWriteTool.writeByte(writeBuf,object1.vip_type);

 GameWriteTool.writeByte(writeBuf,object1.isHide);

 GameWriteTool.writeByte(writeBuf,object1.moveSpeedPercent);

 GameWriteTool.writeInt(writeBuf,object1.score);

 GameWriteTool.writeByte(writeBuf,object1.opacity);

 GameWriteTool.writeInt(writeBuf,object1.masquerade);

 GameWriteTool.writeByte(writeBuf,object1.upgradestate);

 GameWriteTool.writeByte(writeBuf,object1.upgradetype);

 GameWriteTool.writeByte(writeBuf,object1.obstacle);

 GameWriteTool.writeShort(writeBuf,object1.light_effect_count);

 GameWriteTool.writeInt(writeBuf,object1.effect);

 GameWriteTool.writeInt(writeBuf,object1.share_mount_icon);

 GameWriteTool.writeInt(writeBuf,object1.share_mount_leader_id);

 GameWriteTool.writeShort(writeBuf,object1.gather_count);

 GameWriteTool.writeShort(writeBuf,object1.gather_name_num);

 GameWriteTool.writeInt(writeBuf,object1.portrait);

 GameWriteTool.writeString(writeBuf,object1.customIcon);
}@Override
    public int cmd() {
        return 65529;
    }
}

