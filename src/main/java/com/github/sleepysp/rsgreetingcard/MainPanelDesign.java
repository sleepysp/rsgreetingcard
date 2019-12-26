/*
 * Created by JFormDesigner on Mon Dec 23 18:59:07 SGT 2019
 */

package com.github.sleepysp.rsgreetingcard;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * @author User #1 using JFormDesigner
 * @since  Mon Dec 23 18:59:07 SGT 2019
 */
class MainPanelDesign extends JPanel {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    JSplitPane splMain;
    JScrollPane scpImage;
    JLabel pnlImage;
    JPanel pnlRight;
    JPanel pnlImgOpts;
    JLabel lblImgLoc;
    JTextField txtImgLoc;
    JButton btnImgLocBrw;
    JButton btnImgLoad;
    JLabel lblFont;
    JComboBox cboFont;
    JLabel lblFontSize;
    JComboBox cboFontSize;
    JToolBar tbrFontStyle;
    JToggleButton tgbBold;
    JToggleButton tgbItalics;
    private JLabel lblFontColor;
    JLabel lblFontColorDisp;
    private JPanel panel1;
    JTextField txtFontColor;
    JTextField txtFontColorHex;
    JButton btnFontColorLoad;
    JLabel lblOffset01;
    JTextField txtOffset01;
    JCheckBox chkOffset01OneClick;
    JLabel lblText02;
    JTextField txtText01;
    JTabbedPane tabPanel;
    JPanel pnlTabPreview;
    JLabel lblName;
    JTextField txtName;
    JButton btnPreviewGen;
    JButton btnPreviewReset;
    private JPanel pnlAutoPreview;
    JCheckBox chkAutoPreview;
    JPanel pnlTabBatch;
    JLabel lblReceivers;
    JScrollPane scpReceivers;
    JEditorPane txtReceivers;
    JLabel lblDestFormat;
    JComboBox cboDestFormat;
    JLabel lblDestPath;
    JTextField txtDestPath;
    JButton btnDestPathBrw;
    JLabel lblDestFilePre;
    JTextField txtDestFilePre;
    JButton btnBatchRun;
    private JButton btnBatchCancel;
    JPanel pnlStatusBar;
    JLabel lblImageDim;
    JLabel txtCoord;
    JProgressBar pbrProgress;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    MainPanelDesign() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        splMain = new JSplitPane();
        scpImage = new JScrollPane();
        pnlImage = new JLabel();
        pnlRight = new JPanel();
        pnlImgOpts = new JPanel();
        lblImgLoc = new JLabel();
        txtImgLoc = new JTextField();
        btnImgLocBrw = new JButton();
        btnImgLoad = new JButton();
        lblFont = new JLabel();
        cboFont = new JComboBox();
        lblFontSize = new JLabel();
        cboFontSize = new JComboBox();
        tbrFontStyle = new JToolBar();
        tgbBold = new JToggleButton();
        tgbItalics = new JToggleButton();
        lblFontColor = new JLabel();
        lblFontColorDisp = new JLabel();
        panel1 = new JPanel();
        txtFontColor = new JTextField();
        txtFontColorHex = new JTextField();
        btnFontColorLoad = new JButton();
        lblOffset01 = new JLabel();
        txtOffset01 = new JTextField();
        chkOffset01OneClick = new JCheckBox();
        lblText02 = new JLabel();
        txtText01 = new JTextField();
        tabPanel = new JTabbedPane();
        pnlTabPreview = new JPanel();
        lblName = new JLabel();
        txtName = new JTextField();
        btnPreviewGen = new JButton();
        btnPreviewReset = new JButton();
        pnlAutoPreview = new JPanel();
        chkAutoPreview = new JCheckBox();
        pnlTabBatch = new JPanel();
        lblReceivers = new JLabel();
        scpReceivers = new JScrollPane();
        txtReceivers = new JEditorPane();
        lblDestFormat = new JLabel();
        cboDestFormat = new JComboBox();
        lblDestPath = new JLabel();
        txtDestPath = new JTextField();
        btnDestPathBrw = new JButton();
        lblDestFilePre = new JLabel();
        txtDestFilePre = new JTextField();
        btnBatchRun = new JButton();
        btnBatchCancel = new JButton();
        pnlStatusBar = new JPanel();
        lblImageDim = new JLabel();
        txtCoord = new JLabel();
        pbrProgress = new JProgressBar();

        //======== this ========
        setPreferredSize(new Dimension(700, 500));
        setLayout(new BorderLayout());

