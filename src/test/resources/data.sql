
----- 玩家 -----
INSERT INTO Player (id,  username,  password,  nickname)
VALUES             ( 1,   'Jason',     '123',     '傑生');
INSERT INTO Player (id,  username,  password,  nickname)
VALUES             ( 2,  'Walter',     '123',     '華特');
INSERT INTO Player (id,  username,  password,  nickname)
VALUES             ( 3, 'Maxwell',     '123',   '麥克斯');

----- 腳色 -----
INSERT INTO Character (id,  player_id,      role,       name,  level,  hp)
VALUES                ( 1,          1,  'Knight',  '森林騎士',      1,  98);
INSERT INTO Character (id,  player_id,      role,       name,  level,  hp)
VALUES                ( 2,          1,  'Wizard',  '邪惡巫師',     22, 100);
INSERT INTO Character (id,  player_id,      role,       name,  level,  hp)
VALUES                ( 3,          2,    'Monk',  '世迦摩尼',     51,  42);
INSERT INTO Character (id,  player_id,      role,       name,  level,  hp)
VALUES                ( 4,          3,    'Monk',    '觀世音',     32,   0);
