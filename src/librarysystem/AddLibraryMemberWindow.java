package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import business.Address;
import business.LibraryMember;
import business.LibrarySystemException;
import business.SystemController;

public class AddLibraryMemberWindow extends JFrame implements LibWindow {

    private static final long serialVersionUID = 1L;
    public static final AddLibraryMemberWindow INSTANCE = new AddLibraryMemberWindow();

    private boolean isInitialized = false;

    private JPanel mainPanel;
    private JPanel upperHalf;
    private JPanel middleHalf;
    private JPanel lowerHalf;
  

    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel lowerPanel;
    private JPanel leftTextPanel;
    private JPanel rightTextPanel;

    private JTextField memberID;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField telephone;
    private JTextField city;
    private JTextField zip;
    private JTextField state;
    private JTextField street;
  

    private JLabel label;
    private JButton submitButton;
    

    public void init() {
        mainPanel = new JPanel();
        defineUpperHalf();
        defineMiddleHalf();
        defineLowerHalf();
        BorderLayout bl = new BorderLayout();
        bl.setVgap(30);
        mainPanel.setLayout(bl);
        mainPanel.add(upperHalf, BorderLayout.NORTH);
        mainPanel.add(middleHalf, BorderLayout.CENTER);
        mainPanel.add(lowerHalf, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);
        isInitialized(true);
        pack();
    }

    private void defineUpperHalf() {
        upperHalf = new JPanel();
        upperHalf.setLayout(new BorderLayout());
        defineTopPanel();
        defineMiddlePanel();
        defineLowerPanel();
        upperHalf.add(topPanel, BorderLayout.NORTH);
        upperHalf.add(middlePanel, BorderLayout.CENTER);
        upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    }

    private void defineMiddleHalf() {
        middleHalf = new JPanel();
        middleHalf.setLayout(new BorderLayout());
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.HORIZONTAL);
        middleHalf.add(s, BorderLayout.SOUTH);
    }

    private void defineLowerHalf() {
        lowerHalf = new JPanel();
        lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton backButton = new JButton("<= Back to Main");
        addBackButtonListener(backButton);
        lowerHalf.add(backButton);
    }

    private void defineTopPanel() {
        topPanel = new JPanel();
        JPanel intPanel = new JPanel(new BorderLayout());
        intPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        JLabel addLibraryMemberLabel = new JLabel("Add Library Member Details");
        Util.adjustLabelFont(addLibraryMemberLabel, Color.BLUE.darker(), true);
        intPanel.add(addLibraryMemberLabel, BorderLayout.CENTER);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(intPanel);
    }

    private void defineMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        defineLeftTextPanel();
        defineRightTextPanel();
        defineMidTextPanel();
        middlePanel.add(leftTextPanel);
        middlePanel.add(rightTextPanel);

    }

    private void defineLowerPanel() {
        lowerPanel = new JPanel();
        submitButton = new JButton("Submit");
        addSubmitButtonListener(submitButton);
        lowerPanel.add(submitButton);
    }

    private void defineMidTextPanel() {

        JPanel topText = new JPanel();
        JPanel bottomText = new JPanel();
        topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        memberID = new JTextField(10);
        label = new JLabel("MemberID");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(memberID);
        bottomText.add(label);

        firstName = new JTextField(10);
        label = new JLabel("FirstName");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(firstName);
        bottomText.add(label);

        telephone = new JTextField(10);
        label = new JLabel("Telephone");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(telephone);
        bottomText.add(label);

        city = new JTextField(10);
        label = new JLabel("City");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(city);
        bottomText.add(label);

        zip = new JTextField(10);
        label = new JLabel("ZIP");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(zip);
        bottomText.add(label);

        state = new JTextField(10);
        label = new JLabel("State");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(state);
        bottomText.add(label);

        street = new JTextField(10);
        label = new JLabel("Street");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(street);
        bottomText.add(label);

       

        leftTextPanel = new JPanel();
        leftTextPanel.setLayout(new BorderLayout());
        leftTextPanel.add(topText, BorderLayout.NORTH);
        leftTextPanel.add(bottomText, BorderLayout.CENTER);
    }

    private void defineLeftTextPanel() {
        JPanel topText = new JPanel();
        JPanel bottomText = new JPanel();
        topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        memberID = new JTextField(10);
        label = new JLabel("MemberID");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(memberID);
        bottomText.add(label);

        leftTextPanel = new JPanel();
        leftTextPanel.setLayout(new BorderLayout());
        leftTextPanel.add(topText, BorderLayout.NORTH);
        leftTextPanel.add(bottomText, BorderLayout.CENTER);
    }

    private void defineRightTextPanel() {
        JPanel topText = new JPanel();
        JPanel bottomText = new JPanel();
        topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        lastName = new JTextField(10);
        label = new JLabel("LastName");
        label.setFont(Util.makeSmallFont(label.getFont()));
        topText.add(lastName);
        bottomText.add(label);

        rightTextPanel = new JPanel();
        rightTextPanel.setLayout(new BorderLayout());
        rightTextPanel.add(topText, BorderLayout.NORTH);
        rightTextPanel.add(bottomText, BorderLayout.CENTER);
    }

    private void addBackButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            LibrarySystem.hideAllWindows();
            LibrarySystem.INSTANCE.setVisible(true);
        });
    }

    private void addSubmitButtonListener(JButton butn) {
        butn.addActionListener(evt -> {
            // Access the values entered by the user
            String memberId = memberID.getText();
            String fName = firstName.getText();
            String lName = lastName.getText();
            String phone = telephone.getText();
            String cityVal = city.getText();
            String zipVal = zip.getText();
            String stateVal = state.getText();
            String streetVal = street.getText();
           
            
            Address a=new Address(streetVal,cityVal, stateVal,zipVal);
            LibraryMember lb = new LibraryMember(memberId, fName, lName, phone,a);
            SystemController controller = new SystemController();
            try
            {
            controller.addMember(lb);
            }
            catch (LibrarySystemException e)
            {
            	e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "Member Information:\n" +
                    "Member ID: " + lb.getMemberId() + "\n" +
                    "Name: " + lb.getFirstName() + " " + lb.getLastName() + "\n" +
                    "Phone: " + lb.getTelephone() + "\n" +
                    "Address: " + lb.getAddress());
        });
    }
    @Override
    public boolean isInitialized() {
        return isInitialized;
    }

    @Override
    public void isInitialized(boolean val) {
        isInitialized = val;
    }
}
