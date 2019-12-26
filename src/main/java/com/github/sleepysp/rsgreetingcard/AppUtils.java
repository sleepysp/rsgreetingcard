package com.github.sleepysp.rsgreetingcard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.apache.log4j.Logger;

/**
 *
 *
 * @author   shernpoh
 * @since    24 Dec, 2019, 2:43:20 am
 */
public class AppUtils
{
    
    private static final Logger logger = Logger.getLogger(AppUtils.class);
    
    private static String[] fontFamilyNames = null;

    private static Map<String, FontUIResource> loadedFontMap = new HashMap<String, FontUIResource>();
    
    
    // Instance Creation **************************************************
    
    private AppUtils() {
    }
    
    // Public API *********************************************************
    
    
    public static ImageIcon readImageIcon(String loc) {
        ImageIcon ico = null; 
    
        if (loc == null) {
            return new ImageIcon();
        }
        
        if (loc.startsWith("http:") || loc.startsWith("https:")) {
            try {
                URL url = new URL(loc);
                ico = new ImageIcon(url);
            }
            catch (Exception e) {
                logger.info("Unable to load from URL. url: " + loc);
                ico = new ImageIcon();
            }
        }
        else if (loc.startsWith("classpath:")) {
            try {
                String cpLoc = loc.replaceAll("classpath:", "");
                URL url = AppUtils.class.getResource(cpLoc);
                ico = new ImageIcon(url);
            }
            catch (Exception e) {
                logger.info("Unable to load from classpath. url: " + loc);
                ico = new ImageIcon();
            }
        }
        else {
            ico = new ImageIcon(loc);
        }
        
        return ico;
    }
 
    
    public static String[] getFontFamilies() {
        if (fontFamilyNames == null) {
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            fontFamilyNames = env.getAvailableFontFamilyNames();
        }
        return fontFamilyNames;
    }

    public static void close(Closeable stream) {
        if (stream == null) {
            return;
        }
        
        try {
            stream.close();
        }
        catch (Exception ex) {
            logger.debug("Unable to close stream. Ex: " + ex);
        }
    }

    public static File pathAsFile(final String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        
        File file = null;
        if (path.startsWith("http:") || path.startsWith("https:")) {
            try {
                URL url = new URL(path);
                file = new File(url.toURI());
            }
            catch (Exception e) {
                logger.info("Unable to load from URL. url: " + path);
                file = new File(path);
            }
        }
        else if (path.startsWith("classpath:")) {
            try {
                String cpLoc = path.replaceAll("classpath:", "");
                URL url = AppUtils.class.getResource(cpLoc);
                file = new File(url.toURI());
            }
            catch (Exception e) {
                logger.info("Unable to load from classpath. url: " + path);
                file = new File(path);
            }
        }
        else {
            file = new File(path);
        }

        return file;
    }

    
    public static Dimension getImageDim(final String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        
        Dimension dim = getImageDim(pathAsFile(path));
        return dim;
    }
    
    
    // https://stackoverflow.com/questions/672916/how-to-get-image-height-and-width-using-java
    public static Dimension getImageDim(final File file) {
        Dimension result = null;
        
        if (file == null) {
            return null;
        }
        
        String path   = file.getAbsolutePath();
        String suffix = getFileSuffix(path);
        Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
        if (iter.hasNext()) {
            ImageReader reader = iter.next();
            ImageInputStream stream = null;
            try {
                stream = new FileImageInputStream(file);
                reader.setInput(stream);
                int width = reader.getWidth(reader.getMinIndex());
                int height = reader.getHeight(reader.getMinIndex());
                result = new Dimension(width, height);
            } 
            catch (IOException e) {
                logger.error(e.getMessage());
            }
            finally {
                close(stream);
                reader.dispose();
            }
        }
        else {
            logger.error("No reader found for given format: " + suffix);
        }
        return result;
    }


    public static String getFileSuffix(final String path) {
        String result = null;
        if (path != null) {
            result = "";
            if (path.lastIndexOf('.') != -1) {
                result = path.substring(path.lastIndexOf('.'));
                if (result.startsWith(".")) {
                    result = result.substring(1);
                }
            }
        }
        return result;
    }

    public static String colorHex(Color color) {
        if (color == null) {
            return null;
        }

        String hex = Integer.toHexString(color.getRGB());

        // Reduced to RGB: hex -> "#ff0000"
        hex = "#" + hex.substring(2, hex.length());
        return hex.toUpperCase();
    }
    
    
    public static int[] toIntArray(final String txt) {
        if (txt == null) {
            return null;
        }

        
        String[] parts = txt.replaceAll("\\s", "").split(",");
        
        if (parts == null) {
            return null;
        }
        
        if (parts.length == 0) {
            return new int[0];
        }
        
        int[] arr = new int[parts.length];
        
        for (int i = 0; i < arr.length; i++) {
            String part = parts[i];
            
            part = part.trim();
            
            arr[i] = Integer.parseInt(part);
        }
        
        return arr;
    }

    
    @SuppressWarnings("rawtypes")
    public static void setSelectedItem(JComboBox cb, String value) {
        if (cb == null || value == null) {
            return;
        }
        
        for (int i = 0; i < cb.getItemCount(); i++) {
            String item = "" + cb.getItemAt(i);
            
            if (value.equals(item)) {
                cb.setSelectedIndex(i);
                break;
            }
        }
    }


