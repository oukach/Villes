package ExerciceNio.Vue;
import ExerciceNio.metier.IServiceVille;
import ExerciceNio.metier.ServiceVilles;
import ExerciceNio.model.Ville;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CityMainFrame extends JFrame {
    Container mainContainer;
    JPanel header,center,west,est,panelForm,pnlRecherche,pnlRechercheForm,pnlRechercheResult;
    JLabel lblTitle;
    JButton btnAdd, btnEdit, btnDelete, btnSearch, btnReload, btnCancel;
    JTable citiesList;
    JScrollPane sp;
    Icon iconAdd;
    String WindowName="";
    IServiceVille service = new ServiceVilles(Paths.get("villes.txt"));
    ArrayList<Ville> v ;
        void initIcons() throws IOException {
             iconAdd = new ImageIcon("Icons\\addIcon.jpg");
        }
        void initTable() throws IOException {
            String [] column =  {"ID","NAME","POPULATION","REGION"};
            String [][] data = {};
            TableModel tableModel = new DefaultTableModel(data, column);
            citiesList = new JTable(tableModel);
            sp = new JScrollPane(citiesList);
            sp.setVisible(true);
            loadDatatoJtable();
        }
        void loadDatatoJtable() throws IOException {

            Object [] rowData = new Object[4];
            DefaultTableModel model = (DefaultTableModel) citiesList.getModel();
            v = new ArrayList<>(service.lireBDVilles_NIO());
            v.forEach(System.out::println);
            v.forEach(s->{
                rowData[0] = s.getId();
                rowData[1] = s.getNom();
                rowData[2] = s.getPopulation();
                rowData[3] = s.getRegion();
                model.addRow(rowData);
            });
        }
        void initLabel() {
            lblTitle = new JLabel();
            lblTitle.setText("DASHBOARD ");
            lblTitle.setFont(new Font("Optima", Font.BOLD, 20));
            lblTitle.setForeground(Color.black);
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            lblTitle.setBounds(0, 10, 400, 30);
        }
        void initButton(){
        btnReload = new JButton();
        btnReload.setText("Reload");
        btnReload.setFont(new Font("Optima",Font.BOLD,15));
        btnReload.setBackground(Color.WHITE);

        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setFont(new Font("Optima",Font.BOLD,15));
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setHorizontalAlignment(JLabel.CENTER);

        btnAdd = new JButton();
        btnAdd.setText("Add City");
        btnAdd.setFont(new Font("Optima",Font.BOLD,15));
        btnAdd.setBackground(Color.WHITE);
        btnAdd.setHorizontalAlignment(JLabel.CENTER);


        btnEdit = new JButton();
        btnEdit.setText("Edit City");
        btnEdit.setFont(new Font("Optima",Font.BOLD,15));
        btnEdit.setBackground(Color.WHITE);
        btnEdit.setHorizontalAlignment(JLabel.CENTER);

        btnDelete = new JButton();
        btnDelete.setText("Delete City");
        btnDelete.setFont(new Font("Optima",Font.BOLD,15));
        btnDelete.setBackground(Color.WHITE);
        btnDelete.setHorizontalAlignment(JLabel.CENTER);

        btnSearch = new JButton();
        btnSearch.setText("Search city");
        btnSearch.setFont(new Font("Optima",Font.BOLD,15));
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setHorizontalAlignment(JLabel.CENTER);

    }
        void initPanel() throws IOException {
            initLabel();
            initButton();
            initTable();
            panelForm = new JPanel();
            header = new JPanel();
            header.setBackground(Color.WHITE);
            header.setLayout(new FlowLayout());
            header.add(lblTitle);

            west = new JPanel();
            west.setBackground(Color.darkGray);
            west.setLayout(new GridLayout(5,1));
            west.add(btnAdd);
            west.add(btnEdit);
            west.add(btnDelete);
            west.add(btnSearch);
            west.add(btnReload);

            center = new JPanel();
            center.setLayout(new GridLayout(1,1));
            center.setBackground(Color.lightGray);

            est = new JPanel();
            est.setBackground(Color.darkGray);
            est.setLayout(new GridLayout(1,1));
            est.add(sp);

        }
        void centerPanel(JPanel p){
            center.removeAll();
            center.add(p);
        }
        void initMainContainer() throws IOException {
            initPanel();
            mainContainer=this.getContentPane();
            mainContainer.setBackground(Color.lightGray);
            mainContainer.setLayout(new BorderLayout());
            mainContainer.add(header,BorderLayout.NORTH);
            mainContainer.add(west,BorderLayout.WEST);
            mainContainer.add(est,BorderLayout.EAST);
            mainContainer.add(center,BorderLayout.CENTER);

            btnAdd.addActionListener(e -> {
                System.out.println("button add clicked");
                centerPanel(new CityFormFrame("",1).getPanelCenter());
                WindowName="Add new City";
                lblTitle.setText("DASHBOARD");
                center.validate();

                btnAdd.setBackground(Color.lightGray);
                btnReload.setBackground(Color.white);
                btnSearch.setBackground(Color.white);
                btnEdit.setBackground(Color.white);
                btnDelete.setBackground(Color.white);
            });
            btnEdit.addActionListener(e -> {
                System.out.println("button edit clicked");
                centerPanel(new CityFormFrame("",0).getPanelCenter());
                WindowName="Edit Existing City";
                center.validate();

                btnAdd.setBackground(Color.white);
                btnReload.setBackground(Color.white);
                btnSearch.setBackground(Color.white);
                btnEdit.setBackground(Color.lightGray);
                btnDelete.setBackground(Color.white);
            });
            btnDelete.addActionListener(e->{
            centerPanel(new CityFormFrame("",-1).getPanelCenter());
                WindowName="Delete Existing City";
                center.validate();

                btnAdd.setBackground(Color.white);
                btnReload.setBackground(Color.white);
                btnSearch.setBackground(Color.white);
                btnEdit.setBackground(Color.white);
                btnDelete.setBackground(Color.lightGray);

            });
            btnSearch.addActionListener(e->{
                centerPanel(new CityFormFrame("",2).getPanelCenter());
                WindowName="Search Existing City";
                center.validate();

                btnAdd.setBackground(Color.white);
                btnReload.setBackground(Color.white);
                btnSearch.setBackground(Color.lightGray);
                btnEdit.setBackground(Color.white);
                btnDelete.setBackground(Color.white);
            });
            btnReload.addActionListener(e->{
                try {
                    est.removeAll();
                    initTable();
                    est.add(sp);
                    est.revalidate();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                btnAdd.setBackground(Color.white);
                btnReload.setBackground(Color.lightGray);
                btnSearch.setBackground(Color.white);
                btnEdit.setBackground(Color.white);
                btnDelete.setBackground(Color.white);
            });
            citiesList.getSelectionModel().addListSelectionListener(e -> {
                CityFormFrame cF;
                if ("Edit Existing City".equals(WindowName) || "Delete Existing City".equals(WindowName)){
                        if("Edit Existing City".equals(WindowName)) {WindowName="Edit Existing City";cF = new CityFormFrame("",0);}
                        else {WindowName ="Delete Existing City";cF= new CityFormFrame("",-1);}
                        lblTitle.setText("DASHBOARD  #"+citiesList.getValueAt(citiesList.getSelectedRow(), 0));

                        cF.txfId.setText(citiesList.getValueAt(citiesList.getSelectedRow(), 0).toString());
                        cF.txfName.setText(citiesList.getValueAt(citiesList.getSelectedRow(), 1).toString());
                        cF.txfPopulation.setText(citiesList.getValueAt(citiesList.getSelectedRow(), 2).toString());
                        cF.txfRegion.setText(citiesList.getValueAt(citiesList.getSelectedRow(), 3).toString());

                        center.removeAll();
                        center.add(cF.getPanelCenter());
                        est.revalidate();
                }
            });
        }
        public CityMainFrame(String title) throws IOException {
            initMainContainer();
            setTitle(title);
            setSize(1000,410);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

        }
        public static void main(String[] args) throws IOException {
            new CityMainFrame("Dashboard");
        }


}
