package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_45381_0;

@Service
public class M45381_0 extends BaseWrite{
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_45381_0 object1 = (Vo_45381_0) object;
        GameWriteTool.writeInt(writeBuf, object1.start_time);

        GameWriteTool.writeInt(writeBuf, object1.end_time);

        GameWriteTool.writeByte(writeBuf, object1.all_rewards_count);

        GameWriteTool.writeByte(writeBuf, object1.no0);

        GameWriteTool.writeString(writeBuf, object1.name0);

        GameWriteTool.writeString(writeBuf, object1.desc0);

        GameWriteTool.writeByte(writeBuf, object1.level0);

        GameWriteTool.writeByte(writeBuf, object1.no1);

        GameWriteTool.writeString(writeBuf, object1.name1);

        GameWriteTool.writeString(writeBuf, object1.desc1);

        GameWriteTool.writeByte(writeBuf, object1.level1);

        GameWriteTool.writeByte(writeBuf, object1.no2);

        GameWriteTool.writeString(writeBuf, object1.name2);

        GameWriteTool.writeString(writeBuf, object1.desc2);

        GameWriteTool.writeByte(writeBuf, object1.level2);

        GameWriteTool.writeByte(writeBuf, object1.no3);

        GameWriteTool.writeString(writeBuf, object1.name3);

        GameWriteTool.writeString(writeBuf, object1.desc3);

        GameWriteTool.writeByte(writeBuf, object1.level3);

        GameWriteTool.writeByte(writeBuf, object1.no4);

        GameWriteTool.writeString(writeBuf, object1.name4);

        GameWriteTool.writeString(writeBuf, object1.desc4);

        GameWriteTool.writeByte(writeBuf, object1.level4);

        GameWriteTool.writeByte(writeBuf, object1.no5);

        GameWriteTool.writeString(writeBuf, object1.name5);

        GameWriteTool.writeString(writeBuf, object1.desc5);

        GameWriteTool.writeByte(writeBuf, object1.level5);

        GameWriteTool.writeByte(writeBuf, object1.no6);

        GameWriteTool.writeString(writeBuf, object1.name6);

        GameWriteTool.writeString(writeBuf, object1.desc6);

        GameWriteTool.writeByte(writeBuf, object1.level6);

        GameWriteTool.writeByte(writeBuf, object1.no7);

        GameWriteTool.writeString(writeBuf, object1.name7);

        GameWriteTool.writeString(writeBuf, object1.desc7);

        GameWriteTool.writeByte(writeBuf, object1.level7);

        GameWriteTool.writeByte(writeBuf, object1.no8);

        GameWriteTool.writeString(writeBuf, object1.name8);

        GameWriteTool.writeString(writeBuf, object1.desc8);

        GameWriteTool.writeByte(writeBuf, object1.level8);

        GameWriteTool.writeByte(writeBuf, object1.no9);

        GameWriteTool.writeString(writeBuf, object1.name9);

        GameWriteTool.writeString(writeBuf, object1.desc9);

        GameWriteTool.writeByte(writeBuf, object1.level9);

        GameWriteTool.writeByte(writeBuf, object1.no10);

        GameWriteTool.writeString(writeBuf, object1.name10);

        GameWriteTool.writeString(writeBuf, object1.desc10);

        GameWriteTool.writeByte(writeBuf, object1.level10);

        GameWriteTool.writeByte(writeBuf, object1.no11);

        GameWriteTool.writeString(writeBuf, object1.name11);

        GameWriteTool.writeString(writeBuf, object1.desc11);

        GameWriteTool.writeByte(writeBuf, object1.level11);

        GameWriteTool.writeByte(writeBuf, object1.no12);

        GameWriteTool.writeString(writeBuf, object1.name12);

        GameWriteTool.writeString(writeBuf, object1.desc12);

        GameWriteTool.writeByte(writeBuf, object1.level12);

        GameWriteTool.writeByte(writeBuf, object1.no13);

        GameWriteTool.writeString(writeBuf, object1.name13);

        GameWriteTool.writeString(writeBuf, object1.desc13);

        GameWriteTool.writeByte(writeBuf, object1.level13);

        GameWriteTool.writeByte(writeBuf, object1.no14);

        GameWriteTool.writeString(writeBuf, object1.name14);

        GameWriteTool.writeString(writeBuf, object1.desc14);

        GameWriteTool.writeByte(writeBuf, object1.level14);

        GameWriteTool.writeByte(writeBuf, object1.no15);

        GameWriteTool.writeString(writeBuf, object1.name15);

        GameWriteTool.writeString(writeBuf, object1.desc15);

        GameWriteTool.writeByte(writeBuf, object1.level15);

        GameWriteTool.writeByte(writeBuf, object1.no16);

        GameWriteTool.writeString(writeBuf, object1.name16);

        GameWriteTool.writeString(writeBuf, object1.desc16);

        GameWriteTool.writeByte(writeBuf, object1.level16);

        GameWriteTool.writeByte(writeBuf, object1.no17);

        GameWriteTool.writeString(writeBuf, object1.name17);

