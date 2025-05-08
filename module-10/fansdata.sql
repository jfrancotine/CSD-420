CREATE TABLE IF NOT EXISTS fans (
    ID INT PRIMARY KEY,
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    favoriteteam VARCHAR(25)
);

INSERT INTO fans (ID, firstname, lastname, favoriteteam) VALUES
(1, 'Jose', 'Altuve', 'Astros'),
(2, 'Miguel', 'Cabreara', 'Detroit'),
(3, 'Ronald', 'Acuña Jr.', 'Atlanta'),
(4, 'Mookie', 'Betts', 'LA (Dodgers)'),
(5, 'Aaron', 'Judge', 'NY (Yankees)'),
(6, 'Adley', 'Rutschman', 'Baltimore'),
(7, 'Julio', 'Rodríguez', 'Seattle'),
(8, 'Fernando', 'Tatis Jr.', 'San Diego'),
(9, 'Bobby', 'Witt Jr.', 'Kansas City'),
(10, 'Seiya', 'Suzuki', 'Chicago (Cubs)');
