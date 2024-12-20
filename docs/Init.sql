INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (1, 1, 'connor', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (2, 2, 'adminPlayer', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (3, 3, 'testPlayer1', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (4, 4, 'testPlayer2', 'inactive');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (5, 5, 'testPlayer3', 'banned');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (6, 6, 'testPlayer4', 'deleted');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (7, 7, 'testPlayer5', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (8, 8, 'testPlayer6', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (9, 9, 'testPlayer7', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (10, 10, 'testPlayer8', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (11, 11, 'testPlayer9', 'active');
INSERT INTO mydb.PlayerEntity (id, user_id, name, status) VALUES (12, 12, 'testPlayer10', 'active');



INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (1, 1, 'Local match to join', 'scheduled',  'to join, message xyxyxy', 1);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (2, 1, 'Local match to join', 'scheduled',  'to join, message xyxyxy', 1);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (3, 2, 'testMatch1', 'active',  'to join, message xyxyxy', 2);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (4, 2, 'testMatch2', 'completed',  'to join, message xyxyxy', 3);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (5, 1, 'testMatch3', 'cancelled',  'to join, message xyxyxy', 4);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (6, 1, 'testMatch4', 'active',  'to join, message xyxyxy', 5);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (7, 2, 'testMatch5', 'scheduled',  'to join, message xyxyxy', 6);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (8, 2, 'testMatch6', 'active',  'to join, message xyxyxy', 7);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (9, 1, 'testMatch7', 'scheduled',  'to join, message xyxyxy', 8);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (10, 1, 'testMatch8', 'completed',  'to join, message xyxyxy', 9);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (11, 1, 'testMatch9', 'cancelled',  'to join, message xyxyxy', 10);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (12, 2, 'testMatch10', 'deleted',  'to join, message xyxyxy', 11);
INSERT INTO mydb.MatchEntity (id, location_id, description, status, private_description, creator_id) VALUES (13, 2, 'testMatch11', 'active',  'to join, message xyxyxy', 12);


INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (1, 'team1', 'testTeam', 1,  1, 'fixed');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (2, 'team2', 'testTeam', 1,  1, 'dropin');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (3, 'team3', 'testTeam', 1,  2, 'fixed');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (4, 'team4', 'testTeam', 1,  3, 'dropin');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (5, 'team5', 'testTeam', 1,  4, 'open');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (6, 'team6', 'testTeam', 0,  1, 'open');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (7, 'team7', 'testTeam', 0,  2, 'fixed');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (8, 'team8', 'testTeam', 1,  3, 'dropin');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (9, 'team9', 'testTeam', 1,  4, 'open');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (10, 'team10', 'testTeam', 1,  5, 'open');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (11, 'team11', 'testTeam', 1,  6, 'fixed');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (12, 'team12', 'testTeam', 1,  7, 'dropin');
INSERT INTO mydb.TeamEntity (id, name, description, active, home_ground, type) VALUES (13, 'team13', 'testTeam', 1,  8, 'open');


INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (1, 'LocalField1', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (2, 'LocalField2', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (3, 'LocalField3', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (4, 'LocalField4', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (5, 'LocalField5', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (6, 'LocalField6', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (7, 'LocalField7', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (8, 'LocalField8', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (9, 'LocalField9', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (10, 'LocalField10', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (11, 'LocalField11', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (12, 'LocalField12', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');
INSERT INTO mydb.LocationEntity (id, name,maps_link) VALUES (13, 'LocalField13', 'https://maps.app.goo.gl/Lu9bUBy9yGYDFZmH6');


INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (1, 1, 1, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (2, 2, 1, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (3, 1, 2, 'inactive');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (4, 2, 2, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (5, 3, 2, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (6, 4, 2, 'inactive');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (7, 5, 2, 'deleted');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (8, 6, 3, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (9, 7, 3, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (10, 8, 4, 'active');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (11, 9, 5, 'deleted');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (12, 10, 6, 'deleted');
INSERT INTO mydb.PlayerTeamLinkEntity (id, player_id, team_id, status) VALUES (13, 11, 1, 'inactive');


INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (1, 1, 1, 'active');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (2, 2, 1, 'active');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (3, 1, 2, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (4, 2, 2, 'active');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (5, 3, 2, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (6, 4, 2, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (7, 1, 3, 'active');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (8, 2, 3, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (9, 3, 3, 'active');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (10, 4, 4, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (11, 5, 4, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (12, 6, 4, 'cancelled');
INSERT INTO mydb.PlayerMatchLinkEntity (id, player_id, match_id, status) VALUES (13, 7, 4, 'active');


INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (1, 1, 1, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (2, 2, 1, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (3, 1, 2, 'cancelled');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (4, 2, 2, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (5, 3, 3, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (6, 4, 4, 'cancelled');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (7, 5, 3, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (8, 6, 4, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (9, 7, 5, 'active');
INSERT INTO mydb.TeamMatchLinkEntity (id, team_id, match_id, status) VALUES (10, 8, 5, 'active');
