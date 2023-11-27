package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao {
String addNewTeam(Team team);
List<String> getAllTeamsAbbreviations();
Team getDetailsByAbbreviation(String abbrev);
}
