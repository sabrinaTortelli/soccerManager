package br.univali.tortelli.team;

import br.univali.tortelli.players.PlayersType;
import br.univali.tortelli.players.SoccerPlayer;
import br.univali.tortelli.validator.Validator;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Classe que manipula os times
 */
public class Team {
    ArrayList<SoccerPlayer> soccerTeam;
    private final String name;
    private BigDecimal skillTeams;
    private int totalGoalTeam;
    private int totalPoints;
    private int totalVictory;
    private int totalTie;
    private TeamsType teamsType;
    private int goalTeam1;
    private int goalTeam2;

    /**
     * Construtor de times
     * @param name nome do time
     */
    public Team(String name){
        Validator validator = new Validator();
        validator.validateName(name);
        this.name = name;
    }

    /**
     * Seta o gol do time 1
     * @param goalTeam1 gol do time 1
     */
    public void setGoalTeam1(int goalTeam1) {
        this.goalTeam1 = goalTeam1;
    }

    /**
     * Seta o gol do time 2
     * @param goalTeam2 gol do time 2
     */
    public void setGoalTeam2(int goalTeam2) {
        this.goalTeam2 = goalTeam2;
    }

    /**
     * @return gol do time 1
     */
    public int getGoalTeam1() {
        return goalTeam1;
    }

    /**
     * @return gol do time 2
     */
    public int getGoalTeam2() {
        return goalTeam2;
    }

    /**
     * Seta os tipos de times
     * @param teamsType enumeração de times (casa e vsitante)
     */
    public void setTeamsType(TeamsType teamsType) {
        this.teamsType = teamsType;
    }

    /**
     * @return tipo dos times
     */
    public TeamsType getTeamsType() {
        return teamsType;
    }

    /**
     * Seta total de gols de um time
     * @param totalGoalTeam total de gols do time
     */
    public void setTotalGoalTeam(int totalGoalTeam) {
        this.totalGoalTeam += totalGoalTeam;
    }

    /**
     * @return total de gols de um time
     */
    public int getTotalGoalTeam() {
        return totalGoalTeam;
    }

    /**
     * @return total de pontos de um time
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Seta o total de pontos de um time
     * @param totalPoints total de pontos
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints += totalPoints;
    }

    /**
     * @return total de empates
     */
    public int getTotalTie() {
        return totalTie;
    }

    /**
     * Seta total de empates
     * @param totalTie total de empates
     */
    public void setTotalTie(int totalTie) {
        this.totalTie += totalTie;
    }

    /**
     * @return total de vitórias
     */
    public int getTotalVictory() {
        return totalVictory;
    }

    /**
     * Seta total de vitórias de um time
     * @param totalVictory total de vitórias
     */
    public void setTotalVictory(int totalVictory) {
        this.totalVictory += totalVictory;
    }

    /**
     * @return lista de jogadores de um time
     */
    public ArrayList<SoccerPlayer> getSoccerTeam() {
        return soccerTeam;
    }

    /**
     * Seta jogadores de um time
     * @param soccerTeam lista de jogadores de um time
     */
    public void setSoccerTeam(ArrayList<SoccerPlayer> soccerTeam) {
        this.soccerTeam = soccerTeam;
    }

    /**
     * @return nome do time
     */
    public String getName() {
        return name;
    }

    /**
     * @return total das habilidades de um time
     */
    public BigDecimal getSkillTeams() {
        return skillTeams;
    }

    /**
     * Adiciona os jogadores em um time.
     * Se for um jogador em uma posição repetida, ele não adiciona
     * @param soccerTeam lista de jogadores de um time
     * @param player jogador
     * @return lista de jogadores
     */
    public ArrayList<SoccerPlayer> addPlayers(ArrayList<SoccerPlayer> soccerTeam, SoccerPlayer player) {
        if (soccerTeam.isEmpty()) {
            soccerTeam.add(player);
        } else {
            int contGoal = 0;
            int contDefender1 = 0;
            int contAttacker1 = 0;
            int contDefender2 = 0;
            int contAttacker2 = 0;
            for (int i = 0; i < soccerTeam.size(); i++) {
                if (soccerTeam.get(i).getType() == PlayersType.GOALKEEPER) {
                    contGoal++;
                }
                if (soccerTeam.get(i).getType() == PlayersType.DEFENDER1) {
                    contDefender1++;
                }
                if (soccerTeam.get(i).getType() == PlayersType.ATTACKER1) {
                    contAttacker1++;
                }
                if (soccerTeam.get(i).getType() == PlayersType.DEFENDER2) {
                    contDefender2++;
                }
                if (soccerTeam.get(i).getType() == PlayersType.ATTACKER2) {
                    contAttacker2++;
                }
            }
            if ((player.getType() == PlayersType.GOALKEEPER && contGoal < 1) ||
                    (player.getType() == PlayersType.DEFENDER1 && contDefender1 < 1) ||
                    (player.getType() == PlayersType.ATTACKER1 && contAttacker1 < 1) ||
                    (player.getType() == PlayersType.DEFENDER2 && contDefender2 < 1) ||
                    (player.getType() == PlayersType.ATTACKER2 && contAttacker2 < 1)) {
                soccerTeam.add(player);
            } else {
                System.out.println("There are already enough players of this type on the list");
            }
        }
        return soccerTeam;
    }

    /**
     * Remove o jogador escolhido do time
     * @param soccerTeam lista de jogadores de um time
     * @param namePlayer nome do jogador a ser removido
     * @return lista de jogadores de um time
     */
    public ArrayList<SoccerPlayer> removePlayers(ArrayList<SoccerPlayer> soccerTeam, String namePlayer){
        for(int i=0; i<soccerTeam.size(); i++){
            if(namePlayer.equals(soccerTeam.get(i).getNamePlayer())){
                soccerTeam.remove(i);
            }
        }
        return soccerTeam;
    }

    /**
     * Mostra a lista de jogadores de um time
     * @param soccerTeam lista de jogadores de um time
     * @param team time
     */
    public void showTeam(ArrayList<SoccerPlayer> soccerTeam, Team team){
        System.out.println("Team: " + team.getName());
        for(SoccerPlayer t : soccerTeam){
            System.out.println(t);
        }
        System.out.println("**********************");
    }

    /**
     * Calcula o total das habilidades do time somando as habilidades de todos os jogadores do time
     * @param soccerPlayers lista de jogadores do time
     */
    public void setTeamSkill(ArrayList<SoccerPlayer> soccerPlayers){
        BigDecimal sum = new BigDecimal(0);
        for(int i=0; i<soccerPlayers.size(); i++){
            sum = soccerPlayers.get(i).getSkill().add(sum);
        }
        this.skillTeams = sum;
    }

}
