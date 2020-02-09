public class CTGTeamReport {

    String teamName;
    int numWins, numLosses;
    double netRtg;
    double eFG, tovRate, orbRate, ftRate;
    double defEFG, defTovRate, defOrbRate, defFtRate;

    public CTGTeamReport(String teamName,
                         int numWins, int numLosses, double netRtg,
                         double eFG, double tovRate, double orbRate, double ftRate,
                         double defEFG, double defTovRate, double defOrbRate, double defFtRate)
    {
        this.teamName = teamName;
        this.numWins = numWins;
        this.numLosses = numLosses;
        this.netRtg = netRtg;
        this.eFG = eFG;
        this.tovRate = tovRate;
        this.orbRate = orbRate;
        this.ftRate = ftRate;
        this.defEFG = defEFG;
        this.defTovRate = defTovRate;
        this.defOrbRate = defOrbRate;
        this.defFtRate = defFtRate;
    }

    public String toCsv() {
        return String.format("%s, %d, %d, %f, %f, %f, %f, %f, %f, %f, %f, %f\n",
                this.teamName,
                this.numWins,
                this.numLosses,
                this.netRtg,
                this.eFG,
                this.tovRate,
                this.orbRate,
                this.ftRate,
                this.defEFG,
                this.defTovRate,
                this.defOrbRate,
                this.defFtRate
        );
    }

    public String getTeamName() {
        return teamName;
    }

}
