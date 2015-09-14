import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * Represents the driver for the GUI
 * @author Bilal Mawji
 * @version 1.0
 */
public class MailReader extends Application {

    private Comparator<Message> sendComp =
        Comparator.comparing(Message::getSender);
    private Comparator<Message> subjComp =
        Comparator.comparing(Message::getSubject);
    /**
     * Start method for driver class
     * @param stage the stage to be used
     */
    @Override
    public void start(Stage stage) {

        Server server = new Server();

        Button refresh = new Button();
        refresh.setText("Refresh");

        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.VERTICAL);
        separator1.setValignment(VPos.CENTER);

        Button sender = new Button();
        sender.setText("Sort by Sender");

        Button date = new Button();
        date.setText("Sort by Date");

        Button subject = new Button();
        subject.setText("Sort by Subject");

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);
        separator2.setValignment(VPos.CENTER);

        Button trashButton = new Button();
        trashButton.setText("Trash");

        Button flag = new Button();
        flag.setText("Flag");

        ToolBar toolBar = new ToolBar(refresh, separator1, sender, date,
            subject, separator2, trashButton, flag);

        Mailbox inbox = new Mailbox("Inbox");
        Mailbox important = new Mailbox("Important");
        Mailbox trash = new Mailbox("Trash");

        ArrayList<Mailbox> arrMailBox = new ArrayList<Mailbox>(3);
        arrMailBox.add(inbox);
        arrMailBox.add(important);
        arrMailBox.add(trash);

        ObservableList<Mailbox> inboxes =
            FXCollections.observableArrayList(arrMailBox);
        ListView<Mailbox> listView1 = new ListView<Mailbox>(inboxes);

        ObservableList<Message> mailList =
            FXCollections.observableArrayList();
        ListView<Message> listView2 = new ListView<Message>(mailList);

        listView2.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
            });

        VBox vbox2 = new VBox();
        vbox2.setPrefWidth(300);
        vbox2.getChildren().addAll(listView2);

        listView1.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                mailList.clear();
                mailList.addAll(newValue.getMessages());
            });

        VBox vbox1 = new VBox();
        vbox1.setPrefWidth(100);
        vbox1.getChildren().addAll(listView1);

        Label subjectLabel = new Label();
        subjectLabel.setFont(new Font("Arial", 40));
        Label personsLabel = new Label();
        Label senderLabel = new Label();
        Label timeLabel = new Label();
        Label msgBodyLabel = new Label();

        listView2.getSelectionModel().selectedItemProperty()
            .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        subjectLabel.setText(newValue.getSubject() + "\n\n");
                        personsLabel.setText("To: " + newValue.getRecipients()
                            .toString() + "\n\n");
                        senderLabel.setText(newValue.getSender().toString()
                            + "  " + "<" + newValue.getSender().getEmail()
                            + ">" + "\n\n");
                        timeLabel.setText(newValue.getLocalDateTime() + "\n\n");
                        msgBodyLabel.setText(newValue.getBody());
                    }
                });

        VBox vbox3 = new VBox();
        vbox3.setPrefWidth(600);
        vbox3.getChildren().addAll(subjectLabel, personsLabel, senderLabel,
            timeLabel, msgBodyLabel);

        refresh.setOnAction(e -> {
                Server s = new Server();
                Message m1 = s.generateRandom();
                Mailbox box = listView1.getSelectionModel().getSelectedItem();
                inbox.add(s.generateRandom());
                mailList.clear();
                if (box != null) {
                    mailList.addAll(box.getMessages());
                }
            });
        flag.setOnAction(e -> {
                Mailbox box = listView1.getSelectionModel().getSelectedItem();
                Message temp = listView2.getSelectionModel().getSelectedItem();
                if (temp != null) {
                    box.remove(temp);
                    important.add(temp);
                    mailList.clear();
                    mailList.addAll(box.getMessages());
                }
            });
        trashButton.setOnAction(e -> {
                Mailbox box = listView1.getSelectionModel().getSelectedItem();
                Message temp = listView2.getSelectionModel().getSelectedItem();
                if (temp != null) {
                    box.remove(temp);
                    trash.add(temp);
                    mailList.clear();
                    mailList.addAll(box.getMessages());
                }
            });
        sender.setOnAction(e -> {
                Collections.sort(mailList, sendComp);
            });
        subject.setOnAction(e -> {
                Collections.sort(mailList, subjComp);
            });
        date.setOnAction(e -> {
                Collections.sort(mailList);
            });

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolBar);
        borderPane.setLeft(vbox1);
        borderPane.setCenter(vbox2);
        borderPane.setRight(vbox3);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("MailReader");
        stage.show();
    }
}