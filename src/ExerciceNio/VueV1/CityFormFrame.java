package ExerciceNio.VueV1;
import javax.swing.*;
import java.awt.*;
public class CityFormFrame extends JFrame {
    /*Container mainContainer;
    boolean toAdd;
    Color bgColor = new Color(100,150,255);
    JPanel titlePanel,footerPanel,centerPanel;
    JLabel lblTitle,lblId,lblName,lblPopulation,lblRegion;
    JTextField txfId,txfName,txfPopulation,txfRegion;
    JButton btnReset , btnAction;

    void initTextFields(boolean toAdd) {
        txfId = new JTextField();
        if (toAdd) {txfId.setText("Auto generated");txfId.setEnabled(false);}
        else {txfId.setText("");txfId.setEnabled(true);}

        txfId.setFont(new Font("Optima",Font.BOLD,15));
        txfId.setForeground(Color.BLUE); // Couleur du label
        txfId.setHorizontalAlignment(JLabel.CENTER);
        txfId.setBounds(120,20,200,25);

        txfName = new JTextField();
        txfName.setText("");
        txfName.setFont(new Font("Optima",Font.BOLD,15));
        txfName.setForeground(Color.BLUE); // Couleur du label
        txfName.setHorizontalAlignment(JLabel.CENTER);
        txfName.setBounds(120,65,200,25);

        txfPopulation = new JTextField();
        txfPopulation.setText("");
        txfPopulation.setFont(new Font("Optima",Font.BOLD,15));
        txfPopulation.setForeground(Color.BLUE); // Couleur du label
        txfPopulation.setHorizontalAlignment(JLabel.CENTER);
        txfPopulation.setBounds(120,125,200,25);

        txfRegion = new JTextField();
        txfRegion.setText("");
        txfRegion.setFont(new Font("Optima",Font.BOLD,15));
        txfRegion.setForeground(Color.BLUE); // Couleur du label
        txfRegion.setHorizontalAlignment(JLabel.CENTER);
        txfRegion.setBounds(120,175,200,25);
    }
    void initButtons(boolean toAdd){
        btnReset = new JButton();
        btnReset.setText("Reset");
        btnReset.setFont(new Font("Optima",Font.BOLD,15));
        btnReset.setForeground(bgColor);
        btnReset.setHorizontalAlignment(JLabel.CENTER);
        btnReset.setBounds(100,15,100,30);

        btnAction = new JButton();
        if (toAdd) {txfId.setText("Auto generated");txfId.setEnabled(false);}
        else {txfId.setText("");txfId.setEnabled(true);}
        btnAction.setText("Action");
        btnAction.setFont(new Font("Optima",Font.BOLD,15));
        btnAction.setForeground(bgColor);
        btnAction.setHorizontalAlignment(JLabel.CENTER);
        btnAction.setBounds(220,15,100,30);

    }
    void initLabel(){
        lblTitle = new JLabel();
        lblTitle.setText("Add new city [Form]");
        lblTitle.setFont(new Font("Optima",Font.BOLD,20));
        lblTitle.setForeground(bgColor); // Couleur du label
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBounds(0,10,400,30);


        lblId = new JLabel();
        lblId.setText("ID : ");
        lblId.setFont(new Font("Optima",Font.BOLD,15));
        lblId.setForeground(Color.WHITE); // Couleur du label
        lblId.setHorizontalAlignment(JLabel.LEFT);
        lblId.setBounds(25,15,100,20);

        lblName = new JLabel();
        lblName.setText("Name : ");
        lblName.setFont(new Font("Optima",Font.BOLD,15));
        lblName.setForeground(Color.WHITE); // Couleur du label
        lblName.setHorizontalAlignment(JLabel.LEFT);
        lblName.setBounds(25,75,100,20);

        lblPopulation = new JLabel();
        lblPopulation.setText("Population : ");
        lblPopulation.setFont(new Font("Optima",Font.BOLD,15));
        lblPopulation.setForeground(Color.WHITE); // Couleur du label
        lblPopulation.setHorizontalAlignment(JLabel.LEFT);
        lblPopulation.setBounds(25,125,100,20);

        lblRegion = new JLabel();
        lblRegion.setText("Region : ");
        lblRegion.setFont(new Font("Optima",Font.BOLD,15));
        lblRegion.setForeground(Color.WHITE); // Couleur du label
        lblRegion.setHorizontalAlignment(JLabel.LEFT);
        lblRegion.setBounds(25,175,100,20);
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
        centerPanel.setBackground(bgColor);
        centerPanel.setBounds(0,40,400,360);
        centerPanel.setLayout(null);
        centerPanel.add(lblId);
        centerPanel.add(lblName);
        centerPanel.add(lblPopulation);
        centerPanel.add(lblRegion);

        centerPanel.add(txfId);
        centerPanel.add(txfName);
        centerPanel.add(txfPopulation);
        centerPanel.add(txfRegion);

        footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBounds(0,330,400,40);
        footerPanel.setLayout(null);
        footerPanel.add(btnReset);
        footerPanel.add(btnAction);
    }
    void initMainContainer(){
        initPanel();
        mainContainer=this.getContentPane();
        mainContainer.setBackground(bgColor);
        mainContainer.setLayout(null); //Layout par default place les element l'un sur l'autre
        mainContainer.add(titlePanel);
        mainContainer.add(footerPanel);
        mainContainer.add(centerPanel);

    }

    public CityFormFrame(String title , boolean toAdd){
        this.toAdd=toAdd;
        initMainContainer();
        setTitle(title);
        setSize(400,410);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ExerciceNio.Vue.CityFormFrame("City Form",1);
    }
    */
}
