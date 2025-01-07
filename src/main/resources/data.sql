INSERT INTO users (username, password, role)
SELECT 'admin', '$2y$10$xLH/TSmZZwkhagV5j5WDn..v9N1dvVbuwLItiApQ/dZBPI1LqmG2S', 'ROLE_ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'admin'
);
