package com.example.filmamora.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private String film = "CREATE TABLE Film(id integer  PRIMARY KEY AUTOINCREMENT  NOT NULL , titre Varchar (255) NOT NULL , annee Int NOT NULL , synopsis Varchar (1000) NOT NULL, aVoir int NOT NULL DEFAULT 0);";
    private String personne = "CREATE TABLE personne( id integer PRIMARY KEY AUTOINCREMENT  NOT NULL , nom Varchar (50), prenom Varchar (50) NOT NULL);";
    private String role = "CREATE TABLE role(id integer PRIMARY KEY AUTOINCREMENT  NOT NULL , libelle Varchar (255) NOT NULL);";
    private String avis =  "CREATE TABLE avis(id integer PRIMARY KEY AUTOINCREMENT NOT NULL , note Int NOT NULL , commentaire Varchar (1000) NOT NULL , id_Film Int REFERENCES Film(id) UNIQUE NOT NULL);";
    private String participe =  "CREATE TABLE participe(id integer REFERENCES personne(id) NOT NULL, id_Film integer REFERENCES Film(id) NOT NULL , id_role integer REFERENCES role(id) NOT NULL, PRIMARY KEY(id, id_Film, id_role));";
    private String insertFilm = "\n" +
            "INSERT INTO `Film` (`id`, `titre`, `annee`, `synopsis`, `aVoir`) VALUES\n" +
            "(1, \"Interstellar\", 2014, \"Alors que la Terre se meurt, une équipe d\'astronautes franchit un trou de ver apparu près de Saturne et conduisant à une autre galaxie, afin d\'explorer un nouveau système stellaire et dans l\'espoir de trouver une planète habitable et y établir une colonie spatiale pour sauver l\'humanité.\", 0),\n" +
            "(2, \"Ready Player One\", 2018, \"En 2045, le monde est au bord du chaos. Les êtres humains se réfugient dans l\'OASIS, univers virtuel mis au point par le brillant et excentrique James Halliday. Avant de disparaître, celui-ci a décidé de léguer son immense fortune à quiconque découvrira l\'oeuf de Pâques numérique qu\'il a pris soin de dissimuler dans l\'OASIS. L\'appât du gain provoque une compétition planétaire.\", 0),\n" +
            "(3, \"Valérian et La Cité des Milles Planètes\", 2017, \"Au 28ème siècle, Valérian et Laureline forment une équipe d\'agents spatio-temporels chargés de maintenir l\'ordre dans les territoires humains. Mandaté par le Ministre de la Défense, le duo part en mission sur l\'extraordinaire cité intergalactique Alpha. Un mystère se cache au coeur d\'Alpha, une force obscure qui menace l\'existence paisible de la Cité des Mille Planètes.\", 0),\n" +
            "(4, \"Matrix\", 1999, \"Programmeur anonyme dans un service administratif le jour, Thomas Anderson devient Neo la nuit venue. Sous ce pseudonyme, il est l\'un des pirates les plus recherchés du cyber-espace. À cheval entre deux mondes, Neo est assailli par d\'étranges songes et des messages cryptés provenant d\'un certain Morpheus. Celui-ci l\'exhorte à aller au-delà des apparences et à trouver la réponse à la question qui hante constamment ses pensées : qu\'est-ce que la Matrice ?\", 0),\n" +
            "(5, \"Matrix Reloaded\", 2003, \"Les hommes sauvés de la Matrice sont réfugiés dans la cité souterraine de Zion, que des machines de destruction tentent d\'atteindre. Morpheus et Neo attendent un signe de l\'Oracle pour continuer leur combat. Lorsque, enfin, il se manifeste, Neo comprend qu\'une erreur de programmation de la Matrice a engendré l\'Oracle. Il se met ensuite en route pour sa nouvelle mission : retrouver le Maître des clés, qui est prisonnier du Mérovingien.\", 0),\n" +
            "(6, \"Matrix Revolution\", 2003, \"Alors que Neo est coincé dans une gare entre deux mondes, les Machines s\'apprêtent à attaquer Zion. Morpheus, Trinity et Seraph attaquent le repaire du Mérovingien pour le rejoindre. L\'Oracle avertit Neo qu\'il doit se méfier de l\'agent Smith, son contraire, car la bataille finale entre les hommes et les Machines est proche. Les citoyens de Zion préparent activement la défense de la cité.\", 0),\n" +
            "(7, \"Wall-E\", 2008, \"Wall E, un petit robot, est le dernier être sur Terre ! 700 ans plus tôt, l\'humanité a déserté notre planète en lui laissant le soin de nettoyer la Terre. Mais Wall E a développé un petit défaut technique : une forte personnalité ! Curieux et indiscret, il est surtout très seul. Sa vie va être bouleversée avec l\'arrivée d\'Eve, une petite robote. Wall E va tout mettre en œuvre pour la séduire.\", 0),\n" +
            "(8, \"I, Robot\", 2004, \"L\'action se déroule en 2035. Des robots sont pleinement intégrés à notre vie quotidienne, et tout le monde a confiance en eux, à l\'exception d\'un détective légèrement paranoïaque enquêtant sur un meurtre dont il est le seul à penser qu\'il est l\'œuvre d\'un robot. Cette enquête l\'amènera à découvrir une bien plus terrifiante menace pour la race humaine.\", 0),\n" +
            "(9, \"Stratégie Enders\", 2013, \"Depuis l\'attaque sanglante des Doryphores, qui a fait des millions de morts il y a 50 ans, l\'humanité se prépare à une nouvelle tentative d\'invasion extraterrestre en recrutant, parmi les enfants, ceux qui démontrent les plus grandes capacités.\", 0),\n" +
            "(10, \"Passengers\", 2016, \"Alors que 5.000 passagers endormis pour longtemps voyagent dans l\'espace vers une nouvelle planète, deux d\'entre eux sont accidentellement tirés de leur sommeil artificiel 90 ans trop tôt. Jim et Aurora doivent désormais accepter l\'idée de passer le reste de leur existence à bord du vaisseau spatial. Alors qu\'ils éprouvent peu à peu une indéniable attirance, ils découvrent que le vaisseau court un grave danger. La vie des milliers de passagers endormis est entre leurs mains.\", 0),\n" +
            "(11, \"L\'Homme Bicentenaire\", 2000, \"En ce début de XXIe siècle, la robotique a fait d\'importants progrès. La famille Martin peut ainsi faire l\'acquisition d\'un robot domestique, le NDR-114, conçu pour effectuer toutes les taches ménagères. Les enfants réagissent chacun différemment à la présence d\'un nouveau venu, surnommé Andrew. Grace, l\'aînée, le considère comme une boite de conserve et lui ordonne de sauter du premier étage.\", 0),\n" +
            "(12, \"WestWorld(MondWest)\", 1973, \"Dans un parc d\'attractions du futur, de riches vacanciers peuvent assouvir tous leurs fantasmes sur des robots qui leur servent de défouloir. Mais une créature d\'acier à l\'allure de cow boy, incarnée par un Yul Brynner impassible à souhait, se rebelle et tue tous les humains qui passent à sa portée\", 0),\n" +
            "(13, \"Soleil Vert\", 1974, \"En 2022, les hommes ont épuisé les ressources naturelles. Seul le soleil vert, sorte de pastille, parvient à nourrir une population miséreuse qui ne sait pas comment créer de tels aliments. Omniprésente et terriblement répressive, la police assure l\'ordre. Accompagné de son fidèle ami, un policier va découvrir, au péril de sa vie, l\'effroyable réalité de cette société inhumaine.\", 0),\n" +
            "(14, \"Cinquième Élément\", 1997, \"Egypte, 1914. Des extraterrestres récupèrent quatre pierres magiques, symboles des quatre éléments, jadis confiées à des prêtres. Avant de partir, les extraterrestres promettent que dans 300 ans, ils rapporteront les précieux cailloux. Au XXIIIe siècle, alors qu\'ils font route vers la Terre, ils sont anéantis par la planète du Mal. Les habitants de ce monde maléfique, les Mangalores, s\'emparent des pierres et foncent vers la Terre.\", 0),\n" +
            "(15, \"Seul Sur Mars\", 2015, \"Lors d\'une expédition sur Mars, l\'astronaute Mark Watney est laissé pour mort par ses coéquipiers, une tempête les ayant obligés à décoller en urgence. Mark a survécu et il est désormais seul, sans moyen de repartir, sur une planète hostile. Il va devoir faire appel à son intelligence et son ingéniosité pour tenter de survivre et trouver un moyen de contacter la Terre.\", 0),\n" +
            "(16, \"Bienvenue à Gattaca\", 1997, \"Dans un futur proche, notre société pratique l\'eugénisme à grande échelle : les gamètes des parents sont triés et sélectionnés afin de concevoir in vitro des enfants quasi parfaits. Malgré l\'interdiction officielle, les entreprises recourent à des tests ADN discrets afin de sélectionner leurs employés. Ainsi, les personnes conçues naturellement se voient reléguées à des tâches subalternes\", 0),\n" +
            "(17, \"Her\", 2013, \"En 2025 à Los Angeles, Theodore travaille pour un site web comme écrivain public, rédigeant des lettres manuscrites de toutes sortes - familiales, amoureuses, etc. - pour d\'autres. Son épouse Catherine et lui ont rompu depuis bientôt un an mais il ne se décide pas à signer les papiers du divorce. Dans un état de dépression qui perdure, il installe un nouveau système d\'exploitation OS1, auquel il donne une voix féminine.\", 0),\n" +
            "(18, \"Seven Sisters\", 2017, \"Face à la surpopulation de la Terre, les autorités décident d’instaurer la politique de l\'enfant unique. Cette mesure est appliquée sévèrement par le Bureau d’Allocation des Naissances (Child Allocation Bureau), dirigé par Nicolette Cayman. Quelques années plus tard, Karen, la fille de Terrence Settman, donne naissance à des septuplées. Alors que la mère ne survit pas à l\'accouchement, Terrence décide de garder secrète l’existence de ses sept petites-filles malgré la loi. Toutes prénommées d’un jour de la semaine, elles devront rester confinées dans leur appartement. Elles partagent alors une identité unique lorsqu\'elles sortent à l’extérieur : celle de leur mère Karen Settman. Cet incroyable secret demeure intact durant trente ans, mais tout s\'effondre le jour où Lundi disparait mystérieusement\", 0),\n" +
            "(19, \"Blade Runner\", 1982, \"Dans les dernières années du 20e siècle, des milliers d\'hommes et de femmes partent à la conquête de l\'espace, fuyant les mégalopoles devenues insalubres. Sur les colonies, une nouvelle race d\'esclaves voit le jour : les répliquants, des androïdes que rien ne peut distinguer de l\'être humain. Cependant, suite à une révolte, ces derniers sont peu à peu retirés.\", 0),\n" +
            "(20, \"Tron\", 1982, \"Flynn, un concepteur de jeux vidéo qui s\'est vu voler ses jeux par son ex-employeur, veut à tout prix récupérer une preuve qui lui ferait valoir ses droits. Avec l\'aide d\'Alan et de Lora, deux de ses anciens collègues, il infiltre le MCP (Maître Contrôleur Principal), un ordinateur avide de pouvoir à l\'intelligence artificielle surdéveloppée. Quand ce dernier découvre que Flynn veut s\'infiltrer dans ses circuits, il le téléporte dans un jeu vidéo.\", 0),\n" +
            "(21, \"Tron L\'Héritage\", 2010, \"Sam Flynn, un rebelle de 27 ans, est hanté par la disparition mystérieuse de son père, Kevin Flynn, un homme autrefois connu pour être le meilleur développeur de jeux vidéo au monde. Lorsque Sam se penche sur un signal étrange qui parvient de l\'ancienne arcade de jeux de Flynn, il se retrouve aspiré dans un monde numérique où Kevin est prisonnier depuis 20 ans.\", 0),\n" +
            "(22, \"Blade Runner: 2049\", 2017, \"En 2049, la société est fragilisée par les nombreuses tensions entre les humains et leurs esclaves créés par bioingénierie. L\'officier K est un Blade Runner : il fait partie d\'une force d\'intervention d\'élite chargée de trouver et d\'éliminer ceux qui n\'obéissent pas aux ordres des humains. Lorsqu\'il découvre un secret enfoui depuis longtemps et capable de changer le monde, les plus hautes instances décident que c\'est à son tour d\'être traqué et éliminé.\", 0),\n" +
            "(23, \"Ex Machina\", 2015, \"À 26 ans, Caleb est un des plus brillants codeurs que compte BlueBook, le plus important moteur de recherche Internet au monde. À ce titre, il remporte un séjour d\'une semaine dans la résidence du grand patron à la montagne. Quand il arrive dans la demeure isolée, il découvre qu\'il va devoir participer à une expérience troublante : interagir avec le représentant d\'une nouvelle intelligence artificielle apparaissant sous les traits d\'une très jolie femme robot prénommée Ava.\", 0),\n" +
            "(24, \"Minority Report\", 2002, \"En 2054, la société du futur a éradiqué les crimes en se dotant d\'un système de prévention, détection et répression le plus sophistiqué du monde. Dissimulés de tous, trois extras-lucides transmettent les images des crimes à venir aux policiers de la Précrime. Cependant, un jour, John, le chef de brigade, reçoit l\'impossible : sa propre image assassinant un inconnu. Démarre alors une course contre la montre pour prouver son innocence.\", 0);\n";

    private String insertParticipe = "INSERT INTO `participe` (`id`, `id_Film`, `id_role`) VALUES\n" +
            "(2, 1, 2),\n" +
            "(20, 1, 1),\n" +
            "(21, 1, 1),\n" +
            "(22, 1, 1),\n" +
            "(23, 1, 1),\n" +
            "(24, 1, 1),\n" +
            "(25, 1, 1),\n" +
            "(1, 2, 2),\n" +
            "(26, 2, 1),\n" +
            "(27, 2, 1),\n" +
            "(28, 2, 1),\n" +
            "(29, 2, 1),\n" +
            "(30, 2, 1),\n" +
            "(31, 2, 1),\n" +
            "(3, 3, 2),\n" +
            "(32, 3, 1),\n" +
            "(33, 3, 1),\n" +
            "(34, 3, 1),\n" +
            "(35, 3, 1),\n" +
            "(36, 3, 1),\n" +
            "(37, 3, 1),\n" +
            "(4, 4, 2),\n" +
            "(38, 4, 1),\n" +
            "(39, 4, 1),\n" +
            "(40, 4, 1),\n" +
            "(41, 4, 1),\n" +
            "(42, 4, 1),\n" +
            "(4, 5, 2),\n" +
            "(38, 5, 1),\n" +
            "(39, 5, 1),\n" +
            "(40, 5, 1),\n" +
            "(41, 5, 1),\n" +
            "(43, 5, 1),\n" +
            "(44, 5, 1),\n" +
            "(4, 6, 2),\n" +
            "(38, 6, 1),\n" +
            "(39, 6, 1),\n" +
            "(40, 6, 1),\n" +
            "(41, 6, 1),\n" +
            "(45, 6, 1),\n" +
            "(5, 7, 2),\n" +
            "(46, 7, 1),\n" +
            "(47, 7, 1),\n" +
            "(48, 7, 1),\n" +
            "(49, 7, 1),\n" +
            "(6, 8, 2),\n" +
            "(50, 8, 1),\n" +
            "(51, 8, 1),\n" +
            "(52, 8, 1),\n" +
            "(53, 8, 1),\n" +
            "(54, 8, 1),\n" +
            "(55, 8, 1),\n" +
            "(56, 8, 1),\n" +
            "(7, 9, 2),\n" +
            "(57, 9, 1),\n" +
            "(58, 9, 1),\n" +
            "(59, 9, 1),\n" +
            "(60, 9, 1),\n" +
            "(61, 9, 1),\n" +
            "(62, 9, 1),\n" +
            "(8, 10, 2),\n" +
            "(39, 10, 1),\n" +
            "(63, 10, 1),\n" +
            "(64, 10, 1),\n" +
            "(65, 10, 1),\n" +
            "(9, 11, 2),\n" +
            "(66, 11, 1),\n" +
            "(69, 11, 1),\n" +
            "(70, 11, 1),\n" +
            "(71, 11, 1),\n" +
            "(10, 12, 2),\n" +
            "(67, 12, 1),\n" +
            "(68, 12, 1),\n" +
            "(72, 12, 1),\n" +
            "(11, 13, 2),\n" +
            "(73, 13, 1),\n" +
            "(74, 13, 1),\n" +
            "(75, 13, 1),\n" +
            "(76, 13, 1),\n" +
            "(3, 14, 2),\n" +
            "(77, 14, 1),\n" +
            "(78, 14, 1),\n" +
            "(79, 14, 1),\n" +
            "(80, 14, 1),\n" +
            "(81, 14, 1),\n" +
            "(12, 15, 2),\n" +
            "(22, 15, 1),\n" +
            "(25, 15, 1),\n" +
            "(82, 15, 1),\n" +
            "(83, 15, 1),\n" +
            "(84, 15, 1),\n" +
            "(85, 15, 1),\n" +
            "(13, 16, 2),\n" +
            "(36, 16, 1),\n" +
            "(86, 16, 1),\n" +
            "(87, 16, 1),\n" +
            "(14, 17, 2),\n" +
            "(88, 17, 1),\n" +
            "(89, 17, 1),\n" +
            "(90, 17, 1),\n" +
            "(91, 17, 1),\n" +
            "(15, 18, 2),\n" +
            "(92, 18, 1),\n" +
            "(93, 18, 1),\n" +
            "(94, 18, 1),\n" +
            "(12, 19, 2),\n" +
            "(59, 19, 1),\n" +
            "(95, 19, 1),\n" +
            "(96, 19, 1),\n" +
            "(97, 19, 1),\n" +
            "(98, 19, 1),\n" +
            "(99, 19, 1),\n" +
            "(16, 20, 2),\n" +
            "(100, 20, 1),\n" +
            "(101, 20, 1),\n" +
            "(102, 20, 1),\n" +
            "(103, 20, 1),\n" +
            "(17, 21, 2),\n" +
            "(100, 21, 1),\n" +
            "(101, 21, 1),\n" +
            "(104, 21, 1),\n" +
            "(105, 21, 1),\n" +
            "(106, 21, 1),\n" +
            "(18, 22, 2),\n" +
            "(59, 22, 1),\n" +
            "(107, 22, 1),\n" +
            "(108, 22, 1),\n" +
            "(109, 22, 1),\n" +
            "(110, 22, 1),\n" +
            "(111, 22, 1),\n" +
            "(112, 22, 1),\n" +
            "(113, 22, 1),\n" +
            "(114, 22, 1),\n" +
            "(115, 22, 1),\n" +
            "(19, 23, 2),\n" +
            "(116, 23, 1),\n" +
            "(117, 23, 1),\n" +
            "(118, 23, 1),\n" +
            "(1, 24, 2),\n" +
            "(119, 24, 1),\n" +
            "(120, 24, 1),\n" +
            "(121, 24, 1),\n" +
            "(122, 24, 1),\n" +
            "(123, 24, 1);";

    private String insertPersonne = "\n" +
            "INSERT INTO `Personne` (`id`, `nom`, `prenom`) VALUES\n" +
            "(1, \"Spielberg\", \"Steven\"),\n" +
            "(2, \"Nolan\", \"Christopher\"),\n" +
            "(3, \"Besson\", \"Luc\"),\n" +
            "(4, \"Wachowski\", \"Les\"),\n" +
            "(5, \"Stanton\", \"Andrew\"),\n" +
            "(6, \"Proyas\", \"Alex\"),\n" +
            "(7, \"Hood\", \"Gavin\"),\n" +
            "(8, \"Tyldum\", \"Morten\"),\n" +
            "(9, \"Columbus\", \"Chris\"),\n" +
            "(10, \"Chrichton\", \"Michael\"),\n" +
            "(11, \"Fleischer\", \"Richard\"),\n" +
            "(12, \"Scott\", \"Ridley\"),\n" +
            "(13, \"Niccol\", \"Andrew\"),\n" +
            "(14, \"Jonze\", \"Spike\"),\n" +
            "(15, \"Wirkola\", \"Tommy\"),\n" +
            "(16, \"Lisberger\", \"Steven\"),\n" +
            "(17, \"Kosinski\", \"Joseph\"),\n" +
            "(18, \"Villeneuve\", \"Denis\"),\n" +
            "(19, \"Garland\", \"Alex\"),\n" +
            "(20, \"McConaughey\", \"Matthew\"),\n" +
            "(21, \"Hathaway\", \"Anne\"),\n" +
            "(22, \"Chastain\", \"Jessica\"),\n" +
            "(23, \"Caine\", \"Michael\"),\n" +
            "(24, \"Affleck\", \"Casey\"),\n" +
            "(25, \"Damon\", \"Matt\"),\n" +
            "(26, \"Sheridan\", \"Tye\"),\n" +
            "(27, \"Cooke\", \"Olivia\"),\n" +
            "(28, \"Mendelsohn\", \"Ben\"),\n" +
            "(29, \"Pegg\", \"Simon\"),\n" +
            "(30, \"Rylance\", \"Mark\"),\n" +
            "(31, \"Waithe\", \"Lena\"),\n" +
            "(32, \"Dehaan\", \"Dane\"),\n" +
            "(33, \"Delevingne\", \"Cara\"),\n" +
            "(34, \"Owen\", \"Clive\"),\n" +
            "(35, NULL, \"Rihanna\"),\n" +
            "(36, \"Hawke\", \"Ethan\"),\n" +
            "(37, \"Hancock\", \"Herbie\"),\n" +
            "(38, \"Reeves\", \"Keanu\"),\n" +
            "(39, \"Fishburne\", \"Laurence\"),\n" +
            "(40, \"Moss\", \"Carrie-Anne\"),\n" +
            "(41, \"Weaving\", \"Hugo\"),\n" +
            "(42, \"Pantoliano\", \"Joe\"),\n" +
            "(43, \"Bernhardt\", \"Daniel\"),\n" +
            "(44, \"Wilson\", \"Lambert\"),\n" +
            "(45, \"Pinkett Smith\", \"Jada\"),\n" +
            "(46, \"Ratzenberger\", \"John\"),\n" +
            "(47, \"Najimy\", \"Kathy\"),\n" +
            "(48, \"Weaver\", \"Sigourney\"),\n" +
            "(49, \"Burtt\", \"Ben\"),\n" +
            "(50, \"Smith\", \"Will\"),\n" +
            "(51, \"Tudyk\", \"Alan\"),\n" +
            "(52, \"Moynahan\", \"Bridget\"),\n" +
            "(53, \"McBride\", \"Chi\"),\n" +
            "(54, \"Greenwood\", \"Bruce\"),\n" +
            "(55, \"Cromwell\", \"James\"),\n" +
            "(56, \"LaBeouf\", \"Shia\"),\n" +
            "(57, \"Butterfield\", \"Asa\"),\n" +
            "(58, \"Breslin\", \"Abigail\"),\n" +
            "(59, \"Ford\", \"Harrison\"),\n" +
            "(60, \"Steinfeld\", \"Hailee\"),\n" +
            "(61, \"Davis\", \"Viola\"),\n" +
            "(62, \"Kingsley\", \"Ben\"),\n" +
            "(63, \"Lawrence\", \"Jennifer\"),\n" +
            "(64, \"Pratt\", \"Chris\"),\n" +
            "(65, \"Sheen\", \"Michael\"),\n" +
            "(66, \"Williams\", \"Robin\"),\n" +
            "(67, \"Benjamin\", \"Richard\"),\n" +
            "(68, \"Brolin\", \"James\"),\n" +
            "(69, \"Davidtz\", \"Embeth\"),\n" +
            "(70, \"Neill\", \"Sam\"),\n" +
            "(71, \"Platt\", \"Oliver\"),\n" +
            "(72, \"Brynner\", \"Yul\"),\n" +
            "(73, \"Heston\", \"Charlton\"),\n" +
            "(74, \"Taylor-Young\", \"Leigh\"),\n" +
            "(75, \"Robinson\", \"Edward G.\"),\n" +
            "(76, \"Connors\", \"Chuck\"),\n" +
            "(77, \"Willis\", \"Bruce\"),\n" +
            "(78, \"Jovovich\", \"Milla\"),\n" +
            "(79, \"Oldman\", \"Gary\"),\n" +
            "(80, \"Holm\", \"Ian\"),\n" +
            "(81, \"Tucker\", \"Chris\"),\n" +
            "(82, \"Wiig\", \"Kristen\"),\n" +
            "(83, \"Stan\", \"Sebastian\"),\n" +
            "(84, \"Bean\", \"Sean\"),\n" +
            "(85, \"Peña\", \"Michael\"),\n" +
            "(86, \"Thurman\", \"Uma\"),\n" +
            "(87, \"Law\", \"Jude\"),\n" +
            "(88, \"Phoenix\", \"Joaquin\"),\n" +
            "(89, \"Johansson\", \"Scarlett\"),\n" +
            "(90, \"Adams\", \"Amy\"),\n" +
            "(91, \"Mara\", \"Rooney\"),\n" +
            "(92, \"Rapace\", \"Noomi\"),\n" +
            "(93, \"Close\", \"Glenn\"),\n" +
            "(94, \"Dafoe\", \"Willem\"),\n" +
            "(95, \"Hauer\", \"Rutger\"),\n" +
            "(96, \"Young\", \"Sean\"),\n" +
            "(97, \"Walsh\", \"Emmet\"),\n" +
            "(98, \"Olmos\", \"Edward James\"),\n" +
            "(99, \"Hannah\", \"Daryl\"),\n" +
            "(100, \"Bridges\", \"Jeff\"),\n" +
            "(101, \"Boxleitner\", \"Bruce\"),\n" +
            "(102, \"Warner\", \"David\"),\n" +
            "(103, \"Morgan\", \"Cindy\"),\n" +
            "(104, \"Hedlund\", \"Garrett\"),\n" +
            "(105, \"Wilde\", \"Olivia\"),\n" +
            "(106, \"Garrett\", \"Beau\"),\n" +
            "(107, \"Gosling\", \"Ryan\"),\n" +
            "(108, \"de Armas\", \"Ana\"),\n" +
            "(109, \"Wright\", \"Robin\"),\n" +
            "(110, \"Hoeks\", \"Sylvia\"),\n" +
            "(111, \"Davis\", \"Mackenzie\"),\n" +
            "(112, \"Juri\", \"Carla\"),\n" +
            "(113, \"James\", \"Lennie\"),\n" +
            "(114, \"Bautista\", \"David\"),\n" +
            "(115, \"Leto\", \"Jared\"),\n" +
            "(116, \"Isaac\", \"Oscar\"),\n" +
            "(117, \"Vikander\", \"Alicia\"),\n" +
            "(118, \"Gleeson\", \"Domhnall\"),\n" +
            "(119, \"Cruise\", \"Tom\"),\n" +
            "(120, \"Farrell\", \"Colin\"),\n" +
            "(121, \"Von Sydow\", \"Max\"),\n" +
            "(122, \"Morton\", \"Samantha\"),\n" +
            "(123, \"Morris\", \"Kathryn\");";

    private String insertRole = "INSERT INTO `Role` (`id`, `libelle`) VALUES\n" +
            "(1, \"acteur\"),\n" +
            "(2, \"réalisateur\");";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(film);
        sqLiteDatabase.execSQL(personne);
        sqLiteDatabase.execSQL(role);
        sqLiteDatabase.execSQL(avis);
        sqLiteDatabase.execSQL(participe);
        sqLiteDatabase.execSQL(insertFilm);
        sqLiteDatabase.execSQL(insertParticipe);
        sqLiteDatabase.execSQL(insertPersonne);
        sqLiteDatabase.execSQL(insertRole);
    }

    /**
     * Called when update database to newer version
     * @param sqLiteDatabase
     * @param i old version number
     * @param i1 new version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
