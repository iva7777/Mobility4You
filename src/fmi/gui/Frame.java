package fmi.gui;

import fmi.operationdb.DbOperations;
import fmi.operationdb.MyModel;
import fmi.util.CarParser;
import fmi.util.FileOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    JPanel topPanel = new JPanel();
    JPanel midPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    private JButton btnLoadFile = new JButton("Load File");
    private JButton btnResize = new JButton("Resize");
    private JFileChooser fileChooser = new JFileChooser();
//    Dimension dimFrame = null;
    public Frame(){
        this.setVisible(true);
        this.setSize(400, 600);
//        dimFrame.getSize();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));

        this.add(topPanel);
        this.add(midPanel);
        this.add(bottomPanel);

        //topPanel



        //midPanel
        midPanel.add(btnLoadFile);
        btnLoadFile.addActionListener(new LoadAction());
        midPanel.add(btnResize);
        btnResize.addActionListener(new ResizeAction());

        //bottomPanel
        bottomPanel.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(350,180));
        showAll();
    }

    private class LoadAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser.showOpenDialog(null);
            String path = fileChooser.getSelectedFile().getAbsolutePath();

            for (String row : FileOperation.readFileByRow(path)){
                CarParser.insertAbstractCar(row);
            }
            showAll();
        }
    }
//    public void resizeFrame(){
//        int wFrame = (int)(dimFrame.getWidth() + 10);
//        int hFrame = (int) dimFrame.getHeight();
//        this.setSize(wFrame,hFrame);
//    }
    private class ResizeAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension dimension = scrollPane.getSize();
            int w = (int) dimension.getWidth() + 10;
            int h = (int) dimension.getHeight() + 10;
//            resizeFrame();
            scrollPane.setSize(w, h);
            try {

                table.setModel(new MyModel(DbOperations.getAllCars()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void showAll(){
        try {
            table.setModel(new MyModel(DbOperations.getAllCars()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
