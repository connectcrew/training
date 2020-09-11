--//****** 個別ページ用 ******//--
--商品詳細テーブル
SELECT 
	product_info.id, 
	title, br_name, 
	release_date, 
	series, engine, 
	pi_comment, 
	pi_text
FROM product_info
JOIN brand
ON product_info.br_id=brand.id
WHERE product_info.id = 1;

--プロデューサーテーブル
SELECT
	producer.id,
	pr_name,
	pr_gender,
	pr_place,
	pr_birthday,
	pr_blood,
	br_name,
	cl_name
FROM product_info
JOIN product_pr ON product_info.id = product_pr.pi_id
JOIN producer ON product_pr.pr_id = producer.id
LEFT OUTER JOIN brand ON producer.br_id = brand.id
LEFT OUTER JOIN club ON producer.cl_id = club.id
WHERE product_info.id = ?;

--シナリオライターテーブル
SELECT 
	scenario_writer.id, 
	sw_name, 
	sw_gender, 
	sw_place, 
	sw_birthday, 
	sw_blood, 
	br_name, 
	cl_name
FROM product_info 
JOIN product_sw ON product_info.id=product_sw.pi_id 
JOIN scenario_writer ON product_sw.sw_id=scenario_writer.id 
LEFT OUTER JOIN brand ON scenario_writer.br_id=brand.id 
LEFT OUTER JOIN club ON scenario_writer.cl_id=club.id
WHERE product_info.id = 1;

--イラストレーター
SELECT
  illustrator.id,
  il_name,
  il_gender,
  il_place,
  il_birthday,
  il_blood,
  br_name,
  cl_name
FROM product_info
JOIN product_il ON product_info.id = product_il.pi_id
JOIN illustrator ON product_il.il_id = illustrator.id
LEFT OUTER JOIN brand ON illustrator.br_id = brand.id
LEFT OUTER JOIN club ON illustrator.cl_id = club.id
WHERE product_info.id = 1;

--グラフィッククリエイター
SELECT
  graphic_creator.id,
  gc_name,
  gc_gender,
  gc_place,
  gc_birthday,
  gc_blood,
  br_name,
  cl_name
FROM
  product_info
  JOIN product_gc ON product_info.id = product_gc.pi_id
  JOIN graphic_creator ON product_gc.gc_id = graphic_creator.id
  LEFT OUTER JOIN brand ON graphic_creator.br_id = brand.id
  LEFT OUTER JOIN club ON graphic_creator.cl_id = club.id
WHERE
  product_info.id = 1;

--サウンドクリエーター
SELECT
  sound_creator.id,
  sc_name,
  sc_gender,
  sc_place,
  sc_birthday,
  sc_blood,
  br_name,
  cl_name
FROM
  product_info
  JOIN product_sc ON product_info.id = product_sc.pi_id
  JOIN sound_creator ON product_sc.sc_id = sound_creator.id
  LEFT OUTER JOIN brand ON sound_creator.br_id = brand.id
  LEFT OUTER JOIN club ON sound_creator.cl_id = club.id
WHERE
  product_info.id = 1;

--声優テーブル
SELECT
  voice_actor.id,
  va_name,
	va_namespell,
  va_gender,
  va_place,
  va_birthday,
  va_blood,
	va_debut,
	ao_name,
  av_name
FROM
  product_info
  JOIN product_va ON product_info.id = product_va.pi_id
  JOIN voice_actor ON product_va.va_id = voice_actor.id
  LEFT OUTER JOIN affilication_office ON voice_actor.ao_id = affilication_office.id
  LEFT OUTER JOIN animation_va ON voice_actor.av_id = animation_va.id
WHERE
  product_info.id = 1;

--//****** topページ用 ******//--
-- ランキングページを個別で作るのであれば、lim外したものを使うと良い。
-- DB負荷を考慮してDAOには両パターンを組み込むこととする。

-- 新着
-->> 新たに自動更新型のdatetimeカラムを詳細データテーブルに追加する必要がある。


-- 会社/グループ
SELECT
	co_name,
	COUNT(co_name)
FROM product_info
	JOIN brand ON product_info.br_id=brand.id
	JOIN company ON brand.co_id=company.id
GROUP BY co_name
ORDER BY COUNT(co_name) DESC
LIMIT 5;

-- ブランド
SELECT
	br_name,
	COUNT(br_name)
FROM product_info
	JOIN brand
	ON product_info.br_id=brand.id
GROUP BY br_name
ORDER BY COUNT(br_name) DESC
LIMIT 5;

-- プロデューサー
SELECT
	pr_name,
	COUNT(pr_name)
FROM product_info
	JOIN product_pr ON product_info.id=product_pr.pi_id
	JOIN producer ON producer.id=product_pr.pr_id
GROUP BY pr_name
ORDER BY COUNT(pr_name) DESC
LIMIT 5;


-- シナリオライター
SELECT
	sw_name,
	COUNT(sw_name)
