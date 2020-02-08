public class TeamReport {

    String teamName;
    int numWins, numLosses;
    double netRtg;
    double eFG, tovRate, orbRate, ftRate;
    double defEFG, defTovRate, defOrbRate, defFtRate;

    public TeamReport(String teamName,
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

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public int getNumLosses() {
        return numLosses;
    }

    public void setNumLosses(int numLosses) {
        this.numLosses = numLosses;
    }

    public double getNetRtg() {
        return netRtg;
    }

    public void setNetRtg(double netRtg) {
        this.netRtg = netRtg;
    }

    public double geteFG() {
        return eFG;
    }

    public void seteFG(double eFG) {
        this.eFG = eFG;
    }

    public double getTovRate() {
        return tovRate;
    }

    public void setTovRate(double tovRate) {
        this.tovRate = tovRate;
    }

    public double getOrbRate() {
        return orbRate;
    }

    public void setOrbRate(double orbRate) {
        this.orbRate = orbRate;
    }

    public double getFtRate() {
        return ftRate;
    }

    public void setFtRate(double ftRate) {
        this.ftRate = ftRate;
    }

    public double getDefEFG() {
        return defEFG;
    }

    public void setDefEFG(double defEFG) {
        this.defEFG = defEFG;
    }

    public double getDefTovRate() {
        return defTovRate;
    }

    public void setDefTovRate(double defTovRate) {
        this.defTovRate = defTovRate;
    }

    public double getDefOrbRate() {
        return defOrbRate;
    }

    public void setDefOrbRate(double defOrbRate) {
        this.defOrbRate = defOrbRate;
    }

    public double getDefFtRate() {
        return defFtRate;
    }

    public void setDefFtRate(double defFtRate) {
        this.defFtRate = defFtRate;
    }
}
