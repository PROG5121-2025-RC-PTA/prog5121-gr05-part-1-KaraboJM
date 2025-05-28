/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Karabo Jason Mfopa
 */
public class ChatAppMessages {

    private int messageCounter = 0;

    public ChatAppMessages() {
        mainMenu();
    }
    
    import javax.swing.JOptionPane;

        private void mainMenu() {
        JOptionPane.showMessageDialog(null, "Hello! This is ChatApp.");

        while (true) {
            String[] actions = {"Start Chat", "Help", "Exit"};
            int option = JOptionPane.showOptionDialog(
                    null,
                    "Choose an action:",
                    "ChatApp Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    actions,
                    actions[0]);

            if (option == 0) {
                startChat();
            } else if (option == 1) {
                JOptionPane.showMessageDialog(null, "Just a demo app. Send messages and track how many you sent.");
            } else {
                JOptionPane.showMessageDialog(null, "Closing ChatApp. Goodbye!");
                break;
            }
        }
    }

    private void startChat() {
        String limitStr = JOptionPane.showInputDialog("How many messages do you want to send?");
        if (limitStr == null) return;

        int limit;
        try {
            limit = Integer.parseInt(limitStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            return;
        }

        for (int i = 0; i < limit; i++) {
            String number = JOptionPane.showInputDialog("Recipient phone (+27 format):");
            if (number == null || !number.startsWith("+27")) {
                JOptionPane.showMessageDialog(null, "Invalid number format. Skipping.");
                continue;
            }

            String msg = JOptionPane.showInputDialog("Enter your message:");
            if (msg == null || msg.length() > 250) {
                JOptionPane.showMessageDialog(null, "Invalid message. Skipping.");
                continue;
            }

            messageCounter++;
            JOptionPane.showMessageDialog(null,
                    "Sent to: " + number + "\nMessage: " + msg + "\nMessage ID: MSG" + messageCounter);
        }

        JOptionPane.showMessageDialog(null, "You sent " + messageCounter + " message(s).");
    }

    public static void main(String[] args) {
        new ChatAppMessages();
    }
}