-- 1. Obter todas as linhas atendidas por uma determinada empresa, dado o nome dessa
-- empresa.
SELECT 
	 E.nome_empresa AS EMPRESA,
	 E.codigo_linha AS CODIGO_LINHA,
	 L.nome  AS NOME_LINHA
 FROM TB_EMPRESA_LINHA E
  INNER JOIN TB_LINHA L ON E.CODIGO_LINHA = L.CODIGO
WHERE E.nome_empresa = 'Viação Paraty';

-- 2. Obter o itinerário de uma determinada linha de ônibus, dado o Nome (Identificação)
-- dessa linha.
SELECT
	L.nome AS NOME_LINHA,
	I.nome AS ITINERARIO,
	LO.nome AS LOGRADOURO
FROM TB_LINHA L
  INNER JOIN TB_ITINERARIO I ON L.CODIGO = I.CODIGO_LINHA
  INNER JOIN TB_LOGRADOURO LO ON LO.CODIGO = I.CODIGO_LOGRADOURO
WHERE L.NOME = 'Águas do Paiol'
ORDER BY I.ordem ;

-- 3. Obter o quadro de horário de uma determinada linha, dado seu Nome.
SELECT
	L.nome AS NOME_LINHA,
	QH.dia  AS DIA_SEMANA,
	QH.horario_partida AS HORARIO
FROM TB_LINHA L
  INNER JOIN TB_QUADRO_HORARIO QH ON L.CODIGO = QH.CODIGO_LINHA
WHERE NOME = 'Águas do Paiol';

-- 4. Obter as linhas de ônibus/empresa que passam por um determinado logradouro, dado o
-- nome desse logradouro.
SELECT
	LO.nome AS LOGRADOURO,
	L.nome  AS NOME_LINHA
FROM TB_LOGRADOURO LO
  INNER JOIN TB_ITINERARIO I ON LO.codigo = I.codigo_logradouro 
  INNER JOIN TB_LINHA L ON L.codigo  = I.codigo_linha 
WHERE LO.NOME LIKE 'Rua Bento Machado Ramalho';