package mcm.edu.ph.Act3_Abstruse;

public class Monster extends GameUnit {
    public Monster() {
    }

    public Monster(String unitName, int baseHP, int minDPT, int maxDPT) {
        super.unitName = unitName;
        super.baseHP = baseHP;
        super.minDPT = minDPT;
        super.maxDPT = maxDPT;
        super.level =1;
        super.baseArmor = 0;


    }
}
