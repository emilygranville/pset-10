import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class Toolbar extends JPanel {
    
    private Word[] tbWords;
    private JList wordsList;
    private JButton addButton;
    private JButton deleteButton;
    private JButton ascButton;
    private JButton descButton;
    
    public Toolbar(Word[] displayWords) {
        tbWords = displayWords;
    }
    
    public JList getJList() {
        return wordsList;
    }
    
    public JButton getAddButton() {
        return addButton;
    }
    
    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public JButton getAscButton() {
        return ascButton;
    }
    
    public JButton getDescButton() {
        return descButton;
    }
    
    public void initComponents() {
        removeAll();
        revalidate();
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        addButton = new JButton("Add");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(addButton, gbc);
        deleteButton = new JButton("Delete");
        gbc.gridx = 1;
        add(deleteButton, gbc);
        
        JTextField search = new JTextField("Search");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(search, gbc);
        
        ascButton = new JButton("Asc");
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(ascButton, gbc);
        descButton = new JButton("Desc");
        gbc.gridx = 1;
        add(descButton, gbc);
        
        makeWords(gbc);
        setVisible(true);
    }
    
    public void makeWords(GridBagConstraints gbc) {
        wordsList = new JList(Utils.parseWords(tbWords));
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(wordsList, gbc);
        setVisible(true);
    }
}