FROM product_info
	JOIN product_sw ON product_info.id=product_sw.pi_id
	JOIN scenario_writer ON scenario_writer.id=product_sw.sw_id
GROUP BY sw_name
ORDER BY COUNT(sw_name) DESC
LIMIT 5;


-- イラストレーター
SELECT
	il_name,
	COUNT(il_name)
FROM product_info
	JOIN product_il ON product_info.id=product_il.pi_id
	JOIN illustrator ON illustrator.id=product_il.il_id
GROUP BY il_name
ORDER BY COUNT(il_name) DESC
LIMIT 5;

-- グラフィッククリエイター
SELECT
	gc_name,
	COUNT(gc_name)
FROM product_info
	JOIN product_gc ON product_info.id=product_gc.pi_id
	JOIN graphic_creator ON graphic_creator.id=product_gc.gc_id
GROUP BY gc_name
ORDER BY COUNT(gc_name) DESC
LIMIT 5;

-- サウンドクリエイター
SELECT
	sc_name,
	COUNT(sc_name)
FROM product_info
	JOIN product_sc ON product_info.id=product_sc.pi_id
	JOIN sound_creator ON sound_creator.id=product_sc.sc_id
GROUP BY sc_name
ORDER BY COUNT(sc_name) DESC
LIMIT 5;

-- 声優
SELECT
	va_name,
	COUNT(va_name)
FROM product_info
	JOIN product_va ON product_info.id=product_va.pi_id
	JOIN voice_actor ON voice_actor.id=product_va.va_id
GROUP BY va_name
ORDER BY COUNT(va_name) DESC
LIMIT 5;

-- 声優（表）
SELECT
	av_name,
	COUNT(av_name)
FROM product_info
	JOIN product_va ON product_info.id=product_va.pi_id
	JOIN voice_actor ON voice_actor.id=product_va.va_id
	JOIN animation_va ON animation_va.id=voice_actor.av_id
GROUP BY av_name
ORDER BY COUNT(av_name) DESC
LIMIT 5;


--//****** product_information ページ用 ******//--
-- DB負荷を考慮してDAOには両パターンを組み込むこととする。

-- プロデューサー
SELECT producer.id, pr_name
FROM product_info
	JOIN product_pr ON product_info.id=product_pr.pi_id
	JOIN producer ON producer.id=product_pr.pr_id
WHERE product_info.id = ?;

-- シナリオライター
SELECT scenario_writer.id, sw_name
FROM product_info
	JOIN product_sw ON product_info.id=product_sw.pi_id
	JOIN scenario_writer ON scenario_writer.id=product_sw.sw_id
WHERE product_info.id = ?;

-- イラストレーター
SELECT illustrator.id, il_name
FROM product_info
	JOIN product_il ON product_info.id=product_il.pi_id
	JOIN illustrator ON illustrator.id=product_il.il_id
WHERE product_info.id = ?;

-- グラフィッククリエイター
SELECT graphic_creator.id, gc_name
FROM product_info
	JOIN product_gc ON product_info.id=product_gc.pi_id
	JOIN graphic_creator ON graphic_creator.id=product_gc.gc_id
WHERE product_info.id = ?;

-- サウンドクリエイター
SELECT sound_creator.id, sc_name
FROM product_info
	JOIN product_sc ON product_info.id=product_sc.pi_id
	JOIN sound_creator ON sound_creator.id=product_sc.sc_id
WHERE product_info.id = ?;

-- 声優
SELECT voice_actor.id, va_name
FROM product_info
	JOIN product_va ON product_info.id=product_va.pi_id
	JOIN voice_actor ON voice_actor.id=product_va.va_id
WHERE product_info.id = ?;



--//*** 個別インフォメーションページ用 ***//--
-- company_information
SELECT company.id AS co_id, co_name, co_year, co_address, brand.id AS br_id, br_name
FROM company
	JOIN brand ON company.id = brand.co_id
WHERE company.id = 2;

-- brand_information
SELECT brand.id AS br_id, br_name, company.id AS co_id, co_name, product_info.id AS pi_id, title
FROM brand
	JOIN product_info ON brand.id = product_info.br_id
	JOIN company ON brand.co_id = company.id
WHERE br_id = 1
ORDER BY pi_id DESC
LIMIT 3;


--//*** creators ***//--
-- producer_informaation
SELECT
	producer.id AS pr_id,
	pr_name,
	pr_gender,
	pr_place,
	pr_birthday,
	pr_blood,
	brand.id AS br_id,
	br_name,
	club.id AS cl_id,
	cl_name,
	product_info.id AS pi_id,
	title
FROM producer
	LEFT OUTER JOIN brand ON producer.br_id = brand.id
	LEFT OUTER JOIN club ON cl_id = club.id
	LEFT OUTER JOIN product_pr ON producer.id = product_pr.pr_id
	JOIN product_info ON product_pr.pi_id = product_info.id