        //======== splMain ========
        {
            splMain.setDividerLocation(400);
            splMain.setOneTouchExpandable(true);

            //======== scpImage ========
            {
                scpImage.setPreferredSize(new Dimension(320, 500));

                //---- pnlImage ----
                pnlImage.setHorizontalAlignment(SwingConstants.LEFT);
                pnlImage.setVerticalAlignment(SwingConstants.TOP);
                pnlImage.setBackground(UIManager.getColor("Desktop.background"));
                pnlImage.setOpaque(true);
                scpImage.setViewportView(pnlImage);
            }
            splMain.setLeftComponent(scpImage);

            //======== pnlRight ========
            {
                pnlRight.setPreferredSize(new Dimension(380, 500));
                pnlRight.setLayout(new BorderLayout());

                //======== pnlImgOpts ========
                {
                    pnlImgOpts.setBorder(new CompoundBorder(
                        new TitledBorder("Image Options"),
                        new EmptyBorder(5, 5, 5, 5)));
                    pnlImgOpts.setLayout(new GridBagLayout());
                    ((GridBagLayout)pnlImgOpts.getLayout()).columnWidths = new int[] {0, 25, 130, 0, 0, 0};
                    ((GridBagLayout)pnlImgOpts.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)pnlImgOpts.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)pnlImgOpts.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- lblImgLoc ----
                    lblImgLoc.setText("Image Location:");
                    pnlImgOpts.add(lblImgLoc, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtImgLoc ----
                    txtImgLoc.setText("classpath:/holiday_loading.jpg");
                    pnlImgOpts.add(txtImgLoc, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnImgLocBrw ----
                    btnImgLocBrw.setText("...");
                    pnlImgOpts.add(btnImgLocBrw, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnImgLoad ----
                    btnImgLoad.setText("Load");
                    pnlImgOpts.add(btnImgLoad, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- lblFont ----
                    lblFont.setText("Font:");
                    pnlImgOpts.add(lblFont, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- cboFont ----
                    cboFont.setEditable(true);
                    pnlImgOpts.add(cboFont, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- lblFontSize ----
                    lblFontSize.setText("Font Size:");
                    pnlImgOpts.add(lblFontSize, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- cboFontSize ----
                    cboFontSize.setEditable(true);
                    cboFontSize.setModel(new DefaultComboBoxModel(new String[] {
                        "8",
                        "9",
                        "10",
                        "11",
                        "12",
                        "14",
                        "16",
                        "18",
                        "20",
                        "22",
                        "24",
                        "26",
                        "28",
                        "36",
                        "48",
                        "72",
                        "96"
                    }));
                    cboFontSize.setSelectedIndex(6);
                    pnlImgOpts.add(cboFontSize, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //======== tbrFontStyle ========
                    {
                        tbrFontStyle.setFloatable(false);

                        //---- tgbBold ----
                        tgbBold.setText("Bold");
                        tgbBold.setFont(tgbBold.getFont().deriveFont(tgbBold.getFont().getStyle() | Font.BOLD));
                        tbrFontStyle.add(tgbBold);

                        //---- tgbItalics ----
                        tgbItalics.setText("Italics");
                        tgbItalics.setFont(tgbItalics.getFont().deriveFont(tgbItalics.getFont().getStyle() | Font.ITALIC));
                        tbrFontStyle.add(tgbItalics);
                    }
                    pnlImgOpts.add(tbrFontStyle, new GridBagConstraints(3, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- lblFontColor ----
                    lblFontColor.setText("Font Color:");
                    pnlImgOpts.add(lblFontColor, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- lblFontColorDisp ----
                    lblFontColorDisp.setText(" ");
                    lblFontColorDisp.setBackground(Color.white);
                    lblFontColorDisp.setOpaque(true);
                    lblFontColorDisp.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
                    pnlImgOpts.add(lblFontColorDisp, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //======== panel1 ========
                    {
                        panel1.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 10, 0, 0};
                        ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                        ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0, 1.0E-4};
                        ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                        //---- txtFontColor ----
                        txtFontColor.setBackground(Color.white);
                        txtFontColor.setText("255,255,255");
                        panel1.add(txtFontColor, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));

                        //---- txtFontColorHex ----
                        txtFontColorHex.setBackground(Color.white);
                        txtFontColorHex.setText("#FFFFFF");
                        panel1.add(txtFontColorHex, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    pnlImgOpts.add(panel1, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- btnFontColorLoad ----
                    btnFontColorLoad.setText("...");
                    pnlImgOpts.add(btnFontColorLoad, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- lblOffset01 ----
                    lblOffset01.setText("Offset 01:");
                    pnlImgOpts.add(lblOffset01, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- txtOffset01 ----
                    txtOffset01.setText("0,0");
                    pnlImgOpts.add(txtOffset01, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- chkOffset01OneClick ----
                    chkOffset01OneClick.setText("One click");
                    pnlImgOpts.add(chkOffset01OneClick, new GridBagConstraints(3, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- lblText02 ----
                    lblText02.setText("Text 01:");
                    pnlImgOpts.add(lblText02, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- txtText01 ----
                    txtText01.setText("Dear ${name},");
                    pnlImgOpts.add(txtText01, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                pnlRight.add(pnlImgOpts, BorderLayout.NORTH);

                //======== tabPanel ========
                {
                    tabPanel.setPreferredSize(new Dimension(200, 64));

                    //======== pnlTabPreview ========
                    {
                        pnlTabPreview.setBorder(new EmptyBorder(5, 5, 5, 5));
                        pnlTabPreview.setLayout(new GridBagLayout());
                        ((GridBagLayout)pnlTabPreview.getLayout()).columnWidths = new int[] {0, 130, 0, 0, 0};
                        ((GridBagLayout)pnlTabPreview.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                        ((GridBagLayout)pnlTabPreview.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)pnlTabPreview.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};

                        //---- lblName ----
                        lblName.setText("Name:");
                        pnlTabPreview.add(lblName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- txtName ----
                        txtName.setText("Toto");
                        pnlTabPreview.add(txtName, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- btnPreviewGen ----
                        btnPreviewGen.setText("Preview");
                        pnlTabPreview.add(btnPreviewGen, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnPreviewReset ----
                        btnPreviewReset.setText("Reset");
                        pnlTabPreview.add(btnPreviewReset, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //======== pnlAutoPreview ========
                        {
                            pnlAutoPreview.setLayout(new FlowLayout(FlowLayout.RIGHT));

                            //---- chkAutoPreview ----
                            chkAutoPreview.setText("Auto Preview");
                            chkAutoPreview.setSelected(true);
                            pnlAutoPreview.add(chkAutoPreview);
                        }
                        pnlTabPreview.add(pnlAutoPreview, new GridBagConstraints(0, 3, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    tabPanel.addTab("Preview", pnlTabPreview);


                    //======== pnlTabBatch ========
                    {
                        pnlTabBatch.setBorder(new EmptyBorder(5, 5, 5, 5));
                        pnlTabBatch.setLayout(new GridBagLayout());
                        ((GridBagLayout)pnlTabBatch.getLayout()).columnWidths = new int[] {0, 130, 0, 0, 0};
                        ((GridBagLayout)pnlTabBatch.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0};
                        ((GridBagLayout)pnlTabBatch.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};
                        ((GridBagLayout)pnlTabBatch.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                        //---- lblReceivers ----
                        lblReceivers.setText("Receiver Names:");
                        pnlTabBatch.add(lblReceivers, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //======== scpReceivers ========
                        {
                            scpReceivers.setViewportView(txtReceivers);
                        }
                        pnlTabBatch.add(scpReceivers, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- lblDestFormat ----
                        lblDestFormat.setText("Destination Format:");
                        pnlTabBatch.add(lblDestFormat, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- cboDestFormat ----
                        cboDestFormat.setMaximumRowCount(10);
                        cboDestFormat.setEditable(true);
                        cboDestFormat.setModel(new DefaultComboBoxModel(new String[] {
                            "bmp",
                            "gif",
                            "jpg",
                            "png"
                        }));
                        cboDestFormat.setSelectedIndex(3);
                        pnlTabBatch.add(cboDestFormat, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- lblDestPath ----
                        lblDestPath.setText("Destination Path:");
                        pnlTabBatch.add(lblDestPath, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                        pnlTabBatch.add(txtDestPath, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnDestPathBrw ----
                        btnDestPathBrw.setText("...");
                        btnDestPathBrw.setPreferredSize(new Dimension(25, 23));
                        pnlTabBatch.add(btnDestPathBrw, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- lblDestFilePre ----
                        lblDestFilePre.setText("Destination Filename Prefix:");
                        pnlTabBatch.add(lblDestFilePre, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                        pnlTabBatch.add(txtDestFilePre, new GridBagConstraints(0, 7, 3, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- btnBatchRun ----
                        btnBatchRun.setText("Run Batch");
                        pnlTabBatch.add(btnBatchRun, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- btnBatchCancel ----
                        btnBatchCancel.setText("Cancel");
                        pnlTabBatch.add(btnBatchCancel, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    tabPanel.addTab("Batch", pnlTabBatch);

                }
                pnlRight.add(tabPanel, BorderLayout.CENTER);
            }
            splMain.setRightComponent(pnlRight);
        }
        add(splMain, BorderLayout.CENTER);

        //======== pnlStatusBar ========
        {
            pnlStatusBar.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnlStatusBar.setLayout(new GridBagLayout());
            ((GridBagLayout)pnlStatusBar.getLayout()).columnWidths = new int[] {100, 10, 50, 0, 0, 0};
            ((GridBagLayout)pnlStatusBar.getLayout()).rowHeights = new int[] {18, 0};
            ((GridBagLayout)pnlStatusBar.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)pnlStatusBar.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //---- lblImageDim ----
            lblImageDim.setText("0000 x 0000");
            pnlStatusBar.add(lblImageDim, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- txtCoord ----
            txtCoord.setText("0,0");
            pnlStatusBar.add(txtCoord, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            pnlStatusBar.add(pbrProgress, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(pnlStatusBar, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
