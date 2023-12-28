/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itenas.uas.view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import org.itenas.uas.view.component.PanelCover;
import net.miginfocom.swing.MigLayout;
import org.itenas.uas.view.component.PanelLoginAndRegister;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Win10
 */
public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 45;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###");
    
    
    public Main() {
        initComponents();
        init();
    }

    private void init(){
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loginAndRegister = new PanelLoginAndRegister();
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionlogin;
                double size = coverSize;
                if(fraction <= 0.5f){
                    size += fraction * addSize;
                } else{
                    size += addSize - fraction * addSize;
                }
                if(isLogin){
                    fractionCover = 1f - fraction;
                    fractionlogin = fraction;
                } else{
                    fractionCover = fraction;
                    fractionlogin = 1f - fraction;
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionlogin = Double.valueOf(df.format(fractionlogin));
                layout.setComponentConstraints(cover, "width " +size+ "%, pos " +fractionCover+"al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " +loginSize+ "%, pos " +fractionlogin+"al 0 n 100%");
                background.revalidate();;
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
            
        };
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        background.setLayout(layout);
        background.add(cover, "width "+coverSize+"%, pos 0al 0 n 100%");
        background.add(loginAndRegister, "width "+loginSize+"%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!animator.isRunning()){
                    animator.start();
                }
            }
            
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 977, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    // End of variables declaration//GEN-END:variables
}
