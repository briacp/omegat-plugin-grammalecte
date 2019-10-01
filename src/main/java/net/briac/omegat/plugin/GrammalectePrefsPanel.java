/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2019 Briac Pilpre
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/
package net.briac.omegat.plugin;

public class GrammalectePrefsPanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 8823690595799802407L;

    /**
     * Creates new form GrammalectePrefs
     */
    public GrammalectePrefsPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        panelConfig = new javax.swing.JPanel();
        labelUrl = new javax.swing.JLabel();
        fieldUrl = new javax.swing.JTextField();
        panelTypog = new javax.swing.JPanel();
        prefTypo = new javax.swing.JCheckBox();
        prefApos = new javax.swing.JCheckBox();
        prefEsp = new javax.swing.JCheckBox();
        prefTab = new javax.swing.JCheckBox();
        prefNbsp = new javax.swing.JCheckBox();
        prefUnit = new javax.swing.JCheckBox();
        prefTu = new javax.swing.JCheckBox();
        prefMaj = new javax.swing.JCheckBox();
        prefNum = new javax.swing.JCheckBox();
        prefVirg = new javax.swing.JCheckBox();
        prefNf = new javax.swing.JCheckBox();
        prefPoncfin = new javax.swing.JCheckBox();
        prefChim = new javax.swing.JCheckBox();
        prefOcr = new javax.swing.JCheckBox();
        prefMapos = new javax.swing.JCheckBox();
        prefLiga = new javax.swing.JCheckBox();
        prefEepi = new javax.swing.JCheckBox();
        panelGramm = new javax.swing.JPanel();
        prefConf = new javax.swing.JCheckBox();
        prefSgpl = new javax.swing.JCheckBox();
        prefGn = new javax.swing.JCheckBox();
        panelVerbs = new javax.swing.JPanel();
        prefInfi = new javax.swing.JCheckBox();
        prefConj = new javax.swing.JCheckBox();
        prefPpas = new javax.swing.JCheckBox();
        prefImp = new javax.swing.JCheckBox();
        prefInte = new javax.swing.JCheckBox();
        prefVmode = new javax.swing.JCheckBox();
        panelStyle = new javax.swing.JPanel();
        prefBs = new javax.swing.JCheckBox();
        prefPleo = new javax.swing.JCheckBox();
        prefRedon1 = new javax.swing.JCheckBox();
        prefRedon2 = new javax.swing.JCheckBox();
        prefNeg = new javax.swing.JCheckBox();
        panelMisc = new javax.swing.JPanel();
        prefDate = new javax.swing.JCheckBox();
        prefMc = new javax.swing.JCheckBox();

        panelConfig.setBorder(
                javax.swing.BorderFactory.createTitledBorder(GrammalectePlugin.res.getString("prefs.config")));

        labelUrl.setText(GrammalectePlugin.res.getString("prefs.server.url"));

        javax.swing.GroupLayout panelConfigLayout = new javax.swing.GroupLayout(panelConfig);
        panelConfig.setLayout(panelConfigLayout);
        panelConfigLayout
                .setHorizontalGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelConfigLayout.createSequentialGroup().addContainerGap().addComponent(labelUrl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldUrl).addContainerGap()));
        panelConfigLayout.setVerticalGroup(panelConfigLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelConfigLayout.createSequentialGroup()
                        .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelUrl).addComponent(fieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)));

        panelTypog
                .setBorder(javax.swing.BorderFactory.createTitledBorder(GrammalectePlugin.res.getString("opt.typog")));
        panelTypog.setLayout(new java.awt.GridLayout(9, 2));

        prefTypo.setText(GrammalectePlugin.res.getString("opt.typo"));
        panelTypog.add(prefTypo);

        prefApos.setText(GrammalectePlugin.res.getString("opt.apos"));
        prefApos.addActionListener(evt -> prefAposActionPerformed(evt));
        panelTypog.add(prefApos);

        prefEsp.setText(GrammalectePlugin.res.getString("opt.esp"));
        panelTypog.add(prefEsp);

        prefTab.setText(GrammalectePlugin.res.getString("opt.tab"));
        panelTypog.add(prefTab);

        prefNbsp.setText(GrammalectePlugin.res.getString("opt.nbsp"));
        panelTypog.add(prefNbsp);

        prefUnit.setText(GrammalectePlugin.res.getString("opt.unit"));
        panelTypog.add(prefUnit);

        prefTu.setText(GrammalectePlugin.res.getString("opt.tu"));
        panelTypog.add(prefTu);

        prefMaj.setText(GrammalectePlugin.res.getString("opt.maj"));
        panelTypog.add(prefMaj);

        prefNum.setText(GrammalectePlugin.res.getString("opt.num"));
        panelTypog.add(prefNum);

        prefVirg.setText(GrammalectePlugin.res.getString("opt.virg"));
        panelTypog.add(prefVirg);

        prefNf.setText(GrammalectePlugin.res.getString("opt.nf"));
        panelTypog.add(prefNf);

        prefPoncfin.setText(GrammalectePlugin.res.getString("opt.poncfin"));
        panelTypog.add(prefPoncfin);

        prefChim.setText(GrammalectePlugin.res.getString("opt.chim"));
        panelTypog.add(prefChim);

        prefOcr.setText(GrammalectePlugin.res.getString("opt.ocr"));
        panelTypog.add(prefOcr);

        prefMapos.setText(GrammalectePlugin.res.getString("opt.mapos"));
        panelTypog.add(prefMapos);

        prefLiga.setText(GrammalectePlugin.res.getString("opt.liga"));
        panelTypog.add(prefLiga);

        prefEepi.setText(GrammalectePlugin.res.getString("opt.eepi"));
        panelTypog.add(prefEepi);

        panelGramm
                .setBorder(javax.swing.BorderFactory.createTitledBorder(GrammalectePlugin.res.getString("opt.gramm")));
        panelGramm.setLayout(new java.awt.GridLayout(1, 3));

        prefConf.setText(GrammalectePlugin.res.getString("opt.conf"));
        panelGramm.add(prefConf);

        prefSgpl.setText(GrammalectePlugin.res.getString("opt.sgpl"));
        panelGramm.add(prefSgpl);

        prefGn.setText(GrammalectePlugin.res.getString("opt.gn"));
        panelGramm.add(prefGn);

        panelVerbs
                .setBorder(javax.swing.BorderFactory.createTitledBorder(GrammalectePlugin.res.getString("opt.verbs")));
        panelVerbs.setLayout(new java.awt.GridLayout(2, 3));

        prefInfi.setText(GrammalectePlugin.res.getString("opt.infi"));
        panelVerbs.add(prefInfi);

        prefConj.setText(GrammalectePlugin.res.getString("opt.conj"));
        panelVerbs.add(prefConj);

        prefPpas.setText(GrammalectePlugin.res.getString("opt.ppas"));
        panelVerbs.add(prefPpas);

        prefImp.setText(GrammalectePlugin.res.getString("opt.imp"));
        panelVerbs.add(prefImp);

        prefInte.setText(GrammalectePlugin.res.getString("opt.inte"));
        panelVerbs.add(prefInte);

        prefVmode.setText(GrammalectePlugin.res.getString("opt.vmode"));
        panelVerbs.add(prefVmode);

        panelStyle
                .setBorder(javax.swing.BorderFactory.createTitledBorder(GrammalectePlugin.res.getString("opt.style")));
        panelStyle.setLayout(new java.awt.GridLayout(3, 3));

        prefBs.setText(GrammalectePlugin.res.getString("opt.bs"));
        panelStyle.add(prefBs);

        prefPleo.setText(GrammalectePlugin.res.getString("opt.pleo"));
        panelStyle.add(prefPleo);

        prefRedon1.setText(GrammalectePlugin.res.getString("opt.redon1"));
        panelStyle.add(prefRedon1);

        prefRedon2.setText(GrammalectePlugin.res.getString("opt.redon2"));
        panelStyle.add(prefRedon2);

        prefNeg.setText(GrammalectePlugin.res.getString("opt.neg"));
        panelStyle.add(prefNeg);

        panelMisc.setBorder(javax.swing.BorderFactory.createTitledBorder(GrammalectePlugin.res.getString("opt.misc")));
        panelMisc.setLayout(new java.awt.GridLayout(1, 2));

        prefDate.setText(GrammalectePlugin.res.getString("opt.date"));
        panelMisc.add(prefDate);

        prefMc.setText(GrammalectePlugin.res.getString("opt.mc"));
        panelMisc.add(prefMc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelConfig, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelTypog, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelGramm, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelVerbs, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelStyle, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelMisc, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(panelConfig, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTypog, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGramm, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelVerbs, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelStyle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelMisc, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>

    private void prefAposActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    protected javax.swing.JTextField fieldUrl;
    private javax.swing.JLabel labelUrl;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelGramm;
    private javax.swing.JPanel panelMisc;
    private javax.swing.JPanel panelStyle;
    private javax.swing.JPanel panelTypog;
    private javax.swing.JPanel panelVerbs;
    protected javax.swing.JCheckBox prefApos;
    protected javax.swing.JCheckBox prefBs;
    protected javax.swing.JCheckBox prefChim;
    protected javax.swing.JCheckBox prefConf;
    protected javax.swing.JCheckBox prefConj;
    protected javax.swing.JCheckBox prefDate;
    protected javax.swing.JCheckBox prefEepi;
    protected javax.swing.JCheckBox prefEsp;
    protected javax.swing.JCheckBox prefGn;
    protected javax.swing.JCheckBox prefImp;
    protected javax.swing.JCheckBox prefInfi;
    protected javax.swing.JCheckBox prefInte;
    protected javax.swing.JCheckBox prefLiga;
    protected javax.swing.JCheckBox prefMaj;
    protected javax.swing.JCheckBox prefMapos;
    protected javax.swing.JCheckBox prefMc;
    protected javax.swing.JCheckBox prefNbsp;
    protected javax.swing.JCheckBox prefNeg;
    protected javax.swing.JCheckBox prefNf;
    protected javax.swing.JCheckBox prefNum;
    protected javax.swing.JCheckBox prefOcr;
    protected javax.swing.JCheckBox prefPleo;
    protected javax.swing.JCheckBox prefPoncfin;
    protected javax.swing.JCheckBox prefPpas;
    protected javax.swing.JCheckBox prefRedon1;
    protected javax.swing.JCheckBox prefRedon2;
    protected javax.swing.JCheckBox prefSgpl;
    protected javax.swing.JCheckBox prefTab;
    protected javax.swing.JCheckBox prefTu;
    protected javax.swing.JCheckBox prefTypo;
    protected javax.swing.JCheckBox prefUnit;
    protected javax.swing.JCheckBox prefVirg;
    protected javax.swing.JCheckBox prefVmode;
    // End of variables declaration
}