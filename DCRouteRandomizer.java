// by kyubifang - https://github.com/kyubifang/dead-cells-route-randomizer

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class DCRouteRandomizer extends JFrame
{
    private static final int WIDTH = 1800;
    private static final int HEIGHT = 1070;

    public static JButton randomButton, resetButton;
    public static JLabel programNameLabel, BSCLabel, DLCLabel, finalBossLabel, classLabel;
    public static JLabel stage0, stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8, stage9, stage10, stage11;
    public static JLabel floor0, floor1, floor2, floor3, floor4, floor5, floor6, floor7, floor8, floor9, floor10, floor11;
    public static JLabel classPicked, cChestPercentLabel, cChestLabel, tChestLabel, sFragLabel, dScrollLabel, pScrollLabel;
    public static JLabel panel0, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10, panel11;
    public static JLabel blank1, blank2, blank3, blank4, blank5, blank6, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
    public static JCheckBox TBSBox, FFBox, QatSBox, RtCBox, classBox;
    public static JRadioButton finalBoxYes, finalBoxRandom, finalBoxNo;

    public static Font TitleFont;
    public static Font ATCFont;
    public static Font BeryliumFont;
    public static Font DosisFont;
    public static Font NovaFont;
    public static Font castleFont;
    
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints gbm = new GridBagConstraints();

    // define colors
    public static Color royal_peacock = new Color(38, 181, 217); // base color
    public static Color aggressive_baby_blue = new Color(113, 255, 246); // giant color
    public static Color pedestrian_green = new Color(0, 184, 37); // tbs color
    public static Color fine_gold = new Color(217, 167, 40); // ff color
    public static Color jacaranda_pink = new Color(190, 98, 255); // queen color
    public static Color lower_lip = new Color(244, 66, 145); // castlevania color
    public static Color red_handed = new Color(220, 33, 50); // boss battle color
    public static Color midnight_express = new Color(27, 41, 57); // map image background
    public static Color cool_balaclavas_are_forever = new Color(20, 29, 60); // base background
    public static Color queen_of_trees = new Color(20, 60, 25); // tbs background
    public static Color pullman_green = new Color(62, 50, 21); // ffalls background
    public static Color blackcurrant = new Color(42, 18, 58); // queen background
    public static Color chilli_black_red = new Color(80, 22, 47); // castlevania background
    public static Color rustic_red = new Color(60, 20, 27); // bs5 background
    public static Color assassin_red = new Color(247, 6, 11); // brutality
    public static Color telemagenta = new Color(173, 53, 208); // tactics
    public static Color booger_buster = new Color(0, 255, 113); // survival
    public static Color sanskrit = new Color(234, 150, 47); // orange gradient
    public static Color cadmium_yellow = new Color(255, 246, 0); //yellow gradient

    // define borders
    public static Border baseBorder = BorderFactory.createLineBorder(royal_peacock, 3);
    public static Border orangeBorder = BorderFactory.createLineBorder(sanskrit, 3);
    public static Border giantBorder = BorderFactory.createLineBorder(aggressive_baby_blue, 3);
    public static Border badSeedBorder = BorderFactory.createLineBorder(pedestrian_green, 3);
    public static Border fallsBorder = BorderFactory.createLineBorder(fine_gold, 3);
    public static Border queenBorder = BorderFactory.createLineBorder(jacaranda_pink, 3);
    public static Border castlevaniaBorder = BorderFactory.createLineBorder(lower_lip, 3);
    public static Border bs5Border = BorderFactory.createLineBorder(red_handed, 3);
    public static Border brutalityBorder = BorderFactory.createLineBorder(assassin_red, 3);
    public static Border tacticsBorder = BorderFactory.createLineBorder(telemagenta, 3);
    public static Border survivalBorder = BorderFactory.createLineBorder(booger_buster, 3);

    // define images
    public static ImageIcon aSewerImg = new ImageIcon("images\\ancient_sewer.png");
    public static ImageIcon aLabImg = new ImageIcon("images\\astrolab.png");
    public static ImageIcon bBridgeImg = new ImageIcon("images\\bridge.png");
    public static ImageIcon bruteImg = new ImageIcon("images\\rusty_sword.png");
    public static ImageIcon cOutskirtImg = new ImageIcon("images\\castle_outskirt.png");
    public static ImageIcon cavernImg = new ImageIcon("images\\cavern.png");
    public static ImageIcon cRoomImg = new ImageIcon("images\\clock_room.png");
    public static ImageIcon cTowerImg = new ImageIcon("images\\clock_tower.png");
    public static ImageIcon cPrisonImg = new ImageIcon("images\\corrupted.png");
    public static ImageIcon crownImg = new ImageIcon("images\\crown.png");
    public static ImageIcon cryptImg = new ImageIcon("images\\crypt.png");
    public static ImageIcon cSkullImg = new ImageIcon("images\\curse_skull.png");
    public static ImageIcon defiledImg = new ImageIcon("images\\defiled.png");
    public static ImageIcon derelictImg = new ImageIcon("images\\derelict.png");
    public static ImageIcon dilapidatedImg = new ImageIcon("images\\dilapidated.png");
    public static ImageIcon dCastleImg = new ImageIcon("images\\dracula_castle.png");
    public static ImageIcon dScrollImg = new ImageIcon("images\\dual_scroll.png");
    public static ImageIcon graveyardImg = new ImageIcon("images\\graveyard.png");
    public static ImageIcon guardianImg = new ImageIcon("images\\guardian.png");
    public static ImageIcon hPeakCastleImg = new ImageIcon("images\\high_peak.png");
    public static ImageIcon infestedImg = new ImageIcon("images\\infested.png");
    public static ImageIcon skipKeyImg = new ImageIcon("images\\key.png");
    public static ImageIcon legendaryImg = new ImageIcon("images\\legendary.png");
    public static ImageIcon lighthouseImg = new ImageIcon("images\\lighthouse.png");
    public static ImageIcon lCellImg = new ImageIcon("images\\locked_cell.png");
    public static ImageIcon masterImg = new ImageIcon("images\\master.png");
    public static ImageIcon mausoleumImg = new ImageIcon("images\\mausoleum.png");
    public static ImageIcon morassImg = new ImageIcon("images\\morass.png");
    public static ImageIcon nestImg = new ImageIcon("images\\nest.png");
    public static ImageIcon observeImg = new ImageIcon("images\\observatory.png");
    public static ImageIcon ossuaryImg = new ImageIcon("images\\ossuary.png");
    public static ImageIcon pScrollImg = new ImageIcon("images\\power_scroll.png");
    public static ImageIcon pDepthImg = new ImageIcon("images\\prison_depth.png");
    public static ImageIcon pQuarterImg = new ImageIcon("images\\prisoner_quarter.png");
    public static ImageIcon promenadeImg = new ImageIcon("images\\promenade.png");
    public static ImageIcon rampartImg = new ImageIcon("images\\rampart.png");
    public static ImageIcon sanctuaryImg = new ImageIcon("images\\sanctuary.png");
    public static ImageIcon sFragImg = new ImageIcon("images\\scroll_frag.png");
    public static ImageIcon sepulcherImg = new ImageIcon("images\\sepulcher.png");
    public static ImageIcon shoresImg = new ImageIcon("images\\shores.png");
    public static ImageIcon shrinesImg = new ImageIcon("images\\shrines.png");
    public static ImageIcon surviveImg = new ImageIcon("images\\old_wood_shield.png");
    public static ImageIcon tacticImg = new ImageIcon("images\\begin_bow.png");
    public static ImageIcon tChestImg = new ImageIcon("images\\treasure.png");
    public static ImageIcon tKeyImg = new ImageIcon("images\\throne_key.png");
    public static ImageIcon tRoomImg = new ImageIcon("images\\throne_room.png");
    public static ImageIcon tSewerImg = new ImageIcon("images\\toxic_sewer.png");
    public static ImageIcon villageImg = new ImageIcon("images\\village.png");

    //constructor method
    public DCRouteRandomizer()
    {
        setTitle("Dead Cells Route Generator");
        setSize(WIDTH, HEIGHT);

        //set background
        try {
        this.setContentPane(
            new JLabel(new ImageIcon(ImageIO.read(new File("images\\Beheaded-Island-BG.jpg")))));
        } catch (IOException e) {};

        //Initialize the drop down menu
        String[] BSCCount = {"0", "1", "2", "3", "4", "5"};

        //define fonts
        try {
            TitleFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\ATC Krueger Bold.ttf")).deriveFont(75f);
            ATCFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\ATC Krueger Bold.ttf")).deriveFont(30f);
            BeryliumFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Berylium Bd.otf")).deriveFont(20f);
            DosisFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\Dosis-VariableFont_wght.ttf")).deriveFont(20f);
            NovaFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\NovaFlat-Regular.ttf")).deriveFont(20f);
            castleFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts\\fette-unz-fraktur.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ATCFont);
            ge.registerFont(BeryliumFont);
            ge.registerFont(DosisFont);
            ge.registerFont(castleFont);
        } catch (FontFormatException|IOException e) {
            e.printStackTrace();
        }
        
        //define buttons
        randomButton = new JButton("Randomize!");
        resetButton = new JButton("Start Over");

        //define labels
        programNameLabel = new JLabel("Dead Cells Route Generator");
        BSCLabel = new JLabel("BSC Difficulty:");
        DLCLabel = new JLabel("Owned DLC:");
        finalBossLabel = new JLabel("Fight True Final Boss this run?");
        classLabel = new JLabel("Choose random stat?");

        stage0 = new JLabel("Prisoners' Quarters");
        stage0.setBorder(baseBorder);
        stage0.setFont(NovaFont);
        stage1 = new JLabel("stage1");
        stage1.setFont(NovaFont);
        stage2 = new JLabel("stage2");
        stage2.setFont(NovaFont);
        stage3 = new JLabel("stage3");
        stage3.setFont(NovaFont);
        stage4 = new JLabel("stage4");
        stage4.setFont(NovaFont);
        stage5 = new JLabel("stage5");
        stage5.setFont(NovaFont);
        stage6 = new JLabel("stage6");
        stage6.setFont(NovaFont);
        stage7 = new JLabel("stage7");
        stage7.setFont(NovaFont);
        stage8 = new JLabel("stage8");
        stage8.setFont(NovaFont);
        stage9 = new JLabel("stage9");
        stage9.setFont(NovaFont);
        stage10 = new JLabel("stage10");
        stage10.setFont(NovaFont);
        stage11 = new JLabel("stage11");
        stage11.setFont(NovaFont);

        floor0 = new JLabel("Floor 0");
        floor0.setBorder(baseBorder);
        floor0.setFont(NovaFont);
        floor1 = new JLabel("Floor 1");
        floor1.setFont(NovaFont);
        floor2 = new JLabel("Floor 2");
        floor2.setFont(NovaFont);
        floor3 = new JLabel("Floor 3");
        floor3.setFont(NovaFont);
        floor4 = new JLabel("Floor 4");
        floor4.setFont(NovaFont);
        floor5 = new JLabel("Floor 5");
        floor5.setFont(NovaFont);
        floor6 = new JLabel("Floor 6");
        floor6.setFont(NovaFont);
        floor7 = new JLabel("Floor 7");
        floor7.setFont(NovaFont);
        floor8 = new JLabel("Floor 8");
        floor8.setFont(NovaFont);
        floor9 = new JLabel("Floor 9");
        floor9.setFont(NovaFont);
        floor10 = new JLabel("Floor 10");
        floor10.setFont(NovaFont);
        floor11 = new JLabel("Floor 11");
        floor11.setFont(NovaFont);

        panel0 = new JLabel();
        panel1 = new JLabel();
        panel2 = new JLabel();
        panel3 = new JLabel();
        panel4 = new JLabel();
        panel5 = new JLabel();
        panel6 = new JLabel();
        panel7 = new JLabel();
        panel8 = new JLabel();
        panel9 = new JLabel();
        panel10 = new JLabel();
        panel11 = new JLabel();

        cChestPercentLabel = new JLabel();
        cChestLabel = new JLabel();
        tChestLabel = new JLabel();
        sFragLabel = new JLabel();
        dScrollLabel = new JLabel();
        pScrollLabel = new JLabel();
        classPicked = new JLabel();

        // blank labels for organization
        blank1 = new JLabel(" ");
        blank2 = new JLabel(" ");
        blank3 = new JLabel(" ");
        blank4 = new JLabel(" ");
        blank5 = new JLabel(" ");
        blank6 = new JLabel(" ");
        b1 = new JLabel();
        b2 = new JLabel();
        b3 = new JLabel();
        b4 = new JLabel();
        b5 = new JLabel();
        b6 = new JLabel();
        b7 = new JLabel();
        b8 = new JLabel();
        b9 = new JLabel();
        b10 = new JLabel();
        b11 = new JLabel();

        // define panel JLabel sizes for images to fit
        panel0.setPreferredSize(new Dimension(250, 154));
        panel1.setPreferredSize(new Dimension(250, 154));
        panel2.setPreferredSize(new Dimension(250, 154));
        panel3.setPreferredSize(new Dimension(250, 154));
        panel4.setPreferredSize(new Dimension(250, 154));
        panel5.setPreferredSize(new Dimension(250, 154));
        panel6.setPreferredSize(new Dimension(250, 154));
        panel7.setPreferredSize(new Dimension(250, 154));
        panel8.setPreferredSize(new Dimension(250, 154));
        panel9.setPreferredSize(new Dimension(250, 154));
        panel10.setPreferredSize(new Dimension(250, 154));
        panel11.setPreferredSize(new Dimension(250, 154));

        panel0.setIcon(pQuarterImg);
        panel0.setBorder(baseBorder);

        JComboBox BSCCombo = new JComboBox<>(BSCCount);

        //define checkboxes
        TBSBox = new JCheckBox("The Bad Seed");
        FFBox = new JCheckBox("Fatal Falls");
        QatSBox = new JCheckBox("The Queen and the Sea");
        RtCBox = new JCheckBox("Return to Castlevania");
        finalBoxYes = new JRadioButton("Yes");
        finalBoxRandom = new JRadioButton("Maybe");
        finalBoxNo = new JRadioButton("No");
        classBox = new JCheckBox("Yes");
        ButtonGroup bg = new ButtonGroup();
        bg.add(finalBoxYes);
        bg.add(finalBoxRandom);
        bg.add(finalBoxNo);

        // set layouts for randomizer
        Container pane = getContentPane();
        Container mapPane = new JPanel();
        mapPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        pane.setLayout(new GridBagLayout());
        mapPane.setLayout(new GridBagLayout());
        
        // place each object in their respective containers
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.gridx = 7;
        
        programNameLabel.setFont(TitleFont);
        programNameLabel.setForeground(Color.WHITE);
        pane.add(programNameLabel, gbc);

        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipady = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        BSCLabel.setFont(BeryliumFont);
        BSCLabel.setBackground(midnight_express);
        BSCLabel.setOpaque(true);
        BSCLabel.setForeground(sanskrit);
        pane.add(BSCLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        BSCCombo.setFont(DosisFont);
        BSCCombo.setBackground(Color.WHITE);
        BSCCombo.setForeground(red_handed);
        pane.add(BSCCombo, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        pane.add(blank1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        finalBossLabel.setFont(BeryliumFont);
        finalBossLabel.setBackground(midnight_express);
        finalBossLabel.setOpaque(true);
        finalBossLabel.setForeground(sanskrit);
        pane.add(finalBossLabel, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 2;
        gbc.gridy = 2;
        finalBoxYes.setFont(DosisFont);
        finalBoxYes.setBackground(Color.WHITE);
        finalBoxYes.setForeground(red_handed);
        pane.add(finalBoxYes, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        finalBoxRandom.setFont(DosisFont);
        finalBoxRandom.setBackground(Color.WHITE);
        finalBoxRandom.setForeground(jacaranda_pink);
        pane.add(finalBoxRandom, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        finalBoxNo.setFont(DosisFont);
        finalBoxNo.setBackground(Color.WHITE);
        finalBoxNo.setForeground(royal_peacock);
        pane.add(finalBoxNo, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        pane.add(blank2, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        classLabel.setFont(BeryliumFont);
        classLabel.setBackground(midnight_express);
        classLabel.setOpaque(true);
        classLabel.setForeground(sanskrit);
        pane.add(classLabel, gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        classBox.setFont(DosisFont);
        classBox.setBackground(Color.WHITE);
        pane.add(classBox, gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        pane.add(blank3, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 1;
        DLCLabel.setFont(BeryliumFont);
        DLCLabel.setBackground(midnight_express);
        DLCLabel.setOpaque(true);
        DLCLabel.setForeground(sanskrit);
        pane.add(DLCLabel, gbc);

        gbc.gridx = 6;
        gbc.gridy = 2;
        TBSBox.setFont(ATCFont);
        TBSBox.setBackground(Color.WHITE);
        TBSBox.setForeground(pedestrian_green);
        pane.add(TBSBox, gbc);

        gbc.gridx = 6;
        gbc.gridy = 3;
        FFBox.setFont(ATCFont);
        FFBox.setBackground(Color.WHITE);
        FFBox.setForeground(fine_gold);
        pane.add(FFBox, gbc);

        gbc.gridx = 6;
        gbc.gridy = 4;
        QatSBox.setFont(ATCFont);
        QatSBox.setBackground(Color.WHITE);
        QatSBox.setForeground(jacaranda_pink);
        pane.add(QatSBox, gbc);

        gbc.gridx = 6;
        gbc.gridy = 5;
        RtCBox.setFont(castleFont);
        RtCBox.setBackground(Color.WHITE);
        RtCBox.setForeground(lower_lip);
        pane.add(RtCBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        randomButton.setFont(NovaFont);
        pane.add(randomButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        resetButton.setFont(NovaFont);
        pane.add(resetButton, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 7;
        gbc.gridy = 6;
        classPicked.setFont(NovaFont);
        classPicked.setBackground(midnight_express);
        classPicked.setOpaque(true);
        classPicked.setForeground(sanskrit);
        pane.add(classPicked, gbc);



        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 8;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 8;
        mapPane.setBackground(new Color(27,41,57,100));
        pane.add(mapPane, gbc);

        gbm.anchor = GridBagConstraints.CENTER;
        gbm.weightx = 1;
        gbm.weighty = 1;
        gbm.gridx = 0;
        gbm.gridy = 0;
        mapPane.add(b1, gbm);

        gbm.gridx = 1;
        gbm.gridy = 0;
        mapPane.add(b2, gbm);

        gbm.gridx = 2;
        gbm.gridy = 0;
        mapPane.add(b3, gbm);

        gbm.gridx = 3;
        gbm.gridy = 0;
        mapPane.add(b4, gbm);

        gbm.gridx = 4;
        gbm.gridy = 0;
        mapPane.add(b5, gbm);

        gbm.gridx = 5;
        gbm.gridy = 0;
        mapPane.add(b6, gbm);

        gbm.gridx = 6;
        gbm.gridy = 0;
        mapPane.add(b7, gbm);

        gbm.gridx = 7;
        gbm.gridy = 0;
        mapPane.add(b8, gbm);

        gbm.gridx = 8;
        gbm.gridy = 0;
        mapPane.add(b9, gbm);

        gbm.weightx = 0;
        gbm.weighty = 0;
        gbm.gridx = 0;
        gbm.gridy = 2;
        pScrollLabel.setIcon(pScrollImg);
        pScrollLabel.setFont(NovaFont);
        pScrollLabel.setBackground(cool_balaclavas_are_forever);
        pScrollLabel.setOpaque(true);
        pScrollLabel.setForeground(sanskrit);
        pScrollLabel.setBorder(orangeBorder);
        mapPane.add(pScrollLabel, gbm);

        gbm.gridx = 1;
        gbm.gridy = 1;
        stage0.setBackground(cool_balaclavas_are_forever);
        stage0.setOpaque(true);
        stage0.setForeground(sanskrit);
        mapPane.add(stage0, gbm);

        gbm.gridx = 1;
        gbm.gridy = 2;
        panel0.setBackground(cool_balaclavas_are_forever);
        mapPane.add(panel0, gbm);

        gbm.gridx = 1;
        gbm.gridy = 3;
        floor0.setBackground(cool_balaclavas_are_forever);
        floor0.setOpaque(true);
        floor0.setForeground(sanskrit);
        mapPane.add(floor0, gbm);

        gbm.gridx = 3;
        gbm.gridy = 1;
        stage1.setBackground(cool_balaclavas_are_forever);
        stage1.setOpaque(true);
        stage1.setForeground(sanskrit);
        mapPane.add(stage1, gbm);

        gbm.gridx = 3;
        gbm.gridy = 2;
        panel1.setBackground(aggressive_baby_blue);
        mapPane.add(panel1, gbm);

        gbm.gridx = 3;
        gbm.gridy = 3;
        floor1.setOpaque(true);
        floor1.setForeground(sanskrit);
        mapPane.add(floor1, gbm);

        gbm.gridx = 5;
        gbm.gridy = 1;
        stage2.setOpaque(true);
        stage2.setForeground(sanskrit);
        mapPane.add(stage2, gbm);

        gbm.gridx = 5;
        gbm.gridy = 2;
        mapPane.add(panel2, gbm);

        gbm.gridx = 5;
        gbm.gridy = 3;
        floor2.setBackground(cool_balaclavas_are_forever);
        floor2.setOpaque(true);
        floor2.setForeground(sanskrit);
        mapPane.add(floor2, gbm);

        gbm.gridx = 7;
        gbm.gridy = 1;
        stage3.setBackground(cool_balaclavas_are_forever);
        stage3.setOpaque(true);
        stage3.setForeground(sanskrit);
        mapPane.add(stage3, gbm);

        gbm.gridx = 7;
        gbm.gridy = 2;
        panel3.setBackground(cool_balaclavas_are_forever);
        mapPane.add(panel3, gbm);

        gbm.gridx = 7;
        gbm.gridy = 3;
        floor3.setBackground(cool_balaclavas_are_forever);
        floor3.setOpaque(true);
        floor3.setForeground(sanskrit);
        mapPane.add(floor3, gbm);

        gbm.gridx = 8;
        gbm.gridy = 2;
        dScrollLabel.setIcon(dScrollImg);
        dScrollLabel.setFont(NovaFont);
        dScrollLabel.setBackground(cool_balaclavas_are_forever);
        dScrollLabel.setOpaque(true);
        dScrollLabel.setForeground(sanskrit);
        dScrollLabel.setBorder(orangeBorder);
        mapPane.add(dScrollLabel, gbm);

        gbm.weightx = 1;
        gbm.weighty = 1;
        gbm.gridx = 0;
        gbm.gridy = 4;
        mapPane.add(b10, gbm);

        gbm.weightx = 0;
        gbm.weighty = 0;
        gbm.gridx = 0;
        gbm.gridy = 6;
        sFragLabel.setIcon(sFragImg);
        sFragLabel.setFont(NovaFont);
        sFragLabel.setBackground(cool_balaclavas_are_forever);
        sFragLabel.setOpaque(true);
        sFragLabel.setForeground(sanskrit);
        sFragLabel.setBorder(orangeBorder);
        mapPane.add(sFragLabel, gbm);

        gbm.gridx = 1;
        gbm.gridy = 5;
        stage4.setBackground(cool_balaclavas_are_forever);
        stage4.setOpaque(true);
        stage4.setForeground(sanskrit);
        mapPane.add(stage4, gbm);

        gbm.gridx = 1;
        gbm.gridy = 6;
        panel4.setBackground(aggressive_baby_blue);
        mapPane.add(panel4, gbm);

        gbm.gridx = 1;
        gbm.gridy = 7;
        floor4.setBackground(cool_balaclavas_are_forever);
        floor4.setOpaque(true);
        floor4.setForeground(sanskrit);
        mapPane.add(floor4, gbm);

        gbm.gridx = 3;
        gbm.gridy = 5;
        stage5.setBackground(cool_balaclavas_are_forever);
        stage5.setOpaque(true);
        stage5.setForeground(sanskrit);
        mapPane.add(stage5, gbm);

        gbm.gridx = 3;
        gbm.gridy = 6;
        panel5.setBackground(aggressive_baby_blue);
        mapPane.add(panel5, gbm);

        gbm.gridx = 3;
        gbm.gridy = 7;
        floor5.setBackground(cool_balaclavas_are_forever);
        floor5.setOpaque(true);
        floor5.setForeground(sanskrit);
        mapPane.add(floor5, gbm);

        gbm.gridx = 5;
        gbm.gridy = 5;
        stage6.setBackground(cool_balaclavas_are_forever);
        stage6.setOpaque(true);
        stage6.setForeground(sanskrit);
        mapPane.add(stage6, gbm);

        gbm.gridx = 5;
        gbm.gridy = 6;
        panel6.setBackground(cool_balaclavas_are_forever);
        mapPane.add(panel6, gbm);

        gbm.gridx = 5;
        gbm.gridy = 7;
        floor6.setBackground(cool_balaclavas_are_forever);
        floor6.setOpaque(true);
        floor6.setForeground(sanskrit);
        mapPane.add(floor6, gbm);

        gbm.gridx = 7;
        gbm.gridy = 5;
        stage7.setBackground(cool_balaclavas_are_forever);
        stage7.setOpaque(true);
        stage7.setForeground(sanskrit);
        mapPane.add(stage7, gbm);

        gbm.gridx = 7;
        gbm.gridy = 6;
        panel7.setBackground(aggressive_baby_blue);
        mapPane.add(panel7, gbm);

        gbm.gridx = 7;
        gbm.gridy = 7;
        floor7.setBackground(cool_balaclavas_are_forever);
        floor7.setOpaque(true);
        floor7.setForeground(sanskrit);
        mapPane.add(floor7, gbm);

        gbm.gridx = 8;
        gbm.gridy = 6;
        tChestLabel.setIcon(tChestImg);
        tChestLabel.setFont(NovaFont);
        tChestLabel.setBackground(cool_balaclavas_are_forever);
        tChestLabel.setOpaque(true);
        tChestLabel.setForeground(sanskrit);
        tChestLabel.setBorder(orangeBorder);
        mapPane.add(tChestLabel, gbm);

        gbm.weightx = 1;
        gbm.weighty = 1;
        gbm.gridx = 0;
        gbm.gridy = 8;
        b11.setOpaque(false);
        mapPane.add(b11, gbm);

        gbm.weightx = 0;
        gbm.weighty = 0;
        gbm.gridx = 0;
        gbm.gridy = 10;
        cChestLabel.setIcon(cSkullImg);
        cChestLabel.setFont(NovaFont);
        cChestLabel.setBackground(cool_balaclavas_are_forever);
        cChestLabel.setOpaque(true);
        cChestLabel.setForeground(sanskrit);
        cChestLabel.setBorder(orangeBorder);
        mapPane.add(cChestLabel, gbm);

        gbm.gridx = 1;
        gbm.gridy = 9;
        stage8.setBackground(cool_balaclavas_are_forever);
        stage8.setOpaque(true);
        stage8.setForeground(sanskrit);
        mapPane.add(stage8, gbm);

        gbm.gridx = 1;
        gbm.gridy = 10;
        panel8.setBackground(aggressive_baby_blue);
        mapPane.add(panel8, gbm);

        gbm.gridx = 1;
        gbm.gridy = 11;
        floor8.setBackground(cool_balaclavas_are_forever);
        floor8.setOpaque(true);
        floor8.setForeground(sanskrit);
        mapPane.add(floor8, gbm);

        gbm.gridx = 3;
        gbm.gridy = 9;
        stage9.setBackground(cool_balaclavas_are_forever);
        stage9.setOpaque(true);
        stage9.setForeground(sanskrit);
        mapPane.add(stage9, gbm);

        gbm.gridx = 3;
        gbm.gridy = 10;
        panel9.setBackground(cool_balaclavas_are_forever);
        mapPane.add(panel9, gbm);

        gbm.gridx = 3;
        gbm.gridy = 11;
        floor9.setBackground(cool_balaclavas_are_forever);
        floor9.setOpaque(true);
        floor9.setForeground(sanskrit);
        mapPane.add(floor9, gbm);

        gbm.gridx = 5;
        gbm.gridy = 9;
        stage10.setBackground(cool_balaclavas_are_forever);
        stage10.setOpaque(true);
        stage10.setForeground(sanskrit);
        mapPane.add(stage10, gbm);

        gbm.gridx = 5;
        gbm.gridy = 10;
        panel10.setBackground(aggressive_baby_blue);
        mapPane.add(panel10, gbm);

        gbm.gridx = 5;
        gbm.gridy = 11;
        floor10.setBackground(cool_balaclavas_are_forever);
        floor10.setOpaque(true);
        floor10.setForeground(sanskrit);
        mapPane.add(floor10, gbm);

        gbm.gridx = 7;
        gbm.gridy = 9;
        stage11.setBackground(cool_balaclavas_are_forever);
        stage11.setOpaque(true);
        stage11.setForeground(sanskrit);
        mapPane.add(stage11, gbm);

        gbm.gridx = 7;
        gbm.gridy = 10;
        panel11.setBackground(aggressive_baby_blue);
        mapPane.add(panel11, gbm);

        gbm.gridx = 7;
        gbm.gridy = 11;
        floor11.setBackground(cool_balaclavas_are_forever);
        floor11.setOpaque(true);
        floor11.setForeground(sanskrit);
        mapPane.add(floor11, gbm);

        gbm.gridx = 8;
        gbm.gridy = 10;
        cChestPercentLabel.setIcon(cSkullImg);
        cChestPercentLabel.setFont(NovaFont);
        cChestPercentLabel.setBackground(cool_balaclavas_are_forever);
        cChestPercentLabel.setOpaque(true);
        cChestPercentLabel.setForeground(sanskrit);
        cChestPercentLabel.setBorder(orangeBorder);
        mapPane.add(cChestPercentLabel, gbm);

        mapPane.setVisible(false);

        // center the randomizer in the middle of the screen
        centerFrame(WIDTH, HEIGHT);

        // hide the true final boss labels until BSC 5 is selected
        finalBossLabel.setVisible(false);
        finalBoxYes.setVisible(false);
        finalBoxRandom.setVisible(false);
        finalBoxNo.setVisible(false);
        finalBoxYes.setSelected(false);
        finalBoxRandom.setSelected(false);
        finalBoxNo.setSelected(true);
        
        // BSC difficulty menu
        BSCCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s = (String) BSCCombo.getSelectedItem();

                switch (s)
                {
                    case "5":
                        finalBossLabel.setVisible(true);
                        finalBoxYes.setVisible(true);
                        finalBoxRandom.setVisible(true);
                        finalBoxNo.setVisible(true);
                        finalBoxYes.setSelected(false);
                        finalBoxRandom.setSelected(false);
                        finalBoxNo.setSelected(false);
                        break;
                    default:
                        finalBossLabel.setVisible(false);
                        finalBoxYes.setVisible(false);
                        finalBoxRandom.setVisible(false);
                        finalBoxNo.setVisible(false);
                        finalBoxYes.setSelected(false);
                        finalBoxRandom.setSelected(false);
                        finalBoxNo.setSelected(true);
                }
            }
        });

        // randomizer functionality
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mapPane.setVisible(true);
                biomes(BSCCombo, TBSBox, FFBox, QatSBox, RtCBox, classBox, finalBoxYes, finalBoxRandom, finalBoxNo);
                randomButton.setEnabled(false);
                mapPane.revalidate();
                mapPane.repaint();
            }
        });

        // reset button functionality
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                classPicked.setVisible(false);
                mapPane.setVisible(false);
                floor2.setText("Floor 2");
                floor5.setIcon(null);
                floor5.setText("Floor 5");
                floor8.setText("Floor 8");
                stage10.setVisible(true);
                panel10.setVisible(true);
                floor10.setVisible(true);
                floor10.setText("Floor 10");
                stage11.setVisible(true);
                panel11.setVisible(true);
                floor11.setVisible(true);
                floor11.setText("Floor 11");
                randomButton.setEnabled(true);
            }
        });
    } // end constructor

    // method to center the frame on the screen
    public void centerFrame(int frameWidth, int frameHeight)
    {
        // create a Toolkit object
        Toolkit aToolkit = Toolkit.getDefaultToolkit();

        // create a Dimension object with user screen information
        Dimension screen = aToolkit.getScreenSize();

        // assign x, y position of upper-left corner of frame
        int xPositionOfFrame = (screen.width - frameWidth) / 2;
        int yPositionOfFrame = (screen.height - frameHeight) / 2;

        // method to center frame on user's screen
        setBounds(xPositionOfFrame, yPositionOfFrame, frameWidth, frameHeight);
    } // end centerFrame

    // method to calculate paths
    public static void biomes(JComboBox bsc, JCheckBox badSeed, JCheckBox fFalls, JCheckBox queenSea, JCheckBox returnCastle, JCheckBox classSelect, JRadioButton yesFinal, JRadioButton maybeFinal, JRadioButton noFinal)
    {
        String cellString = (String) bsc.getSelectedItem();
        int cell = Integer.parseInt(cellString);
        int opt = 0;
        boolean optional = false;
        boolean dlc1 = false;
        boolean dlc2 = false;
        boolean dlc3 = false;
        boolean dlc4 = false;
        boolean dlcCheck = false;
        int finalStage = 0;
        int trueFinal = 0;

        Random rng = new Random();
        int rand = rng.nextInt();
        int[] rewards = {2, 0, 0, 1, 0, 1};  // {gold scrolls, dual scrolls, scroll fragments, treasure chests, cursed chests, chance for another cursed}
        String[] path = {null, null, null, null, null, null, null, null, null, null, null, null};

        // BIOME REWARD GUIDE
        //  If there is no BSC requirement, it's guaranteed
        //  If there is a BSC requirement, the reward listed is in addition to the previous rewards
        String PQ = "Prisoners' Quarters";
        // BSC 0-5 = 2 scrolls of power, 1 treasure chest, 1% chance of a cursed chest
        path[0] = PQ;
        String PotC = "Promenade of the Condemned";
        // 10% cursed chest
        // BSC 0 = 1 scroll of power, 2 dual scrolls
        // BSC 1-5 = 1 scroll of power
        // BSC 3 = 1 scroll fragment, 1 treasure chest
        // BSC 4-5 = 1 scroll fragment, 1 treasure chest
        String TS = "Toxic Sewers";
        // 10% cursed chest
        // BSC 0 = 1 scroll of power, 2 dual scrolls
        // BSC 1-5 = 1 scroll of power, 1 treasure chest
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String DA = "Dilapidated Arboretum";
        // 10% cursed chest
        // BSC 0 = 1 scroll of power, 2 dual scrolls
        // BSC 1-5 = 1 scroll of power
        // BSC 3 = 1 scroll fragment, 1 treasure chest
        // BSC 4-5 = 1 scroll fragment, 1 treasure chest
        String CO = "Castle's Outskirts";
        // 10% cursed chest
        // BSC 0 = 1 scroll of power, 2 dual scrolls
        // BSC 1-5 = 1 scroll of power
        // BSC 3 = 1 scroll fragment
        // BSC 4-5 = 2 scroll fragments
        String PD = "Prison Depths";
        // 1 cursed chest
        String CP = "Corrupted Prison";
        // 1 cursed chest
        String R = "Ramparts";
        // 10% cursed chest
        // 2 treasure chests
        // BSC 0-1 = 3 scrolls of power, 2 dual scrolls
        // BSC 2-5 = 1 scrolls of power
        // BSC 3 = 1 scroll fragment
        // BSC 4-5 = 1 scroll fragment, 1 treasure chest
        String AS = "Ancient Sewers";
        // 10% cursed chest
        // BSC 0-1 = 3 scrolls of power, 2 dual scrolls
        // BSC 1 = 1 treasure chest
        // BSC 2-5 = 1 scroll of power
        // BSC 2 = 1 treasure chest
        // BSC 3 = 3 scroll fragments, 1 treasure chest
        // BSC 4-5 = 2 scroll fragments
        String Oss = "Ossuary";
        // 1 cursed chest, 10% chance for another
        // BSC 0-1 = 2 scrolls of power, 2 dual scrolls
        // BSC 2-5 = 1 scroll of power, 1 treasure chest
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String MotB = "Morass of the Banished";
        // 1 cursed chest, 10% chance for another
        // 1 treasure chest
        // BSC 0-1 = 2 scrolls of power, 2 dual scrolls
        // BSC 2-5 = 1 scroll of power
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 2 scroll fragments
        String DC3 = "Dracula's Castle (Depth 3)";
        // 1 cursed chest, 10% chance for another
        // 1 treasure chest
        // BSC 0-1 = 3 scrolls of power, 2 dual scrolls
        // BSC 1 = 1 treasure chest
        // BSC 2-5 = 1 scroll of power
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 1 scroll fragment, 1 treasure chest
        String BB = "Black Bridge";
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String IC = "Insufferable Crypt";
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 2 scroll fragments
        String N = "Nest";
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String DN = "Defiled Necropolis";
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String SV = "Stilt Village";
        // 10% cursed chest
        // 2 treasure chests
        // BSC 0-2 = 3 scrolls of power, 1 dual scroll
        // BSC 1 = 1 treasure chest
        // BSC 2 = 1 treasure chest
        // BSC 3-5 = 1 scroll of power, 1 treasure chest
        // BSC 3 = 1 scroll fragment
        // BSC 4-5 = 1 scroll fragment
        String SS = "Slumbering Sanctuary";
        // 1 cursed chest, 10% chance for another
        // 2 treasure chests
        // BSC 0-2 = 2 scrolls of power, 1 dual scroll
        // BSC 1 = 1 treasure chest
        // BSC 3-5 = 1 scroll of power, 1 treasure chest
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String G = "Graveyard";
        // 1 cursed chest, 10% chance for another
        // BSC 0-2 = 2 scroll of power, 1 dual scroll
        // BSC 3 = 1 scroll of power, 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String FracShrine = "Fractured Shrines";
        // 1 cursed chest
        // 2 treasure chests
        // 1 LEGENDARY item
        // BSC 0-2 = 2 scrolls of power, 1 dual scroll
        // BSC 1 = 1 treasure chest
        // BSC 2 = 1 treasure chest
        // BSC 3-5 = 1 scroll fragment, 1 treasure chest
        // BSC 4-5 = 1 scroll fragment
        String CT = "Clock Tower";
        // 10% cursed chest
        // 1 treasure chest
        // BSC 0-3 = 4 scrolls of power, 2 dual scrolls
        // BSC 3 = 3 scroll fragments, 1 treasure chest
        // BSC 4-5 = 1 scroll of power, 1 scroll fragment
        String ForgSep = "Forgotten Sepulcher";
        // 1 cursed chest, 10% chance for another
        // 1 treasure chest
        // BSC 0-3 = 3 scrolls of power, 2 dual scrolls
        // BSC 3 = 2 scroll fragments, 1 treasure chest
        // BSC 4-5 = 1 scroll of power, 1 scroll fragment
        String C = "Cavern";
        // 10% cursed chest
        // 1 treasure chest
        // BSC 0-3 = 4 scrolls of power, 2 dual scrolls
        // BSC 1 = 1 treasure chest
        // BSC 2 = 1 treasure chest
        // BSC 3 = 4 scroll fragments
        // BSC 4-5 = 1 scroll of power, 1 scroll fragment
        String US = "Undying Shores";
        // 10% cursed chest
        // 1 treasure chest
        // BSC 0-3 = 4 scrolls of power, 2 dual scrolls
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 1 scroll of power, 1 scroll fragment
        String CR = "Clock Room";
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String GH = "Guardian's Haven";
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String M = "Mausoleum";
        // BSC 3 = 2 scroll fragments
        // BSC 4-5 = 1 scroll fragment
        String HPC = "High Peak Castle";
        // 5% cursed chest
        // 2 treasure chests
        // BSC 0-5 = 2 scrolls of power, 2 dual scrolls
        // BSC 3 = 1 scroll fragment
        // BSC 4-5 = 1 scroll fragment
        String DD = "Derelict Distillery";
        // 5% cursed chest
        // 2 treasure chests
        // BSC 0-5 = 2 scrolls of power, 2 dual scrolls
        // BSC 3 = 1 scroll fragment
        // BSC 4-5 = 1 scroll fragment
        String IS = "Infested Shipwreck";
        // 5% cursed chest
        // 2 treasure chests
        // BSC 0-2 = 2 scrolls of power, 2 dual scrolls
        // BSC 2 = 1 treasure chest
        // BSC 3 = 1 scroll of power, 1 scroll fragment, 1 treasure chest
        // BSC 4-5 = 1 scroll fragment
        String DC6 = "Dracula's Castle (Depth 6)";
        // 1 cursed chest, 10% chance for another
        // 1 treasure chest
        // BSC 0 = 2 scrolls of power, 2 dual scrolls
        // BSC 1-5 = 1 scroll of power, 1 treasure chest
        // BSC 3 = 3 scroll fragments
        // BSC 4-5 = 1 scroll fragment, 1 treasure chest
        String TR = "Throne Room";
        String L = "Lighthouse";
        // BSC 3 = 1 scroll fragment
        // BSC 4-5 = 2 scroll fragments
        String MK = "Master's Keep";
        String A = "Astrolab";
        // 2 dual scrolls
        String TC = "The Crown";
        String Obs = "Observatory";

        // DLC CHECKER
        dlc1 = badSeed.isSelected();
        dlc2 = fFalls.isSelected();
        dlc3 = queenSea.isSelected();
        dlc4 = returnCastle.isSelected();

        // CLASS PICKER (if selected)
        if (classSelect.isSelected())
        {
            classPicked.setVisible(true);
            rand = rng.nextInt(3);
            if (rand == 0)
            {
                classPicked.setBorder(brutalityBorder);
                classPicked.setIcon(bruteImg);
                classPicked.setText("Your class is brutality.");
            }
                
            else if (rand == 1)
            {
                classPicked.setBorder(tacticsBorder);
                classPicked.setIcon(tacticImg);
                classPicked.setText("Your class is tactics.");
            }
                
            else
            {
                classPicked.setBorder(survivalBorder);
                classPicked.setIcon(surviveImg);
                classPicked.setText("Your class is survival.");
            }
                
        }

        // STAGE 1
        // if (TBS && castlevania owned)
        if (dlc1 && dlc4)
        {
            switch (rng.nextInt(4))
            {
                case 0: // go dilapidated
                    path[1] = DA;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            rewards[3] += 2;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1: // go promenade
                    path[1] = PotC;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            rewards[3] += 2;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2: // go toxic
                    path[1] = TS;
                    rewards[5] += 10;
                    if (cell > 0)
                    {
                        rewards[0] += 1;
                        rewards[3] += 1;
                    }
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 2;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 3;
                            break;
                        default:
                            break;
                    }
                    break;
                case 3: // go outskirt
                    path[1] = CO;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 3;
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        // else if (TBS owned)
        else if (dlc1)
        {
            switch (rng.nextInt(3))
            {
                case 0: // go dilapidated
                    path[1] = DA;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            rewards[3] += 2;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1: // go promenade
                    path[1] = PotC;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            rewards[3] += 2;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2: // go toxic
                    path[1] = TS;
                    rewards[5] += 10;
                    if (cell > 0)
                    {
                        rewards[0] += 1;
                        rewards[3] += 1;
                    }
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 2;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 3;
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        // else if (castlevania owned)
        else if (dlc4)
        {
            switch (rng.nextInt(3))
            {
                case 0: // go promenade
                    path[1] = PotC;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            rewards[3] += 2;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1: // go toxic
                    path[1] = TS;
                    rewards[5] += 10;
                    if (cell > 0)
                    {
                        rewards[0] += 1;
                        rewards[3] += 1;
                    }
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 2;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 3;
                            break;
                        default:
                            break;
                    }
                    break;
                case 2: // go outskirts
                    path[1] = CO;
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 3;
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        // else (neither DLC owned)
        else
        {
            switch (rng.nextInt(2))
            {
                case 0: // go promenade
                    path[1] = PotC;
                    stage1.setBackground(cool_balaclavas_are_forever);
                    stage1.setText("Promenade of the Condemned");
                    stage1.setBorder(baseBorder);
                    panel1.setIcon(promenadeImg);
                    panel1.setBorder(baseBorder);
                    floor1.setBackground(cool_balaclavas_are_forever);
                    floor1.setBorder(baseBorder);
                    rewards[5] += 10;
                    if (cell > 0)
                        rewards[0] += 1;
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 1;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            rewards[3] += 2;
                            break;
                        default:
                            break;
                    }
                    break;
                case 1: // go toxic
                    path[1] = TS;
                    stage1.setBackground(cool_balaclavas_are_forever);
                    stage1.setBorder(baseBorder);
                    panel1.setIcon(tSewerImg);
                    panel1.setBorder(baseBorder);
                    floor1.setBackground(cool_balaclavas_are_forever);
                    floor1.setBorder(baseBorder);
                    rewards[5] += 10;
                    if (cell > 0)
                    {
                        rewards[0] += 1;
                        rewards[3] += 1;
                    }
                    switch (cell)
                    {
                        case 0:
                            rewards[0] += 1;
                            rewards[1] += 2;
                            break;
                        case 3:
                            rewards[2] += 2;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 3;
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }

        // STAGE 2

        // if last stage was promenade or dilapidated
        if (path[1].contains("Promenade") || path[1].contains("Dilapidated"))
        {
            switch (rng.nextInt(2))
            {
                case 0: // go prison depths
                    optional = true;
                    opt = 1;
                    path[2] = PD;
                    rewards[4] += 1;
                    break;
                default:
                    break;
            }
        }
        // else if last stage was toxic or outskirts
        else if (path[1].contains("Toxic") || path[1].contains("Outskirts"))
        {
            switch (rng.nextInt(2))
            {
                case 0: // go corrupted prison
                    optional = true;
                    opt = 2;
                    path[2] = CP;
                    rewards[4] += 1;
                    break;
                default:
                    break;
            }
        }

        // if neither stage was taken, skip stage 2
        if(!optional)
        {
            path[2] = "SKIPPED";
        }
        
        // STAGE 3, ONLY IF PRISON DEPTHS OR CORRUPTED PRISON WAS TAKEN
        if (optional)
        {
            // last stage was prison depths
            if (opt == 1)
            {
                while (!dlcCheck)
                {
                    switch (rng.nextInt(3))
                    {
                        case 0: // go morass IF TBS owned
                            if (dlc1) 
                            {
                                path[3] = MotB;
                                if (cell > 1)
                                    rewards[0] += 1;
                                rewards[0] += 2;
                                rewards[1] += 2;
                                rewards[3] += 1;
                                rewards[4] += 1;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 2;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 4;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                        case 1: //  go ancient IF BSC 1 or higher
                            if (cell > 0)
                            {
                                path[3] = AS;
                                if (cell > 0)
                                    rewards[3] += 1;
                                if (cell > 1)
                                {
                                    rewards[0] += 1;
                                    rewards[3] += 1;
                                }
                                rewards[0] += 3;
                                rewards[1] += 2;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 3;
                                        rewards[3] += 1;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 5;
                                        rewards[3] += 1;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                        case 2: // go ossuary
                            path[3] = Oss;
                            if (cell > 1)
                            {
                                rewards[0] += 1;
                                rewards[3] += 1;
                            }
                            rewards[0] += 2;
                            rewards[1] += 2;
                            rewards[4] += 1;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 2;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 3;
                                    break;
                                default:
                                    break;
                            }
                            dlcCheck = true;
                            break;
                    }
                }
                dlcCheck = false;
            }
            // last stage was corrupted prison
            else
            {
                while (!dlcCheck)
                {
                    switch (rng.nextInt(3))
                    {
                        case 0: // go go dracula castle IF castlevania owned
                            if (dlc4)
                            {
                                path[3] = DC3;
                                if (cell > 0)
                                    rewards[3] += 1;
                                if (cell > 1)
                                    rewards[0] += 1;
                                rewards[0] += 3;
                                rewards[1] += 2;
                                rewards[3] += 1;
                                rewards[4] += 1;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 3;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 4;
                                        rewards[3] += 1;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                        case 1: // go ramparts IF BSC 1 or higher
                            if (cell > 0)
                            {
                                path[3] = R;
                                if (cell > 1)
                                    rewards[0] += 1;
                                rewards[0] += 3;
                                rewards[1] += 2;
                                rewards[3] += 2;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 1;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 2;
                                        rewards[4] += 1;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                        case 2: // go ancient
                            if (cell > 0)
                            {
                                path[3] = AS;
                                if (cell > 0)
                                    rewards[3] += 1;
                                if (cell > 1)
                                {
                                    rewards[0] += 1;
                                    rewards[3] += 1;
                                }
                                rewards[0] += 3;
                                rewards[1] += 2;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 3;
                                        rewards[3] += 1;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 5;
                                        rewards[3] += 1;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                    }
                }
                dlcCheck = false;
            }
        }
        //STAGE 3 IF PRISON DEPTHS OR CORRUPTED PRISON WAS NOT TAKEN
        else
        {
            if (path[1].contains("Dilapidated"))
            {
                switch (rng.nextInt(2))
                {
                    case 0: // go morass
                        path[3] = MotB;
                        if (cell > 1)
                            rewards[0] += 1;
                        rewards[0] += 2;
                        rewards[1] += 2;
                        rewards[3] += 1;
                        rewards[4] += 1;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 2;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 4;
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1: // go ramparts
                        path[3] = R;
                        if (cell > 1)
                            rewards[0] += 1;
                        rewards[0] += 3;
                        rewards[1] += 2;
                        rewards[3] += 2;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 1;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 2;
                                rewards[4] += 1;
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }
            else if (path[1].contains("Promenade"))
            {
                while (!dlcCheck)
                {
                    switch (rng.nextInt(3))
                    {
                        case 0: // go morass IF tbs owned
                            if (dlc1)
                            {
                                path[3] = MotB;
                                if (cell > 1)
                                    rewards[0] += 1;
                                rewards[0] += 2;
                                rewards[1] += 2;
                                rewards[3] += 1;
                                rewards[4] += 1;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 2;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 4;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                        case 1: // go ossuary
                            path[3] = Oss;
                            if (cell > 1)
                            {
                                rewards[0] += 1;
                                rewards[3] += 1;
                            }
                            rewards[0] += 2;
                            rewards[1] += 2;
                            rewards[4] += 1;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 2;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 3;
                                    break;
                                default:
                                    break;
                            }
                            dlcCheck = true;
                            break;
                        case 2: // go ramparts
                            path[3] = R;
                            if (cell > 1)
                                rewards[0] += 1;
                            rewards[0] += 3;
                            rewards[1] += 2;
                            rewards[3] += 2;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 1;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 2;
                                    rewards[4] += 1;
                                    break;
                                default:
                                    break;
                            }
                            dlcCheck = true;
                            break;
                    }
                }
                dlcCheck = false;
            }
            else if (path[1].contains("Toxic"))
            {
                while (!dlcCheck)
                {
                    switch (rng.nextInt(3))
                    {
                        case 0: // go dracula's castle IF castlevania owned
                            if (dlc4)
                            {
                                path[3] = DC3;
                                if (cell > 0)
                                    rewards[3] += 1;
                                if (cell > 1)
                                    rewards[0] += 1;
                                rewards[0] += 3;
                                rewards[1] += 2;
                                rewards[3] += 1;
                                rewards[4] += 1;
                                rewards[5] += 10;
                                switch (cell)
                                {
                                    case 3:
                                        rewards[2] += 3;
                                        break;
                                    case 4:
                                    case 5:
                                        rewards[2] += 4;
                                        rewards[3] += 1;
                                        break;
                                    default:
                                        break;
                                }
                                dlcCheck = true;
                            }
                            break;
                        case 1: // go ramparts
                            path[3] = R;
                            if (cell > 1)
                                rewards[0] += 1;
                            rewards[0] += 3;
                            rewards[1] += 2;
                            rewards[3] += 2;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 1;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 2;
                                    rewards[4] += 1;
                                    break;
                                default:
                                    break;
                            }
                            dlcCheck = true;
                            break;
                        case 2: // go ancient
                            path[3] = AS;
                            if (cell > 0)
                                rewards[3] += 1;
                            if (cell > 1)
                            {
                                rewards[0] += 1;
                                rewards[3] += 1;
                            }
                            rewards[0] += 3;
                            rewards[1] += 2;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 3;
                                    rewards[3] += 1;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 5;
                                    rewards[3] += 1;
                                    break;
                                default:
                                    break;
                            }
                            dlcCheck = true;
                            break;
                    }
                }
                dlcCheck = false;
            }
            else if (path[1].contains("Outskirts"))
            {
                switch (rng.nextInt(2))
                {
                    case 0: // go ossuary
                        path[3] = Oss;
                        if (cell > 1)
                        {
                            rewards[0] += 1;
                            rewards[3] += 1;
                        }
                        rewards[0] += 2;
                        rewards[1] += 2;
                        rewards[4] += 1;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 2;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 3;
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1: // go dracula's castle
                        path[3] = DC3;
                        if (cell > 0)
                            rewards[3] += 1;
                        if (cell > 1)
                            rewards[0] += 1;
                        rewards[0] += 3;
                        rewards[1] += 2;
                        rewards[3] += 1;
                        rewards[4] += 1;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 3;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 4;
                                rewards[3] += 1;
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }
        }

        //STAGE 4

        // if morass was visited, go nest (mama tick fight)
        if (path[2].contains("Morass") || path[3].contains("Morass"))
        {
            path[4] = N;
            if (cell > 2)
                rewards[2] += 3;
            if (cell > 3)
                rewards[2] += 1;
        }
        // if ossuary was visited
        else if (path[2].contains("Ossuary") || path[3].contains("Ossuary"))
        {
            while (!dlcCheck)
            {
                switch (rng.nextInt(2))
                {
                    case 0: // go defiled (death fight) IF castlevania owned
                        if (dlc4)
                        {
                            path[4] = DN;
                            if (cell > 2)
                                rewards[2] += 2;
                            if (cell > 3)
                                rewards[3] += 1;
                            dlcCheck = true;
                        }
                        
                        break;
                    case 1: // go bridge (concierge fight)
                        path[4] = BB;
                        if (cell > 2)
                            rewards[2] += 2;
                        if (cell > 3)
                            rewards[2] += 1;
                        dlcCheck = true;
                        break;
                }
            }
            dlcCheck = false;
        }
        // if ramparts was visited
        else if (path[2].contains("Ramparts") || path[3].contains("Ramparts"))
        {
            // if 0 && playing on BSC 3 or higher, go crypt (conjunctivius fight)
            // else, go bridge (concierge fight)
            if (rng.nextInt(2) == 0 && cell > 2)
            {
                path[4] = IC;
                rewards[2] += 3;
                if (cell > 3)
                    rewards[2] += 2;
            }
            else
            {
                path[4] = BB;
                if (cell > 2)
                    rewards[2] += 2;
                if (cell > 3)
                    rewards[2] += 1;
            }
        }
        // if ancient sewers was visited, go crypt (conjunctivius fight)
        else if (path[2].contains("Ancient") || path[3].contains("Ancient"))
        {
            path[4] = IC;
            if (cell > 2)
                rewards[2] += 3;
            if (cell > 3)
                rewards[2] += 2;
        }
        // else dracula's castle was visited
        else
        {
            // 0 = go bridge (concierge fight)
            // 1 = go defiled (death fight)
            if (rng.nextInt(2) == 0)
            {
                path[4] = BB;
                if (cell > 2)
                    rewards[2] += 2;
                if (cell > 3)
                    rewards[2] += 1;
            }
            else
            {
                path[4] = DN;
                if (cell > 2)
                    rewards[2] += 2;
                if (cell > 3)
                    rewards[3] += 1;
            }
        }

        // STAGE 5

        // fought mama tick
        if (path[4].contains("Nest"))
        {
            while (!dlcCheck)
            {
                switch (rng.nextInt(3))
                {
                    case 0: // go shrines IF fatal falls owned
                        if (dlc2)
                        {
                            path[5] = FracShrine;
                            if (cell > 0)
                                rewards[3] += 1;
                            if (cell > 1)
                                rewards[3] += 1;
                            if (cell > 2)
                                rewards[3] += 1;
                            rewards[0] += 2;
                            rewards[1] += 1;
                            rewards[3] += 2;
                            rewards[4] += 1;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 1;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 2;
                                    break;
                            }
                            dlcCheck = true;
                        }
                        break;
                    case 1: // go village
                        path[5] = SV;
                        if (cell > 0)
                            rewards[3] += 1;
                        if (cell > 1)
                            rewards[3] += 1;
                        if (cell > 2)
                        {
                            rewards[0] += 1;
                            rewards[3] += 1;
                        }
                        rewards[0] += 3;
                        rewards[1] += 1;
                        rewards[3] += 2;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 1;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 2;
                                break;
                        }    
                        dlcCheck = true;
                        break;
                    case 2: // go graveyard
                        path[5] = G;
                        if (cell > 2)
                        {
                            rewards[0] += 1;
                            rewards[2] += 2;
                        }
                        if (cell > 3)
                            rewards[2] += 1;
                        rewards[0] += 2;
                        rewards[1] += 1;
                        rewards[4] += 1;
                        rewards[5] += 10;
                        dlcCheck = true;
                        break;
                }
            }
            dlcCheck = false;
        }
        // fought concierge
        else if (path[4].contains("Bridge"))
        {
            while (!dlcCheck)
            {
                switch (rng.nextInt(3))
                {
                    case 0: // go shrines IF fatal falls owned
                        if (dlc2)
                        {
                            path[5] = FracShrine;
                            if (cell > 0)
                                rewards[3] += 1;
                            if (cell > 1)
                                rewards[3] += 1;
                            if (cell > 2)
                                rewards[3] += 1;
                            rewards[0] += 2;
                            rewards[1] += 1;
                            rewards[3] += 2;
                            rewards[4] += 1;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 1;
                                    break;
                                case 4:
                                case 5:
                                    rewards[2] += 2;
                                    break;
                            }
                            dlcCheck = true;
                        }
                        break;
                    case 1: // go village
                        path[5] = SV;
                        if (cell > 0)
                            rewards[3] += 1;
                        if (cell > 1)
                            rewards[3] += 1;
                        if (cell > 2)
                        {
                            rewards[0] += 1;
                            rewards[3] += 1;
                        }
                        rewards[0] += 3;
                        rewards[1] += 1;
                        rewards[3] += 2;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 1;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 2;
                                break;
                        }    
                        dlcCheck = true;
                        break;
                    case 2: // go sanctuary
                        path[5] = SS;
                        if (cell > 0)
                            rewards[3] += 1;
                        if (cell > 2)
                        {
                            rewards[0] += 1;
                            rewards[2] += 1;
                        }
                        rewards[0] += 2;
                        rewards[1] += 1;
                        rewards[3] += 2;
                        rewards[4] += 1;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 3;
                                break;
                            case 4:
                            case 5:
                                rewards[2] += 4;
                                break;
                        }  
                        dlcCheck = true;
                        break;
                }
            }
            dlcCheck = false;
        }
        // fought conjunctivius
        else if (path[4].contains("Crypt"))
        {
            // if 0, go sanctuary
            // else go graveyard
            if (rng.nextInt(1) == 0)
            {
                
                path[5] = SS;
                if (cell > 0)
                    rewards[3] += 1;
                if (cell > 2)
                {
                    rewards[0] += 1;
                    rewards[2] += 1;
                }
                rewards[0] += 2;
                rewards[1] += 1;
                rewards[3] += 2;
                rewards[4] += 1;
                rewards[5] += 10;
                switch (cell)
                {
                    case 3:
                        rewards[2] += 3;
                        break;
                    case 4:
                    case 5:
                        rewards[2] += 4;
                        break;
                }  
            }
            else
            {
                path[5] = G;
                if (cell > 2)
                {
                    rewards[0] += 1;
                    rewards[2] += 2;
                }
                if (cell > 3)
                    rewards[2] += 1;
                rewards[0] += 2;
                rewards[1] += 1;
                rewards[4] += 1;
                rewards[5] += 10;
            }
        }
        // fought death
        else
        {
            switch (rng.nextInt(3))
            {
                case 0: // go village
                    path[5] = SV;
                    if (cell > 0)
                        rewards[3] += 1;
                    if (cell > 1)
                        rewards[3] += 1;
                    if (cell > 2)
                    {
                        rewards[0] += 1;
                        rewards[3] += 1;
                    }
                    rewards[0] += 3;
                    rewards[1] += 1;
                    rewards[3] += 2;
                    rewards[5] += 10;
                    switch (cell)
                    {
                        case 3:
                            rewards[2] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 2;
                            break;
                    }    
                    break;
                case 1: // go sanctuary
                    path[5] = SS;
                    if (cell > 0)
                        rewards[3] += 1;
                    if (cell > 2)
                    {
                        rewards[0] += 1;
                        rewards[2] += 1;
                    }
                    rewards[0] += 2;
                    rewards[1] += 1;
                    rewards[3] += 2;
                    rewards[4] += 1;
                    rewards[5] += 10;
                    switch (cell)
                    {
                        case 3:
                            rewards[2] += 3;
                            break;
                        case 4:
                        case 5:
                            rewards[2] += 4;
                            break;
                    }  
                    break;
                case 2: // go graveyard
                    path[5] = G;
                    if (cell > 2)
                    {
                        rewards[0] += 1;
                        rewards[2] += 2;
                    }
                    if (cell > 3)
                        rewards[2] += 1;
                    rewards[0] += 2;
                    rewards[1] += 1;
                    rewards[4] += 1;
                    rewards[5] += 10;
                    break;
            }
        }

        // STAGE 6

        // visited shrines or village
        if (path[5].contains("Shrines") || path[5].contains("Village"))
        {
            while (!dlcCheck)
            {
                switch (rng.nextInt(3))
                {
                    case 0: // go shores IF fatal falls owned
                        if (dlc2)
                        {
                            path[6] = US;
                            rewards[0] += 4;
                            rewards[1] += 2;
                            rewards[3] += 1;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 3;
                                    break;
                                case 4:
                                case 5:
                                    rewards[0] += 1;
                                    rewards[2] += 4;
                                    break;
                            }
                            dlcCheck = true;
                        }
                        break;
                    case 1: // go clock tower
                        path[6] = CT;
                        rewards[0] += 4;
                        rewards[1] += 2;
                        rewards[3] += 1;
                        rewards[5] += 10;
                        switch (cell)
                        {
                            case 3:
                                rewards[2] += 3;
                                rewards[3] += 1;
                                break;
                            case 4:
                            case 5:
                                rewards[0] += 1;
                                rewards[2] += 4;
                                rewards[3] += 1;
                                break;
                        }
                        dlcCheck = true;
                        break;
                    case 2: // go sepulcher
                        path[6] = ForgSep;
                        if (cell > 2)
                        {
                            rewards[2] += 2;
                            rewards[3] += 1;
                        }
                        if (cell > 3)
                        {
                            rewards[0]++;
                            rewards[2]++;
                        }
                        rewards[0] += 3;
                        rewards[1] += 2;
                        rewards[3] += 1;
                        rewards[4]++;
                        rewards[5] += 10;
                        dlcCheck = true;
                        break;
                }
            }
            dlcCheck = false;
        }
        // visited sanctuary
        else if (path[5].contains("Sanctuary"))
        {
            rand = rng.nextInt(3);
            // if 0 and playing on BSC 2 or higher
            //      go cavern
            // else
            //      1 = go clock tower
            //      2 = go sepulcher
            while (rand != 3)
            {
                if (rand == 0 && cell > 1)
                {
                    path[6] = C;
                    if (cell > 0)
                        rewards[3]++;
                    if (cell > 1)
                        rewards[3]++;
                    if(cell > 2)
                        rewards[2] += 4;
                    if (cell > 3)
                    {
                        rewards[0]++;
                        rewards[2]++;
                    }
                    rewards[0] += 4;
                    rewards[1] += 2;
                    rewards[3]++;
                    rewards[5] += 10;
                    rand = 3;
                }
                else if (rand == 1)
                {
                    path[6] = CT;
                    rewards[0] += 4;
                    rewards[1] += 2;
                    rewards[3] += 1;
                    rewards[5] += 10;
                    switch (cell)
                    {
                        case 3:
                            rewards[2] += 3;
                            rewards[3] += 1;
                            break;
                        case 4:
                        case 5:
                            rewards[0] += 1;
                            rewards[2] += 4;
                            rewards[3] += 1;
                            break;
                    }
                    rand = 3;
                }
                else if (rand == 2)
                {
                    path[6] = ForgSep;
                    if (cell > 2)
                    {
                        rewards[2] += 2;
                        rewards[3] += 1;
                    }
                    if (cell > 3)
                    {
                        rewards[0]++;
                        rewards[2]++;
                    }
                    rewards[0] += 3;
                    rewards[1] += 2;
                    rewards[3] += 1;
                    rewards[4]++;
                    rewards[5] += 10;
                    rand = 3;
                }
                else
                {
                    rand = rng.nextInt(3);
                }
            }
        }
        // visited graveyard
        else
        {
            while (!dlcCheck)
            {
                switch (rng.nextInt(3))
                {
                    case 0: // go shores IF fatal falls owned
                        if (dlc2)
                        {
                            path[6] = US;
                            rewards[0] += 4;
                            rewards[1] += 2;
                            rewards[3] += 1;
                            rewards[5] += 10;
                            switch (cell)
                            {
                                case 3:
                                    rewards[2] += 3;
                                    break;
                                case 4:
                                case 5:
                                    rewards[0] += 1;
                                    rewards[2] += 4;
                                    break;
                            }
                            dlcCheck = true;
                        }
                        break;
                    case 1: // go sepulcher
                        path[6] = ForgSep;
                        if (cell > 2)
                        {
                            rewards[2] += 2;
                            rewards[3] += 1;
                        }
                        if (cell > 3)
                        {
                            rewards[0]++;
                            rewards[2]++;
                        }
                        rewards[0] += 3;
                        rewards[1] += 2;
                        rewards[3] += 1;
                        rewards[4]++;
                        rewards[5] += 10;
                        dlcCheck = true;
                        break;
                    case 2: // go cavern
                        path[6] = C;
                        if (cell > 0)
                            rewards[3]++;
                        if (cell > 1)
                            rewards[3]++;
                        if(cell > 2)
                            rewards[2] += 4;
                        if (cell > 3)
                        {
                            rewards[0]++;
                            rewards[2]++;
                        }
                        rewards[0] += 4;
                        rewards[1] += 2;
                        rewards[3]++;
                        rewards[5] += 10;
                        rand = 3;
                        dlcCheck = true;
                        break;
                }
            }
            dlcCheck = false;
        }

        // STAGE 7

        // visited undying shores, go mausoleum (scarecrow fight)
        if (path[6].contains("Shores"))
        {
            path[7] = M;
            if (cell > 2)
                rewards[2] += 2;
            if (cell > 3)
                rewards[2]++;
        }
        // visited clock tower, go clock room (time keeper fight)
        else if (path[6].contains("Clock"))
        {
            path[7] = CR;
            if (cell > 2)
                rewards[2] += 2;
            if (cell > 3)
                rewards[2]++;
        }
        //visited sepulcher
        else if (path[6].contains("Forgotten"))
        {
            // if 0 && playing on BSC 2 or higher, go guardian (giant fight)
            // else go clock room (time keeper fight)
            if (rng.nextInt(2) == 0 && cell > 1)
            {
                path[7] = GH;
                if (cell > 2)
                    rewards[2] += 3;
                if (cell > 3)
                    rewards[2]++;
            }
            else
            {
                path[7] = CR;
                if (cell > 2)
                    rewards[2] += 2;
                if (cell > 3)
                    rewards[2]++;
            }
        }
        //visited cavern
        else
        {
            // if 0 && fatal falls owned, go mausoleum (scarecrow fight)
            // else go guardian (giant fight)
            if (rng.nextInt(2) == 0 && dlc2)
            {
                path[7] = M;
                if (cell > 2)
                    rewards[2] += 2;
                if (cell > 3)
                    rewards[2]++;
            }
            else
            {
                path[7] = GH;
                if (cell > 2)
                    rewards[2] += 3;
                if (cell > 3)
                    rewards[2]++;
            }
        }

        // STAGE 8

        // fought giant
        if (path[7].contains("Haven"))
            finalStage = rng.nextInt(5);
        else
            finalStage = rng.nextInt(4);
        
        // check if BSC is set to 5. if so, check if yes or maybe was selected for true final boss
        if (cell == 5)
        {
            if (yesFinal.isSelected())
                trueFinal = 2;
            else if (maybeFinal.isSelected())
                trueFinal = 1;
        }

        // if 0, queen dlc owned, and true final boss is maybe or no, go infested
        if (finalStage == 0 && dlc3 && trueFinal < 2)
        {
            path[8] = IS;
            if (cell > 1)
                rewards[3]++;
            if (cell > 2)
            {
                rewards[0]++;
                rewards[2]++;
                rewards[3]++;
            }
            if(cell > 3)
                rewards[2]++;
            rewards[0] += 2;
            rewards[1] += 2;
            rewards[3] += 2;
            rewards[5] += 5;
        }
        // if 1, go derelict
        else if(finalStage == 1)
        {
            path[8] = DD;
            if (cell > 2)
                rewards[2]++;
            if(cell > 3)
                rewards[2]++;
            rewards[0] += 2;
            rewards[1] += 2;
            rewards[3] += 2;
            rewards[5] += 5;
        }
        //if 2, castlevania owned, and true final boss is maybe or no, go dracula's castle (depth 6)
        else if(finalStage == 2 && dlc4 && trueFinal < 2)
        {
            path[8] = DC6;
            if (cell > 0)
            {
                rewards[0]++;
                rewards[3]++;
            }
            if (cell > 2)
                rewards[2] += 3;
            if (cell > 3)
            {
                rewards[2]++;
                rewards[3]++;
            }
            rewards[0] += 2;
            rewards[1] += 2;
            rewards[3]++;
            rewards[4]++;
            rewards[5] += 10;
        }
        // if 3, go high peak castle
        else if(finalStage == 3)
        {
            path[8] = HPC;
            if (cell > 2)
                rewards[2]++;
            if(cell > 3)
                rewards[2]++;
            rewards[0] += 2;
            rewards[1] += 2;
            rewards[3] += 2;
            rewards[5] += 5;
        }
        // otherwise, skip stage 8 and collect 2 power scrolls
        else
        {
            path[8] = "SKIPPED";
            rewards[0] += 2;
        }

        // STAGE 9

        // if skipped stage 8, go straight to throne room (hand of the king fight)
        if (path[8].contains("SKIPPED"))
            path[9] = TR;
        // if went to infested or derelict, determine if going to lighthouse or throne room
        else if (path[8].contains("Infested") || path[8].contains("Derelict"))
        {
            // if infested, go straight to lighthouse (servants fight)
            // if derelict, rng = 0, queen dlc owned, and true final is maybe or no, go lighthouse (servants fight)
            // if neither is true, go throne room (hand of king fight)
            if (path[8].contains("Infested") || ((rng.nextInt(2)) == 0 && dlc3 && (trueFinal < 2)))
            {
                path[9] = L;
                if (cell > 2)
                    rewards[2]++;
                if (cell > 3)
                    rewards[2] += 2;
            }
            else
                path[9] = TR;
        }
        // if went to high peak/dracula's castle, determine if going to throne room or master's keep
        else if (path[8].contains("Castle"))
        {
            // if dracula, go straight to master (dracula fight)
            // if high peak, rng = 0, castlevania dlc owned, and true final boss is maybe or no, go master (dracula fight)
            // if neither is true, go throne room (hand of the king fight)
            if (path[8].contains("Dracula") || (rng.nextInt(2) == 0 && dlc3 && trueFinal < 2))
                path[9] = MK;
            else
                path[9] = TR;
        }

        // STAGE 10 (SPOILERS AHEAD)

        // if fought servants, go crown (queen fight)
        if (path[9].contains("Lighthouse"))
        {
            path[10] = TC;
            path[11] = "NONE";
        }
        // if fought hand of the king, test for true final
        else if ((path[9].contains("Throne")))
        {
            // if true final is yes and BSC is 5, go astrolab
            if ((cell == 5) && (trueFinal == 2))
            {
                path[10] = A;
                rewards[0] += 2;
            }
            // if BSC is 5, fought hand of the king, and true final is not yes
            //      If maybe, flip a coin to see if going to true final
            //          0 = go astrolab
            //          1 = hand of the king was the final fight
            else if ((cell == 5) && (trueFinal != 2))
            {
                if ((trueFinal == 1) && (rng.nextInt(2) == 0))
                    path[10] = "Astrolab";
                else
                {
                    path[10] = "NONE";
                    path[11] = "NONE";
                }
            }
            // BSC is less than 5, indicate that true final is only available on BSC 5
            else
            {
                path[10] = "LOCKED";
                path[11] = "LOCKED";
            }
        }
        // if neither is true, dracula was the final fight of this run
        else
        {
            path[10] = "NONE";
            path[11] = "NONE";
        }

        // STAGE 11 (only if BSC 5 and didn't fight queen)

        if (path[10].contains("Astrolab"))
            path[11] = Obs;


        // GENERATE THE STAGES
        switch (path[1])
        {
            case "Dilapidated Arboretum":
                stage1.setBackground(queen_of_trees);
                stage1.setText("Dilapidated Arboretum");
                stage1.setBorder(badSeedBorder);
                panel1.setIcon(dilapidatedImg);
                panel1.setBorder(badSeedBorder);
                floor1.setBackground(queen_of_trees);
                floor1.setBorder(badSeedBorder);
                break;
            case "Promenade of the Condemned":
                stage1.setBackground(cool_balaclavas_are_forever);
                stage1.setText("Promenade of the Condemned");
                stage1.setBorder(baseBorder);
                panel1.setIcon(promenadeImg);
                panel1.setBorder(baseBorder);
                floor1.setBackground(cool_balaclavas_are_forever);
                floor1.setBorder(baseBorder);
                break;
            case "Toxic Sewers":
                stage1.setBackground(cool_balaclavas_are_forever);
                stage1.setText("Toxic Sewers");
                stage1.setBorder(baseBorder);
                panel1.setIcon(tSewerImg);
                panel1.setBorder(baseBorder);
                floor1.setBackground(cool_balaclavas_are_forever);
                floor1.setBorder(baseBorder);
                break;
            case "Castle's Outskirts":
                stage1.setBackground(chilli_black_red);
                stage1.setText("Castle's Outskirts");
                stage1.setBorder(castlevaniaBorder);
                panel1.setIcon(cOutskirtImg);
                panel1.setBorder(castlevaniaBorder);
                floor1.setBackground(chilli_black_red);
                floor1.setBorder(castlevaniaBorder);
                break;
        }

        switch (path[2])
        {
            case "SKIPPED":
                stage2.setBackground(midnight_express);
                stage2.setText("Proceed to Floor 3");
                stage2.setBorder(orangeBorder);
                panel2.setIcon(skipKeyImg);
                panel2.setBorder(orangeBorder);
                floor2.setBackground(midnight_express);
                floor2.setText("N/A");
                floor2.setBorder(orangeBorder);
                break;
            case "Prison Depths":
                stage2.setBackground(cool_balaclavas_are_forever);
                stage2.setText("Prison Depths");
                stage2.setBorder(baseBorder);
                panel2.setIcon(pDepthImg);
                panel2.setBorder(baseBorder);
                floor2.setBackground(cool_balaclavas_are_forever);
                floor2.setBorder(baseBorder);
                break;
            case "Corrupted Prison":
                stage2.setBackground(cool_balaclavas_are_forever);
                stage2.setText("Corrupted Prison");
                stage2.setBorder(baseBorder);
                panel2.setIcon(cPrisonImg);
                panel2.setBorder(baseBorder);
                floor2.setBackground(cool_balaclavas_are_forever);
                floor2.setBorder(baseBorder);
                break;
        }

        switch (path[3])
        {
            case "Morass of the Banished":
                stage3.setBackground(queen_of_trees);
                stage3.setText("Morass of the Banished");
                stage3.setBorder(badSeedBorder);
                panel3.setIcon(morassImg);
                panel3.setBorder(badSeedBorder);
                floor3.setBackground(queen_of_trees);
                floor3.setBorder(badSeedBorder);
                break;
            case "Ossuary":
                stage3.setBackground(cool_balaclavas_are_forever);
                stage3.setText("Ossuary");
                stage3.setBorder(baseBorder);
                panel3.setIcon(ossuaryImg);
                panel3.setBorder(baseBorder);
                floor3.setBackground(cool_balaclavas_are_forever);
                floor3.setBorder(baseBorder);
                break;
            case "Ramparts":
                stage3.setBackground(cool_balaclavas_are_forever);
                stage3.setText("Ramparts");
                stage3.setBorder(baseBorder);
                panel3.setIcon(rampartImg);
                panel3.setBorder(baseBorder);
                floor3.setBackground(cool_balaclavas_are_forever);
                floor3.setBorder(baseBorder);
                break;
            case "Ancient Sewers":
                stage3.setBackground(cool_balaclavas_are_forever);
                stage3.setText("Ancient Sewers");
                stage3.setBorder(baseBorder);
                panel3.setIcon(aSewerImg);
                panel3.setBorder(baseBorder);
                floor3.setBackground(cool_balaclavas_are_forever);
                floor3.setBorder(baseBorder);
                break;
            case "Dracula's Castle (Depth 3)":
                stage3.setBackground(chilli_black_red);
                stage3.setText("Dracula's Castle");
                stage3.setBorder(castlevaniaBorder);
                panel3.setIcon(dCastleImg);
                panel3.setBorder(castlevaniaBorder);
                floor3.setBackground(chilli_black_red);
                floor3.setBorder(castlevaniaBorder);
                break;
        }

        switch (path[4])
        {
            case "Nest":
                stage4.setBackground(queen_of_trees);
                stage4.setText("Nest");
                stage4.setBorder(badSeedBorder);
                panel4.setIcon(nestImg);
                panel4.setBorder(badSeedBorder);
                floor4.setBackground(queen_of_trees);
                floor4.setText("Mama Tick Boss Fight");
                floor4.setBorder(badSeedBorder);
                break;
            case "Black Bridge":
                stage4.setBackground(cool_balaclavas_are_forever);
                stage4.setText("Black Bridge");
                stage4.setBorder(baseBorder);
                panel4.setIcon(bBridgeImg);
                panel4.setBorder(baseBorder);
                floor4.setBackground(cool_balaclavas_are_forever);
                floor4.setText("Concierge Boss Fight");
                floor4.setBorder(baseBorder);
                break;
            case "Insufferable Crypt":
                stage4.setBackground(cool_balaclavas_are_forever);
                stage4.setText("Insufferable Crypt");
                stage4.setBorder(baseBorder);
                panel4.setIcon(cryptImg);
                panel4.setBorder(baseBorder);
                floor4.setBackground(cool_balaclavas_are_forever);
                floor4.setText("Conjunctivius Boss Fight");
                floor4.setBorder(baseBorder);
                break;
            case "Defiled Necropolis":
                stage4.setBackground(chilli_black_red);
                stage4.setText("Defiled Necropolis");
                stage4.setBorder(castlevaniaBorder);
                panel4.setIcon(defiledImg);
                panel4.setBorder(castlevaniaBorder);
                floor4.setBackground(chilli_black_red);
                floor4.setText("Death Boss Fight");
                floor4.setBorder(castlevaniaBorder);
                break;
        }

        switch (path[5])
        {
            case "Fractured Shrines":
                stage5.setBackground(pullman_green);
                stage5.setText("Fractured Shrines");
                stage5.setBorder(fallsBorder);
                panel5.setIcon(shrinesImg);
                panel5.setBorder(fallsBorder);
                floor5.setBackground(pullman_green);
                floor5.setIcon(legendaryImg);
                floor5.setText("Floor 5 (Legendary Item)");
                floor5.setBorder(fallsBorder);
                break;
            case "Stilt Village":
                stage5.setBackground(cool_balaclavas_are_forever);
                stage5.setText("Stilt Village");
                stage5.setBorder(baseBorder);
                panel5.setIcon(villageImg);
                panel5.setBorder(baseBorder);
                floor5.setBackground(cool_balaclavas_are_forever);
                floor5.setBorder(baseBorder);
                break;
            case "Slumbering Sanctuary":
                stage5.setBackground(cool_balaclavas_are_forever);
                stage5.setText("Slumbering Sanctuary");
                stage5.setBorder(baseBorder);
                panel5.setIcon(sanctuaryImg);
                panel5.setBorder(baseBorder);
                floor5.setBackground(cool_balaclavas_are_forever);
                floor5.setBorder(baseBorder);
                break;
            case "Graveyard":
                stage5.setBackground(cool_balaclavas_are_forever);
                stage5.setText("Graveyard");
                stage5.setBorder(baseBorder);
                panel5.setIcon(graveyardImg);
                panel5.setBorder(baseBorder);
                floor5.setBackground(cool_balaclavas_are_forever);
                floor5.setBorder(baseBorder);
                break;
        }

        switch (path[6])
        {
            case "Undying Shores":
                stage6.setBackground(pullman_green);
                stage6.setText("Undying Shores");
                stage6.setBorder(fallsBorder);
                panel6.setIcon(shoresImg);
                panel6.setBorder(fallsBorder);
                floor6.setBackground(pullman_green);
                floor6.setBorder(fallsBorder);
                break;
            case "Clock Tower":
                stage6.setBackground(cool_balaclavas_are_forever);
                stage6.setText("Clock Tower");
                stage6.setBorder(baseBorder);
                panel6.setIcon(cTowerImg);
                panel6.setBorder(baseBorder);
                floor6.setBackground(cool_balaclavas_are_forever);
                floor6.setBorder(baseBorder);
                break;
            case "Forgotten Sepulcher":
                stage6.setBackground(cool_balaclavas_are_forever);
                stage6.setText("Forgotten Sepulcher");
                stage6.setBorder(baseBorder);
                panel6.setIcon(sepulcherImg);
                panel6.setBorder(baseBorder);
                floor6.setBackground(cool_balaclavas_are_forever);
                floor6.setBorder(baseBorder);
                break;
            case "Cavern":
                stage6.setBackground(cool_balaclavas_are_forever);
                stage6.setText("Cavern");
                stage6.setBorder(giantBorder);
                panel6.setIcon(cavernImg);
                panel6.setBorder(giantBorder);
                floor6.setBackground(cool_balaclavas_are_forever);
                floor6.setBorder(giantBorder);
                break;
        }

        switch (path[7])
        {
            case "Mausoleum":
                stage7.setBackground(pullman_green);
                stage7.setText("Mausoleum");
                stage7.setBorder(fallsBorder);
                panel7.setIcon(mausoleumImg);
                panel7.setBorder(fallsBorder);
                floor7.setBackground(pullman_green);
                floor7.setText("Scarecrow Boss Fight");
                floor7.setBorder(fallsBorder);
                break;
            case "Clock Room":
                stage7.setBackground(cool_balaclavas_are_forever);
                stage7.setText("Clock Room");
                stage7.setBorder(baseBorder);
                panel7.setIcon(cRoomImg);
                panel7.setBorder(baseBorder);
                floor7.setBackground(cool_balaclavas_are_forever);
                floor7.setText("Time Keeper Boss Fight");
                floor7.setBorder(baseBorder);
                break;
            case "Guardian's Haven":
                stage7.setBackground(cool_balaclavas_are_forever);
                stage7.setText("Guardian's Haven");
                stage7.setBorder(giantBorder);
                panel7.setIcon(guardianImg);
                panel7.setBorder(giantBorder);
                floor7.setBackground(cool_balaclavas_are_forever);
                floor7.setText("Giant Boss Fight");
                floor7.setBorder(giantBorder);
                break;
        }

        switch (path[8])
        {
            case "Infested Shipwreck":
                stage8.setBackground(blackcurrant);
                stage8.setText("Infested Shipwreck");
                stage8.setBorder(queenBorder);
                panel8.setIcon(infestedImg);
                panel8.setBorder(queenBorder);
                floor8.setBackground(blackcurrant);
                floor8.setBorder(queenBorder);
                break;
            case "Derelict Distillery":
                stage8.setBackground(cool_balaclavas_are_forever);
                stage8.setText("Derelict Distillery");
                stage8.setBorder(baseBorder);
                panel8.setIcon(derelictImg);
                panel8.setBorder(baseBorder);
                floor8.setBackground(cool_balaclavas_are_forever);
                floor8.setBorder(baseBorder);
                break;
            case "High Peak Castle":
                stage8.setBackground(cool_balaclavas_are_forever);
                stage8.setText("High Peak Castle");
                stage8.setBorder(baseBorder);
                panel8.setIcon(hPeakCastleImg);
                panel8.setBorder(baseBorder);
                floor8.setBackground(cool_balaclavas_are_forever);
                floor8.setBorder(baseBorder);
                break;
            case "SKIPPED":
                stage8.setBackground(midnight_express);
                stage8.setText("Proceed to Throne Room");
                stage8.setBorder(orangeBorder);
                panel8.setIcon(tKeyImg);
                panel8.setBorder(orangeBorder);
                floor8.setBackground(midnight_express);
                floor8.setText("N/A");
                floor8.setBorder(orangeBorder);
                break;
            case "Dracula's Castle (Depth 6)":
                stage8.setBackground(chilli_black_red);
                stage8.setText("Dracula's Castle");
                stage8.setBorder(castlevaniaBorder);
                panel8.setIcon(dCastleImg);
                panel8.setBorder(castlevaniaBorder);
                floor8.setBackground(chilli_black_red);
                floor8.setBorder(castlevaniaBorder);
                break;
        }

        switch (path[9])
        {
            case "Lighthouse":
                stage9.setBackground(blackcurrant);
                stage9.setText("Lighthouse");
                stage9.setBorder(queenBorder);
                panel9.setIcon(lighthouseImg);
                panel9.setBorder(queenBorder);
                floor9.setBackground(blackcurrant);
                floor9.setText("Servants Boss Fight");
                floor9.setBorder(queenBorder);
                break;
            case "Throne Room":
                stage9.setBackground(cool_balaclavas_are_forever);
                stage9.setText("Throne Room");
                stage9.setBorder(baseBorder);
                panel9.setIcon(tRoomImg);
                panel9.setBorder(baseBorder);
                floor9.setBackground(cool_balaclavas_are_forever);
                floor9.setText("Hand of the King Boss Fight");
                floor9.setBorder(baseBorder);
                break;
            case "Master's Keep":
                stage9.setBackground(chilli_black_red);
                stage9.setText("Master's Keep");
                stage9.setBorder(castlevaniaBorder);
                panel9.setIcon(masterImg);
                panel9.setBorder(castlevaniaBorder);
                floor9.setBackground(chilli_black_red);
                floor9.setText("Dracula Boss Fight");
                floor9.setBorder(castlevaniaBorder);
                break;
        }

        switch (path[10])
        {
            case "The Crown":
                stage10.setBackground(blackcurrant);
                stage10.setText("The Crown");
                stage10.setBorder(queenBorder);
                panel10.setIcon(crownImg);
                panel10.setBorder(queenBorder);
                floor10.setBackground(blackcurrant);
                floor10.setText("The Queen Boss Fight");
                floor10.setBorder(queenBorder);
                break;
            case "Astrolab":
                stage10.setBackground(rustic_red);
                stage10.setText("Astrolab");
                stage10.setBorder(bs5Border);
                panel10.setIcon(aLabImg);
                panel10.setBorder(bs5Border);
                floor10.setBackground(rustic_red);
                floor10.setBorder(bs5Border);
                break;
            case "LOCKED":
                stage10.setBackground(rustic_red);
                stage10.setText("???");
                stage10.setBorder(bs5Border);
                panel10.setIcon(lCellImg);
                panel10.setBorder(bs5Border);
                floor10.setBackground(rustic_red);
                floor10.setText("BSC 5 Required");
                floor10.setBorder(bs5Border);
                break;
            case "NONE":
                stage10.setVisible(false);
                panel10.setVisible(false);
                floor10.setVisible(false);
                break;
        }

        switch (path[11])
        {
            case "Observatory":
                stage11.setBackground(rustic_red);
                stage11.setText("Observatory");
                stage11.setBorder(bs5Border);
                panel11.setIcon(observeImg);
                panel11.setBorder(bs5Border);
                floor11.setBackground(rustic_red);
                floor11.setText("The Collector Boss Fight");
                floor11.setBorder(bs5Border);
                break;
            case "LOCKED":
                stage11.setBackground(rustic_red);
                stage11.setText("???");
                stage11.setBorder(bs5Border);
                panel11.setIcon(lCellImg);
                panel11.setBorder(bs5Border);
                floor11.setBackground(rustic_red);
                floor11.setText("BSC 5 Required");
                floor11.setBorder(bs5Border);
                break;
            case "NONE":
                stage11.setVisible(false);
                panel11.setVisible(false);
                floor11.setVisible(false);
                break;
        }

        pScrollLabel.setText("x " + rewards[0]);
        dScrollLabel.setText("x " + rewards[1]);
        sFragLabel.setText("x " + rewards[2]);
        tChestLabel.setText("x " + rewards[3]);
        cChestLabel.setText("x " + rewards[4]);
        cChestPercentLabel.setText(rewards[5] + "%");
    } // end biomes
    

    // main function
    public static void main(String[] args) {
        JFrame frame = new DCRouteRandomizer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
} // end class