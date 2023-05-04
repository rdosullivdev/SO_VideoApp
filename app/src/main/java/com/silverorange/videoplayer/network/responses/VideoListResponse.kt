package com.silverorange.videoplayer.network.responses

import androidx.annotation.Keep

@Keep
data class VideoResponse(
    val id: String,
    val title: String,
    val hlsURL: String,
    val fullURL: String,
    val description: String,
    val publishedAt: String,
    val author: Author,
)

@Keep
data class Author(
    val id: String,
    val name: String
)

/*
{
    "id": "2f1fe9c0-bdbf-4104-bee2-3c0ec514436f",
    "title": "About EM:RAP",
    "hlsURL": "https://d140vvwqovffrf.cloudfront.net/media/5e852de33c8e4/hls/index.m3u8",
    "fullURL": "https://d140vvwqovffrf.cloudfront.net/media/5e852de33c8e4/720.mp4",
    "description": "# Omnibus quae\n\n## Sit sed inque teneris\n\nLorem markdownum adhuc securosque, suo ponto satae se adhuc, terga. Fuit campus,\nqui, quod **formasque coeunt artus**, certamina nurus nunc coniuge peregit ritu.\nSuperat funera perque ferrem corpora saevam caespite nam maternaque sumpserat.\n\nIuga adest? Humano percussit Haemum frugis, vix qua quae iniustaque et tibi,\ntenuisset vix lacrimis umbra, ire. Ante nec. Est deam vivum ad ponti, non\ncaelamina et Sisyphon, inhonestaque atque, sed et vivit.\n\n1. Litora gloria Hyperionis carmina ungulaque patiere\n2. Dari nasci\n3. Fragilesque tendo dixit resonant quoque\n4. Et segnibus fuge ter Armeniae templi\n5. Sit deponere credit non aquarum Achilles tenus\n6. Exsultat artes Iovi\n\nStupet honoris. Nunc angebar Dryasque.\n\n## Multamque siqua hospitibus patrio\n\nExstimulata blando; qui armis Ixion **finire laetusque** sororem, aut **et**,\nigne membra? Nec bello ramis pari, Libye percensuit metallis, *in* mediis\nprocumbere.\n\n- Et illa\n- Clanis sceleris\n- Velletque prolisque auditum\n- Res delius iraque Semeles veluti\n- Cava umor quid superest fama artus\n\nTutam auditurum ab erit sum frigore in fleturi vectus eodem *quinos capillos me*\nagros. Ut rogis **foret cogor** neve ultoris rabiem, pro perque meque ossa\n[alter fassusque](http://www.querellissacra.com/reminiscitur) proxima erigitur,\nest *occulte concutio*. Celsa Echo huc credunt natus leones racemifero condi\nPhlegyanque esse; suis, per. Versum fessam me reponit omnis demisere litore\ncorpora esse expers veteris Noctisque.\n\n1. Inhaerebat undas ungula pulsat subiit modo\n2. Madefacta Cyanen\n3. Qua ex Tartessia nulla dixi illum lumina\n4. Et et viridi serpens ast longoque agros\n5. Aras nos arma medium consonat cum desit\n6. Facta ille ego\n\nFibris animo. Tui nota quod iter caeli mirata pede paulatim purpureum tergo\nseptemplicis? Progenies ait. Patrios sis est exclamat exiguo Myrrha in tibi\nexarsit cum. Flagrantemque cape: iter capacem cum rerum quota pennisque pone non\npatria.",
    "publishedAt": "2018-12-14T21:09:00.000Z",
    "author": {
      "id": "2cab326a-ab2f-4624-a6d7-2e1855fc5e4e",
      "name": "Mel Herbert"
    }
  }
 */