WHERE producer.id = 1
ORDER BY release_date DESC
LIMIT 3;

-- scenario_writer
SELECT
	scenario_writer.id AS sw_id, 
	sw_name, 
	sw_gender, 
	sw_place, 
	sw_birthday, 
	sw_blood, 
	brand.id AS br_id,
	br_name,
	club.id AS cl_id,
	cl_name,
	product_info.id AS pi_id,
	title
FROM scenario_writer
	LEFT OUTER JOIN brand ON scenario_writer.br_id = brand.id
	LEFT OUTER JOIN club ON cl_id = club.id
	LEFT OUTER JOIN product_sw ON scenario_writer.id = product_sw.sw_id
	LEFT OUTER JOIN product_info ON product_sw.pi_id = product_info.id
WHERE scenario_writer.id = 1
ORDER BY release_date DESC
LIMIT 3;

-- illustrator
SELECT
	illustrator.id AS il_id, 
	il_name, 
	il_gender, 
	il_place, 
	il_birthday, 
	il_blood, 
	brand.id AS br_id,
	br_name,
	club.id AS cl_id,
	cl_name,
	product_info.id AS pi_id,
	title
FROM illustrator
	LEFT OUTER JOIN brand ON illustrator.br_id = brand.id
	LEFT OUTER JOIN club ON cl_id = club.id
	LEFT OUTER JOIN product_il ON illustrator.id = product_il.il_id
	LEFT OUTER JOIN product_info ON product_il.pi_id = product_info.id
WHERE illustrator.id = 1
ORDER BY release_date DESC
LIMIT 3;

-- graphic_creator
SELECT 
	graphic_creator.id AS gc_id, 
	gc_name, 
	gc_gender, 
	gc_place, 
	gc_birthday, 
	gc_blood, 
	brand.id AS br_id,
	br_name,
	club.id AS cl_id,
	cl_name,
	product_info.id AS pi_id,
	title
FROM graphic_creator
	LEFT OUTER JOIN brand ON graphic_creator.br_id = brand.id
	LEFT OUTER JOIN club ON cl_id = club.id
	LEFT OUTER JOIN product_gc ON graphic_creator.id = product_gc.gc_id
	LEFT OUTER JOIN product_info ON product_gc.pi_id = product_info.id
WHERE graphic_creator.id = 1
ORDER BY release_date DESC
LIMIT 3;

-- sound_creator
SELECT 
	sound_creator.id AS sc_id, 
	sc_name, 
	sc_gender, 
	sc_place, 
	sc_birthday, 
	sc_blood, 
	brand.id AS br_id,
	br_name,
	club.id AS cl_id,
	cl_name,
	product_info.id AS pi_id,
	title
FROM sound_creator
	LEFT OUTER JOIN brand ON sound_creator.br_id = brand.id
	LEFT OUTER JOIN club ON cl_id = club.id
	LEFT OUTER JOIN product_sc ON sound_creator.id = product_sc.sc_id
	LEFT OUTER JOIN product_info ON product_sc.pi_id = product_info.id
WHERE sound_creator.id = 1
ORDER BY release_date DESC
LIMIT 3;

-- voice_actor
SELECT
	voice_actor.id AS va_id,
	va_name,
	animation_va.id AS av_id,
	av_name,
	va_gender,
	va_place,
	va_birthday,
	va_blood,
	va_debut,
	product_info.id AS pi_id,
	title
FROM voice_actor
	left outer JOIN animation_va ON av_id = animation_va.id
	left outer JOIN product_va ON voice_actor.id = product_va.va_id
	left outer JOIN product_info ON product_va.pi_id = product_info.id
WHERE voice_actor.id = 7
ORDER BY release_date DESC
LIMIT 3;

-- animation voice actor
SELECT
	animation_va.id AS av_id,
	av_name,
	av_gender,
	av_place,
	av_birthday,
	av_blood,
	av_debut,
	affilication_office.id AS ao_id,
	ao_name,
	voice_actor.id AS va_id,
	va_name
FROM animation_va
	LEFT OUTER JOIN affilication_office ON ao_id = affilication_office.id
	LEFT OUTER JOIN voice_actor ON voice_actor.av_id = animation_va.id
WHERE animation_va.id = 7;

-- affilication_office
SELECT
	affilication_office.id AS ao_id,
	ao_name,
	animation_va.id AS av_id,
	av_name
FROM affilication_office
	LEFT OUTER JOIN animation_va ON ao_id = affilication_office.id
WHERE affilication_office.id = 3;


SELECT COUNT(*)/20
FROM product_info JOIN brand
ON product_info.br_id=brand.id
ORDER BY release_date DESC;



INSERT INTO a_test(title, br_id, release_date, series, ENGINE, pi_comment, pi_text)
SELECT 'あけるり', brand.id, '9999-12-31', 'あけるり', '', '', ''
FROM brand WHERE br_name = 'ゆずソフト';