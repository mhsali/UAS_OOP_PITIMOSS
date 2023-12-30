/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itenas.uas.view.component.swing;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

/**
 *
 * @author Kelompok
 */
public class ShowPasswordCheckBox extends JCheckBox{
     public ShowPasswordCheckBox() {
        this.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\org\\itenas\\uas\\images\\eyes.png"));
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);
    }
}
