import javax.swing.ImageIcon;
import outils.OutilsComposants;
import java.util.Random;
import javax.swing.Icon;

        
public class Master extends javax.swing.JFrame {

     // Indices des images pour les différents labels
    private int currentImageIndex88 = 0;
    private int currentImageIndex86 = 0;
    private int currentImageIndex87 = 0;
    private int currentImageIndex85 = 0;
    
    
    // Chemin des images pour les couleurs possibles (jeu et vérification)
     private String[] imagePaths2 = {
        "Color2/jaune.png",
        "Color2/Bleu.png",
        "Color2/Rouge.png",
        "Color2/Noir.png",
        "Color2/Rose.png",
        "Color2/Vert.png",
        "Color2/Blanc.png",
        "Color2/Violet.png"
     };
    
   
    private String[] imagePaths = {
        "Color/jaune.png",
        "Color/Bleu.png",
        "Color/Rouge.png",
        "Color/Noir.png",
        "Color/Rose.png",
        "Color/Vert.png",
        "Color/Blanc.png",
        "Color/Violet.png"
    };

        // Tableaux pour stocker les composants du jeu
      private javax.swing.JLabel[][] jStock = new javax.swing.JLabel[10][4];     
      private javax.swing.JLabel[] jResultat = new javax.swing.JLabel[4];    
      private javax.swing.JLabel[] jcouleur = new javax.swing.JLabel[4];    
      private javax.swing.JLabel[][] verifR = new javax.swing.JLabel[10][4];
      
    
     // Constructeur de la classe Master
    public Master() {
        initComponents(); 
        DefTaille();
        initialisationdejcouleur();
        initialisationLabels();
        jResultat();
        genererLeSecret();
        Dialogue();
        verifR();       
        jResultat[0].setVisible(false);
        jResultat[1].setVisible(false);
        jResultat[2].setVisible(false);
        jResultat[3].setVisible(false);
    }
    
    // Définit la taille et la position de la fenêtre principale
    private void DefTaille() {
        setSize(603, 750);
        setLocationRelativeTo(null); // Pour centrer la fenêtre
    }
    
     // Initialise les boîtes de dialogue avec des animations GIF
    private void Dialogue() {
    
    ImageIcon gifIcon = new ImageIcon(getClass().getResource("Gif/Gifeux.gif"));
    jGif0.setIcon(gifIcon);
    
        jDialog1.setSize(554, 400);
        jDialog1.setResizable(false);
        jDialog1.setLocationRelativeTo(null); 
        
     ImageIcon gifIcon0 = new ImageIcon(getClass().getResource("Gif/Gifeux2.gif"));
     jGif1.setIcon(gifIcon0);
        
        jDialog2.setSize(564, 481);
        jDialog2.setResizable(false);
        jDialog2.setLocationRelativeTo(null); 
        
        jDialog3.setSize(925, 903);
        jDialog3.setResizable(false);
        jDialog3.setLocationRelativeTo(null); 
    }
    
     // Réinitialise le jeu pour une nouvelle manche
    private void restartRound() {
    currentRow = 0; // Réinitialisation de la ligne actuelle
    
   ImageIcon blancIcon = new ImageIcon(getClass().getResource("Color/blanc.png"));
   ImageIcon blancIcon2 = new ImageIcon(getClass().getResource("Color2/blanc.png"));
   
    // Réinitialise les résultats cachés
    for (int i = 0; i < jResultat.length; i++) {
        jResultat[i].setVisible(false);
        jResultat[i].setIcon(blancIcon);
    }

    // Réinitialise la grille du jeu
    for (int i = 0; i < jStock.length; i++) {
        for (int j = 0; j < jStock[i].length; j++) {
            jStock[i][j].setIcon(blancIcon); // Met une icône blanche
        }
    }

    // Réinitialise les vérifications
    for (int i = 0; i < verifR.length; i++) {
        for (int j = 0; j < verifR[i].length; j++) {
            verifR[i][j].setIcon(blancIcon2); // Met une icône blanche
        }
    }

    // Réinitialise les choix du joueur
    for (int i = 0; i < jcouleur.length; i++) {
        jcouleur[i].setIcon(blancIcon);
}

     // Réactiver le bouton pour jouer un nouveau tour
     jButton1.setEnabled(true);
    
     // Générer un nouveau code secret
     genererLeSecret();
     jDialog1.setVisible(false);
     jDialog2.setVisible(false);

}
    
      private int currentRow = 0; 

     private void jResultat() {
        jResultat[0] = jlabel100;
        jResultat[1] = jLabel101;      
        jResultat[2] = jLabel102;
        jResultat[3] = jLabel103;  

     } 

      // Génère un code secret aléatoire
      public void genererLeSecret() {
        Random random = new Random();

        for (int j = 0; j < 4; j++) {
            int randomIndex = random.nextInt(imagePaths.length); 
            ImageIcon icon = new ImageIcon(getClass().getResource(imagePaths[randomIndex]));
            jResultat[j].setIcon(icon); 
        }
    }
      
