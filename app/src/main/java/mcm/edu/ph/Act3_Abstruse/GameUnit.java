package mcm.edu.ph.Act3_Abstruse;

public class GameUnit {

    int level;
    String unitName;
    int baseHP;
    int baseMP;
    int baseArmor;
    int minDPT;
    int maxDPT;

    public GameUnit(){}
    public GameUnit(String unitName, int baseHP, int baseMP, int minDPT, int maxDPT){
        this.unitName = unitName;
        this.baseHP = baseHP;
        this.baseMP = baseMP;
        this.minDPT = minDPT;
        this.maxDPT = maxDPT;
        level = 0;
        baseArmor = 0;

    }
}
