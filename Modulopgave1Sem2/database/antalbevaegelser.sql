use modul;
SELECT antalbevaegelser 
                 FROM bevaegelser INNER JOIN kommune 
                 ON kommune_kommuneid = kommuneID 
                 INNER JOIN koen 
                 on koen_koenID = koenID 
                 INNER JOIN bevaegelsesart 
                 ON bevaegelsesart_bevaegelsesartID = bevaegelsesartID 
                 INNER JOIN aarstal 
                 ON aarstal_aarstalID = aarstalID 
                 WHERE kommunenavn = "København" AND koennavn = "Maend" AND bevaegelsesartnavn = "døde" 
                 AND aarstalid = 2006;
                 
                 
 use modul;
SELECT antalbevaegelser 
                 FROM bevaegelser INNER JOIN kommune 
                 ON kommune_kommuneid = kommuneID 
                 INNER JOIN koen 
                 on koen_koenID = koenID 
                 INNER JOIN bevaegelsesart 
                 ON bevaegelsesart_bevaegelsesartID = bevaegelsesartID 
                 INNER JOIN aarstal 
                 ON aarstal_aarstalID = aarstalID 
                 WHERE kommunenavn = "København" AND koennavn = "Maend" AND bevaegelsesartnavn = "døde" 
                 AND aarstalid = 2006;