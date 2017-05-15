/**
 * Created by Mac_T on 14/05/2017.
 */
package kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AplikasiKalkulator extends JFrame {
    private JPanel panelMain, panelButtons;
    private BoxLayout layout;
    private Font font;
    private JTextField field1;
    private JButton one,two,three,four,five,six,seven,eight,nine,zero,zerozero,tmbh,krg,bagi,kali,smdgn,ce,posmin,del,c;
    private Double temp, displayNilai,Nilai;
    private String opSblmnya;

    public AplikasiKalkulator()
    {
        temp = 0.0;
        displayNilai = 0.0;
        opSblmnya = "";

        ActionListener actionButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String actionCommand = actionEvent.getActionCommand();

                if(actionCommand.equals("delete"))
                {
                    String value = displayNilai.toString();

                    value = value.substring(0,value.length()-3);

                    if(value.isEmpty()) {
                        displayNilai = 0.0;
                    }
                    else{
                        displayNilai = Double.parseDouble(value);
                    }
                    display();
                }
                else if(actionCommand.equals("tmblTmbh")){
                    perhitungan();
                    temp = Double.parseDouble(field1.getText());
                    opSblmnya = "+";
                    displayNilai = 0.0;
                }
                else if(actionCommand.equals("tmblKrg")){
                    temp = Double.parseDouble(field1.getText());
                    perhitungan();
                    opSblmnya = "-";
                    displayNilai = 0.0;
                }
                else if(actionCommand.equals("tmblBagi")){
                    temp = Double.parseDouble(field1.getText());
                    perhitungan();
                    opSblmnya = "/";
                    displayNilai = 0.0;
                }
                else if(actionCommand.equals("tmblKali")){
                    temp = Double.parseDouble(field1.getText());
                    perhitungan();
                    opSblmnya = "*";
                    displayNilai = 0.0;
                }
                else if(actionCommand.equals("tmblCE")){
                    displayNilai = Double.parseDouble(field1.getText());
                    display();
                }
                else if(actionCommand.equals("tmblC"))
                {
                    displayNilai = 0.0;
                    temp = 0.0;
                    display();
                }
                else if(actionCommand.equals("tmblSmdgn")){
                    perhitungan();
                    display();
                    displayNilai = 0.0;
                }
                else if(actionCommand.equals("tmblPosmin")) {
                    displayNilai = displayNilai * -1;
                    display();
                }
                else
                {
                    if(displayNilai > 999999999) {
                        return;
                    }
                    else {
                        displayNilai = displayNilai * 10 + Integer.parseInt(String.valueOf(actionCommand.charAt(4)));
                        display();
                    }
                }
            }
        };

        //panel Main
        panelMain = (JPanel) this.getContentPane();
        //layout
        layout = new BoxLayout(panelMain, BoxLayout.Y_AXIS);
        panelMain.setLayout(layout);

        //field1
        field1 = new JTextField("");

        font = new Font("Century Gothic",Font.BOLD,60);
        field1.setForeground(Color.darkGray);
        field1.setLocation(0,1);
        field1.setEditable(false);
        field1.setBackground(Color.white);
        field1.setFont(font);
        field1.setPreferredSize(new Dimension(400,200));
        field1.setHorizontalAlignment(JTextField.RIGHT);
        field1.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));

        //panel Buttons
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridBagLayout());
        panelButtons.setPreferredSize(new Dimension(400,400));

        //buttons
        one = new JButton("1");
        one.setBackground(Color.white);
        one.setForeground(Color.black);

        two= new JButton("2");
        two.setBackground(Color.white);
        two.setForeground(Color.black);

        three = new JButton("3");
        three.setBackground(Color.white);
        three.setForeground(Color.black);

        four = new JButton("4");
        four.setBackground(Color.white);
        four.setForeground(Color.black);

        five = new JButton("5");
        five.setBackground(Color.white);
        five.setForeground(Color.black);

        six = new JButton("6");
        six.setBackground(Color.white);
        six.setForeground(Color.black);

        seven = new JButton("7");
        seven.setBackground(Color.white);
        seven.setForeground(Color.black);

        eight = new JButton("8");
        eight.setBackground(Color.white);
        eight.setForeground(Color.black);

        nine = new JButton("9");
        nine.setBackground(Color.white);
        nine.setForeground(Color.black);

        zero = new JButton("0");
        zero.setBackground(Color.white);
        zero.setForeground(Color.black);

        posmin = new JButton("±");
        posmin.setBackground(Color.black);
        posmin.setForeground(Color.red);
        posmin.setActionCommand("tmblPosmin");
        posmin.addActionListener(actionButton);

        smdgn = new JButton("=");
        smdgn.setBackground(Color.black);
        smdgn.setForeground(Color.red);
        smdgn.setActionCommand("tmblSmdgn");
        smdgn.addActionListener(actionButton);

        tmbh = new JButton("+");
        tmbh.setBackground(Color.black);
        tmbh.setForeground(Color.red);
        tmbh.setActionCommand("tmblTmbh");
        tmbh.addActionListener(actionButton);

        krg = new JButton("-");
        krg.setBackground(Color.black);
        krg.setForeground(Color.red);
        krg.setActionCommand("tmblKrg");
        krg.addActionListener(actionButton);

        kali = new JButton("×");
        kali.setBackground(Color.black);
        kali.setForeground(Color.red);
        kali.setActionCommand("tmblKali");
        kali.addActionListener(actionButton);

        bagi = new JButton("÷");
        bagi.setBackground(Color.black);
        bagi.setForeground(Color.red);
        bagi.setActionCommand("tmblBagi");
        bagi.addActionListener(actionButton);

        ce = new JButton("CE");
        ce.setBackground(Color.black);
        ce.setForeground(Color.red);
        ce.setActionCommand("tmblCE");
        ce.addActionListener(actionButton);

        c = new JButton("C");
        c.setBackground(Color.black);
        c.setForeground(Color.red);
        c.setActionCommand("tmblC");
        c.addActionListener(actionButton);

        del = new JButton("←");
        del.setBackground(Color.black);
        del.setForeground(Color.red);
        del.setActionCommand("delete");
        del.addActionListener(actionButton);


        //tombol 1
        one.setActionCommand("tmbl1");
        one.addActionListener(actionButton);
        //tombol 2
        two.setActionCommand("tmbl2");
        two.addActionListener(actionButton);
        //tombol 3
        three.setActionCommand("tmbl3");
        three.addActionListener(actionButton);
        //tombol 4
        four.setActionCommand("tmbl4");
        four.addActionListener(actionButton);
        //tombol 5
        five.setActionCommand("tmbl5");
        five.addActionListener(actionButton);
        //tombol 6
        six.setActionCommand("tmbl6");
        six.addActionListener(actionButton);
        //tombol 7
        seven.setActionCommand("tmbl7");
        seven.addActionListener(actionButton);
        //tombol 8
        eight.setActionCommand("tmbl8");
        eight.addActionListener(actionButton);
        //tombol 9
        nine.setActionCommand("tmbl9");
        nine.addActionListener(actionButton);
        //tombol 0
        zero.setActionCommand("tmbl0");
        zero.addActionListener(actionButton);

        //constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill=GridBagConstraints.BOTH;

        //button add
        constraints.weightx = 1;
        constraints.weighty=1;

        constraints.gridwidth = 2;
        constraints.gridheight =1;
        constraints.gridy=7;
        constraints.gridx=1;


        panelButtons.add(zero,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=7;
        constraints.gridx=3;

//        panelButtons.add(zerozero, constraints);

        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.gridy = 7;
        constraints.gridx = 3;

        panelButtons.add(posmin,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=7;
        constraints.gridx=4;

        panelButtons.add(smdgn,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=6;
        constraints.gridx=1;

        panelButtons.add(one,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=6;
        constraints.gridx=2;

        panelButtons.add(two,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=6;
        constraints.gridx=3;

        panelButtons.add(three,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=6;
        constraints.gridx=4;

        panelButtons.add(tmbh,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=5;
        constraints.gridx=1;

        panelButtons.add(four,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=5;
        constraints.gridx=2;

        panelButtons.add(five,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=5;
        constraints.gridx=3;

        panelButtons.add(six,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=5;
        constraints.gridx=4;

        panelButtons.add(krg,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=4;
        constraints.gridx=1;

        panelButtons.add(seven,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=4;
        constraints.gridx=2;

        panelButtons.add(eight,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=4;
        constraints.gridx=3;

        panelButtons.add(nine,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=4;
        constraints.gridx=4;

        panelButtons.add(bagi,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=3;
        constraints.gridx=1;

        panelButtons.add(ce,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=3;
        constraints.gridx=2;

        panelButtons.add(c,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight =1;
        constraints.gridy=3;
        constraints.gridx=3;

        panelButtons.add(del,constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridy=3;
        constraints.gridx=4;

        panelButtons.add(kali,constraints);

        //add
        panelMain.add(field1);
        panelMain.add(panelButtons);

        this.setTitle("Kalkulator Mac_T");
        this.setSize(400,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        AplikasiKalkulator kalk = new AplikasiKalkulator();
    }

    private void display()
    {
        String textDisplay = "";

        if(String.valueOf(displayNilai).isEmpty()){
            textDisplay = String.valueOf(0.0);
        }
        else{
            if(displayNilai % 1 == 0){
                textDisplay = ((Integer) displayNilai.intValue()).toString();
            }
            else{
                //if(field1.getText().endsWith(".0"))
                //textDisplay = (String.format("%.2f",displayNilai)).toString();
                textDisplay = displayNilai.toString();
            }
        }

        field1.setText(textDisplay);
    }

    private double perhitungan() {
        switch (opSblmnya) {
            case "+": {
                displayNilai = temp + displayNilai;
                //displayNilai = temp;
                temp = displayNilai;
                display();
                opSblmnya = "";
                break;
            }
            case "-": {
                temp = temp - displayNilai;
                displayNilai = temp;
                display();
                opSblmnya = "";
                break;
            }
            case "/" :{
                temp = temp / displayNilai;
                displayNilai = temp;
                display();
                opSblmnya = "";
                break;
            }
            case "*":{
                temp = temp * displayNilai;
                displayNilai = temp;
                display();
                opSblmnya = "";
                break;
            }
        }
        return displayNilai;
    }
}

