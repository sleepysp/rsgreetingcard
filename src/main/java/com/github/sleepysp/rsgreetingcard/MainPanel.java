/*
 * Created by JFormDesigner on Mon Dec 23 18:04:48 SGT 2019
 */

package com.github.sleepysp.rsgreetingcard;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

import javax.accessibility.Accessible;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.apache.log4j.Logger;


/**
 * @author User #1 using JFormDesigner
 * @since  Mon Dec 23 18:04:48 SGT 2019
 */
class MainPanel extends MainPanelDesign {

    private static final Logger logger = Logger.getLogger(MainPanel.class);
    
    private App app = null;
    
    // Instance Creation **************************************************
    
    public MainPanel() {
        initSvcs();
        initUi();
        initEvents();
    }


    // Building ***********************************************************

    
    
    private void initSvcs() {
        app = App.get();
    }


    @SuppressWarnings("unchecked")
    private void initUi() {
        final String[] fonts = AppUtils.getFontFamilies();
        for (int i = 0; i < fonts.length; i++) {
            cboFont.addItem(fonts[i]);
        }
        
        final int lblFontSize = lblFont.getFont().getSize();
        
        // https://stackoverflow.com/questions/5896282/how-to-prevent-jcombobox-from-becoming-unresponsive-when-using-a-custom-listcell
        cboFont.setPrototypeDisplayValue(lblFontSize + 5);
        Accessible a = cboFont.getUI().getAccessibleChild(cboFont, 0);
        if (a instanceof javax.swing.plaf.basic.ComboPopup) {
            @SuppressWarnings("rawtypes")
            JList popupList = ((javax.swing.plaf.basic.ComboPopup) a).getList();
            // route the comboBox' prototype to the list
            // should happen in BasicComboxBoxUI
            popupList.setPrototypeCellValue(cboFont.getPrototypeDisplayValue());
        }

        cboFont.setRenderer(new FontListCellRenderer());
        
        cboFont.setMaximumRowCount(15);
        
        pbrProgress.setVisible(false);

        
        AppUtils.setSelectedItem(cboFont, "Arial");
        AppUtils.setSelectedItem(cboFontSize, "24");
        
        String homeDir = System.getProperty("user.home");
        txtDestPath.setText(homeDir + File.separator + "greetout");
    }


    
    private void initEvents() {
        pnlImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                
                boolean isLeftClick = SwingUtilities.isLeftMouseButton(me);
                
                if (isLeftClick) {
                    boolean oneClick = chkOffset01OneClick.isSelected();
                    
                    if (oneClick || me.getClickCount() % 2 == 0) {
                        txtOffset01.setText(x + ", " + y);
                        loadImageInContents();
                    }
                }
            }
        });
        
        pnlImage.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                txtCoord.setText(x + ", " + y);
            }
            
            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });
        
        
        txtImgLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fp = txtImgLoc.getText().trim();
                File f = new File(fp);
                
                updateDestFilePrefix(f);
                loadImageInContents();
            }
        });
        
        btnImgLocBrw.addActionListener(new ActionListener() {
            JFileChooser fc = new JFileChooser();

            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setFileFilter(new ImageFileFilter());
                fc.showOpenDialog(app.getMainFrame());
                
                File f = fc.getSelectedFile();
                updateDestFilePrefix(f);
                loadImageInContents();
            }
        });
        
        
        btnImgLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImageInContents();
            }
        });
        
        
        btnPreviewReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImageInContents(false);
            }
        });
        
        btnFontColorLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color ori = getSelectedFontColor();
                Color color = JColorChooser.showDialog(app.getMainFrame(), "Choose Font Color", ori);
                setSelectedFontColor(color);
                
                loadImageInContents();
            }
        });
        
        
        
        txtFontColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = txtFontColor.getText().trim();
                
                if (txt.length() == 0) {
                    return;
                }
                
                try {
                    int[] parts = AppUtils.toIntArray(txt);
                    
                    if (parts.length == 3) {
                        int r = parts[0];
                        int g = parts[1];
                        int b = parts[2];
                        
                        Color c = new Color(r, g, b);
                        setSelectedFontColor(c);
                    }
                }
                catch (Exception ex) {
                    logger.info("Unable to parse color. color = " + txt, ex);
                }
                
                loadImageInContents();
            }
        });
        
        
        txtFontColorHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hex = txtFontColorHex.getText().trim();
                
                if (hex.startsWith("#") == false) {
                    hex = "#" + hex;
                }
                
                try {
                    Color c = Color.decode(hex);
                    setSelectedFontColor(c);
                }
                catch (Exception ex) {
                    logger.info("Unable to parse color hex. " + hex);
                }
                
                loadImageInContents();
            }
        });
        
        btnPreviewGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePreview();
            }
        });
        
        
        ActionListener actLoadImg = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadImageInContents();
            }
        };
        cboFont.addActionListener(actLoadImg);
        cboFontSize.addActionListener(actLoadImg);
        tgbBold.addActionListener(actLoadImg);
        tgbItalics.addActionListener(actLoadImg);
        txtOffset01.addActionListener(actLoadImg);
        
        
        btnDestPathBrw.addActionListener(new ActionListener() {
            JFileChooser fc = new JFileChooser();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.showOpenDialog(app.getMainFrame());
                
                File f = fc.getSelectedFile();
                if (f != null) {
                    String fp = f.getAbsolutePath();
                    txtDestPath.setText(fp);
                }
            }
        });
        
        btnBatchRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String srcFilePath = txtImgLoc.getText();
                final String destFmt     = "" + cboDestFormat.getSelectedItem();
                final String destPath    = txtDestPath.getText().trim();
                final String destPrf     = txtDestFilePre.getText().trim();
                final String nameList    = txtReceivers.getText().trim();
                final String text01Tpl   = txtText01.getText();
                
                final String[] nameArr = nameList.split("\n");
                
                final Color  fontColor = getSelectedFontColor();
                final Font   font      = getSelectedFont();
                final int[]  offset    = AppUtils.toIntArray(txtOffset01.getText());

                
                final File srcFile = AppUtils.pathAsFile(srcFilePath);
                final File destDir = destPath.length() == 0? null : new File(destPath);

                
                if (srcFile == null || srcFile.exists() == false) {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }
                
                
                if (destDir == null || destDir.exists()) {
                    if (destDir.isDirectory() == false) {
                        Toolkit.getDefaultToolkit().beep();
                        return;
                    }
                }
                
                if (destFmt.length() == 0) {
                    if (destDir.isDirectory() == false) {
                        Toolkit.getDefaultToolkit().beep();
                        return;
                    }
                }
                
                btnBatchRun.setEnabled(false);
                
                SwingWorker<Object, Object> worker = new SwingWorker<Object, Object>() {
                    List<String> errList = new ArrayList<String>();
                    int cardCount = 0;
                    @Override
                    protected Object doInBackground() throws Exception {
                        for (int i = 0; i < nameArr.length; i++) {
                            String name = nameArr[i];
                            
                            if (name == null) {
                                continue;
                            }
                            
                            name = name.trim();

                            if (name.length() == 0) {
                                continue;
                            }

                            
                            int num = i + 1;
                            String fileName = destPrf + String.format("_%02d_", num) + name + '.' + destFmt;

                            try {
                                String fileDir  = destPath + File.separator;
                                String text01   = formatText(text01Tpl, name);
                                File   destFile = new File(fileDir, fileName);
                                
                                if (destFile.exists()) {
                                    errList.add("File already exists. name: " + name + ", file: " + fileName);
                                }
                                else {
                                    BufferedImage bi = renderImage(srcFile, text01, fontColor, font, 
                                        offset[0], offset[1]);
                                    
                                    if (bi == null) {
                                        errList.add("Image is NULL. name: " + name + ", file: " + fileName);
                                    }
                                    else {
                                        logger.info("Writing to file: " + destFile); 
                                        ImageIO.write(bi, destFmt, destFile);
                                        cardCount++;
                                    }
                                }
                            }
                            catch (Exception e) {
                                String errMsg = "Unable to output card. name: " + name + ", file: " + fileName;
                                errList.add(errMsg);
                                logger.error(errMsg, e);
                            }
                        }
                        
                        return null;
                    }
                    
                    private BufferedImage renderImage(File srcFile, String text01, 
                        Color fontColor, Font font, int x, int y) {
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(srcFile);
                            img = overlayText(img, text01, fontColor, font, x, y);
                        }
                        catch (Exception e) {
                            logger.error("Unable to load image. Ex: " + e, e);
                        }
                        return img;
                    }

                    @Override
                    protected void done() {
                        try {
                            get();
                        }
                        catch (Exception e) {
                            logger.error("Error running batch. ", e);
                        }
                        
                        if (errList.size() > 0) {
                            JOptionPane.showMessageDialog(app.getMainFrame(), "Errors occurred. " + errList.size());
                            for (String errMsg : errList) {
                                logger.info("error: " + errMsg);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(app.getMainFrame(), cardCount + " cards generated.");
                        }
                        
                        btnBatchRun.setEnabled(true);
                    }
                };
                
                worker.execute();
            }
        });
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int divider = splMain.getDividerLocation();
                                
                if (divider == 0 || divider == 1) {
                    return;
                }
                
                int rWd = pnlRight.getPreferredSize().width;
                int fWd = getSize().width;
                int pf = fWd - rWd;
                pf = Math.max(pf, 0);
                splMain.setDividerLocation(pf);
            }
        });
    }
    
    
    protected void updateDestFilePrefix(File inputImage) {
        File f = inputImage;
        if (f != null && f.exists()) {
            String fp = f.getAbsolutePath();
            String fn = f.getName();
            String fe = AppUtils.getFileSuffix(fn);
            
            txtImgLoc.setText(fp);

            
            String prefix = txtDestFilePre.getText();
            if (prefix.length() == 0) {
                prefix = fn.replace("." + fe, "");
                txtDestFilePre.setText(prefix);
            }
        }
    }


    protected void generatePreview() {
        loadImageInContents(true);
    }


    
    
    // Public API *********************************************************

    public String formatText(String tpl, String name) {
        String msg = "Hello, world!";
        msg = tpl.replace("${name}", name);
        return msg;
    }
    
    public Font getSelectedFont() {
        String fname    = "" + cboFont.getSelectedItem();
        String fsizeStr = "" + cboFontSize.getSelectedItem();
        boolean isBold  = tgbBold.isSelected();
        boolean isItal  = tgbItalics.isSelected();
        
        int fsize = 18;
        int fstyle = 0;
        
        // new Font("Serif", Font.BOLD, 20)
        
        fname = fname.trim();
        fsizeStr = fsizeStr.trim();
        
        if (fname.length() == 0) {
            fname = "Arial Unicode MS";
        }
        
        try {
            fsize = Integer.parseInt(fsizeStr);
        }
        catch (Exception ex) {
            logger.error("Unable to parse font size. size: " + fsizeStr, ex);
        }
        
        
        if (isBold) {
            fstyle += Font.BOLD;
        }
        
        if (isItal) {
            fstyle += Font.ITALIC;
        }
        
        Font font = new Font(fname, fstyle, fsize);
        return font;
    }
    
    

    
    public Color getSelectedFontColor() {
        return lblFontColorDisp.getBackground();
    }
    
    
    public void setSelectedFontColor(Color color) {
        if (color != null) {
            String colorRgb = color.getRed() + ", " 
                    + color.getGreen()  + ", " 
                    + color.getBlue(); 
            String colorHex = AppUtils.colorHex(color);
            txtFontColor.setText(colorRgb);
            txtFontColorHex.setText(colorHex);
            lblFontColorDisp.setBackground(color);
        }
    }

    
    
    public void loadImageInContents() {
        boolean autoPre = chkAutoPreview.isSelected();
        loadImageInContents(autoPre);
    }

    
    public void loadImageInContents(boolean genPreview) {
        /*
        String loc = txtImgLoc.getText().trim();
        
        if (loc.length() == 0) {
            logger.debug("Can't load image file. filename='" + loc + "'");
            return;
        }
        
        ImageIcon ico = AppUtils.readImageIcon(loc);
        updateImageInContents(ico);
        */
        
        String  path = txtImgLoc.getText().trim();
        File    file = AppUtils.pathAsFile(path);
        BufferedImage img = null;

        if (file == null) {
            logger.debug("Can't find image file. filename='" + path + "'");
            return;
        }
        
        try {
            Color  fontColor = getSelectedFontColor();
            Font   font      = getSelectedFont();
            
            String name01 = txtName.getText();
            String text01 = formatText(txtText01.getText(), name01);
            int[]  offset = AppUtils.toIntArray(txtOffset01.getText());
            
            img = ImageIO.read(file);
            
            if (genPreview) {
                logger.info("font: " +  font);
                img = overlayText(img, text01, fontColor, font, offset[0], offset[1]);
            }
            
        }
        catch (Exception ex) {
            logger.info("Unable to gen preview. Ex: " + ex);
        }
        
        
        if (img != null) {
            ImageIcon ico = new ImageIcon(img);
            updateImageInContents(ico);
        }
    }

    
    private void updateImageInContents(ImageIcon ico) {
        if (ico != null) {
            pnlImage.setIcon(ico);
            scpImage.repaint();
            
            lblImageDim.setText(ico.getIconWidth() + " x " + ico.getIconHeight() + " px");
        }
    }
    
    
    private BufferedImage overlayText(BufferedImage old, String text, 
        Color fontColor, Font font, int x, int y) {
        
        if (old == null) {
            return null;
        }
        
        int w = old.getWidth();
        int h = old.getHeight();
        
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = img.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw original image first
        g2d.drawImage(old, 0, 0, w, h, this);
        
        // draw overlay String
        g2d.setPaint(fontColor);
        g2d.setFont(font);
        
        FontMetrics fm = g2d.getFontMetrics();
        
        int fx = x - fm.stringWidth(text) - 5;
        int fy = y + font.getSize();

        fx = x;
        
        // https://stackoverflow.com/questions/9482255/how-do-i-specify-fallback-fonts-in-java2d-graphics2d
        Font uniFont = new Font("Arial Unicode MS", font.getStyle(), font.getSize());
        
        AttributedString astr =createFallbackString(text, font, uniFont);
        g2d.drawString(astr.getIterator(), fx, fy);
        g2d.dispose();
        
        return img;
    }

    private AttributedString createFallbackString(String text, Font mainFont, Font fallbackFont) {
        AttributedString result = new AttributedString(text);

        int textLength = text.length(); 
        result.addAttribute(TextAttribute.FONT, mainFont, 0, textLength);

        boolean fallback = false;
        int fallbackBegin = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean curFallback = !mainFont.canDisplay(text.charAt(i));
            if (curFallback != fallback) {
                fallback = curFallback;
                if (fallback) {
                    fallbackBegin = i;
                } else {
                    result.addAttribute(TextAttribute.FONT, fallbackFont, fallbackBegin, i);
                }
            }
        }
        return result;
    }

    
}
