package doancanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tutorial_GUI extends JFrame implements ActionListener {

    private JTextArea tutorialArea;
    private JButton nextButton, prevButton;
    private int currentStep = 0;
    private String[] tutorialSteps = {
        "**Welcome to the Tutorial!**\n\n"
        + "This tutorial will guide you through the basic steps of using this application.",
        "**Step 1: Create a New Project**\n\n"
        + "To begin, click on the 'File' menu and select 'New Project'.",
        "**Step 2: Choose Project Type**\n\n"
        + "Select the desired project type from the available options.",
        "**Step 3: Configure Settings**\n\n"
        + "Specify project settings such as name, location, and other relevant options.",
        "**Step 4: Start Coding!**\n\n"
        + "You can now start writing your code in the editor window.",
        "**Congratulations!**\n\n"
        + "You have completed the basic tutorial. You can now explore the application further."
    };

    public Tutorial_GUI() {
        setTitle("Tutorial");
        setSize(600, 300);
        setLocation(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tutorialArea = new JTextArea();
        tutorialArea.setEditable(false);
        tutorialArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(tutorialArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        prevButton = new JButton("Previous");
        prevButton.addActionListener(this);
        prevButton.setEnabled(false); // Disable "Previous" on the first step
        buttonPanel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        updateTutorial();

        setVisible(true);
    }

    private void updateTutorial() {
        tutorialArea.setText(tutorialSteps[currentStep]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            currentStep++;
            if (currentStep == tutorialSteps.length - 1) {
                nextButton.setEnabled(false);
            }
            prevButton.setEnabled(true);
        } else if (e.getSource() == prevButton) {
            currentStep--;
            if (currentStep == 0) {
                prevButton.setEnabled(false);
            }
            nextButton.setEnabled(true);
        }
        updateTutorial();
    }

    public static void main(String[] args) {
        new Tutorial_GUI();
    }
}