        GameWriteTool.writeString(writeBuf, object1.desc17);

        GameWriteTool.writeByte(writeBuf, object1.level17);

        GameWriteTool.writeByte(writeBuf, object1.no18);

        GameWriteTool.writeString(writeBuf, object1.name18);

        GameWriteTool.writeString(writeBuf, object1.desc18);

        GameWriteTool.writeByte(writeBuf, object1.level18);

        GameWriteTool.writeByte(writeBuf, object1.no19);

        GameWriteTool.writeString(writeBuf, object1.name19);

        GameWriteTool.writeString(writeBuf, object1.desc19);

        GameWriteTool.writeByte(writeBuf, object1.level19);

        GameWriteTool.writeByte(writeBuf, object1.no20);

        GameWriteTool.writeString(writeBuf, object1.name20);

        GameWriteTool.writeString(writeBuf, object1.desc20);

        GameWriteTool.writeByte(writeBuf, object1.level20);

        GameWriteTool.writeByte(writeBuf, object1.no21);

        GameWriteTool.writeString(writeBuf, object1.name21);

        GameWriteTool.writeString(writeBuf, object1.desc21);

        GameWriteTool.writeByte(writeBuf, object1.level21);

        GameWriteTool.writeByte(writeBuf, object1.no22);

        GameWriteTool.writeString(writeBuf, object1.name22);

        GameWriteTool.writeString(writeBuf, object1.desc22);

        GameWriteTool.writeByte(writeBuf, object1.level22);

        GameWriteTool.writeByte(writeBuf, object1.no23);

        GameWriteTool.writeString(writeBuf, object1.name23);

        GameWriteTool.writeString(writeBuf, object1.desc23);

        GameWriteTool.writeByte(writeBuf, object1.level23);

        GameWriteTool.writeByte(writeBuf, object1.no24);

        GameWriteTool.writeString(writeBuf, object1.name24);

        GameWriteTool.writeString(writeBuf, object1.desc24);

        GameWriteTool.writeByte(writeBuf, object1.level24);

        GameWriteTool.writeByte(writeBuf, object1.no25);

        GameWriteTool.writeString(writeBuf, object1.name25);

        GameWriteTool.writeString(writeBuf, object1.desc25);

        GameWriteTool.writeByte(writeBuf, object1.level25);

        GameWriteTool.writeByte(writeBuf, object1.no26);

        GameWriteTool.writeString(writeBuf, object1.name26);

        GameWriteTool.writeString(writeBuf, object1.desc26);

        GameWriteTool.writeByte(writeBuf, object1.level26);

        GameWriteTool.writeByte(writeBuf, object1.no27);

        GameWriteTool.writeString(writeBuf, object1.name27);

        GameWriteTool.writeString(writeBuf, object1.desc27);

        GameWriteTool.writeByte(writeBuf, object1.level27);

        GameWriteTool.writeByte(writeBuf, object1.no28);

        GameWriteTool.writeString(writeBuf, object1.name28);

        GameWriteTool.writeString(writeBuf, object1.desc28);

        GameWriteTool.writeByte(writeBuf, object1.level28);

        GameWriteTool.writeByte(writeBuf, object1.no29);

        GameWriteTool.writeString(writeBuf, object1.name29);

        GameWriteTool.writeString(writeBuf, object1.desc29);

        GameWriteTool.writeByte(writeBuf, object1.level29);

        GameWriteTool.writeByte(writeBuf, object1.no30);

        GameWriteTool.writeString(writeBuf, object1.name30);

        GameWriteTool.writeString(writeBuf, object1.desc30);

        GameWriteTool.writeByte(writeBuf, object1.level30);

        GameWriteTool.writeByte(writeBuf, object1.no31);

        GameWriteTool.writeString(writeBuf, object1.name31);

        GameWriteTool.writeString(writeBuf, object1.desc31);

        GameWriteTool.writeByte(writeBuf, object1.level31);

        GameWriteTool.writeByte(writeBuf, object1.no32);

        GameWriteTool.writeString(writeBuf, object1.name32);

        GameWriteTool.writeString(writeBuf, object1.desc32);

        GameWriteTool.writeByte(writeBuf, object1.level32);

        GameWriteTool.writeByte(writeBuf, object1.no33);

        GameWriteTool.writeString(writeBuf, object1.name33);

        GameWriteTool.writeString(writeBuf, object1.desc33);

        GameWriteTool.writeByte(writeBuf, object1.level33);

        GameWriteTool.writeByte(writeBuf, object1.no34);

        GameWriteTool.writeString(writeBuf, object1.name34);

        GameWriteTool.writeString(writeBuf, object1.desc34);

        GameWriteTool.writeByte(writeBuf, object1.level34);

        GameWriteTool.writeByte(writeBuf, object1.no35);

        GameWriteTool.writeString(writeBuf, object1.name35);

        GameWriteTool.writeString(writeBuf, object1.desc35);

        GameWriteTool.writeByte(writeBuf, object1.level35);
    }

    @Override
    public int cmd() {
        return 45381;
    }
}




















































































































































