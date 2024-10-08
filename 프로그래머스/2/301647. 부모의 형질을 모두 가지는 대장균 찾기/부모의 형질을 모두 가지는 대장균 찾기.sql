SELECT e.ID AS ID, e.GENOTYPE AS GENOTYPE, p.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS e
LEFT JOIN ECOLI_DATA p ON e.PARENT_ID = p.ID
WHERE (e.GENOTYPE & p.GENOTYPE) = p.GENOTYPE
ORDER BY e.ID;