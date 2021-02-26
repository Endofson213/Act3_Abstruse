package mcm.edu.ph.Act3_Abstruse;

public class Hero extends GameUnit {
    int exp;
    double statSTR;
    double statAGI;
    double statINT;

    public Hero() {
    }

    public Hero(String unitName, int baseHP, int baseMP, int minDPT, int maxDPT,
                double statSTR, double statAGI, double statINT) {
        super.unitName = unitName;
        super.baseHP = baseHP;
        super.baseMP = baseMP;
        super.minDPT = minDPT;
        super.maxDPT = maxDPT;
        this.statSTR = statSTR;
        this.statAGI = statAGI;
        this.statINT = statINT;
        super.level =1;
        super.baseArmor = 0;
        this.exp = 0;


    }
}
