CREATE MATERIALIZED VIEW accommodation_per_host AS
SELECT
    h.id AS host_id,
    --h.name AS host_name,
    COUNT(a.id) AS num_accommodations
FROM host h
         LEFT JOIN accommodation a ON a.host_id = h.id
GROUP BY h.id, h.name;


CREATE MATERIALIZED VIEW host_per_country AS
SELECT
    c.id AS country_id,
    COUNT(h.id) AS num_hosts
FROM country c
         LEFT JOIN host h ON h.country_id = c.id
GROUP BY c.id, c.name;


