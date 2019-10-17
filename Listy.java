import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class Listy extends JFrame
{
    public Listy()
    {
        initComponents();
    }

    public void initComponents()
    {
        this.setTitle("Listy");
       this.setBounds(300,300,300,200);


        listaPrzedmiotow.setVisibleRowCount(4);
        //listaPrzedmiotow.setFixedCellHeight(40);
        //listaPrzedmiotow.setFixedCellWidth(70);
        listaPrzedmiotow.setSelectionBackground(Color.BLUE);
        listaPrzedmiotow.setSelectionForeground(Color.GREEN);
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        //listaPrzedmiotow.setLayoutOrientation(JList.VERTICAL_WRAP);


        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                System.out.println("Zmieniłem sie "+ (++i));
                if (e.getValueIsAdjusting())
                    System.out.println("Trzymam button");
                else
                    System.out.println("Pusciłem button myszy");
                if (!e.getValueIsAdjusting())
                {
                    Object[] wartosciWLiscie = ((JList)e.getSource()).getSelectedValues();

                    String przedmioty = "";

                    for(int i = 0; i < wartosciWLiscie.length; i++)
                        przedmioty += (String)wartosciWLiscie[i]+ " ";

                    System.out.println(przedmioty);
                    komunikat.setText("Nie lubie nastepujących przedmiotów: "+przedmioty);
                }


            }


        });

        final DefaultListModel modelListy = new DefaultListModel();
        String[] tekst = new String[]{"Matematyka", "Fizyka", "Informatyka", "Biologia", "Chemia", "WOS", "PO", "Historia"};

        for(int i = 0; i < tekst.length; i++)
            modelListy.addElement(tekst[i]);
        modelListy.addElement("k");
        modelListy.addElement("g");
        modelListy.addElement("h");

        JList lista2 = new JList(modelListy);

        lista2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
            modelListy.removeAllElements();
            }
        });

        panelListy.add(scrollListy);
        panelKomunikatu.add(komunikat);

       this.getContentPane().add(panelListy, BorderLayout.NORTH);
       this.getContentPane().add(panelKomunikatu,BorderLayout.CENTER);
       this.getContentPane().add(lista2, BorderLayout.SOUTH);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private int i = 0;
    private JList listaPrzedmiotow = new JList(new String[]{"Matematyka", "Fizyka", "Informatyka", "Biologia", "Chemia", "WOS", "PO", "Historia"});
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelListy = new JPanel();
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel();
    public static void main(String[] args)
    {
        new Listy().setVisible(true);
    }
}
