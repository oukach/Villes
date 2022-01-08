package ExerciceNio.Vue;
import ExerciceNio.metier.IServiceVille;
import ExerciceNio.metier.ServiceVilles;
import ExerciceNio.model.Ville;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CityFormFrame  {
        JPanel mainContainer;
        int toAdd;
        String title;
        Color bgColor = new Color(100,150,255);
        JPanel titlePanel,footerPanel,centerPanel;
        JLabel lblTitle,lblId,lblName,lblPopulation,lblRegion;
        JTextField txfId,txfName,txfPopulation,txfRegion;
        JButton btnReset , btnAction ;

        void initTextFields(int toAdd) {
            txfId = new JTextField();
            if (toAdd==1) {txfId.setText("Auto generated");txfId.setEnabled(false);}
            else {txfId.setText("");txfId.setEnabled(true);}

            txfId.setFont(new Font("Optima",Font.BOLD,15));
            txfId.setForeground(Color.BLUE); // Couleur du label
            txfId.setHorizontalAlignment(JLabel.CENTER);
            txfId.setBounds(120,70,200,25);

            txfName = new JTextField();
            txfName.setText("");
            txfName.setFont(new Font("Optima",Font.BOLD,15));
            txfName.setForeground(Color.BLUE); // Couleur du label
            txfName.setHorizontalAlignment(JLabel.CENTER);
            txfName.setBounds(120,120,200,25);

            txfPopulation = new JTextField();
            txfPopulation.setText("");
            txfPopulation.setFont(new Font("Optima",Font.BOLD,15));
            txfPopulation.setForeground(Color.BLUE); // Couleur du label
            txfPopulation.setHorizontalAlignment(JLabel.CENTER);
            txfPopulation.setBounds(120,170,200,25);

            txfRegion = new JTextField();
            txfRegion.setText("");
            txfRegion.setFont(new Font("Optima",Font.BOLD,15));
            txfRegion.setForeground(Color.BLUE); // Couleur du label
            txfRegion.setHorizontalAlignment(JLabel.CENTER);
            txfRegion.setBounds(120,220,200,25);
        }
        void initButtons(int toAdd){
            btnReset = new JButton();
            btnReset.setText("Reset");
            btnReset.setFont(new Font("Optima",Font.BOLD,15));
            btnReset.setForeground(Color.black);
            btnReset.setBackground(Color.gray);
            btnReset.setHorizontalAlignment(JLabel.CENTER);
            btnReset.setBounds(120,280,100,30);

            btnAction = new JButton();
            if (toAdd==1) {
                txfId.setText("Auto generated");
                txfId.setEnabled(false);
                btnAction.setText("Add");}
            else if(toAdd==0) {
                txfId.setText("");
                txfId.setEnabled(false);
                btnAction.setText("Edit");}
            else if(toAdd==-1) {
                txfId.setText("");
                txfId.setEnabled(false);
                btnAction.setText("Delete");}
            else {
                txfId.setText("");
                txfId.setEnabled(true);
                txfName.setEnabled(false);
                txfPopulation.setEnabled(false);
                txfRegion.setEnabled(false);
                btnAction.setText("Search");}
            btnAction.setFont(new Font("Optima",Font.BOLD,15));
            btnAction.setForeground(Color.black);
            btnAction.setBackground(Color.GREEN);
            btnAction.setHorizontalAlignment(JLabel.CENTER);
            btnAction.setBounds(230,280,100,30);

    }
        void initLabel(){
            lblTitle = new JLabel();
            if (toAdd==1) lblTitle.setText("Add new city");
            else if(toAdd==0) lblTitle.setText("Edit existing city");
            else if(toAdd==-1) lblTitle.setText("Delete existing city");
            else lblTitle.setText("Search existing city");
            lblTitle.setFont(new Font("Optima",Font.BOLD,30));
            lblTitle.setForeground(Color.darkGray); // Couleur du label
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            lblTitle.setBounds(0,10,400,40);


            lblId = new JLabel();
            lblId.setText("ID : ");
            lblId.setFont(new Font("Optima",Font.BOLD,15));
            lblId.setForeground(Color.WHITE); // Couleur du label
            lblId.setHorizontalAlignment(JLabel.LEFT);
            lblId.setBounds(25,70,100,20);

            lblName = new JLabel();
            lblName.setText("Name : ");
            lblName.setFont(new Font("Optima",Font.BOLD,15));
            lblName.setForeground(Color.WHITE); // Couleur du label
            lblName.setHorizontalAlignment(JLabel.LEFT);
            lblName.setBounds(25,120,100,20);

            lblPopulation = new JLabel();
            lblPopulation.setText("Population : ");
            lblPopulation.setFont(new Font("Optima",Font.BOLD,15));
            lblPopulation.setForeground(Color.WHITE); // Couleur du label
            lblPopulation.setHorizontalAlignment(JLabel.LEFT);
            lblPopulation.setBounds(25,170,100,20);

            lblRegion = new JLabel();
            lblRegion.setText("Region : ");
            lblRegion.setFont(new Font("Optima",Font.BOLD,15));
            lblRegion.setForeground(Color.WHITE); // Couleur du label
            lblRegion.setHorizontalAlignment(JLabel.LEFT);
            lblRegion.setBounds(25,220,100,20);
        }
        void initPanel(){
            initLabel();
            initTextFields(toAdd);
            initButtons(toAdd);

            titlePanel = new JPanel();
            titlePanel.setBackground(Color.WHITE);
            titlePanel.setBounds(0,0,400,40);
            titlePanel.setLayout(null);
            titlePanel.add(lblTitle);

            centerPanel = new JPanel();
            centerPanel.setLayout(null);
            centerPanel.setBackground(Color.lightGray);

            centerPanel.add(lblTitle);
            centerPanel.add(lblId);
            centerPanel.add(lblName);
            centerPanel.add(lblPopulation);
            centerPanel.add(lblRegion);

            centerPanel.add(txfId);
            centerPanel.add(txfName);
            centerPanel.add(txfPopulation);
            centerPanel.add(txfRegion);

            centerPanel.add(btnReset);
            centerPanel.add(btnAction);

            footerPanel = new JPanel();
            footerPanel.setBackground(Color.WHITE);
            footerPanel.setLayout(new FlowLayout());


        }
        void initMainContainer(){
            initPanel();
            mainContainer= new JPanel();
            mainContainer.setBackground(bgColor);
            mainContainer.setLayout(null); //Layout par default place les element l'un sur l'autre
            mainContainer.add(titlePanel);
            mainContainer.add(footerPanel);
            mainContainer.add(centerPanel);

            btnAction.addActionListener(e->{
                if (btnAction.getText().equals("Add")){
                        IServiceVille service = new ServiceVilles(Paths.get("villes.txt"));
                        try {
                            String id = String.valueOf(service.lireBDVilles_NIO().size()+1);
                            String name = txfName.getText();
                            String population = txfPopulation.getText();
                            String region = txfRegion.getText();
                            service.writeToFile(id+"#"+name+"#"+population+"#"+region+"\n");
                            JOptionPane.showMessageDialog(null,"The City #ID :"+id+" is added !! PLease reload");

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                }
                else if(btnAction.getText().equals("Edit")){
                    IServiceVille service = new ServiceVilles(Paths.get("villes.txt"));
                    try {
                        ArrayList<Ville> a = new ArrayList<>(service.lireBDVilles_NIO());
                        int rowToEdit = Integer.parseInt(a.get(Integer.parseInt(txfId.getText())).getId())-2;
                        a.set(rowToEdit,
                                new Ville(
                                        txfId.getText(),
                                        txfName.getText(),
                                        txfRegion.getText(),
                                        txfPopulation.getText()
                                            ));
                        service.clearFille();
                        a.forEach(s->{
                            try {
                                service.writeToFile(s.getId()+"#"+s.getNom()+"#"+s.getPopulation()+"#"+s.getRegion()+"\n");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        });
                        JOptionPane.showMessageDialog(null,"The city #ID:"+rowToEdit+1+" Edited well ! Please Reload");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(btnAction.getText().equals("Delete")){
                    IServiceVille service = new ServiceVilles(Paths.get("villes.txt"));
                    try {
                        ArrayList<Ville> a = new ArrayList<>(service.lireBDVilles_NIO());
                        int rowToDelete = Integer.parseInt(a.get(Integer.parseInt(txfId.getText())).getId())-2;
                        a.remove(rowToDelete);
                        service.clearFille();
                        a.forEach(s->{
                            try {
                                service.writeToFile(s.getId()+"#"+s.getNom()+"#"+s.getPopulation()+"#"+s.getRegion()+"\n");
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        });
                        JOptionPane.showMessageDialog(null,"The city #ID:"+rowToDelete+1+" Deleted well ! Please Reload");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else if(btnAction.getText().equals("Search")){
                    IServiceVille service = new ServiceVilles(Paths.get("villes.txt"));
                    try {
                        ArrayList<Ville> a = new ArrayList<>(service.lireBDVilles_NIO());
                        int rowToSearch = Integer.parseInt(a.get(Integer.parseInt(txfId.getText())).getId())-2;
                        JOptionPane.showMessageDialog(
                                null,"******** Information Ville *******\n"+
                                        "ID : "+a.get(rowToSearch).getId()+"\n"+
                                        "NAME : "+a.get(rowToSearch).getNom()+"\n"+
                                        "POPULATION : "+a.get(rowToSearch).getPopulation()+"\n"+
                                        "REGION : "+a.get(rowToSearch).getRegion()+"\n");

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }catch(IndexOutOfBoundsException i){
                        JOptionPane.showMessageDialog(null,"Le ID que vous rechercher est introuvable!!!");
                    }
                }
            });
            btnReset.addActionListener(e->{
                if (toAdd==1) txfId.setText("Auto generated");
                else txfId.setText("");
                txfName.setText("");
                txfPopulation.setText("");
                txfRegion.setText("");
            });

        }
        public CityFormFrame(String title , int toAdd){
            this.title=title;
            this.toAdd=toAdd;
            initMainContainer();
        }
        public JPanel getPanelCenter(){
            return centerPanel;
        }

        public static void main(String[] args) {
                new CityFormFrame("City Form",1);
        }
}