    public static void updateUIFonts() {
        FontUIResource font = createFont("Arial Unicode MS", Font.PLAIN, 14);
        updateFont_Dialog(font);
        updateFont_Menu(font);
        updateFont_Text(font);
    }
    
    
    
    private static void updateFont_Dialog(FontUIResource newFont) {
        FontUIResource font = newFont;
        
        if (font == null) {
            return;
        }
        
        // OptionPane & Dialogs
        UIManager.put("OptionPane.font", font);
        UIManager.put("OptionPane.buttonFont", font);
        UIManager.put("OptionPane.messageFont", font);
        UIManager.put("ColorChooser.font", font);
        UIManager.put("FileChooser.listFont", font);
        // InternalFrame
        UIManager.put("InternalFrame.titleFont", font);
        UIManager.put("InternalFrame.paletteTitleFont", font);
        UIManager.put("InternalFrame.optionDialogTitleFont", font);
        // ToolBar
        UIManager.put("ToolBar.font", font);

    }

    
    private static void updateFont_Menu(FontUIResource newFont) {
        FontUIResource font = newFont;
        
        if (font == null) {
            return;
        }

        // Menu
        UIManager.put("Menu.font", font);
        UIManager.put("MenuBar.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("RadioButtonMenuItem.font", font);
        UIManager.put("PopupMenu.font", font);
        // Menu Accelerator
        UIManager.put("Menu.acceleratorFont", font);
        UIManager.put("MenuItem.acceleratorFont", font);
        UIManager.put("CheckBoxMenuItem.acceleratorFont", font);
        UIManager.put("RadioButtonMenuItem.acceleratorFont", font);
    }
    
    private static void updateFont_Text(FontUIResource newFont) {     
        FontUIResource font = newFont;
        
        if (font == null) {
            return;
        }


        // Text
        UIManager.put("TextField.font", font);        
        UIManager.put("CheckBox.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("EditorPane.font", font);
        UIManager.put("FormattedTextField.font", font);
        UIManager.put("List.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("ProgressBar.font", font);
        UIManager.put("ScrollPane.font", font);
        UIManager.put("Slider.font", font);
        UIManager.put("Spinner.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TextPane.font", font);
        // Label
        UIManager.put("Label.font", font);
        UIManager.put("Panel.font", font);
        UIManager.put("Viewport.font", font);
        // Button
        UIManager.put("Button.font", font);
        UIManager.put("JideButton.font", font);
        UIManager.put("JideSplitButton.font", font);
        UIManager.put("IconButton.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("ToggleButton.font", font);
        // TabbedPane
        UIManager.put("TabbedPane.font", font);
        UIManager.put("TabbedPane.smallFont", font);
        UIManager.put("JideTabbedPane.font", font);
        UIManager.put("JideTabbedPane.selectedTabFont", font);
        // TitledBorder
        UIManager.put("TitledBorder.font", font);
        // ToolTip
        UIManager.put("ToolTip.font", font);
        // Table
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        // Tree
        UIManager.put("Tree.font", font);
        
        
        FontUIResource ttlFont = createFont(font, Font.BOLD, font.getSize());
        UIManager.put("TitledBorder.font", ttlFont);
        UIManager.put("JideTabbedPane.selectedTabFont", ttlFont);

    }
    
    
    public static FontUIResource createFont(String fontName, int fontStyle, int fontSize) {
        if (fontName == null) {
            return null;
        }

        String fontKey = fontName + '|' + fontStyle + '|' + fontSize;

        FontUIResource rst = loadedFontMap.get(fontKey);
        if (rst == null) {
            Font font = new Font(fontName, fontStyle, fontSize);
            rst = new FontUIResource(font.deriveFont(fontStyle, fontSize));
            loadedFontMap.put(fontKey, rst);
        }

        return rst;
    }
    
    public static FontUIResource createFont(Font font, int fontStyle, int fontSize) {
        if (font == null) {
            return null;
        }

        String fontName = font.getName();
        String fontKey = fontName + '|' + fontStyle + '|' + fontSize;

        FontUIResource rst = loadedFontMap.get(fontKey);
        if (rst == null) {
            rst = new FontUIResource(font.deriveFont(fontStyle, fontSize));
            loadedFontMap.put(fontKey, rst);
        }

        return rst;
    }


}
