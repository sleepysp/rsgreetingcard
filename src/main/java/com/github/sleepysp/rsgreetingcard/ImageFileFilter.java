package com.github.sleepysp.rsgreetingcard;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 *
 *
 * @author   shernpoh
 * @since    24 Dec, 2019, 12:09:05 pm
 */
final class ImageFileFilter extends FileFilter
{
    @Override
    public String getDescription() {
        return "Images (*.bmp|*.gif|*.jpg|*.jpeg|*.png)";
    }

    @Override
    public boolean accept(File f) {
        if (f == null ) {
            return false;
        }
        
        if (f.isDirectory()) {
            return true;
        }
        
        String name = "" + f.getName();
        name = name.toLowerCase();
        
        if (name.endsWith(".bmp") 
            || name.endsWith(".gif")
            || name.endsWith(".jpg") || name.endsWith(".jpeg") 
            || name.endsWith(".png") ) {
            return true;
        }
        
        return false;
    }
}