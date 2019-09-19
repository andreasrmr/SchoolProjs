#V1
use modul;
SELECT (bevaegelser1.AntalBevaegelser - bevaegelser2.AntalBevaegelser) as FØDSELSOVERSKUD 
	FROM bevaegelser bevaegelser1 CROSS JOIN
		bevaegelser bevaegelser2
        WHERE bevaegelser1.BevaegelserID = 1189 AND bevaegelser2.BevaegelserID = 2377;

#V2
SELECT (bevaegelser1.AntalBevaegelser - bevaegelser2.AntalBevaegelser) as FØDSELSOVERSKUD 
	FROM bevaegelser bevaegelser1 CROSS JOIN
		bevaegelser bevaegelser2
        WHERE 
        bevaegelser1.Aarstal_aarstalid = 2006 AND
        bevaegelser2.Aarstal_aarstalid = 2006 AND 
        bevaegelser1.Koen_KoenID = 'm' AND
        bevaegelser2.Koen_KoenID = 'm' AND
        bevaegelser1.Kommune_KommuneID = 1 AND
        bevaegelser2.Kommune_KommuneID = 1 AND
        bevaegelser1.Bevaegelsesart_BevaegelsesartID = 2 AND
        bevaegelser2.Bevaegelsesart_BevaegelsesartID = 3;
        
#V3
SELECT (bevaegelser1.AntalBevaegelser - bevaegelser2.AntalBevaegelser) as FØDSELSOVERSKUD 
	FROM bevaegelser bevaegelser1 CROSS JOIN
		bevaegelser bevaegelser2
        INNER JOIN Kommune KOM1 on Bevaegelser1.Kommune_KommuneID = KOM1.KommuneID
        INNER JOIN Kommune KOM2 on bevaegelser2.Kommune_KommuneID = KOM2.KommuneID
        INNER JOIN Bevaegelsesart BA1 on Bevaegelser1.Bevaegelsesart_BevaegelsesartID = BA1.BevaegelsesartID
        INNER JOIN Bevaegelsesart BA2 on Bevaegelser2.Bevaegelsesart_BevaegelsesartID = BA2.BevaegelsesartID
        INNER JOIN Koen KOEN1 on Bevaegelser1.Koen_KoenID = KOEN1.KoenID
        INNER JOIN Koen KOEN2 on Bevaegelser2.Koen_KoenID = KOEN2.KoenID
        WHERE 
        bevaegelser1.Aarstal_aarstalid = 2006 AND
        bevaegelser2.Aarstal_aarstalid = 2006 AND 
        KOEN1.KoenNavn = "Maend" AND
        KOEN2.KoenNavn = "Maend" AND
        KOM1.KommuneNavn = 'København' AND
        KOM2.KommuneNavn = 'København' AND
        BA1.BevaegelsesartNavn = 'levendefødte' AND
        BA2.BevaegelsesartNavn = 'døde';

        select * from bevaegelsesart;
        select * from bevaegelser;
        
/*
stackoverflow:
    ------------------------------------
id | name | sub1 | sub2 | date
------------------------------------
1  | ABC  | 50   | 75   | 2014-11-07
2  | PQR  | 60   | 80   | 2014-11-08 

SELECT(t2.sub1 - t1.sub1) AS sub1, (t2.sub2 - t1.sub2) AS sub2
	FROM table t1 CROSS JOIN
		table t2
	WHERE t1.date = '2014-11-08' AND t2.id = '2014-11-07';

*/