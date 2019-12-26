package com.github.sleepysp.rsgreetingcard;

import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import org.apache.log4j.Logger;

/**
 *
 *
 * @author   shernpoh
 * @since    24 Dec, 2019, 11:31:57 am
 */
final class FontListCellRenderer extends DefaultListCellRenderer
{
    private static final Logger logger = Logger.getLogger(FontListCellRenderer.class);

    String fontName = "Arial"; 
    Font   defFont = null;
    
    Map<String, Font> fontMap = new HashMap<String, Font>(); 
    
    public FontListCellRenderer() {
        JLabel lbl = new JLabel();
        fontName = lbl.getFont().getName();
        defFont = lbl.getFont();
    }
    
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, 
        int index, boolean isSelected, boolean cellHasFocus) {
        
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        fontName = "" + value.toString();
        Font font = getFont(fontName);
        this.setFont(font);

        return this;
    }
    
    
    private Font getFont(String name) {
        Font f = null;
        
        f = fontMap.get(name);
        
        if (f == null) {
            Font font = null;
            
            try {
                font = new Font(name, Font.PLAIN, 16);
            }
            catch (Exception e) {
                name = defFont.getName();
                
                font = new Font(name, Font.PLAIN, 16);
                this.setFont(font);
            }
            
            fontMap.put(name, font);
        }
        
        return f;
    }
}