      private int getIndexFromIcon(Icon icon) {

    for (int i = 0; i < imagePaths.length; i++) {
        Icon testIcon = new ImageIcon(getClass().getResource(imagePaths[i]));
        if (icon.toString().equals(testIcon.toString())) {
            return i;
        }
    }
    return -1; // Retourne -1 si l'icône n'est pas trouvée
}

    // Vérifie si une couleur est dans le code secret
    private boolean containsIndex(int indexStock, int[] secretIndices) {
    for (int secretIndex : secretIndices) {
        if (secretIndex == indexStock) {
            return true; 
        }
    }
    return false; 
}


      // Initialisation des labels pour le choix des couleurs
      private void initialisationdejcouleur() {

        jcouleur[0] = jLabel85;
        jcouleur[1] = jLabel86;      
        jcouleur[2] = jLabel87;
        jcouleur[3] = jLabel88; 
        }
      
      // Initialisation des labels de la grille du jeu
      private void initialisationLabels() {
          
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                jStock[i][j] = OutilsComposants.getLabelByName(this, "jStock" + i + j);
                if (verifR[i][j] == null) {
                    System.err.println("verifR[" + i + "][" + j + "] est null !");
                }
            }
        }
      


    }
      
       // Initialisation des labels indices
       private void verifR() {
      
          for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                verifR[i][j] = OutilsComposants.getLabelByName(this, "verifR" + i + j);
                if (verifR[i][j] == null) {
                    System.err.println("verifR[" + i + "][" + j + "] est null !");
                }
            }
        }
      


    }
    
      
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jQuitter = new javax.swing.JButton();
        jLabel0 = new javax.swing.JLabel();
        jRecommencer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jGif0 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jQuitter2 = new javax.swing.JButton();
        jLabe2 = new javax.swing.JLabel();
        jRecommencer2 = new javax.swing.JButton();
        jLabe1 = new javax.swing.JLabel();
        jGif1 = new javax.swing.JLabel();
        jLabe3 = new javax.swing.JLabel();
        jDialog3 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jGuide1 = new javax.swing.JTextArea();
        jQuitter3 = new java.awt.Button();
        jStock02 = new javax.swing.JLabel();
        jStock03 = new javax.swing.JLabel();
        jStock01 = new javax.swing.JLabel();
        jStock00 = new javax.swing.JLabel();
        jStock12 = new javax.swing.JLabel();
        jStock13 = new javax.swing.JLabel();
        jStock11 = new javax.swing.JLabel();
        jStock10 = new javax.swing.JLabel();
        jStock30 = new javax.swing.JLabel();
        jStock22 = new javax.swing.JLabel();
        jStock23 = new javax.swing.JLabel();
        jStock21 = new javax.swing.JLabel();
        jStock20 = new javax.swing.JLabel();
        jStock32 = new javax.swing.JLabel();
        jStock33 = new javax.swing.JLabel();
        jStock31 = new javax.swing.JLabel();
        jStock50 = new javax.swing.JLabel();
        jStock70 = new javax.swing.JLabel();
        jStock62 = new javax.swing.JLabel();
        jStock63 = new javax.swing.JLabel();
        jStock61 = new javax.swing.JLabel();
        jStock60 = new javax.swing.JLabel();
        jStock72 = new javax.swing.JLabel();
        jStock73 = new javax.swing.JLabel();
        jStock71 = new javax.swing.JLabel();
        jStock42 = new javax.swing.JLabel();
        jStock43 = new javax.swing.JLabel();
        jStock41 = new javax.swing.JLabel();
        jStock40 = new javax.swing.JLabel();
        jStock52 = new javax.swing.JLabel();
        jStock53 = new javax.swing.JLabel();
        jStock51 = new javax.swing.JLabel();
        jStock90 = new javax.swing.JLabel();
        jStock82 = new javax.swing.JLabel();
        jStock83 = new javax.swing.JLabel();
        jStock81 = new javax.swing.JLabel();
        jStock80 = new javax.swing.JLabel();
        jStock92 = new javax.swing.JLabel();
        jStock93 = new javax.swing.JLabel();
        jStock91 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        verifR03 = new javax.swing.JLabel();
        verifR00 = new javax.swing.JLabel();
        verifR01 = new javax.swing.JLabel();
        verifR02 = new javax.swing.JLabel();
        verifR13 = new javax.swing.JLabel();
        verifR10 = new javax.swing.JLabel();
        verifR11 = new javax.swing.JLabel();
        verifR12 = new javax.swing.JLabel();
        verifR23 = new javax.swing.JLabel();
        verifR20 = new javax.swing.JLabel();
        verifR21 = new javax.swing.JLabel();
        verifR22 = new javax.swing.JLabel();
        verifR33 = new javax.swing.JLabel();
        verifR30 = new javax.swing.JLabel();
        verifR31 = new javax.swing.JLabel();
        verifR32 = new javax.swing.JLabel();
        verifR43 = new javax.swing.JLabel();
        verifR40 = new javax.swing.JLabel();
        verifR41 = new javax.swing.JLabel();
        verifR42 = new javax.swing.JLabel();
        verifR53 = new javax.swing.JLabel();
        verifR50 = new javax.swing.JLabel();
        verifR51 = new javax.swing.JLabel();
        verifR52 = new javax.swing.JLabel();
        verifR63 = new javax.swing.JLabel();
        verifR60 = new javax.swing.JLabel();
        verifR61 = new javax.swing.JLabel();
        verifR62 = new javax.swing.JLabel();
        verifR73 = new javax.swing.JLabel();
        verifR70 = new javax.swing.JLabel();
        verifR71 = new javax.swing.JLabel();
        verifR72 = new javax.swing.JLabel();
        verifR83 = new javax.swing.JLabel();
        verifR80 = new javax.swing.JLabel();
        verifR81 = new javax.swing.JLabel();
        verifR82 = new javax.swing.JLabel();
        verifR93 = new javax.swing.JLabel();
        verifR90 = new javax.swing.JLabel();
        verifR91 = new javax.swing.JLabel();
        verifR92 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlabel100 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jGuide0 = new javax.swing.JLabel();

        jDialog1.setIconImage(null);
        jDialog1.setIconImages(null);

        jQuitter.setText("Quitter");
        jQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuitterActionPerformed(evt);
            }
        });

        jLabel0.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel0.setText("Bravo !!");

        jRecommencer.setText("Recommencer");
        jRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecommencerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabel1.setText("Vous avez Réussi");

        jGif0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gif/Gifeux.gif"))); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRecommencer)
                .addGap(75, 75, 75))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel0, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addComponent(jGif0)
                        .addGap(27, 27, 27))))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jGif0, javax.swing.GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuitter)
                    .addComponent(jRecommencer))
                .addGap(41, 41, 41))
        );

        jQuitter2.setText("Quitter");
        jQuitter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuitter2ActionPerformed(evt);
            }
        });

        jLabe2.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabe2.setText("Dommage");

        jRecommencer2.setText("Recommencer");
        jRecommencer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecommencer2ActionPerformed(evt);
            }
        });

        jLabe1.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        jLabe1.setText("Vous avez Perdu...");

        jGif1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gif/Gifeux2.gif"))); // NOI18N

        jLabe3.setFont(new java.awt.Font("Segoe Script", 0, 14)); // NOI18N
        jLabe3.setText("Ne vous découragez pas ! quitter -_- ou alors retentez votre chance ^_^ ");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jQuitter2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRecommencer2)
                .addGap(55, 55, 55))
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabe3))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jGif1))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabe1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabe2)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addComponent(jLabe2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabe1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGif1)
                .addGap(22, 22, 22)
                .addComponent(jLabe3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuitter2)
                    .addComponent(jRecommencer2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jGuide1.setColumns(20);
        jGuide1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jGuide1.setRows(5);
        jGuide1.setText("Déroulement du Jeu :\n\nLancement du jeu :\n\nAu démarrage, un code secret de 4 couleurs est généré aléatoirement et caché au joueur.\nLe joueur peut voir une grille de 10 lignes et 4 colonnes où il va faire ses tentatives.\n\nSélection des couleurs :\n\nLe joueur peut cliquer sur les 4 emplacements disponibles en bas de l'écran pour changer les couleurs.\nÀ chaque clic gauche sur une case, la couleur change dans l'ordre défini (jaune → bleu → rouge → etc.).\n\nValidation de la proposition :\n\nUne fois les 4 couleurs choisies, le joueur clique sur le bouton \"Valider\" pour soumettre sa combinaison.\nLa combinaison choisie est alors enregistrée dans la grille.\n\nIndication de correction :\n\nAprès validation, des indices s'affichent dans une zone de vérification :\n\nVert : Une couleur est bien placée.\nJaune : Une couleur est correcte mais mal placée.\nRouge : Une couleur n’est pas dans le code secret.\n\nSuite des essais :\n\nLe joueur répète le processus en ajustant ses choix en fonction des indices fournis.\nIl continue ainsi jusqu'à trouver la bonne combinaison ou atteindre la limite de 10 tentatives.\n\nConditions de fin de partie :\n\nVictoire : Si le joueur trouve la bonne combinaison avant la 10ᵉ tentative, un message de victoire apparaît.\nDéfaite : Si le joueur dépasse les 10 essais sans trouver la bonne combinaison, \nle jeu affiche un message de défaite et révèle le code secret.\nAutres Options :\n\nRejouer : Après une victoire ou une défaite, le joueur peut recommencer une nouvelle partie en cliquant sur \"Recommencer\".\nQuitter : Le joueur peut fermer le jeu à tout moment en cliquant sur \"Quitter\".\n\nBonne chance et amusez-vous bien ! ^^");
        jScrollPane1.setViewportView(jGuide1);

        jQuitter3.setLabel("Quitter");
        jQuitter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuitter3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jQuitter3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jQuitter3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jStock02.setBackground(new java.awt.Color(255, 255, 255));
        jStock02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock02.setText("Color 3");

        jStock03.setBackground(new java.awt.Color(255, 255, 255));
        jStock03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock03.setText("Color 4");

        jStock01.setBackground(new java.awt.Color(255, 255, 255));
        jStock01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock01.setText("Color 2");

        jStock00.setBackground(new java.awt.Color(255, 255, 255));
        jStock00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock00.setText("Color 1");

        jStock12.setBackground(new java.awt.Color(255, 255, 255));
        jStock12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock12.setText("jLabel1");

        jStock13.setBackground(new java.awt.Color(255, 255, 255));
        jStock13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock13.setText("jLabel1");

        jStock11.setBackground(new java.awt.Color(255, 255, 255));
        jStock11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock11.setText("jLabel1");

        jStock10.setBackground(new java.awt.Color(255, 255, 255));
        jStock10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock10.setText("jLabel1");

        jStock30.setBackground(new java.awt.Color(255, 255, 255));
        jStock30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock30.setText("jLabel1");

        jStock22.setBackground(new java.awt.Color(255, 255, 255));
        jStock22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock22.setText("jLabel1");

        jStock23.setBackground(new java.awt.Color(255, 255, 255));
        jStock23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock23.setText("jLabel1");

        jStock21.setBackground(new java.awt.Color(255, 255, 255));
        jStock21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock21.setText("jLabel1");

        jStock20.setBackground(new java.awt.Color(255, 255, 255));
        jStock20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock20.setText("jLabel1");

        jStock32.setBackground(new java.awt.Color(255, 255, 255));
        jStock32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock32.setText("jLabel1");

        jStock33.setBackground(new java.awt.Color(255, 255, 255));
        jStock33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock33.setText("jLabel1");

        jStock31.setBackground(new java.awt.Color(255, 255, 255));
        jStock31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock31.setText("jLabel1");

        jStock50.setBackground(new java.awt.Color(255, 255, 255));
        jStock50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock50.setText("jLabel1");

        jStock70.setBackground(new java.awt.Color(255, 255, 255));
        jStock70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock70.setText("jLabel1");

        jStock62.setBackground(new java.awt.Color(255, 255, 255));
        jStock62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock62.setText("jLabel1");

        jStock63.setBackground(new java.awt.Color(255, 255, 255));
        jStock63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock63.setText("jLabel1");

        jStock61.setBackground(new java.awt.Color(255, 255, 255));
        jStock61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock61.setText("jLabel1");

        jStock60.setBackground(new java.awt.Color(255, 255, 255));
        jStock60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock60.setText("jLabel1");

        jStock72.setBackground(new java.awt.Color(255, 255, 255));
        jStock72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock72.setText("jLabel1");

        jStock73.setBackground(new java.awt.Color(255, 255, 255));
        jStock73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock73.setText("jLabel1");

        jStock71.setBackground(new java.awt.Color(255, 255, 255));
        jStock71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock71.setText("jLabel1");

        jStock42.setBackground(new java.awt.Color(255, 255, 255));
        jStock42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock42.setText("jLabel1");

        jStock43.setBackground(new java.awt.Color(255, 255, 255));
        jStock43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock43.setText("jLabel1");

        jStock41.setBackground(new java.awt.Color(255, 255, 255));
        jStock41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock41.setText("jLabel1");

        jStock40.setBackground(new java.awt.Color(255, 255, 255));
        jStock40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock40.setText("jLabel1");

        jStock52.setBackground(new java.awt.Color(255, 255, 255));
        jStock52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock52.setText("jLabel1");

        jStock53.setBackground(new java.awt.Color(255, 255, 255));
        jStock53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock53.setText("jLabel1");

        jStock51.setBackground(new java.awt.Color(255, 255, 255));
        jStock51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock51.setText("jLabel1");

        jStock90.setBackground(new java.awt.Color(255, 255, 255));
        jStock90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock90.setText("jLabel1");

        jStock82.setBackground(new java.awt.Color(255, 255, 255));
        jStock82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock82.setText("jLabel1");

        jStock83.setBackground(new java.awt.Color(255, 255, 255));
        jStock83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock83.setText("jLabel1");

        jStock81.setBackground(new java.awt.Color(255, 255, 255));
        jStock81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock81.setText("jLabel1");

        jStock80.setBackground(new java.awt.Color(255, 255, 255));
        jStock80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock80.setText("jLabel1");

        jStock92.setBackground(new java.awt.Color(255, 255, 255));
        jStock92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock92.setText("jLabel1");

        jStock93.setBackground(new java.awt.Color(255, 255, 255));
        jStock93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock93.setText("jLabel1");

        jStock91.setBackground(new java.awt.Color(255, 255, 255));
        jStock91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jStock91.setText("jLabel1");

        jLabel85.setBackground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel85.setText("jLabel1");
        jLabel85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel85MouseClicked(evt);
            }
        });

        jLabel86.setBackground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel86.setText("jLabel1");
        jLabel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel86MouseClicked(evt);
            }
        });

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel87.setText("jLabel1");
        jLabel87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel87MouseClicked(evt);
            }
        });

        jLabel88.setBackground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel88.setText("jLabel1");
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });

        verifR03.setBackground(new java.awt.Color(255, 255, 255));
        verifR03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR03.setText("jLabel1");

        verifR00.setBackground(new java.awt.Color(255, 255, 255));
        verifR00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR00.setText("jLabel1");

        verifR01.setBackground(new java.awt.Color(255, 255, 255));
        verifR01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR01.setText("jLabel1");

        verifR02.setBackground(new java.awt.Color(255, 255, 255));
        verifR02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR02.setText("jLabel1");

        verifR13.setBackground(new java.awt.Color(255, 255, 255));
        verifR13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR13.setText("jLabel1");

        verifR10.setBackground(new java.awt.Color(255, 255, 255));
        verifR10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR10.setText("jLabel1");

        verifR11.setBackground(new java.awt.Color(255, 255, 255));
        verifR11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR11.setText("jLabel1");

        verifR12.setBackground(new java.awt.Color(255, 255, 255));
        verifR12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR12.setText("jLabel1");

        verifR23.setBackground(new java.awt.Color(255, 255, 255));
        verifR23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR23.setText("jLabel1");
        verifR23.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR23.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR23.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR23.setVerifyInputWhenFocusTarget(false);

        verifR20.setBackground(new java.awt.Color(255, 255, 255));
        verifR20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR20.setText("jLabel1");
        verifR20.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR20.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR20.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR20.setVerifyInputWhenFocusTarget(false);

        verifR21.setBackground(new java.awt.Color(255, 255, 255));
        verifR21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR21.setText("jLabel1");
        verifR21.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR21.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR21.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR21.setVerifyInputWhenFocusTarget(false);

        verifR22.setBackground(new java.awt.Color(255, 255, 255));
        verifR22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR22.setText("jLabel1");
        verifR22.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR22.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR22.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR22.setVerifyInputWhenFocusTarget(false);

        verifR33.setBackground(new java.awt.Color(255, 255, 255));
        verifR33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR33.setText("jLabel1");
        verifR33.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR33.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR33.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR33.setVerifyInputWhenFocusTarget(false);

        verifR30.setBackground(new java.awt.Color(255, 255, 255));
        verifR30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR30.setText("jLabel1");
        verifR30.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR30.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR30.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR30.setVerifyInputWhenFocusTarget(false);

        verifR31.setBackground(new java.awt.Color(255, 255, 255));
        verifR31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR31.setText("jLabel1");
        verifR31.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR31.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR31.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR31.setVerifyInputWhenFocusTarget(false);

        verifR32.setBackground(new java.awt.Color(255, 255, 255));
        verifR32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR32.setText("jLabel1");
        verifR32.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR32.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR32.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR32.setVerifyInputWhenFocusTarget(false);

        verifR43.setBackground(new java.awt.Color(255, 255, 255));
        verifR43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR43.setText("jLabel1");
        verifR43.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR43.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR43.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR43.setVerifyInputWhenFocusTarget(false);

        verifR40.setBackground(new java.awt.Color(255, 255, 255));
        verifR40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR40.setText("jLabel1");
        verifR40.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR40.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR40.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR40.setVerifyInputWhenFocusTarget(false);

        verifR41.setBackground(new java.awt.Color(255, 255, 255));
        verifR41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR41.setText("jLabel1");
        verifR41.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR41.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR41.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR41.setVerifyInputWhenFocusTarget(false);

        verifR42.setBackground(new java.awt.Color(255, 255, 255));
        verifR42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR42.setText("jLabel1");
        verifR42.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR42.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR42.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR42.setVerifyInputWhenFocusTarget(false);

        verifR53.setBackground(new java.awt.Color(255, 255, 255));
        verifR53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR53.setText("jLabel1");
        verifR53.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR53.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR53.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR53.setVerifyInputWhenFocusTarget(false);

        verifR50.setBackground(new java.awt.Color(255, 255, 255));
        verifR50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR50.setText("jLabel1");
        verifR50.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR50.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR50.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR50.setVerifyInputWhenFocusTarget(false);

        verifR51.setBackground(new java.awt.Color(255, 255, 255));
        verifR51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR51.setText("jLabel1");
        verifR51.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR51.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR51.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR51.setVerifyInputWhenFocusTarget(false);

        verifR52.setBackground(new java.awt.Color(255, 255, 255));
        verifR52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR52.setText("jLabel1");
        verifR52.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR52.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR52.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR52.setVerifyInputWhenFocusTarget(false);

        verifR63.setBackground(new java.awt.Color(255, 255, 255));
        verifR63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR63.setText("jLabel1");
        verifR63.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR63.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR63.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR63.setVerifyInputWhenFocusTarget(false);

        verifR60.setBackground(new java.awt.Color(255, 255, 255));
        verifR60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR60.setText("jLabel1");
        verifR60.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR60.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR60.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR60.setVerifyInputWhenFocusTarget(false);

        verifR61.setBackground(new java.awt.Color(255, 255, 255));
        verifR61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR61.setText("jLabel1");
        verifR61.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR61.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR61.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR61.setVerifyInputWhenFocusTarget(false);

        verifR62.setBackground(new java.awt.Color(255, 255, 255));
        verifR62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR62.setText("jLabel1");
        verifR62.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR62.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR62.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR62.setVerifyInputWhenFocusTarget(false);

        verifR73.setBackground(new java.awt.Color(255, 255, 255));
        verifR73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR73.setText("jLabel1");
        verifR73.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR73.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR73.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR73.setVerifyInputWhenFocusTarget(false);

        verifR70.setBackground(new java.awt.Color(255, 255, 255));
        verifR70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR70.setText("jLabel1");
        verifR70.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR70.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR70.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR70.setVerifyInputWhenFocusTarget(false);

        verifR71.setBackground(new java.awt.Color(255, 255, 255));
        verifR71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR71.setText("jLabel1");
        verifR71.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR71.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR71.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR71.setVerifyInputWhenFocusTarget(false);

        verifR72.setBackground(new java.awt.Color(255, 255, 255));
        verifR72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR72.setText("jLabel1");
        verifR72.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR72.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR72.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR72.setVerifyInputWhenFocusTarget(false);

        verifR83.setBackground(new java.awt.Color(255, 255, 255));
        verifR83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR83.setText("jLabel1");
        verifR83.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR83.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR83.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR83.setVerifyInputWhenFocusTarget(false);

        verifR80.setBackground(new java.awt.Color(255, 255, 255));
        verifR80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR80.setText("jLabel1");
        verifR80.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR80.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR80.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR80.setVerifyInputWhenFocusTarget(false);

        verifR81.setBackground(new java.awt.Color(255, 255, 255));
        verifR81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR81.setText("jLabel1");
        verifR81.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR81.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR81.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR81.setVerifyInputWhenFocusTarget(false);

        verifR82.setBackground(new java.awt.Color(255, 255, 255));
        verifR82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR82.setText("jLabel1");
        verifR82.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR82.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR82.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR82.setVerifyInputWhenFocusTarget(false);

        verifR93.setBackground(new java.awt.Color(255, 255, 255));
        verifR93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR93.setText("jLabel1");
        verifR93.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR93.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR93.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR93.setVerifyInputWhenFocusTarget(false);

        verifR90.setBackground(new java.awt.Color(255, 255, 255));
        verifR90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR90.setText("jLabel1");
        verifR90.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR90.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR90.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR90.setVerifyInputWhenFocusTarget(false);

        verifR91.setBackground(new java.awt.Color(255, 255, 255));
        verifR91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR91.setText("jLabel1");
        verifR91.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR91.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR91.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR91.setVerifyInputWhenFocusTarget(false);

        verifR92.setBackground(new java.awt.Color(255, 255, 255));
        verifR92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color2/blanc.png"))); // NOI18N
        verifR92.setText("jLabel1");
        verifR92.setMaximumSize(new java.awt.Dimension(16, 16));
        verifR92.setMinimumSize(new java.awt.Dimension(16, 16));
        verifR92.setPreferredSize(new java.awt.Dimension(16, 16));
        verifR92.setVerifyInputWhenFocusTarget(false);

        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlabel100.setBackground(new java.awt.Color(255, 255, 255));
        jlabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jlabel100.setText("jLabel1");

        jLabel102.setBackground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel102.setText("jLabel1");

        jLabel103.setBackground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel103.setText("jLabel1");

        jLabel101.setBackground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Color/Blanc.png"))); // NOI18N
        jLabel101.setText("jLabel1");

        jGuide0.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        jGuide0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Guide/guide.jpg"))); // NOI18N
        jGuide0.setText(": Guide !");
        jGuide0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jGuide0MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jGuide0, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jStock80, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStock81, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStock82, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStock83, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jStock90, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStock91, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStock92, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStock93, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(verifR80, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifR81, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifR82, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifR83, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(verifR90, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifR91, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifR92, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verifR93, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jStock30, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock31, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock32, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock33, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jStock20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock23, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR30, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR32, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jStock10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jStock00, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock01, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock02, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock03, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR00, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR01, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR02, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR03, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jStock70, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock71, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock72, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock73, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jStock60, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock61, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock62, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jStock63, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR70, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR71, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR72, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR73, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR60, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR61, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR62, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR63, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR41, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR42, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR43, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verifR50, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR52, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(verifR53, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jStock50, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStock51, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStock52, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStock53, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jStock40, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStock41, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStock42, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jStock43, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel102, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel101, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabel100, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jGuide0)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock02, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock01, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock00, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock03, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR03, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR02, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR01, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR00, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock32, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock33, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock40, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock52, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock51, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock50, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock53, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock62, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock61, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock60, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock63, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock72, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock71, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock70, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock73, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock82, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock81, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock80, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock83, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStock92, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock91, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock90, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStock93, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR91, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifR93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Gestion du clic sur le JLabel86 pour changer d'image
    private void jLabel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel86MouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) { 
     currentImageIndex86 = (currentImageIndex86 + 1) % imagePaths.length;
    jLabel86.setIcon(new ImageIcon(getClass().getResource(imagePaths[currentImageIndex86])));
     }
    }//GEN-LAST:event_jLabel86MouseClicked

    // Gestion du clic sur le JLabel87 pour changer d'image
    private void jLabel87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel87MouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) { 
     currentImageIndex87 = (currentImageIndex87 + 1) % imagePaths.length;
    jLabel87.setIcon(new ImageIcon(getClass().getResource(imagePaths[currentImageIndex87])));
     }
    }//GEN-LAST:event_jLabel87MouseClicked

    // Gestion du clic sur le JLabel85 pour changer d'image
    private void jLabel85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel85MouseClicked
         if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) { 
     currentImageIndex85 = (currentImageIndex85 + 1) % imagePaths.length;
    jLabel85.setIcon(new ImageIcon(getClass().getResource(imagePaths[currentImageIndex85])));
     }
    }//GEN-LAST:event_jLabel85MouseClicked

    
    // Vérification et mise à jour des icônes après une tentative
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
    int maxTentatives = 10; // Limite de tentatives
        
    boolean victoire = true;
    Icon stock, secret;
    int indexStock, indexSecret;
    int[] secretIndices = new int[4];  // Tableau des indices du code secret
    
    // Copier les icônes des choix du joueur dans la ligne actuelle
    for (int i = 0; i < jcouleur.length; i++) {
        jStock[currentRow][i].setIcon(jcouleur[i].getIcon());
    }

    // Remplir le tableau des indices du code secret
    for (int j = 0; j < jResultat.length; j++) {
        secretIndices[j] = getIndexFromIcon(jResultat[j].getIcon());
    }

    // Comparer les choix avec le code secret
    for (int j = 0; j < jStock[currentRow].length; j++ ) {
        stock = jStock[currentRow][j].getIcon();
        secret = jResultat[j].getIcon();
        
        indexStock = getIndexFromIcon(stock);
        indexSecret = getIndexFromIcon(secret);
        System.out.println(getClass().getResource(imagePaths[0]));

        if (indexStock == indexSecret && indexStock != -1) {
            // Bonne couleur à la bonne position (vert)
            verifR[currentRow][j].setIcon(new ImageIcon(getClass().getResource("Color2/Vert.png")));
        } else if (indexStock != -1 && containsIndex(indexStock, secretIndices)) {
            // Bonne couleur, mais à une mauvaise position (jaune)
            verifR[currentRow][j].setIcon(new ImageIcon(getClass().getResource("Color2/Jaune.png")));
        } else {
            // Mauvaise couleur (rouge)
            verifR[currentRow][j].setIcon(new ImageIcon(getClass().getResource("Color2/Rouge.png")));
        }
    }
        
     for (int e = 0; e < jStock[currentRow].length; e++) {
    indexStock = getIndexFromIcon(jStock[currentRow][e].getIcon());
    indexSecret = secretIndices[e];

    if (indexStock != indexSecret) {
        victoire = false; // Si un indice est différent, la victoire est annulée
        break; // Pas besoin de continuer la vérification si une différence est trouvée
    }
}
 
     currentRow++;
     
        // Affichage du message si le joueur a gagné
        if (victoire) {
            jDialog1.setVisible(true);
            jButton1.setEnabled(false); // Désactiver le bouton après la victoire
        }
         // Vérifier si le nombre de tentatives est dépassé
        if (currentRow >= maxTentatives) {
            jDialog2.setVisible(true);
            jButton1.setEnabled(false); // Désactiver le bouton après l'échec
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Gestion du clic sur le JLabel88 pour changer d'image
    private void jLabel88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            currentImageIndex88 = (currentImageIndex88 + 1) % imagePaths.length;
            jLabel88.setIcon(new ImageIcon(getClass().getResource(imagePaths[currentImageIndex88])));
        }
    }//GEN-LAST:event_jLabel88MouseClicked

    private void jQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuitterActionPerformed
      System.exit(0); // Quitte complètement l'application
    }//GEN-LAST:event_jQuitterActionPerformed

    private void jRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecommencerActionPerformed
      restartRound(); // Redémarre la partie
    }//GEN-LAST:event_jRecommencerActionPerformed

    private void jQuitter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuitter2ActionPerformed
      System.exit(0);
    }//GEN-LAST:event_jQuitter2ActionPerformed

    private void jRecommencer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecommencer2ActionPerformed
      restartRound();
    }//GEN-LAST:event_jRecommencer2ActionPerformed

    private void jGuide0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jGuide0MouseClicked
       jDialog3.setVisible(true);
    }//GEN-LAST:event_jGuide0MouseClicked

    private void jQuitter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuitter3ActionPerformed
       jDialog3.setVisible(false);
    }//GEN-LAST:event_jQuitter3ActionPerformed

   
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Master().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jGif0;
    private javax.swing.JLabel jGif1;
    private javax.swing.JLabel jGuide0;
    private javax.swing.JTextArea jGuide1;
    private javax.swing.JLabel jLabe1;
    private javax.swing.JLabel jLabe2;
    private javax.swing.JLabel jLabe3;
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JButton jQuitter;
    private javax.swing.JButton jQuitter2;
    private java.awt.Button jQuitter3;
    private javax.swing.JButton jRecommencer;
    private javax.swing.JButton jRecommencer2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jStock00;
    private javax.swing.JLabel jStock01;
    private javax.swing.JLabel jStock02;
    private javax.swing.JLabel jStock03;
    private javax.swing.JLabel jStock10;
    private javax.swing.JLabel jStock11;
    private javax.swing.JLabel jStock12;
    private javax.swing.JLabel jStock13;
    private javax.swing.JLabel jStock20;
    private javax.swing.JLabel jStock21;
    private javax.swing.JLabel jStock22;
    private javax.swing.JLabel jStock23;
    private javax.swing.JLabel jStock30;
    private javax.swing.JLabel jStock31;
    private javax.swing.JLabel jStock32;
    private javax.swing.JLabel jStock33;
    private javax.swing.JLabel jStock40;
    private javax.swing.JLabel jStock41;
    private javax.swing.JLabel jStock42;
    private javax.swing.JLabel jStock43;
    private javax.swing.JLabel jStock50;
    private javax.swing.JLabel jStock51;
    private javax.swing.JLabel jStock52;
    private javax.swing.JLabel jStock53;
    private javax.swing.JLabel jStock60;
    private javax.swing.JLabel jStock61;
    private javax.swing.JLabel jStock62;
    private javax.swing.JLabel jStock63;
    private javax.swing.JLabel jStock70;
    private javax.swing.JLabel jStock71;
    private javax.swing.JLabel jStock72;
    private javax.swing.JLabel jStock73;
    private javax.swing.JLabel jStock80;
    private javax.swing.JLabel jStock81;
    private javax.swing.JLabel jStock82;
    private javax.swing.JLabel jStock83;
    private javax.swing.JLabel jStock90;
    private javax.swing.JLabel jStock91;
    private javax.swing.JLabel jStock92;
    private javax.swing.JLabel jStock93;
    private javax.swing.JLabel jlabel100;
    private javax.swing.JLabel verifR00;
    private javax.swing.JLabel verifR01;
    private javax.swing.JLabel verifR02;
    private javax.swing.JLabel verifR03;
    private javax.swing.JLabel verifR10;
    private javax.swing.JLabel verifR11;
    private javax.swing.JLabel verifR12;
    private javax.swing.JLabel verifR13;
    private javax.swing.JLabel verifR20;
    private javax.swing.JLabel verifR21;
    private javax.swing.JLabel verifR22;
    private javax.swing.JLabel verifR23;
    private javax.swing.JLabel verifR30;
    private javax.swing.JLabel verifR31;
    private javax.swing.JLabel verifR32;
    private javax.swing.JLabel verifR33;
    private javax.swing.JLabel verifR40;
    private javax.swing.JLabel verifR41;
    private javax.swing.JLabel verifR42;
    private javax.swing.JLabel verifR43;
    private javax.swing.JLabel verifR50;
    private javax.swing.JLabel verifR51;
    private javax.swing.JLabel verifR52;
    private javax.swing.JLabel verifR53;
    private javax.swing.JLabel verifR60;
    private javax.swing.JLabel verifR61;
    private javax.swing.JLabel verifR62;
    private javax.swing.JLabel verifR63;
    private javax.swing.JLabel verifR70;
    private javax.swing.JLabel verifR71;
    private javax.swing.JLabel verifR72;
    private javax.swing.JLabel verifR73;
    private javax.swing.JLabel verifR80;
    private javax.swing.JLabel verifR81;
    private javax.swing.JLabel verifR82;
    private javax.swing.JLabel verifR83;
    private javax.swing.JLabel verifR90;
    private javax.swing.JLabel verifR91;
    private javax.swing.JLabel verifR92;
    private javax.swing.JLabel verifR93;
    // End of variables declaration//GEN-END:variables
}
